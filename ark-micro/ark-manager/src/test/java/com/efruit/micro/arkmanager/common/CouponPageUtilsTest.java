package com.efruit.micro.arkmanager.common;

import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.arkmanager.utils.CouponPageUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;

public class CouponPageUtilsTest extends BaseTest {

    @Autowired
    CouponPageUtils couponPageUtils;

    @Test
    public void testCreateCoupon() throws Exception {
        final BufferedImage bufferedImage = couponPageUtils.genImage("909090", "www.baidu.com");
        Assert.assertNotNull(bufferedImage);
    }
}
