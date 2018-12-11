package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DispatchingBlackUserServiceTest extends BaseTest {

    @Autowired
    DispatchingBlackUserService dispatchingBlackUserService;

    @Test
    public void test() {
        final String mobile = "13612341234";
        final boolean blackUserByMobile = dispatchingBlackUserService.isBlackUserByMobile(mobile);
        Assert.assertTrue(blackUserByMobile);
    }
}
