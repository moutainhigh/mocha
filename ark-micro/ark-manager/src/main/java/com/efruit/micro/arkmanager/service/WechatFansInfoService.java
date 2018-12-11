package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.WechatFansInfo;

import java.util.Date;
import java.util.List;

public interface WechatFansInfoService {

    void syncWechatFansInfo();

    boolean saveWechatFansInfoList(List<WechatFansInfo> fansInfoList);

    WechatFansInfo getWechatFansInfoByUnionId(String unionId);

    String getWechatOpenId(String unionId);

    String getWechatOpenIdByFansId(long fansId);

    int getAllFansInfoCount();

    List<WechatFansInfo> getAllWechatFansInfo();

    List<String> getAllWechatFansInfoUnionIdList();

    String checkAndGetValidOpenId(String curUserId, long fansId);

    /**
     * 获取特定日期关注的用户
     * @param targetDate
     * @return
     */
    List<WechatFansInfo> getWechatFansInfoByDate(Date targetDate);

}
