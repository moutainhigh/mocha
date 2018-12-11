package com.efruit.micro.arkmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.bean.*;
import com.efruit.micro.arkmanager.pojo.DispatchingAddressInfo;
import com.efruit.micro.arkmanager.pojo.DispatchingAreaInfo;
import com.efruit.micro.arkmanager.pojo.DispatchingCourierInfo;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.service.model.Code;
import com.efruit.micro.arkmanager.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配送 取货
 */
@RestController
@RequestMapping("/dispatching")
public class DispatchingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingController.class);
    @Autowired
    private DispatchingAddressInfoService addressInfoService;
    @Autowired
    private DispatchingOrderService orderService;
    @Autowired
    private DispatchingCourierInfoService courierInfoService;
    @Autowired
    private DispatchingSendMessageService sendMessageService;
    @Autowired
    private OrderSendDateHelper orderSendDateHelper;
    @Autowired
    DispatchingFetchCodeInfoService fetchCodeInfoService;
    @Autowired
    DispatchingOrderDetailsService detailsService;


    //查询地址列表
    @RequestMapping(value = "/address/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getAddressList(@RequestBody DispatchingCondition condition) {
        LOGGER.info("DispatchingController.getAddressList  condition:{}", JSONObject.toJSONString(condition));
        if (condition == null || condition.getSearchDate() == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), condition);
        }
        List<DispatchingAddressListResult> data = addressInfoService.getDispatchingAddressInfo(condition);
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), data);
    }

    //发送消息
    @RequestMapping(value = "/send/sms", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult sendSms(@RequestBody DispatchingCondition condition) {
        LOGGER.info("DispatchingController.sendSms  condition:{}", JSONObject.toJSONString(condition));
        if (condition == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), condition);
        }
        ArkCommonResult result = sendMessageService.sendSms(condition);
        LOGGER.info("---------send WeChat message success! body:{}", JSONObject.toJSONString(result));
        return result;
    }

    //校验配送员的手机号
    @RequestMapping(value = "/checkCourier/mobile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult checkCourierMobile(@RequestBody DispatchingCondition condition) {
        LOGGER.info("DispatchingController.checkCourierMobile  condition:{}", JSONObject.toJSONString(condition));
        if (condition == null || StringUtils.isEmpty(condition.getCourierMobile())) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), condition);
        }
        DispatchingCourierInfo courierInfo = courierInfoService.getCourierInfoByMobile(condition.getCourierMobile());
        if (courierInfo != null) {
            return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), courierInfo);
        } else {
            return ArkCommonResult.build(-1, "未查到用户");
        }
    }

    //获取订单列表
    @RequestMapping(value = "/get/orderList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getOrderByAddress(@RequestBody DispatchingCondition condition) {
        LOGGER.info("DispatchingController.getOrderByAddress  condition:{}", JSONObject.toJSONString(condition));
        if (condition == null || condition.getSearchDate() == null || condition.getId() == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg());
        }
        final Long addressId = condition.getId();
        final Date sendDate = condition.getSearchDate();
        List<DispatchingOrderListResult> data = orderService.getOrderList(addressId, sendDate);
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), data);
    }

    //同步订单信息
    @RequestMapping(value = "/synOrder", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult synOrder(@RequestBody(required = false) DispatchingCondition condition) {
        LOGGER.info("DispatchingController.synOrder  condition:{}", JSONObject.toJSONString(condition));
        final Date synDate = condition.getSearchDate();
        orderService.synOrderInfo(synDate);
        Date startDate = JodaDateUtil.addDay(synDate, -1);
        Date sendDate = orderSendDateHelper.calStartSendDate(startDate);
        fetchCodeInfoService.insertDispatchingFetchCodeInfo(sendDate);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("condition", condition);
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), jsonObject);
    }

    //同步订单信息
    @RequestMapping(value = "/synAddress", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult synAddress(@RequestBody(required = false) DispatchingCondition condition) {
        LOGGER.info("DispatchingController.synAddress  condition:{}", JSONObject.toJSONString(condition));
        addressInfoService.synYouZanOffline();
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg());
    }

    //同步订单退款情况
    @RequestMapping(value = "/synRefundState", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult synOrderRefundState(@RequestBody(required = false) DispatchingCondition condition) {
        detailsService.synOrderRefundState();
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg());
    }

    //购买者确认收货
    @RequestMapping(value = "/buyer/receipt/ok", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult buyerReceiptOK(@RequestBody(required = false) DispatchingCondition condition) {
        LOGGER.info("DispatchingController.updateStatus  condition:{}", JSONObject.toJSONString(condition));
        if (StringUtils.isEmpty(condition.getTid())) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg());
        }
        orderService.buyerReceiptOK(condition.getTid());
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg());
    }

    @PostMapping(value = "/export", produces = "application/json;charset=utf-8")
    public void exportDispatchingAreaOrder(HttpServletResponse response, @RequestBody DispatchingCondition condition) throws IOException {
        final Date searchDate = condition.getSearchDate();
        if (searchDate == null) {
            HttpServletResponseUtils.printMsgToResponse(response, "params error.");
            return;
        }
        final Map<String, DispatchingExportAreaOrderResult> areaOrderMap = orderService.selectByDateAndAddress(searchDate);
        if (MapUtils.isEmpty(areaOrderMap)) {
            HttpServletResponseUtils.printMsgToResponse(response, "no datas.");
            return;
        }
        final StringBuilder fileNameSb = new StringBuilder();
        final DateTime searchDateTime = new DateTime(searchDate);
        final String searchDateStr = searchDateTime.toString("yyyy-MM-dd");
        final String exportTimeStr = DateTime.now().toString("yyyyMMddHHmmss");
        fileNameSb.append("ark_")
                .append(searchDateStr)
                .append("(")
                .append(exportTimeStr)
                .append(")")
                .append(".xls");

        final String fileName = fileNameSb.toString();
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 文件名字去掉所有空格
        response.setHeader("Content-Disposition", String.format("attachment; filename=%s", fileName.replaceAll(" ", "_")));
        final ServletOutputStream outputStream = response.getOutputStream();
        ExportDispatchingExcel.exportExcel(areaOrderMap, searchDate, outputStream);
        outputStream.flush();
        IOUtils.closeQuietly(outputStream);
    }


    //获取后台管理列表
    @RequestMapping(value = "/manage/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getManageOrders(@RequestBody DispatchingManageParam param) {
        LOGGER.info("DispatchingController.getOrderByAddress  condition:{}", JSONObject.toJSONString(param));
        final int pageSize = param.getPageSize();
        final int pageNo = param.getPageNo();
        final int limitStart = (pageNo - 1) * pageSize;
        final int limitEnd = limitStart + pageSize;
        param.setLimitEnd(limitEnd);
        param.setLimitStart(limitStart);
        List<DispatchingManageResult> data = orderService.managerOrderList(param);
        final int count = orderService.countManagerOrderList(param);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", data);
        result.put("total", count);
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), result);
    }

    //修改配送订单
    @RequestMapping(value = "/manage/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult updateManageOrder(@RequestBody DispatchingManageParam param) {
        LOGGER.info("DispatchingController.getOrderByAddress  condition:{}", JSONObject.toJSONString(param));
        if (param == null || StringUtils.isEmpty(param.getTid()) || param.getAddressId() == null ||
                param.getBuyerTel() == null || param.getSendDate() == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), param);
        }
        orderService.updateOrder(param);
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg());
    }

    //获取自提点列表
    @RequestMapping(value = "/manage/address/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getManageAddressList(@RequestBody(required = false) DispatchingManageParam param) {
        LOGGER.info("DispatchingController.getOrderByAddress  condition:{}", JSONObject.toJSONString(param));
        List<DispatchingAddressInfo> data = addressInfoService.selectAll();
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), data);
    }
}
