package com.efruit.micro.arkmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkcommon.utils.DateFormatHelper;
import com.efruit.micro.arkmanager.bean.*;
import com.efruit.micro.arkmanager.constant.OrderPeriodType;
import com.efruit.micro.arkmanager.constant.OrderType;
import com.efruit.micro.arkmanager.pojo.AOrder;
import com.efruit.micro.arkmanager.pojo.DeliverUserInfo;
import com.efruit.micro.arkmanager.pojo.ModifyCountHistory;
import com.efruit.micro.arkmanager.pojo.ShopInfo;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.service.model.Code;
import com.efruit.micro.arkmanager.utils.*;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import com.efruit.micro.youzan.service.YouzanService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private HolidayInfoService holidayInfoService;

    @Autowired
    private ModifyCountHistoryService modifyCountHistoryService;

    @Autowired
    private NewOrderService newOrderService;

    @Autowired
    private ShopInfoService shopInfoService;

    @Autowired
    private DeliverUserService deliverUserService;

    @Autowired
    private YouzanService youzanService;

    //查询列表
    @RequestMapping(value = "/orderList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getOrderList(@RequestBody OrderCondition condition) {
        LOGGER.info("OrderController.getOrderList: condition: " + condition);
        if (condition == null || condition.getSize() <= 0 || condition.getPage() <= 0) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), condition);
        }
        final ArkCommonResult result = newOrderService.getOrderList(condition);
        if (!result.statusOK()) {
            return result;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("condition", condition);
        jsonObject.put("result", result.getData());
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), jsonObject);
    }

    @RequestMapping(value = "/deliverOrderList", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getOrderListForDeliver(@RequestBody OrderCondition condition) {
        final Date currentDate = condition.getTargetDate();
        if (currentDate == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), condition);
        }

        processForDeliver(condition);

        return getOrderList(condition);
    }

    private void processForDeliver(@RequestBody OrderCondition condition) {
        condition.setStartDate(null);
        condition.setEndDate(null);
        condition.setOnlyNeedValid(1);
    }


    //添加订单延期
    @RequestMapping(value = "/orderDelay", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult addOrderDelay(@RequestBody OrderModifyInfo delayOrder) {
        LOGGER.info("addOrderDelay: delayOrder: " + delayOrder);
        if (delayOrder == null || delayOrder.getOrderId() <= 0
                || StringUtils.isAnyBlank(delayOrder.getReceiverName(), delayOrder.getReceiverAddress(), delayOrder.getReceiverMobile())) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), delayOrder);
        }
        return newOrderService.updateOrderDelay(delayOrder);
    }

    //查询订单
    @RequestMapping(value = "/getOrder", produces = "application/json;charset=utf-8")
    public ArkCommonResult getOrder(long orderId) {
        LOGGER.info("getOrder: orderId: " + orderId);
        if (orderId <= 0) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg());
        }
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), newOrderService.getOrderById(orderId));
    }

    //导入订单数据
    @RequestMapping(value = "/loadOrder", produces = "application/json;charset=utf-8")
    public ArkCommonResult loadOrderList() {
        return newOrderService.loadOrderList();
    }

    @RequestMapping(value = "/getAddressList", produces = "application/json;charset=utf-8")
    public ArkCommonResult getAddressList() {
        final List<String> addressList = newOrderService.getAddressList();
        return ArkCommonResult.ok(addressList);
    }

    @RequestMapping(value = "/getOrderTypeMap", produces = "application/json;charset=utf-8")
    public ArkCommonResult getOrderTypeMap() {
        return ArkCommonResult.ok(OrderType.MAP);
    }

    @RequestMapping(value = "/getOrderPeriodTypeMap", produces = "application/json;charset=utf-8")
    public ArkCommonResult getOrderPeriodTypeMap() {
        return ArkCommonResult.ok(OrderPeriodType.MAP);
    }

    @RequestMapping(value = "/getWorkDayList", produces = "application/json;charset=utf-8")
    public ArkCommonResult getWorkDayList(@RequestParam(required = false) Integer count) {
        if (count == null || count <= 0) {
            count = 10;
        }
        final int maxCount = 30;
        if (count > maxCount) {
            count = maxCount;
        }
        return ArkCommonResult.ok(holidayInfoService.getWorkDayList(count));
    }

    @RequestMapping(value = "/getModifyHistory", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult getModifyCountHistoryByOrderId(@RequestBody OrderCountModifyInfo modifyInfo) {
        final long orderId = modifyInfo.getOrderId();
        if (orderId <= 0) {
            return ArkCommonResult.fail("order ID error, please check.");
        }

        final long orderParentId = modifyInfo.getOrderParentId();
        long targetId = TargetIdUtils.getTargetId(orderId, orderParentId);

        final List<ModifyCountHistory> modifyCountHistoryList = modifyCountHistoryService.getModifyCountHistoryByOrderId(targetId, OrderCountModifyInfo.FROME_TYPE_ADMIN);
        return ArkCommonResult.ok(modifyCountHistoryList);
    }

    @RequestMapping(value = "/modifyCount", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult modifyCount(@RequestBody OrderCountModifyInfo modifyInfo) {
        final long orderId = modifyInfo.getOrderId();
        if (orderId <= 0) {
            return ArkCommonResult.fail("order ID error, please check.");
        }

        return newOrderService.modifyOrderCount(modifyInfo);

    }

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public void downloadFile(HttpServletResponse response, @RequestBody OrderCondition condition) throws Exception {
        final Date targetDate = condition.getTargetDate();
        if (targetDate == null) {
            final String msg = "targetDate is null. please check!";
            LOGGER.info("downloadFile() error : {}", msg);
            HttpServletResponseUtils.printMsgToResponse(response, msg);
            return;
        }

        processForDeliver(condition);
        condition.setSelectFrom(OrderCondition.SELECT_FROM_DELIVER_EXPORT);

        final ArkCommonResult result = newOrderService.getOrderList(condition);
        if (!result.statusOK()) {
            final String msg = "Error! errorCode : " + result.getStatus() + ", msg : " + result.getMsg();
            HttpServletResponseUtils.printMsgToResponse(response, msg);
            return;
        }

        String fileName = DateTime.now().toString(DateFormatHelper.DATE_FORMAT) + ".xls";

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 文件名字去掉所有空格
        response.setHeader("Content-Disposition", String.format("attachment; filename=%s", fileName.replaceAll(" ", "_")));

        final QueryResult<AOrder> queryResult = (QueryResult<AOrder>) result.getData();
        final List<OrderExcelBin> excelBins = OrderExportHelper.parse(queryResult.getList());
        ExportExcel<OrderExcelBin> exportExcel = new ExportExcel<>();
        final ServletOutputStream outputStream = response.getOutputStream();
        exportExcel.exportExcel(OrderExportHelper.DEFAULT_HEADER, excelBins, outputStream);
        outputStream.flush();
        IOUtils.closeQuietly(outputStream);
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ArkCommonResult getSelfAddress() {
        final List<ShopInfo> shopInfoList = shopInfoService.getShopInfoList();
        if (CollectionUtils.isEmpty(shopInfoList)) {
            return ArkCommonResult.fail("shopInfoList is empty, Please check.");
        }

        return ArkCommonResult.ok(shopInfoList);
    }

    @RequestMapping(value = "/deliverMsg", method = RequestMethod.POST)
    public ArkCommonResult deliverMsg(@RequestBody OrderDeliverMsgRequestInfo requestInfo) {
        final boolean checkVaild = DeliverMsgRequestSignHelper.checkVaild(requestInfo);
        if (!checkVaild) {
            return ArkCommonResult.fail("checkVaild failed. Please check.");
        }

        return ArkCommonResult.ok();
    }

    @RequestMapping(value = "/deliverUser", method = RequestMethod.POST)
    public ArkCommonResult deliverUser() {

        final List<DeliverUserInfo> allEnableDeliverUserInfoList = deliverUserService.getAllEnableDeliverUserInfoList();
        if (CollectionUtils.isEmpty(allEnableDeliverUserInfoList)) {
            return ArkCommonResult.fail("allEnableDeliverUserInfoList is empty, Please check.");
        }

        return ArkCommonResult.ok(allEnableDeliverUserInfoList);
    }

    @RequestMapping(value = "/tradeInfos", method = RequestMethod.POST)
    public ArkCommonResult tradeInfos(@RequestBody TradeInfoQuery tradeInfoQuery) {
        final Date start = tradeInfoQuery.getStart();
        final Date end = tradeInfoQuery.getEnd();
        if (start == null || end == null) {
            return ArkCommonResult.fail("start == null || end == null.");
        }

        List<YouzanTradesSoldGetResult.StructurizationTrade> structurizationTrades;
        try {
            structurizationTrades = youzanService.syncOrderV4(start, end);
        } catch (YouzanApiException e) {
            final String msg = "syncOrderV4 error.";
            LOGGER.info(msg);
            return ArkCommonResult.fail(msg);
        }

        final List<TradeInfoVo> tradeInfoVos = TradeInfoHelper.calTradeInfo(structurizationTrades);
        return ArkCommonResult.ok(tradeInfoVos);
    }

}
