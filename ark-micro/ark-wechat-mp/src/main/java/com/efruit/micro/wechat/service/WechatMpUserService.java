package com.efruit.micro.wechat.service;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.List;

public interface WechatMpUserService {
    /**
     * 获取帐号的关注者列表
     * @return 关注者的openId列表
     * @throws WxErrorException
     */
    List<String> getAllUserList() throws WxErrorException;


    /**
     * 根据openId获取用户基本信息
     * @param openID
     * @return
     * @throws WxErrorException
     */
    WxMpUser getUserInfo(String openID) throws WxErrorException;

    /**
     * 获取用户基本信息列表
     * @return 关注者用户信息列表
     * @throws WxErrorException
     */
    List<WxMpUser> getUserInfoList() throws WxErrorException;
}
