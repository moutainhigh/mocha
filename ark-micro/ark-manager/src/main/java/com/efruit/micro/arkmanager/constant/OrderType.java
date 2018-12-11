package com.efruit.micro.arkmanager.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类型，首次新购订单、续费订单
 */
public class OrderType {
    public static final int NEW = 1;
    public static final int RENEW = 2;

    public static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(NEW, "首次新购订单");
        MAP.put(RENEW, "续费订单");
    }

}
