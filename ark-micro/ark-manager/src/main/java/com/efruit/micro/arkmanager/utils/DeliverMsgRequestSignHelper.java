package com.efruit.micro.arkmanager.utils;

import com.efruit.micro.arkmanager.bean.OrderDeliverMsgRequestInfo;

public class DeliverMsgRequestSignHelper {

//    public static final String SECRET = "secret";
    public static final String SECRET = "o9X2nh4M4SWchYujFiPK26aJ3Q6Hoep1";

    public static boolean checkVaild(OrderDeliverMsgRequestInfo requestInfo) {
        if (requestInfo == null) {
            return false;
        }

        final String nonce = requestInfo.getNonce();
        final String timestamp = requestInfo.getTimestamp();
        final String signature = requestInfo.getSignature();

        return SignHelper.checkVaild(signature, nonce, timestamp, SECRET);
    }
}
