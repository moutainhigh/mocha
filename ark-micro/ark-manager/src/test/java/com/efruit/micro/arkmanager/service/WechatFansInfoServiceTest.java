package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.arkmanager.pojo.WechatFansInfo;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WechatFansInfoServiceTest extends BaseTest {

    @Autowired
    WechatFansInfoService wechatFansInfoService;

    @Test
    public void testGetAllWechatFansInfoUnionIdList() {
        final List<String> allWechatFansInfoUnionIdList = wechatFansInfoService.getAllWechatFansInfoUnionIdList();
        Assert.assertTrue(CollectionUtils.isNotEmpty(allWechatFansInfoUnionIdList));
    }

    @Test
    public void testGetWechatOpenIdByFansId() {
        final String wechatOpenIdByFansId = wechatFansInfoService.getWechatOpenIdByFansId(5208806293L);
        Assert.assertEquals("oVVo002pfxCNo4Yki2rNZY44e144", wechatOpenIdByFansId);
    }

    @Test
    public void testGetWechatFansInfoByDate() {
        DateTime dateTime = new DateTime(2018, 11,21,0,0);
        final List<WechatFansInfo> wechatFansInfoByDate = wechatFansInfoService.getWechatFansInfoByDate(dateTime.toDate());
        Assert.assertTrue(wechatFansInfoByDate != null);
        Assert.assertTrue(wechatFansInfoByDate.size() > 0);
    }
}
