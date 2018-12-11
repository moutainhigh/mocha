package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.WechatFansInfoMapper;
import com.efruit.micro.arkmanager.pojo.WechatFansInfo;
import com.efruit.micro.arkmanager.pojo.WechatFansInfoExample;
import com.efruit.micro.arkmanager.service.WechatFansInfoService;
import com.efruit.micro.wechat.service.WechatMpUserService;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class WechatFansInfoServiceImpl implements WechatFansInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatFansInfoServiceImpl.class);

    private static final long HOUR = 60 * 60 * 1000L;

    private static final String REDIS_KEY_LAST_SYNC_WECHAT_FANS_INFO = "last_sync_wechat_fans_info";

    private static final String MP_USER_PREF = "oVVo00";

    private AtomicBoolean isSyncing = new AtomicBoolean(false);

    @Autowired
    WechatMpUserService wechatMpUserService;

    @Autowired
    WechatFansInfoMapper wechatFansInfoMapper;

    @Autowired
    YouzanService youzanService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Async
    @Override
    public void syncWechatFansInfo() {
        LOGGER.info("syncWechatFansInfo start...");

        if (isSyncing.get()) {
            LOGGER.info("syncWechatFansInfo was syncing. return.");
            return;
        }

        if (!needSync()) {
            LOGGER.info("syncWechatFansInfo needSync is false. return.");
            return;
        }

        isSyncing.set(true);

        try {
            final boolean syncFansInfo = innerSyncFansInfo();
            if (syncFansInfo) {
                saveLastSyncTime();
            }
        } finally {
            isSyncing.set(false);
        }
    }

    private void saveLastSyncTime() {
        final long currentTimeMillis = System.currentTimeMillis();
        stringRedisTemplate.opsForValue().set(REDIS_KEY_LAST_SYNC_WECHAT_FANS_INFO, String.valueOf(currentTimeMillis));
    }

    private boolean needSync() {
        final String lastSyncDateTime = stringRedisTemplate.opsForValue().get(REDIS_KEY_LAST_SYNC_WECHAT_FANS_INFO);
        if (lastSyncDateTime == null) {
            return true;
        }

        long lastSyncMillis = 0L;

        try {
            lastSyncMillis = Long.parseLong(lastSyncDateTime);
        } catch (Exception e) {
            LOGGER.info("check sync time error.", e);
        }

        final long nowMillis = System.currentTimeMillis();
        final long interval = Math.abs(nowMillis - lastSyncMillis);
        if (interval > 2 * HOUR) {
            return true;
        }

        return false;
    }

    private boolean innerSyncFansInfo() {
        List<WxMpUser> userInfoList = null;
        try {
            userInfoList = wechatMpUserService.getUserInfoList();
        } catch (WxErrorException e) {
            LOGGER.info("syncWechatFansInfo error.", e);
        }

        if (CollectionUtils.isEmpty(userInfoList)) {
            LOGGER.info("syncWechatFansInfo error, userInfoList is empty.");
            return false;
        }

        final List<WechatFansInfo> newWechatFansInfos = toFansInfo(userInfoList);
        if (CollectionUtils.isEmpty(newWechatFansInfos)) {
            LOGGER.info("syncWechatFansInfo error, newWechatFansInfos is empty.");
            return false;
        }

        if (isFirstInit()) {
            LOGGER.info("syncWechatFansInfo isFirstInit, saveWechatFansInfoList start...");
            return saveWechatFansInfoList(newWechatFansInfos);
        } else {
            LOGGER.info("syncWechatFansInfo isFirstInit is false, need process new update fans list...");

            final List<String> allWechatFansInfoUnionIdList = getAllWechatFansInfoUnionIdList();
            final List<WechatFansInfo> needAddList = new ArrayList<>();
            for (WechatFansInfo newFansInfo : newWechatFansInfos) {
                final String newFansInfoUnionid = newFansInfo.getUnionid();
                if (StringUtils.isEmpty(newFansInfoUnionid)) {
                    continue;
                }

                if (allWechatFansInfoUnionIdList.contains(newFansInfoUnionid)) {
                    continue;
                }

                needAddList.add(newFansInfo);
            }

            if (!CollectionUtils.isEmpty(needAddList)) {
                return saveWechatFansInfoList(needAddList);
            }

        }

        return false;
    }

    @Override
    public boolean saveWechatFansInfoList(List<WechatFansInfo> fansInfoList) {
        return wechatFansInfoMapper.insertList(fansInfoList) > 0;
    }

    @Override
    public WechatFansInfo getWechatFansInfoByUnionId(String unionId) {
        return wechatFansInfoMapper.selectByPrimaryKey(unionId);
    }

    @Override
    public String getWechatOpenId(String unionId) {
        final WechatFansInfo wechatFansInfoByUnionId = getWechatFansInfoByUnionId(unionId);
        if (wechatFansInfoByUnionId == null) {
            return "";
        }
        return wechatFansInfoByUnionId.getOpenid();
    }

    @Override
    public String getWechatOpenIdByFansId(long fansId) {
        if (fansId <= 0) {
            return "";
        }

        YouzanUsersWeixinFollowerGetResult.CrmWeixinFans youzanUserInfo = null;

        try {
            youzanUserInfo = youzanService.getYouzanUserInfo(fansId);
        } catch (YouzanApiException e) {
            LOGGER.info("getWechatOpenIdByFansId error.", e);
        }

        if (youzanUserInfo == null) {
            return "";
        }

        final String unionId = youzanUserInfo.getUnionId();
        if (StringUtils.isEmpty(unionId)) {
            return "";
        }

        return getWechatOpenId(unionId);
    }

    @Override
    public int getAllFansInfoCount() {
        final WechatFansInfoExample example = new WechatFansInfoExample();
        return wechatFansInfoMapper.countByExample(example);
    }

    @Override
    public List<WechatFansInfo> getAllWechatFansInfo() {
        final WechatFansInfoExample example = new WechatFansInfoExample();
        return wechatFansInfoMapper.selectByExample(example);
    }

    @Override
    public List<String> getAllWechatFansInfoUnionIdList() {
        return wechatFansInfoMapper.selectAllUnionId();
    }

    @Override
    public String checkAndGetValidOpenId(String curUserId, long fansId) {
        final boolean isMpUser = StringUtils.startsWithAny(curUserId, MP_USER_PREF);
        if (isMpUser) {
            return curUserId;
        }

        final String wechatOpenId = getWechatOpenIdByFansId(fansId);
        if (StringUtils.isEmpty(wechatOpenId)) {
            return wechatOpenId;
        }

        return curUserId;
    }

    @Override
    public List<WechatFansInfo> getWechatFansInfoByDate(Date targetDate) {
        return wechatFansInfoMapper.getWechatFansInfoByDate(targetDate);
    }

    private boolean isFirstInit() {
        final boolean isFirstInit = getAllFansInfoCount() == 0;
        return isFirstInit;
    }

    private List<WechatFansInfo> toFansInfo(List<WxMpUser> wxMpUserList) {
        List<WechatFansInfo> result = new ArrayList<>();
        for (WxMpUser wxMpUser : wxMpUserList) {

            final String unionId = wxMpUser.getUnionId();
            if (StringUtils.isEmpty(unionId)) {
                continue;
            }

            WechatFansInfo fansInfo = new WechatFansInfo();
            fansInfo.setOpenid(wxMpUser.getOpenId());
            fansInfo.setNickname(wxMpUser.getNickname());
            fansInfo.setSubscribeScene(wxMpUser.getSubscribeScene());
            fansInfo.setUnionid(unionId);
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


}
