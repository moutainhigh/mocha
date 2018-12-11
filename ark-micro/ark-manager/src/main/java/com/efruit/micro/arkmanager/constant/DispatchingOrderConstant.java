package com.efruit.micro.arkmanager.constant;

public class DispatchingOrderConstant {
    //状态--激活
    public static final int STATUS_YES = 1;
    //状态--未激活
    public static final int STATUS_NO = 0;
    //未分片区--id
    public static final Long NO_AREA_ID = 0L;
    //未分片区--名字
    public static final String NO_AREA_NAME = "未分配片区";

    //订单补发
    public static final int ORDER_STATUS_REISSUE = 2;
    //订单签收
    public static final int ORDER_STATUS_SUCCESS = 1;
    //订单派送中
    public static final int ORDER_STATUS_DISPATCHING = 0;
    /*订单详情退款状态
     * 0：默认
     * 1:买家已经申请退款，等待卖家同意;
     * 10:卖家拒绝退款;
     * 20:卖家已经同意退货，等待买家退货;
     * 30:买家已经退货，等待卖家确认收货;
     * 40:卖家未收到货,拒绝退款;
     * 50:退款关闭;
     * 60:退款成功;
     */
    public static final String ORDER_DETAILS_STATE = "0";
}
