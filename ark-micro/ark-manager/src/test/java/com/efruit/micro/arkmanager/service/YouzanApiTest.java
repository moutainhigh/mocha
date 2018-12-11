package com.efruit.micro.arkmanager.service;

import com.alibaba.fastjson.JSON;
import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.youzan.bean.ArkOrder;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.sdk.api.YouzanTradesSoldGet;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetParams;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanItemGetResult;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanMultistoreOfflineSearchResult;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowersInfoPullResult;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class YouzanApiTest extends BaseTest {

    @Autowired
    YouzanService youzanService;

    @Test
    public void testTradeGet() throws Exception {
        // 默认查询：E20180920131005075100002
        // 退款查询：E20181106211910021700020
        final ArkOrder arkOrder = youzanService.getArkOrderByTid("E20181119145304075100031");
        Assert.assertNotNull(arkOrder);
    }

    @Test
    public void testTradeSoldGet() throws Exception {
        DateTime start = new DateTime(2018, 9,3, 0,0);
        DateTime end = new DateTime(2018, 9,4, 0,0);
        final ArkCommonResult result = youzanService.syncOrder(start.toDate(), end.toDate());
        final Object data = result.getData();
        List<ArkOrder> arkOrderList = (List<ArkOrder>) data;
        Assert.assertNotNull(arkOrderList);
    }

    @Test
    public void testFansGet() throws Exception {
        final List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> fansList = youzanService.getFansList();
        final int size = fansList.size();
        System.out.println("size : " + size);
        Assert.assertTrue(size > 0);
    }

    @Test
    public void testTradesSoldGet() throws YouzanApiException {
        DateTime start = new DateTime(2018, 9,11, 15,0);
        DateTime end = new DateTime(2018, 9,12, 16,0);
        final List<YouzanTradesSoldGetResult.StructurizationTrade> structurizationTrades = youzanService.syncOrderV4(start.toDate(), end.toDate());
        Assert.assertFalse(CollectionUtils.isEmpty(structurizationTrades));
    }

    @Test
    public void testSyncAddressList() throws Exception {
        final List<YouzanMultistoreOfflineSearchResult.AccountShopOffline> accountShopOfflines = youzanService.syncAddressList();
        Assert.assertFalse(CollectionUtils.isEmpty(accountShopOfflines));
    }

    @Test
    public void testGetYouzanItemByAlias() throws Exception {
        final YouzanItemGetResult.ItemDetailOpenModel youzanItemByAlias = youzanService.getYouzanItemByAlias("3nqj4stpno0ra");
        Assert.assertNotNull(youzanItemByAlias);
    }

    @Test
    public void testGetYouzanUserInfo() throws Exception {

        final YouzanUsersWeixinFollowerGetResult.CrmWeixinFans youzanUserInfo = youzanService.getYouzanUserInfo(5208806293L);
        final String jsonString = JSON.toJSONString(youzanUserInfo);
        System.out.println(jsonString);
        Assert.assertNotNull(youzanUserInfo);

    }

}
