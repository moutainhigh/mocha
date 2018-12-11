package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.WechatFansInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SyncWechatFansInfoTask {
    private static final Logger logger = LoggerFactory.getLogger(SyncWechatFansInfoTask.class);

    @Autowired
    private WechatFansInfoService wechatFansInfoService;

    // 每12个小时同步一次
    @Scheduled(cron = "0 0 0/12 * * ?")
    @Async
    public void start() {
        logger.info("SyncWechatFansInfoTask start....");
        wechatFansInfoService.syncWechatFansInfo();
    }
}
