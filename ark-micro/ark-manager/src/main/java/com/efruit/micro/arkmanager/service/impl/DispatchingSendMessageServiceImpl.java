package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.bean.DispatchingCondition;
import com.efruit.micro.arkmanager.bean.DispatchingItemInfo;
import com.efruit.micro.arkmanager.bean.DispatchingOrderListResult;
import com.efruit.micro.arkmanager.bean.MessageEntity;
import com.efruit.micro.arkmanager.config.EnvConfig;
import com.efruit.micro.arkmanager.def.SendMsgDef;
import com.efruit.micro.arkmanager.mq.RabbitMq4Message;
import com.efruit.micro.arkmanager.pojo.*;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.service.model.Code;
import com.efruit.micro.arkmanager.utils.VoiceSMSHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DispatchingSendMessageServiceImpl implements DispatchingSendMessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingSendMessageServiceImpl.class);
    private static final String DEFAULT_USER_SITE_MAP = "http://wx-page.efruitpro.com/web/distribution/user/site_map";
    private static final int MIN_PERMIT_HOUR = 10;
    private static final int MAX_PERMIT_HOUR = 19;
    @Autowired
    DispatchingTemplateHelper dispatchingTemplateHelper;
    @Autowired
    SendMsgService sendMsgService;
    @Autowired
    SMSHelper smsHelper;
    @Autowired
    EnvConfig envConfig;
    @Autowired
    DispatchingCourierInfoService courierInfoService;
    @Autowired
    RabbitMq4Message rabbitMq4Message;
    @Autowired
    DispatchingAddressInfoService addressInfoService;
    @Autowired
    DispatchingBuyerInfoService buyerInfoService;

    @Override
    @Async
    public void processMessageSend(MessageEntity messageEntity) {
        final String userId = messageEntity.getUserId();
        if (isSendByDate(userId)) {
            LOGGER.info("processMessageSend() has send before.");
            return;
        }
        DispatchingTemplateHelper.MessageInfo messageInfo = new DispatchingTemplateHelper.MessageInfo();
        messageInfo.setUserId(userId);
        messageInfo.setItemInfos(messageEntity.getExtraParam());
        final String fetchName = messageEntity.getFetchName();
        messageInfo.setAddress(fetchName);
        final String deliverName = messageEntity.getDeliverName();
        messageInfo.setDeliver(deliverName);
        final String deliverMobile = messageEntity.getDeliverMobile();
        messageInfo.setMobile(deliverMobile);
        final String fetchCode = messageEntity.getFetchCode();
        messageInfo.setFetchCode(fetchCode);
        final String addressDetail = messageEntity.getAddressDetail();
        messageInfo.setAddressDetail(addressDetail);

        final StringBuilder url = new StringBuilder(DEFAULT_USER_SITE_MAP);
        url.append("?lat=").append(messageEntity.getDeliverLat());
        url.append("&lon=").append(messageEntity.getDeliverLon());
        url.append("&name=").append(deliverName);
        url.append("&mobile=").append(deliverMobile);
        final boolean sucSendTemplate = dispatchingTemplateHelper.sendDispatchingMsgInfo(messageInfo, url.toString());
        saveSendMsg(messageEntity, sucSendTemplate, "", SendMsgDef.MSG_TYPE_TEMPLATE, "");

        // 短信
        LOGGER.info("sms start...");
        final String userMobile = messageEntity.getUserMobile();
        try {
            final SendSmsResponse sendSmsResponse = smsHelper.sendDefaultSMS(userMobile, fetchName, addressDetail, deliverMobile, fetchCode);
            final String code = sendSmsResponse.getCode();
            final String message = sendSmsResponse.getMessage();
            final String bizId = sendSmsResponse.getBizId();
            LOGGER.info("sendDefaultSMS() code : {} , message : {}", code, message);
            final boolean sucSendSMS = StringUtils.equalsIgnoreCase(code, "OK");
            saveSendMsg(messageEntity, sucSendSMS, message, SendMsgDef.MSG_TYPE_SMS, bizId);
        } catch (ClientException e) {
            LOGGER.info("processMessageSend() sendDefaultSMS error. ", e);
        }

        // 语音短信
        LOGGER.info("voice sms start...");
        final VoiceSMSHelper.SendResult sendResult = VoiceSMSHelper.sendDefaultVoiceSMS(userMobile, fetchName, deliverMobile);
        saveSendMsg(messageEntity, sendResult.isSuccess(), sendResult.getResultCode(), SendMsgDef.MSG_TYPE_VOICE_SMS, sendResult.getOrderId());
    }

    private void saveSendMsg(MessageEntity messageEntity, boolean isSuccess, String errorMsg, int type, String extra) {
        SendMsg sendMsg = new SendMsg();
        sendMsg.setUserId(messageEntity.getUserId());
        sendMsg.setSendDate(new Date());
        sendMsg.setName("");
        sendMsg.setMobile(messageEntity.getUserMobile());
        sendMsg.setTid("");
        sendMsg.setSuccess(isSuccess ? SendMsgDef.SUCCESS : SendMsgDef.FAIL);
        sendMsg.setType(type);
        sendMsg.setSendReason(SendMsgDef.SEND_REASON_DISPATCHING);
        sendMsg.setErrorInfo(errorMsg);
        sendMsg.setExtra(extra);
        sendMsgService.saveSendMsg(sendMsg);
    }

    private boolean isSendByDate(String userId) {
        if (envConfig.isDev) {
            return false;
        }
        return sendMsgService.isSendByDate(userId, DateTime.now().toDate(), SendMsgDef.SEND_REASON_DISPATCHING);
    }

    @Override
    public ArkCommonResult sendSms(DispatchingCondition condition) {
        if (!canSendMessageNow()) {
            LOGGER.info("canSendMessageNow is false.");
            return ArkCommonResult.fail("当前时间不允许发送通知，请联系管理员");
        }
        //校验手机号
        final String courierMobile = condition.getCourierMobile();
        DispatchingCourierInfo courierInfo = courierInfoService.selectByMobile(courierMobile);
        if (courierInfo == null) {
            return ArkCommonResult.build(Code.service_error.getCode(), "手机号不正确");
        }
        //获取需要发送消息的用户
        final Long shopInfoId = condition.getId();
        final Date searchDate = condition.getSearchDate();
        List<DispatchingBuyerInfo> buyerInfoList = buyerInfoService.getSendMsgBuyer(shopInfoId, searchDate);
        if (CollectionUtils.isEmpty(buyerInfoList)) {
            return ArkCommonResult.build(Code.success.getCode(), "该地址订单以配发完！");
        }
        //地址信息
        DispatchingAddressInfo addressInfo = addressInfoService.getDispatchingAddressByShopId(shopInfoId);
        //保存结果数据集
        for (DispatchingBuyerInfo buyerInfo : buyerInfoList) {
            //白名单校验
            final String userId = buyerInfo.getUserId();
//            DispatchingWhiteUser whiteUser = whiteUserMapper.selectByPrimaryKey(userId);
//            //没有在白名单里，不发信息，继续发送下一个用户
//            if (whiteUser == null) {
//                continue;
//            }

            if (isSendByDate(userId)) {
                LOGGER.info("has Send before, userId : {}", userId);
                continue;
            }
            final String jsonString = getMessageJSON(buyerInfo, addressInfo, condition, courierInfo);
            rabbitMq4Message.send(jsonString);

        }
        return ArkCommonResult.build(Code.success.getCode(), "发送成功！");
    }

    private String getMessageJSON(DispatchingBuyerInfo buyerInfo, DispatchingAddressInfo addressInfo, DispatchingCondition condition, DispatchingCourierInfo courierInfo) {
        final MessageEntity messageEntity = new MessageEntity();
        // 用户信息
        final String userId = buyerInfo.getUserId();
        messageEntity.setUserId(userId);
        final String userMobile = buyerInfo.getUserMobile();
        messageEntity.setUserMobile(userMobile);
        final String addressInfoName = addressInfo.getName();
        messageEntity.setFetchName(addressInfoName);
        String addressDetail = condition.getAddressDetails();
        if (StringUtils.isNotEmpty(addressDetail)) {
            messageEntity.setAddressDetail(addressDetail);
        }
        final DispatchingFetchCodeInfo fetchCodeInfo = buyerInfo.getFetchCodeInfo();
        messageEntity.setFetchCode(fetchCodeInfo.getCode());
        // 配送人信息
        messageEntity.setDeliverLat(String.valueOf(condition.getLat()));
        messageEntity.setDeliverLon(String.valueOf(condition.getLon()));
        final String deliverMobile = courierInfo.getMobile();
        messageEntity.setDeliverMobile(deliverMobile);
        final String deliverName = courierInfo.getName();
        messageEntity.setDeliverName(deliverName);

        // 商品明细
        final String itemInfoStr = getItemInfoStr(buyerInfo);
        messageEntity.setExtraParam(itemInfoStr);
        final String jsonString = JSON.toJSONString(messageEntity);
        return jsonString;
    }

    /**
     * 组合订单商品
     * @param buyerInfo
     * @return
     */
    @NotNull
    private String getItemInfoStr(DispatchingBuyerInfo buyerInfo) {
        final List<DispatchingOrder> orderList = buyerInfo.getOrderList();
        final StringBuilder itemInfoStr = new StringBuilder();
        final int size = orderList.size();
        for (int i = 0; i < size; i++) {
            final DispatchingOrder order = orderList.get(i);
            final List<DispatchingOrderDetailsInfo> orderDetailsInfoList = order.getOrderDetailsInfoList();
            int orderDetailsIndex = 0;
            for (DispatchingOrderDetailsInfo orderDetailsInfo : orderDetailsInfoList) {
                final DispatchingCommodityInfo commodityInfo = orderDetailsInfo.getCommodityInfo();
                final String title = commodityInfo.getTitle();
                final Long count = orderDetailsInfo.getOrderNum();
                if (orderDetailsIndex == 0) {
                    itemInfoStr.append("\n");
                }
                itemInfoStr.append("    ")
                        .append(title)
                        .append(" × ")
                        .append(count).append("\n");
                orderDetailsIndex++;
            }
        }
        return itemInfoStr.toString();
    }

    private boolean canSendMessageNow() {
        if (envConfig.isDev) {
            return true;
        }
        final DateTime now = DateTime.now();
        final int hourOfDay = now.getHourOfDay();
        if (hourOfDay >= MIN_PERMIT_HOUR && hourOfDay <= MAX_PERMIT_HOUR) {
            return true;
        }
        return false;
    }
}
