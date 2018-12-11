package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.FansInfoMapper;
import com.efruit.micro.arkmanager.pojo.FansInfo;
import com.efruit.micro.arkmanager.pojo.FansInfoExample;
import com.efruit.micro.arkmanager.service.FansInfoService;
import com.efruit.micro.wechat.service.WechatMpUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FansInfoServiceImpl implements FansInfoService {

    @Autowired
    WechatMpUserService wechatMpUserService;

    @Autowired
    FansInfoMapper fansInfoMapper;

    @Async
    @Override
    public void syncWechatUserInfo() throws WxErrorException {
        final List<WxMpUser> userInfoList = wechatMpUserService.getUserInfoList();
        final List<FansInfo> fansInfos = toFansInfo(userInfoList);
        fansInfoMapper.insertList(fansInfos);
    }

    private List<FansInfo> toFansInfo(List<WxMpUser> wxMpUserList) {
        List<FansInfo> result = new ArrayList<>();
        for (WxMpUser wxMpUser : wxMpUserList) {
            FansInfo fansInfo = new FansInfo();
            fansInfo.setOpenid(wxMpUser.getOpenId());
            fansInfo.setNickname(wxMpUser.getNickname());
            fansInfo.setSubscribeScene(wxMpUser.getSubscribeScene());
            fansInfo.setUnionid(wxMpUser.getUnionId());
            final Long subscribeTime = wxMpUser.getSubscribeTime();
            fansInfo.setSubscribeTime(new Date(subscribeTime * 1000));
            final Long[] tagIds = wxMpUser.getTagIds();
            if (tagIds != null && tagIds.length > 0) {
                fansInfo.setTagidList(StringUtils.join(tagIds, ","));
            }
            result.add(fansInfo);
        }
        return result;
    }

    @Override
    public FansInfo getFansInfo(String openId) {
        FansInfoExample example = new FansInfoExample();
        final FansInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOpenidEqualTo(openId);
        final List<FansInfo> fansInfos = fansInfoMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(fansInfos)) {
            return fansInfos.get(0);
        }
        return null;
    }

    @Override
    public List<FansInfo> getFansInfoList() {
        FansInfoExample example = new FansInfoExample();
        final List<FansInfo> fansInfos = fansInfoMapper.selectByExample(example);
        return fansInfos;
    }
}
