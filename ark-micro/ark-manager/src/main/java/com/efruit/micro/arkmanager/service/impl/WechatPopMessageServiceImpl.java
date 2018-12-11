package com.efruit.micro.arkmanager.service.impl;


import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkcommon.utils.DateFormatHelper;
import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.bean.QueryResult;
import com.efruit.micro.arkmanager.def.SendMsgDef;
import com.efruit.micro.arkmanager.pojo.AOrder;
import com.efruit.micro.arkmanager.pojo.SendMsg;
import com.efruit.micro.arkmanager.pojo.WechatFansInfo;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.utils.StatUrlParser;
import com.efruit.micro.wechat.service.WechatMpService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.material.WxMediaImgUploadResult;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.chanjar.weixin.mp.builder.kefu.NewsBuilder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class WechatPopMessageServiceImpl implements WechatPopMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatPopMessageServiceImpl.class);

    private static final String EFRUIT_URL = "http://renderer.rabbitpre.com/m2/aUe1ZjF9lH?mobile=1&lc=1&sui=2cc4d5f2-191f-4de3-8859-fda338dad40a";
    private static final String EFRUIT_TITLE = "可能是你一直在寻找的水果购买方式";

    private static final List<TestCase> TEST_CASE = new ArrayList<>();

    static {
        TEST_CASE.add(new TestCase("A", "感谢支持，点击详情再次获得同等优惠>>", "http://duochishuiguo.mikecrm.com/YAabLiM"));
//        TEST_CASE.add(new TestCase("B", "感谢支持，点击详情30秒了解多吃水果>>", "http://duochishuiguo.mikecrm.com/Nzypej6"));
//        TEST_CASE.add(new TestCase("C", "点击详情完成满意度调查，文末有神券>>", "http://duochishuiguo.mikecrm.com/VLfLFWc"));
    }

    @Autowired
    NewOrderService newOrderService;

    @Autowired
    WechatMpService wechatMpService;

    @Autowired
    SendMsgService sendMsgService;

    @Autowired
    ActTipsService actTipsService;

    @Autowired
    WechatFansInfoService wechatFansInfoService;

    private Random rand = new Random();

    private TestCase getRandomCase() {
        final int size = TEST_CASE.size();
        if (size <= 0) {
            return null;
        }
        final int index = rand.nextInt(size);
        return TEST_CASE.get(index);
    }

    @Override
    public void processPushCSRMsg() {
        OrderCondition orderCondition = new OrderCondition();
        orderCondition.setOnlyNeedValid(1);
        orderCondition.setSelectFrom(OrderCondition.SELECT_FROM_CUSTOM_BATCH_TAGGING);
        final DateTime now = DateTime.now();
        final DateTime endDateTime = now;
        final DateTime startDateTime = now.minusHours(2);
        orderCondition.setStartDate(startDateTime.toDate());
        orderCondition.setEndDate(endDateTime.toDate());
        // FIXME 目前只针对现场下单的用户
        orderCondition.setProductName("现场");
        final ArkCommonResult orderListResult = newOrderService.getOrderList(orderCondition);
        if (!orderListResult.statusOK()) {
            LOGGER.info("processPushCSRMsg error, getOrderList failed.");
            return;
        }

        final QueryResult<AOrder> queryResult = (QueryResult<AOrder>) orderListResult.getData();
        List<AOrder> orderList = queryResult.getList();
        if (CollectionUtils.isEmpty(orderList)) {
            LOGGER.info("processPushCSRMsg error, orderList isEmpty.");
            return;
        }

//        final AOrder aOrder = orderList.get(0);
//        aOrder.setUserId("oVVo009m-ezaUiIFvD7vSHuM3REM");
//        sendCSRMsg(aOrder);

//        aOrder.setUserId("oVVo002pfxCNo4Yki2rNZY44e144");
//        sendCSRMsg(aOrder);
//
//        aOrder.setUserId("oVVo00y5FU5Anp_2h6EB60o-NviQ");
//        sendCSRMsg(aOrder);

        for (AOrder order : orderList) {
            sendCSRMsg(order);
        }
    }

    @Override
    public void processPushEfruitMsg() {
        // 当日支付过订单的用户
        final List<String> orderUserList = getOrderUserList();
        // 主动关注的新用户
        final List<String> newUserList = getNewUserList();

        final Collection<String> unionIdList = CollectionUtils.union(orderUserList, newUserList);
        for (String tmpId : unionIdList) {
            sendEfruitMsg(tmpId);
        }
    }

    private List<String> getNewUserList() {
        List<String> result = new ArrayList<>();
        final DateTime now = DateTime.now();
        final List<WechatFansInfo> wechatFansInfoList = wechatFansInfoService.getWechatFansInfoByDate(now.toDate());
        if (CollectionUtils.isEmpty(wechatFansInfoList)) {
            return result;
        }
        for (WechatFansInfo wechatFansInfo : wechatFansInfoList) {
            final String openid = wechatFansInfo.getOpenid();
            result.add(openid);
        }
        return result;
    }

    private List<String> getOrderUserList() {
        List<String> result = new ArrayList<>();
        OrderCondition orderCondition = new OrderCondition();
        orderCondition.setOnlyNeedValid(1);
        orderCondition.setSelectFrom(OrderCondition.SELECT_FROM_CUSTOM_BATCH_TAGGING);
        final DateTime now = DateTime.now();
        final DateTime endDateTime = now;
        final DateTime startDateTime = now.minusDays(1);
        orderCondition.setStartDate(startDateTime.toDate());
        orderCondition.setEndDate(endDateTime.toDate());
        // FIXME 目前只针对现场下单的用户
        orderCondition.setProductName("现场");
        final ArkCommonResult orderListResult = newOrderService.getOrderList(orderCondition);
        if (!orderListResult.statusOK()) {
            LOGGER.info("getOrderUserList error, getOrderList failed.");
            return result;
        }

        final QueryResult<AOrder> queryResult = (QueryResult<AOrder>) orderListResult.getData();
        List<AOrder> orderList = queryResult.getList();
        if (CollectionUtils.isEmpty(orderList)) {
            LOGGER.info("getOrderUserList error, orderList isEmpty.");
            return result;
        }

//        AOrder aOrder = orderList.get(0);
//        aOrder.setUserId("oVVo002pfxCNo4Yki2rNZY44e144");
//        sendEfruitMsg(aOrder);

        for (AOrder aOrder : orderList) {
            final String userId = aOrder.getUserId();
            result.add(userId);
        }

        return result;
    }

    private void sendEfruitMsg(String userId) {
        final boolean hasSendBefore = sendMsgService.hasSendBefore(userId, SendMsgDef.SEND_REASON_EFRUIT);
        if (hasSendBefore) {
            return;
        }
        final File actTipsPageFile = actTipsService.getActTipsPageFile();
        String clickUrl = null;
        try {
            clickUrl = StatUrlParser.parse(EFRUIT_URL, "efruit", "A");
        } catch (UnsupportedEncodingException e) {
            LOGGER.info("StatUrlParser.parse error.", e);
        }
        sendEfruitMsgByKefu(userId, actTipsPageFile, clickUrl, EFRUIT_TITLE);
    }

    private boolean sendEfruitMsgByKefu(String userId, File actTipsPageFile, String clickUrl, String title) {
        WxMediaImgUploadResult wxMediaImgUploadResult = null;
        WxMpMaterialService materialService = wechatMpService.getMaterialService();
        try {
            wxMediaImgUploadResult = materialService.mediaImgUpload(actTipsPageFile);
        } catch (WxErrorException e) {
            LOGGER.info("sendEfruitMsgByKefu error.", e);
        }

        if (wxMediaImgUploadResult == null) {
            return false;
        }

        WxMpKefuMessage.WxArticle wxArticle = new WxMpKefuMessage.WxArticle();
        wxArticle.setUrl(clickUrl);
        wxArticle.setTitle(title);
        final String url = wxMediaImgUploadResult.getUrl();
        LOGGER.info("url : {}", url);
        wxArticle.setPicUrl(url);

        final NewsBuilder newsBuilder = WxMpKefuMessage.NEWS()
                .toUser(userId)
                .addArticle(wxArticle);

        try {
            final boolean sendKefuMessage = wechatMpService.getKefuService().sendKefuMessage(newsBuilder.build());
            saveSendMsg(userId, sendKefuMessage, "", SendMsgDef.MSG_TYPE_KEFU, SendMsgDef.SEND_REASON_EFRUIT);
            return sendKefuMessage;
        } catch (WxErrorException e) {
            LOGGER.info("sendKefuMessage failed.", e);
            saveSendMsg(userId, false, e.getMessage(), SendMsgDef.MSG_TYPE_KEFU, SendMsgDef.SEND_REASON_EFRUIT);
        }

        return false;
    }

    private void sendCSRMsg(AOrder order) {
        final String userId = order.getUserId();
        final boolean hasSendBefore = sendMsgService.hasSendBefore(userId, SendMsgDef.SEND_REASON_CSR);
        if (hasSendBefore) {
            return;
        }

        final TestCase randomCase = getRandomCase();
        if (randomCase == null) {
            return;
        }
        String clickUrl = null;
        try {
            clickUrl = StatUrlParser.parse(randomCase.url, "csr", randomCase.caseName);
        } catch (UnsupportedEncodingException e) {
            LOGGER.info("StatUrlParser.parse error.", e);
        }
        sendCSRMsgByTemplate(order, clickUrl, randomCase.clickHint);
    }

    private String extractItemSkuName(String skuName) {
        String result = "";
        if (StringUtils.isEmpty(skuName)) {
            return result;
        }

        final int start = skuName.indexOf(":");
        final int end = skuName.indexOf(";");
        if (start <= 0 || end <= 0 || end <= start) {
            return result;
        }

        try {
            result = skuName.substring(start + 1, end);
        } catch (Exception e) {
            LOGGER.info("extractItemSkuName error.", e);
        }

        return result;
    }

    private boolean sendCSRMsgByTemplate(AOrder order, String clickUrl, String remark) {
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(order.getUserId())
                .templateId(SendMsgDef.TEMPLATE_MSG_ID_CSR)
                .url(clickUrl)
                .build();

        // 商品规格:超甜富士苹果（2枚）;发货时间:现场提货，无货请勿拍，不支持第二天配送！;活动赠送:发海报再免费领一份
        final String skuName = order.getSkuName();
        String itemName = extractItemSkuName(skuName);
        if (StringUtils.isEmpty(itemName)) {
            itemName = order.getProductName();
        }

        templateMessage
                .addData(new WxMpTemplateData("first", "您已完成现场取货，水果的价格和质量是否让您满意呢？", "#FF0000"))
                .addData(new WxMpTemplateData("keyword1", itemName, "#000000"))
                .addData(new WxMpTemplateData("keyword2", DateFormatHelper.formatDate(order.getCreated()), "#000000"))
                .addData(new WxMpTemplateData("keyword3", order.getReceiverAddress() + "\n", "#000000"))
                .addData(new WxMpTemplateData("remark", remark, "#FF0000"));

        try {
            final String msgId = wechatMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            final boolean sucSend = !StringUtils.isEmpty(msgId);
            saveSendMsg(order, sucSend, "", SendMsgDef.MSG_TYPE_TEMPLATE, SendMsgDef.SEND_REASON_CSR);
            return sucSend;
        } catch (WxErrorException e) {
            LOGGER.info("sendTemplateMsg error. ", e);
            saveSendMsg(order, false, e.getMessage(), SendMsgDef.MSG_TYPE_TEMPLATE, SendMsgDef.SEND_REASON_CSR);
        }

        return false;
    }

    private void saveSendMsg(AOrder arkOrder, boolean isSuccess, String errorMsg, int type, int sendReason) {
        SendMsg sendMsg = new SendMsg();
        final String userId = arkOrder.getUserId();
        sendMsg.setUserId(userId);
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

    private void saveSendMsg(String userId, boolean isSuccess, String errorMsg, int type, int sendReason) {
        SendMsg sendMsg = new SendMsg();
        sendMsg.setUserId(userId);
        sendMsg.setSendDate(new Date());
        sendMsg.setName("");
        sendMsg.setMobile("");
        sendMsg.setTid("");
        sendMsg.setSuccess(isSuccess ? SendMsgDef.SUCCESS : SendMsgDef.FAIL);
        sendMsg.setType(type);
        sendMsg.setSendReason(sendReason);
        sendMsg.setErrorInfo(errorMsg);
        sendMsgService.saveSendMsg(sendMsg);
    }

    private static class TestCase {
        private String caseName;
        private String clickHint;
        private String url;

        public String getCaseName() {
            return caseName;
        }

        public void setCaseName(String caseName) {
            this.caseName = caseName;
        }

        public String getClickHint() {
            return clickHint;
        }

        public void setClickHint(String clickHint) {
            this.clickHint = clickHint;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public TestCase(String caseName, String clickHint, String url) {
            this.caseName = caseName;
            this.clickHint = clickHint;
            this.url = url;
        }
    }
}
