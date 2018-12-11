package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.NewOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SyncOrderTask {
    private static final Logger logger = LoggerFactory.getLogger(SyncOrderTask.class);

    @Autowired
    private NewOrderService newOrderService;

    @Scheduled(cron = "0 0 0/1 * * ?")
    @Async
    public void start() {
        logger.info("SyncOrderTask cron task start...");
        newOrderService.loadOrderList();
    }
}
