package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.BaseTest;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewOrderServiceTest extends BaseTest {

    @Autowired
    NewOrderService newOrderService;

    @Test
    public void testGetOrderListCountByUserId() throws Exception {
        int orderListCountByUserId = newOrderService.getOrderListCountByUserId("oVVo004ngaliUcX65PBrTo71gePU");
        Assert.assertTrue(orderListCountByUserId == 1);
    }

    @Test
    public void testGetUserId() {
        final List<String> userIdListByMobile = newOrderService.getUserIdListByMobile("13631276294");
        Assert.assertTrue(!CollectionUtils.isEmpty(userIdListByMobile));
    }

}
