package com.efruit.micro.arkmanager.runner;

import com.efruit.micro.arkmanager.config.EnvConfig;
import com.efruit.micro.arkmanager.service.WechatFansInfoService;
import com.efruit.micro.arkmanager.tasks.SyncDispatchingOrderInfoTask;
import com.efruit.micro.arkmanager.tasks.SyncOrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements CommandLineRunner {

    @Autowired
    SyncOrderTask syncOrderTask;

    @Autowired
    SyncDispatchingOrderInfoTask syncDispatchingOrderInfoTask;

    @Autowired
    WechatFansInfoService wechatFansInfoService;

    @Autowired
    EnvConfig config;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner start to initialize ...");

        syncOrderTask.start();

        syncDispatchingOrderInfoTask.start();

        if (!config.isDev) {
            wechatFansInfoService.syncWechatFansInfo();
        }
    }
}
