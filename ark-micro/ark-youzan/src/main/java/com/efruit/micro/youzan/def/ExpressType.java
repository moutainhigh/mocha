package com.efruit.micro.youzan.def;

/**
 * 物流类型
 0:快递发货; 1:到店自提; 2:同城配送; 9:无需发货（虚拟商品订单）
 */
public class ExpressType {
    public static final int EXPRESS = 0;
    public static final int FETCH = 1;
    public static final int SAME_CITY_EXPRESS = 1;
    public static final int NOT_NEED_EXPRESS = 9;
}
