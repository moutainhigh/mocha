package com.efruit.micro.arkgift.controller;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkgift.util.SHA1Util;
import com.efruit.micro.arkgift.util.StringUtil;
import com.efruit.micro.wechat.service.WechatMpService;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 微信交互相关的接口
 *
 * @author wangyang
 */
@Controller
@RequestMapping("mp")
public class MpController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MpController.class);

    @Autowired
    private WechatMpService wechatMpService;

    /**
     * 微信公众号信息
     */
    @Value("${wx_appid}")
    private String appid;
    @Value("${wx_appsecret}")
    private String appsecret;

    /**
     * 获取微信openid
     *
     * @param code 微信返回的code，用户获取openid
     */
    @RequestMapping("getOpenId")
    @ResponseBody
    public ArkCommonResult getOpenId(@RequestParam String code) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        try {
            wxMpOAuth2AccessToken = wechatMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            String errorMsg = "oauth2getAccessToken error";
            LOGGER.info(errorMsg, e);
            final WxError error = e.getError();
            if (error != null) {
                errorMsg = error.getErrorMsg();
            }
            return ArkCommonResult.fail(errorMsg);
        }

        final String openId = wxMpOAuth2AccessToken.getOpenId();
        if (StringUtils.isEmpty(openId)) {
            return ArkCommonResult.fail("openId invalid.");
        }

        return ArkCommonResult.ok(openId);
    }

    /**
     * jsConfig接口
     *
     * @param url 地址
     */
    @RequestMapping("getWxJsConfig")
    @ResponseBody
    public ArkCommonResult getWxJsConfig(@RequestParam String url) {
        String jsapiTicket = null;
        try {
            jsapiTicket = wechatMpService.getJsapiTicket();
        } catch (WxErrorException e) {
            LOGGER.info("getJsapiTicket error.", e);
        }

        if (StringUtils.isEmpty(jsapiTicket)) {
            return ArkCommonResult.fail("getJsapiTicket error.");
        }

        String nonceStr = StringUtil.getUUID();
        long timestamp = System.currentTimeMillis() / 1000;
        String result = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        String sign = SHA1Util.encode(result);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("appId", appid);
        map.put("timestamp", timestamp);
        map.put("nonceStr", nonceStr);
        map.put("signature", sign);
        return ArkCommonResult.ok(map);
    }
}
