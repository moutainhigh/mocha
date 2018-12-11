package com.efruit.micro.wechat.service;

import me.chanjar.weixin.mp.bean.tag.WxUserTag;

import java.util.List;

public interface WechatTagUserService {
    void batchTaggingAll(WxUserTag wxUserTag, List<String> validOpenIdList);

    List<String> getTagUserList(WxUserTag wxUserTag);
}
