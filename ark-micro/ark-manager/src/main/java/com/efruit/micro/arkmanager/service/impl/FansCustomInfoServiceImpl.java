package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.FansCustomerInfoMapper;
import com.efruit.micro.arkmanager.pojo.FansCustomerInfo;
import com.efruit.micro.arkmanager.pojo.FansCustomerInfoExample;
import com.efruit.micro.arkmanager.service.FansCustomInfoService;
import com.efruit.micro.arkmanager.utils.CollectionHelper;
import com.efruit.micro.arkmanager.utils.StatusParser;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowersInfoPullResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FansCustomInfoServiceImpl implements FansCustomInfoService {
    private static final Logger logger = LoggerFactory.getLogger(FansCustomInfoServiceImpl.class);

    @Autowired
    FansCustomerInfoMapper fansCustomerInfoMapper;

    @Autowired
    YouzanService youzanService;

    @Override
    public int getFansCustomerInfoCount() {
        FansCustomerInfoExample example = new FansCustomerInfoExample();
        return fansCustomerInfoMapper.countByExample(example);
    }

    @Override
    public List<FansCustomerInfo> getFansCustomerInfoList() {
        FansCustomerInfoExample example = new FansCustomerInfoExample();
        return fansCustomerInfoMapper.selectByExample(example);
    }

    @Override
    public boolean saveFansCustomerInfoList(List<FansCustomerInfo> fansCustomerInfoList) {
        return fansCustomerInfoMapper.insertList(fansCustomerInfoList) > 0;
    }

    @Override
    public boolean saveFansCustomerInfoListByPage(List<FansCustomerInfo> fansCustomerInfoList) {
        if (CollectionUtils.isEmpty(fansCustomerInfoList)) {
            return false;
        }

        CollectionHelper<FansCustomerInfo> collectionHelper = new CollectionHelper<FansCustomerInfo>();
        collectionHelper.forCollectionByPage(fansCustomerInfoList, 500, new CollectionHelper.Callback<FansCustomerInfo>() {
            @Override
            public void onGothrough(List<FansCustomerInfo> list) {
                saveFansCustomerInfoList(list);
            }
        });

        final int savedCount = getFansCustomerInfoCount();
        if (fansCustomerInfoList.size() != savedCount) {
            return false;
        }
        return true;
    }

    @Transactional
    @Async
    @Override
    public void syncFansCustomerInfoFromYouzan() {
        List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> fansList = null;
        try {
            fansList = youzanService.getFansList();
        } catch (YouzanApiException e) {
            logger.info("syncFansCustomerInfoFromYouzan error.", e);
        }

        if (CollectionUtils.isEmpty(fansList)) {
            logger.info("syncFansCustomerInfoFromYouzan fansList is empty, return ...");
            return;
        }

        final int fansCustomerInfoCount = getFansCustomerInfoCount();
        if (fansCustomerInfoCount > 0) {
            final boolean deleteAllFansCustomerInfo = deleteAllFansCustomerInfo();
            if (!deleteAllFansCustomerInfo) {
                throw new RuntimeException("deleteAllFansCustomerInfo error.");
            }
        }

        final List<FansCustomerInfo> fansCustomerInfos = toFansCustomerInfoList(fansList);
        final boolean saveFansCustomerInfoList = saveFansCustomerInfoListByPage(fansCustomerInfos);
        if (!saveFansCustomerInfoList) {
            throw new RuntimeException("saveFansCustomerInfoList error");
        }
    }

    private List<FansCustomerInfo> toFansCustomerInfoList(List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> youzanList) {
        List<FansCustomerInfo> result = new ArrayList<>();
        for (YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo youzanInfo : youzanList) {
            FansCustomerInfo fansCustomerInfo = new FansCustomerInfo();
            fansCustomerInfo.setAvatar(youzanInfo.getAvatar());
            fansCustomerInfo.setCountry(youzanInfo.getCountry());
            fansCustomerInfo.setProvince(youzanInfo.getProvince());
            fansCustomerInfo.setUserId(youzanInfo.getUserId());
            fansCustomerInfo.setCity(youzanInfo.getCity());
            final Boolean isFollow = youzanInfo.getIsFollow();
            fansCustomerInfo.setIsFollow(StatusParser.toInt(isFollow));
            fansCustomerInfo.setNick(youzanInfo.getNick());
            fansCustomerInfo.setWeixinOpenId(youzanInfo.getWeixinOpenId());
            fansCustomerInfo.setSex(youzanInfo.getSex());
            final Long followTime = youzanInfo.getFollowTime();
            fansCustomerInfo.setFollowTime(new Date(followTime * 1000));

            result.add(fansCustomerInfo);
        }

        return result;
    }

    @Override
    public boolean deleteAllFansCustomerInfo() {
        FansCustomerInfoExample example = new FansCustomerInfoExample();
        return fansCustomerInfoMapper.deleteByExample(example) > 0;
    }
}
