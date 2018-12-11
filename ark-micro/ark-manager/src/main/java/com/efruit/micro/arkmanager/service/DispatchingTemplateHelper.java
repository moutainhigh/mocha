package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.def.SendMsgDef;
import com.efruit.micro.wechat.service.WechatMpService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispatchingTemplateHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingTemplateHelper.class);

    @Autowired
    private WechatMpService wechatMpService;

    /**
     * 商品明细：itemInfos
     * 配送地址：address
     * 配送人：deliver
     * 联系电话：mobile
     * @param messageInfo
     * @param clickUrl
     * @return
     */
    public boolean sendDispatchingMsgInfo(MessageInfo messageInfo, String clickUrl) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(messageInfo.getUserId())
                .templateId(SendMsgDef.TEMPLATE_MSG_ID_DISPATCHING)
                .url(clickUrl)
                .build();

        String address = messageInfo.getAddress();
        final String addressDetail = messageInfo.getAddressDetail();
        if (StringUtils.isNotEmpty(addressDetail)) {
            address = address + "(" + addressDetail + ")";
        }
        templateMessage
                .addData(new WxMpTemplateData("first", "您好，您订购的商品到了，请及时到自提点领取。【取货码：" + messageInfo.getFetchCode() + "】", "#FF0000"))
                .addData(new WxMpTemplateData("keyword1", messageInfo.getItemInfos(), "#000000"))
                .addData(new WxMpTemplateData("keyword2", address, "#000000"))
                .addData(new WxMpTemplateData("keyword3", messageInfo.getDeliver(), "#000000"))
                .addData(new WxMpTemplateData("keyword4", messageInfo.getMobile(), "#000000"))
                .addData(new WxMpTemplateData("remark", "点击详情，查看自提点所在的地图位置。", "#FF0000"));
        try {
            final String msgId = wechatMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            final boolean sucSend = !StringUtils.isEmpty(msgId);
            LOGGER.info("sendDispatchingMsgInfo sucSend : {}", sucSend);
            return sucSend;
        } catch (WxErrorException e) {
            LOGGER.info("sendTemplateMsg error. ", e);
            return false;
        }
    }

    public static class MessageInfo {
        private String userId;
        private String itemInfos;
        private String address;
        private String addressDetail;
        private String deliver;
        private String mobile;
        private String fetchCode;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getItemInfos() {
            return itemInfos;
        }

        public void setItemInfos(String itemInfos) {
            this.itemInfos = itemInfos;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getDeliver() {
            return deliver;
        }

        public void setDeliver(String deliver) {
            this.deliver = deliver;
        }

        public String getFetchCode() {
            return fetchCode;
        }

        public void setFetchCode(String fetchCode) {
            this.fetchCode = fetchCode;
        }
    }
}
