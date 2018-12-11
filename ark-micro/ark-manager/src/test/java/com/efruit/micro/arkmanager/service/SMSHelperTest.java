package com.efruit.micro.arkmanager.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.efruit.micro.arkmanager.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SMSHelperTest extends BaseTest {

    @Autowired
    SMSHelper smsHelper;

    @Test
    public void test() throws ClientException {
        final SendSmsResponse smsResponse = smsHelper.sendDefaultSMS("13631276294", "爱神的箭福建省的看法爱神的箭福建省的看法","爱神的箭福建省的看法",  "136132656276", "10000");
        final String bizId = smsResponse.getBizId();
        final String code = smsResponse.getCode();
        final String message = smsResponse.getMessage();
        System.out.println("******* bizId : " + bizId + ", code : " + code + ", message : " + message);
    }
}
