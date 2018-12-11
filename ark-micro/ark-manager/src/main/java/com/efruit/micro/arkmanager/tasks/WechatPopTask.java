package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.WechatPopMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class WechatPopTask {
    private static final Logger logger = LoggerFactory.getLogger(WechatPopTask.class);

    @Autowired
    private WechatPopMessageService wechatPopMessageService;

    // 朝九晚七工作时间内每半小时
    @Scheduled(cron = "0 30 9-22 * * ?")
    @Async
    public void start() {
        logger.info("WechatPopTask start....");
        wechatPopMessageService.processPushCSRMsg();
    }

    // 每晚9：40 PM
    @Scheduled(cron = "0 40 21 * * ?")
    @Async
    public void startPushEfruitMsg() {
        wechatPopMessageService.processPushEfruitMsg();
    }
}
