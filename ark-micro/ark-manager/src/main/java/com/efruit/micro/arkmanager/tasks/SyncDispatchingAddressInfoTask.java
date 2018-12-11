package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.DispatchingAddressInfoService;
import com.efruit.micro.arkmanager.service.DispatchingOrderService;
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
 * 同步自提点
 */
@Component
@EnableScheduling
public class SyncDispatchingAddressInfoTask {
    private static final Logger logger = LoggerFactory.getLogger(SyncDispatchingAddressInfoTask.class);
    @Autowired
    DispatchingAddressInfoService addressInfoService;

    // 每天凌晨和早上6执行同步
    @Scheduled(cron = "0 0 0,6 * * ? ")
    @Async
    public void start() {
        logger.info("SyncDispatchingAddressInfoTask start......");
        addressInfoService.synYouZanOffline();
    }
}
