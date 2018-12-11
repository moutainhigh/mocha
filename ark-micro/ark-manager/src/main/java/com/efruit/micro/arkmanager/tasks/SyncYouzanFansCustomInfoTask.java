package com.efruit.micro.arkmanager.tasks;

import com.efruit.micro.arkmanager.service.FansCustomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncYouzanFansCustomInfoTask {

    @Autowired
    FansCustomInfoService fansCustomInfoService;

    @Scheduled(cron = "0 30 0 * * ?")
    @Async
    public void start() {
        fansCustomInfoService.syncFansCustomerInfoFromYouzan();
    }

}
