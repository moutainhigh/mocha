package com.efruit.micro.arkmanager.common;

import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.arkmanager.def.SendMsgDef;
import com.efruit.micro.wechat.service.WechatMpService;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanItemGetResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WechatTest extends BaseTest {

    @Autowired
    WechatMpService wechatMpService;

    @Autowired
    YouzanService youzanService;

    @Test
    public void testActionTemplate() throws Exception {

        YouzanItemGetResult.ItemDetailOpenModel youzanItemByAlias = null;
        final String alias = "2x5i2x9t9zf2u";
        try {
            youzanItemByAlias = youzanService.getYouzanItemByAlias(alias);
        } catch (YouzanApiException e) {
//            LOGGER.info("getYouzanItemByAlias error, alias : {}", alias, e);
        }

        if (youzanItemByAlias == null) {
            return;
        }

        String clickUrl = "https://h5.youzan.com/v2/goods/2x5i2x9t9zf2u";

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("oxcef0UoUul8OOM2McC3j-vAOHNg")
                .templateId("kFrcxT3yRNFhTCdxB5g6d3HE_8tPEJtid_2A5M1KkfA")
                .url(clickUrl)
                .build();

        final String title = youzanItemByAlias.getTitle();
        final String tid = "E20180920131005075100002";
        final String productName = "福建平和柚子";
        final String fetchInfoName = "金隅嘉华大厦";

        StringBuilder remark = new StringBuilder();
        remark.append("优惠信息: " + title + "\n");
        if (!StringUtils.isEmpty(fetchInfoName)) {
            remark.append("(仅限" + fetchInfoName + ")");
        }

        templateMessage
                .addData(new WxMpTemplateData("first", "您的商品已经配送成功", "#000000"))
                .addData(new WxMpTemplateData("keyword1", tid, "#000000"))
                .addData(new WxMpTemplateData("keyword2", productName, "#000000"))
                .addData(new WxMpTemplateData("remark", remark.toString(), "#FF0000"));

        try {
            final String msgId = wechatMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            final boolean sucSend = !StringUtils.isEmpty(msgId);
//            saveSendMsg(order, sucSend, "", SendMsgDef.MSG_TYPE_TEMPLATE, SendMsgDef.SEND_REASON_ORDER_PAY);
//            return sucSend;
        } catch (WxErrorException e) {
//            LOGGER.info("sendTemplateMsg error. ", e);
//            saveSendMsg(order, false, e.getMessage(), SendMsgDef.MSG_TYPE_TEMPLATE, SendMsgDef.SEND_REASON_ORDER_PAY);
        }

    }
}
