package com.efruit.micro.arkmanager.common;

import com.efruit.micro.arkmanager.utils.VoiceSMSHelper;
import org.junit.Assert;
import org.junit.Test;

public class VoiceSMSHelperTest {

    @Test
    public void testSend() {
        final VoiceSMSHelper.SendResult sendResult = VoiceSMSHelper.sendDefaultVoiceSMS("18519851222", "金隅嘉华大厦", "13412341234");
        Assert.assertTrue(sendResult.isSuccess());
    }
}
