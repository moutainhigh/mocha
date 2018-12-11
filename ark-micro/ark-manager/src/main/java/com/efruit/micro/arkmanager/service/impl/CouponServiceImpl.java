package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.bean.MsgPushEntity;
import com.efruit.micro.arkmanager.def.SendMsgDef;
import com.efruit.micro.arkmanager.pojo.SendMsg;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.utils.FileHelper;
import com.efruit.micro.arkmanager.utils.PriceFormatter;
import com.efruit.micro.arkmanager.utils.ThreadUtils;
import com.efruit.micro.wechat.service.WechatMpService;
import com.efruit.micro.youzan.bean.ArkOrder;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponServiceImpl.class);

    private static final String[] MATCH_TYPE = {"trade_TradeBuyerPay"};

    //    private static final String TEST_USER_ID = "oxcef0UoUul8OOM2McC3j-vAOHNg";
    private static final String TEST_USER_ID = "";

    private static final String BASE_PUSH_URL = "https://h5.youzan.com/wsctrade/order/detail?order_no=%s&kdt_id=%d";
    private static final String DEFAULT_MY_ORDER_URL = "https://h5.youzan.com/v2/usercenter/B3iba7fynH";

    @Autowired
    WechatFansInfoService wechatFansInfoService;

    @Autowired
    private SendMsgService sendMsgService;

    @Autowired
    private YouzanService youzanService;

    @Autowired
    private WechatMpService wechatMpService;

    @Autowired
    private ActWechatGroupService actWechatGroupService;

    private boolean shouldProcess(String type) {
        for (String str : MATCH_TYPE) {
            if (StringUtils.equalsIgnoreCase(str, type)) {
                return true;
            }
        }

        return false;
    }

    @Override
    @Async
    public void processCouponPush(MsgPushEntity entity) {
        final String type = entity.getType();
        if (!shouldProcess(type)) {
            return;
        }

        final String tid = entity.getId();
        if (StringUtils.isEmpty(tid)) {
            return;
        }

        ArkOrder arkOrder = null;
        try {
            arkOrder = youzanService.getArkOrderByTid(tid);
        } catch (YouzanApiException e) {
            LOGGER.info("getArkOrderByTid() error. : ", e);
        }

        if (arkOrder == null) {
            LOGGER.info("getArkOrderByTid error , tid : {}", tid);
            return;
        }

        // 延迟发送
        ThreadUtils.sleep(3000);

        processOrderPaymentPush(arkOrder, entity);

//        processWechatGroup(arkOrder);

    }

    private String fixOrderUserId(ArkOrder order) {
        if (order == null) {
            return "";
        }

        final String unionId = order.getUnionId();
        if (StringUtils.isEmpty(unionId)) {
            return "";
        }
        final String validUserId = wechatFansInfoService.getWechatOpenId(unionId);
        if (!StringUtils.isEmpty(validUserId)) {
            order.setUserId(validUserId);
        }

        return validUserId;
    }

    private void processWechatGroup(ArkOrder arkOrder) {
        final String fetchInfoName = arkOrder.getFetchInfoName();
        if (StringUtils.isEmpty(fetchInfoName)) {
            return;
        }

        final String validUserId = fixOrderUserId(arkOrder);

        final int sendReasonActionWechatGroup = SendMsgDef.SEND_REASON_ACTION_WECHAT_GROUP;
        final boolean hasSendBefore = sendMsgService.hasSendBefore(validUserId, sendReasonActionWechatGroup);
        if (hasSendBefore) {
            LOGGER.info("processWechatGroup() error. hasSendBefore is true, tid : {}, userId : {}", arkOrder.getTid(), validUserId);
            return;
        }

        final File actImage = actWechatGroupService.getActImage(fetchInfoName);
        if (!FileHelper.checkValid(actImage)) {
            return;
        }

        final boolean sendImageMessageByKefu = sendImageMessageByKefu(actImage, arkOrder, sendReasonActionWechatGroup);
        if (sendImageMessageByKefu) {
            sendWechatGroupTextHintMessage(arkOrder);
        }
    }

    private boolean sendWechatGroupTextHintMessage(ArkOrder arkOrder) {
        WxMpKefuMessage message = WxMpKefuMessage.TEXT()
                .toUser(arkOrder.getUserId())
                .content("感谢您体验多吃水果的服务，想要更多一手福利，欢迎加福利群")
                .build();

        try {
            final boolean sendKefuMessage = wechatMpService.getKefuService().sendKefuMessage(message);
            saveSendMsg(arkOrder, sendKefuMessage, "", SendMsgDef.MSG_TYPE_KEFU, SendMsgDef.SEND_REASON_ACTION_WECHAT_GROUP_TEXT_HINT);
            return sendKefuMessage;
        } catch (WxErrorException e) {
            LOGGER.info("sendWechatGroupTextHintMessage failed.", e);
            saveSendMsg(arkOrder, false, e.getMessage(), SendMsgDef.MSG_TYPE_KEFU, SendMsgDef.SEND_REASON_ACTION_WECHAT_GROUP_TEXT_HINT);
        }

        return false;
    }

    private void processOrderPaymentPush(ArkOrder arkOrder, MsgPushEntity entity) {
        fixOrderUserId(arkOrder);
        final String orderPaymentPushUrl = getOrderPaymentPushUrl(arkOrder.getTid(), entity.getKdt_id());
        final boolean sendTemplateMsg = sendTemplateMsg(arkOrder, orderPaymentPushUrl);
        LOGGER.info("processOrderPaymentPush() : sendTemplateMsg: {}", sendTemplateMsg);
    }

    private static String getOrderPaymentPushUrl(String tid, Integer kdtId) {
        if (StringUtils.isEmpty(tid) || kdtId == null) {
            return DEFAULT_MY_ORDER_URL;
        }
        return String.format(BASE_PUSH_URL, tid, kdtId);
    }

    private boolean sendTemplateMsg(ArkOrder order, String clickUrl) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(order.getUserId())
                .templateId(SendMsgDef.TEMPLATE_MSG_ID_ORDER_PAY)
                .url(clickUrl)
                .build();

        final String price = PriceFormatter.format(order.getPayment());

        templateMessage
                .addData(new WxMpTemplateData("first", "亲，您的商品已订购成功，预计下一个工作日发货，请届时留意到货通知。", "#FF0000"))
                .addData(new WxMpTemplateData("orderMoneySum", price + "元", "#005EFF"))
                .addData(new WxMpTemplateData("orderProductName", order.getProductName() + "\n", "#005EFF"))
                .addData(new WxMpTemplateData("Remark", "生鲜产品保质期很短，收到通知后请尽快签收并享用。", "#FF0000"));
        try {
            final String msgId = wechatMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            final boolean sucSend = !StringUtils.isEmpty(msgId);
            saveSendMsg(order, sucSend, "", SendMsgDef.MSG_TYPE_TEMPLATE, SendMsgDef.SEND_REASON_ORDER_PAY);
            return sucSend;
        } catch (WxErrorException e) {
            LOGGER.info("sendTemplateMsg error. ", e);
            saveSendMsg(order, false, e.getMessage(), SendMsgDef.MSG_TYPE_TEMPLATE, SendMsgDef.SEND_REASON_ORDER_PAY);
        }

        return false;
    }

    private boolean sendImageMessageByKefu(File image, ArkOrder arkOrder, int sendReason) {
        WxMediaUploadResult wxMediaUploadResult = null;
        try {
            WxMpMaterialService materialService = wechatMpService.getMaterialService();
            wxMediaUploadResult = materialService.mediaUpload(WxConsts.MediaFileType.IMAGE, image);
        } catch (WxErrorException e) {
            LOGGER.info("image upload failed.", e);
            saveSendMsg(arkOrder, false, e.getMessage(), SendMsgDef.MSG_TYPE_KEFU, sendReason);
        }

        if (wxMediaUploadResult == null) {
            return false;
        }

        String mediaId = wxMediaUploadResult.getMediaId();

        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConsts.KefuMsgType.IMAGE);
        if (!StringUtils.isEmpty(TEST_USER_ID)) {
            message.setToUser(TEST_USER_ID);
        } else {
            message.setToUser(arkOrder.getUserId());
        }
        message.setMediaId(mediaId);
        try {
            final boolean sendKefuMessage = wechatMpService.getKefuService().sendKefuMessage(message);
            saveSendMsg(arkOrder, sendKefuMessage, "", SendMsgDef.MSG_TYPE_KEFU, sendReason);
            return sendKefuMessage;
        } catch (WxErrorException e) {
            LOGGER.info("sendKefuMessage failed.", e);
            saveSendMsg(arkOrder, false, e.getMessage(), SendMsgDef.MSG_TYPE_KEFU, sendReason);
        }

        return false;
    }

    private void saveSendMsg(ArkOrder arkOrder, boolean isSuccess, String errorMsg) {
        saveSendMsg(arkOrder, isSuccess, errorMsg, SendMsgDef.MSG_TYPE_KEFU, SendMsgDef.SEND_REASON_COUPON_PAGE);
    }

    private void saveSendMsg(ArkOrder arkOrder, boolean isSuccess, String errorMsg, int type, int sendReason) {
        SendMsg sendMsg = new SendMsg();
        sendMsg.setUserId(arkOrder.getUserId());
        sendMsg.setSendDate(new Date());
        sendMsg.setName(arkOrder.getReceiverName());
        sendMsg.setMobile(arkOrder.getReceiverMobile());
        sendMsg.setTid(arkOrder.getTid());
        sendMsg.setSuccess(isSuccess ? SendMsgDef.SUCCESS : SendMsgDef.FAIL);
        sendMsg.setType(type);
        sendMsg.setSendReason(sendReason);
        sendMsg.setErrorInfo(errorMsg);
        sendMsgService.saveSendMsg(sendMsg);
    }

}
