package com.efruit.micro.arkmanager.constant;

import java.util.HashMap;
import java.util.Map;

public class PatchingOrderStatus {
    //订单状态，1：装配 （已付款） 2：待发出（已发车） 3:待配送（包含1,2） 4:订单完成
    public static final int WAIT_SELLER_SEND_GOODS= 1;
    public static final int WAIT_BUYER_CONFIRM_GOODS = 2;
    public static final int TRADE_BUYER_NO_SIGNED = 3;
    public static final int TRADE_SUCCESS = 4;

    public static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(WAIT_SELLER_SEND_GOODS, "订单配件中");
        MAP.put(WAIT_BUYER_CONFIRM_GOODS, "订单已发车");
        MAP.put(TRADE_BUYER_NO_SIGNED, "订单用户未签收");
        MAP.put(TRADE_SUCCESS, "订单配送完成");
    }
}
