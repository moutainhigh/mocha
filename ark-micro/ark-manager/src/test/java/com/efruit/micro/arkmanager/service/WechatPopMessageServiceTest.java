package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WechatPopMessageServiceTest extends BaseTest {
    @Autowired
    WechatPopMessageService wechatPopMessageService;

    @Test
    public void testPushCSR() {
        wechatPopMessageService.processPushCSRMsg();
    }

    @Test
    public void testPushEfruit() {
        wechatPopMessageService.processPushEfruitMsg();
    }

}
