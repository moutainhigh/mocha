package com.efruit.micro.wechat.service.impl;

import com.efruit.micro.wechat.service.WechatMpService;
import com.efruit.micro.wechat.service.WechatMpUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WechatMpUserServiceImpl implements WechatMpUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WechatMpUserServiceImpl.class);

    private static final int MAX_USER_LIST_PAGE_COUNT = 10000;
    private static final int MAX_BATCH_SIZE = 100;

    @Autowired
    WechatMpService wechatMpService;

    @Override
    public List<String> getAllUserList() throws WxErrorException {
        List<String> result = new ArrayList<>();
        final WxMpUserService userService = wechatMpService.getUserService();
        WxMpUserList wxMpUserList = userService.userList(null);
        if (wxMpUserList == null) {
            return result;
        }

        result.addAll(wxMpUserList.getOpenids());

        final long total = wxMpUserList.getTotal();
        if (total > MAX_USER_LIST_PAGE_COUNT) {
            String nextOpenid = wxMpUserList.getNextOpenid();
            while (!StringUtils.isEmpty(nextOpenid)) {
                wxMpUserList = userService.userList(nextOpenid);
                if (wxMpUserList == null) {
                    break;
                }

                result.addAll(wxMpUserList.getOpenids());
                nextOpenid = wxMpUserList.getNextOpenid();
            }
        }

        return result;
    }

    @Override
    public WxMpUser getUserInfo(String openID) throws WxErrorException {
        final WxMpUserService userService = wechatMpService.getUserService();
        final WxMpUser wxMpUser = userService.userInfo(openID);
        return wxMpUser;
    }

    @Override
    public List<WxMpUser> getUserInfoList() throws WxErrorException {
        final List<String> allUserList = getAllUserList();
        return getAllUserInfoList(allUserList);
    }

    /**
     * 获取用户基本信息列表，微信接口限制id个数每次为100，已经实现分批获取。
     * @param openIdList
     * @return
     */
    private List<WxMpUser> getAllUserInfoList(List<String> openIdList) {
        final List<WxMpUser> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(openIdList)) {
            return result;
        }

        final WxMpUserService userService = wechatMpService.getUserService();

        final int totalCount = openIdList.size();
        int requestTimes = totalCount / MAX_BATCH_SIZE;
        int sucTimes = 0;

        LOGGER.info("getAllUserInfoList start, requestTimes : {}", requestTimes);
        for (int i = 0; i <= requestTimes; i++) {
            int fromIndex = i * MAX_BATCH_SIZE;
            int toIndex = Math.min(totalCount, (i + 1) * MAX_BATCH_SIZE);

            List<String> subList = openIdList.subList(fromIndex, toIndex);
            try {
                final List<WxMpUser> wxMpUsers = userService.userInfoList(subList);
                if (!CollectionUtils.isEmpty(wxMpUsers)) {
                    result.addAll(wxMpUsers);
                    sucTimes++;
                }
            } catch (WxErrorException e) {
                LOGGER.info("getAllUserInfoList error, requestTimes : {}, cur : {}, totalSucCount : {}", requestTimes, i, sucTimes, e);
            }

            LOGGER.info("getAllUserInfoList for, requestTimes : {}, cur : {}, totalSucCount : {}", requestTimes, i, sucTimes);
            if (toIndex == totalCount) {
                break;
            }
        }

        LOGGER.info("getAllUserInfoList finish , requestTimes : {} , sucTimes : {}", requestTimes, sucTimes);

        return result;
    }
}
