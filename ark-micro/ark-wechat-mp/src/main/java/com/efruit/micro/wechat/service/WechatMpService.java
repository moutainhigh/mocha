package com.efruit.micro.wechat.service;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

public interface WechatMpService extends WxMpService {

    WxMpXmlOutMessage route(WxMpXmlMessage message);
}
