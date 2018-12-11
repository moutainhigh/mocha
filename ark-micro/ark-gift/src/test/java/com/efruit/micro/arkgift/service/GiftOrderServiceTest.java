package com.efruit.micro.arkgift.service;

import com.efruit.micro.arkgift.BaseTest;
import com.efruit.micro.arkgift.domain.GiftOrder;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GiftOrderServiceTest extends BaseTest {

    @Autowired
    GiftOrderService giftOrderService;

    @Test
    public void testGetGiftOrderListByOpenId() {
        final List<GiftOrder> giftOrderListByOpenId = giftOrderService.getGiftOrderListByOpenId("oVVo002pfxCNo4Yki2rNZY44e144", "f9ea5ba73e2c49e79d584aa4839509db");
        Assert.assertFalse(CollectionUtils.isEmpty(giftOrderListByOpenId));
    }
}
