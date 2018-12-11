package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.OrderInfo;
import com.efruit.micro.arkmanager.pojo.OrderItemInfo;
import com.efruit.micro.arkmanager.pojo.SyncInfo;
import com.efruit.micro.arkmanager.utils.OrderInfoParseHelper;
import com.efruit.micro.arkmanager.utils.OrderItemInfoHelper;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import com.efruit.micro.youzan.service.YouzanService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class YouzanOrderInfoSyncHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(YouzanOrderInfoSyncHelper.class);

    // 有赞后台最早一笔订单创建时间，以这个时间为开始初始化开始时间
    private static final DateTime MIN_START_DATE = new DateTime(2018, 8, 27, 0, 0);

    @Autowired
    private YouzanService youzanService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private SyncInfoService syncInfoService;

    @Autowired
    OrderItemInfoService orderItemInfoService;

    public void syncAllYouzanOrder() throws YouzanApiException {
//        final int countOrderInfo = orderInfoService.countOrderInfo();
        // 非首次执行同步
//        if (countOrderInfo > 0) {
//            final SyncInfo lastSyncInfo = syncInfoService.getLastSyncInfo();
//            Date lastOrderDate = lastSyncInfo.getLastOrderDate();
//            if (lastOrderDate == null) {
//                final OrderInfo lastOrderInfo = orderInfoService.getLastOrderInfo();
//                lastOrderDate = lastOrderInfo.getCreated();
//            }
//            syncYouzanOrderInfo(lastOrderDate, DateTime.now().toDate());
//            return;
//        }

        // 首次执行同步
        final DateTime now = DateTime.now();
        DateTime start = new DateTime(MIN_START_DATE);
        if (now.getMillis() <= start.getMillis()) {
            return;
        }

        DateTime end = null;
        do {
            final int factor = 1;
            if (end == null) {
                end = start.plusWeeks(factor);
            } else {
                start = end;
                end = end.plusWeeks(factor);
            }
            if (end.getMillis() > now.getMillis()) {
                end = new DateTime(now);
            }

            final Date startDate = start.toDate();
            final Date endDate = end.toDate();

            syncYouzanOrderInfo(startDate, endDate);
        } while (end.getMillis() < now.getMillis());

    }

    public void syncYouzanOrderInfo(Date start, Date end) throws YouzanApiException {
        if (start.getTime() >= end.getTime()) {
            return;
        }

        final List<YouzanTradesSoldGetResult.StructurizationTrade> structurizationTrades = youzanService.syncOrderV4(start, end);
        final List<OrderInfo> orderInfoList = OrderInfoParseHelper.toOrderInfoList(structurizationTrades);

        final boolean sucSaveOrderInfoList = orderInfoService.saveYouzanOrderList(orderInfoList);
        if (!sucSaveOrderInfoList) {
            throw new RuntimeException("sucSaveOrderInfoList is false");
        }

        final List<OrderItemInfo> orderItemInfoList = OrderItemInfoHelper.getOrderItemInfoList(orderInfoList);
        final boolean saveOrderItemInfoList = orderItemInfoService.saveOrderItemInfoList(orderItemInfoList);
        if (!saveOrderItemInfoList) {
            throw new RuntimeException("saveOrderItemInfoList error.");
        }


    }


}
