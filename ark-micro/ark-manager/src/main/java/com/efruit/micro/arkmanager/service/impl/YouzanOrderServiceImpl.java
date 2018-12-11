package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.exception.YouzanOrderSyncException;
import com.efruit.micro.arkmanager.pojo.AOrder;
import com.efruit.micro.arkmanager.service.YouzanOrderService;
import com.efruit.micro.arkmanager.utils.OrderParser;
import com.efruit.micro.youzan.bean.ArkOrder;
import com.efruit.micro.youzan.service.YouzanService;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class YouzanOrderServiceImpl implements YouzanOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(YouzanOrderServiceImpl.class);

    @Autowired
    private YouzanService youzanService;

    // 有赞后台最早一笔订单创建时间，以这个时间为开始初始化开始时间
    private static final DateTime MIN_START_DATE = new DateTime(2018, 3, 27, 0, 0);

    @Override
    public List<AOrder> getAllOrder() throws YouzanOrderSyncException {
        List<AOrder> resultList = new ArrayList<>();
        final DateTime now = DateTime.now();
        DateTime start = new DateTime(MIN_START_DATE);
        if (now.getMillis() <= start.getMillis()) {
            return resultList;
        }

        DateTime end = null;
        do {
            final int factor = 1;
            if (end == null) {
                end = start.plusMonths(factor);
            } else {
                start = end;
                end = end.plusMonths(factor);
            }
            if (end.getMillis() > now.getMillis()) {
                end = new DateTime(now);
            }

            final Date startDate = start.toDate();
            final Date endDate = end.toDate();

            final List<AOrder> orderListFromYouzan = getOrderListFromYouzan(startDate, endDate);
            if (orderListFromYouzan == null) {
                throw new YouzanOrderSyncException("getOrderListFromYouzan fail. startDate : " + startDate + ", endDate : " + endDate);
            }

            resultList.addAll(orderListFromYouzan);
        } while (end.getMillis() < now.getMillis());

        return resultList;
    }

    @Override
    public List<AOrder> getOrderList(Date start, Date end) throws YouzanOrderSyncException {
        DateTime startDate = new DateTime(start);
        if (startDate.getMillis() <= MIN_START_DATE.getMillis()) {
            throw new YouzanOrderSyncException("start date < MIN_START_DATE");
        }

        DateTime endDate = new DateTime(end);
        if (startDate.getMillis() >= endDate.getMillis()) {
            throw new YouzanOrderSyncException("startDate.getMillis() >= endDate.getMillis()");
        }

        final List<AOrder> orderListFromYouzan = getOrderListFromYouzan(start, end);
        if (orderListFromYouzan == null) {
            throw new YouzanOrderSyncException("getOrderListFromYouzan fail. startDate : " + startDate + ", endDate : " + endDate);
        }

        return orderListFromYouzan;
    }

    private List<AOrder> getOrderListFromYouzan(Date startDate, Date endDate) throws YouzanOrderSyncException {
        LOGGER.info("start syncOrder, start date : {}, end date : {} ", startDate, endDate);
        try {
            final ArkCommonResult arkCommonResult = youzanService.syncOrder(startDate, endDate);
            if (arkCommonResult.statusOK()) {
                List<ArkOrder> arkOrders = (List<ArkOrder>) arkCommonResult.getData();
                final List<AOrder> orders = parseToOrderList(arkOrders);
                LOGGER.info("end syncOrder and processArkOrderList success, start date : {}, end date : {} , orderSize() : {}", startDate, endDate, orders.size());
                return orders;
            }
        } catch (Exception e) {
            throw new YouzanOrderSyncException("getOrderListFromYouzan fail. startDate : " + startDate + ", endDate : " + endDate, e);
        }

        return null;
    }

    private List<AOrder> parseToOrderList(List<ArkOrder> arkOrderList) {
        final List<AOrder> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(arkOrderList)) {
            return result;
        }

        for (ArkOrder arkOrder : arkOrderList) {
            final AOrder order = OrderParser.toOrder(arkOrder);
            result.add(order);
        }

        return result;
    }
}
