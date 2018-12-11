package com.efruit.micro.arkmanager.common;

import com.efruit.micro.arkmanager.BaseTest;
import com.efruit.micro.arkmanager.bean.OrderDeliverMsgRequestInfo;
import com.efruit.micro.arkmanager.utils.DeliverMsgRequestSignHelper;
import com.efruit.micro.arkmanager.utils.SignHelper;
import org.junit.Assert;
import org.junit.Test;

public class DeliverMsgTest extends BaseTest {

    @Test
    public void testSign() {
        OrderDeliverMsgRequestInfo info = new OrderDeliverMsgRequestInfo();
        final String nonce = "123412";
        info.setNonce(nonce);
        final String timestamp = "1470820198";
        info.setTimestamp(timestamp);

        final String signature = SignHelper.genSignature(DeliverMsgRequestSignHelper.SECRET, nonce, timestamp);
        info.setSignature(signature);
        System.out.println("signature : " + signature);
        final boolean checkVaild = DeliverMsgRequestSignHelper.checkVaild(info);
        Assert.assertTrue(checkVaild);
    }
}
