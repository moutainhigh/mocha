package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.DispatchingOrderDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 同步订单详情状态，如：退款情况
 */
@Component
@EnableScheduling
public class SyncDispatchingOrderRefundStatusTask {
    private static final Logger logger = LoggerFactory.getLogger(SyncDispatchingOrderRefundStatusTask.class);
    @Autowired
    DispatchingOrderDetailsService orderDetailsService;

    // 每天00:30执行同步
    @Scheduled(cron = "0 30 0 * * ? ")
    @Async
    public void start() {
        logger.info("SyncDispatchingOrderRefundStatusTask start......");
        orderDetailsService.synOrderRefundState();
    }
}
