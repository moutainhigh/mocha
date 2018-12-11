package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.DispatchingFetchCodeInfoService;
import com.efruit.micro.arkmanager.service.DispatchingOrderService;
import com.efruit.micro.arkmanager.service.OrderSendDateHelper;
import com.efruit.micro.arkmanager.utils.JodaDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 同步订单，主要是同步配送订单信息
 */
@Component
@EnableScheduling
public class SyncDispatchingOrderInfoTask {
    private static final Logger logger = LoggerFactory.getLogger(SyncDispatchingOrderInfoTask.class);
    @Autowired
    DispatchingOrderService orderService;
    @Autowired
    private OrderSendDateHelper orderSendDateHelper;
    @Autowired
    DispatchingFetchCodeInfoService fetchCodeInfoService;
    // 每天凌晨00：10执行同步
    @Scheduled(cron = "0 10 0 * * ? ")
    @Async
    public void start() {
        logger.info("SyncDispatchingOrderInfoTask start......");
        Date today = JodaDateUtil.getDateCuryyyy_MM_dd();
        orderService.synOrderInfo(today);
        Date startDate = JodaDateUtil.addDay(today, -1);
        Date sendDate = orderSendDateHelper.calStartSendDate(startDate);
        fetchCodeInfoService.insertDispatchingFetchCodeInfo(sendDate);
    }
}
