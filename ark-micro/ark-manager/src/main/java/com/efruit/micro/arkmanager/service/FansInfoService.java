package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.FansInfo;
import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;

public interface FansInfoService {
    void syncWechatUserInfo() throws WxErrorException;

    FansInfo getFansInfo(String openId);

    List<FansInfo> getFansInfoList();
}
