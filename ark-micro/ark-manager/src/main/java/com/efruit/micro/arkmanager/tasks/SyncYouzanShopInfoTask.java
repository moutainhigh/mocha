//package com.efruit.micro.arkmanager.tasks;
//
//import com.efruit.micro.arkmanager.service.ShopInfoService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//@EnableScheduling
//public class SyncYouzanShopInfoTask {
//    private static final Logger logger = LoggerFactory.getLogger(SyncYouzanShopInfoTask.class);
//
//    @Autowired
//    ShopInfoService shopInfoService;
//
//    // 每天凌晨3点执行一次
//    @Scheduled(cron = "0 0 3 1/1 * ?")
//    @Async
//    public void start() {
//        logger.info("SyncYouzanShopInfoTask init...");
//        shopInfoService.syncYouzanShopInfo();
//    }
//}
