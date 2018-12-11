package com.efruit.micro.arkmanager.service;

import java.util.Arrays;
import java.util.List;

//orderServoce 常量
public interface OrderServiceConstant {

    int ORDER_STATUS_VALID = 1;//有效订单（未发货完成的订单）
    int ORDER_STATUS_INVALID = 2;//订单已经完成

    int DEFAULT_PAGE = 1;//默认第一页
    int MIN_PAGE_SIZE = 20;

    int ADD_OPERATION = 1;//增加操作
    int REDUCE_OPERATION = 2;//减少操作

    int GIVE_TYPE = 1;//赠送
    int SUPPLY_AGAIN = 2;//补发

    int DEFAULT_MONTH_DAY = 22;//默认的包月天数

    int MONTH_ORDER_TYPE = 1;//包月订单

    String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";//等等支付 (待支付)
    String WAIT_CONFIRM = "WAIT_CONFIRM";//待确认
    String WAIT_SELLER_SEND_GOODS = "WAIT_SELLER_SEND_GOODS";//等待发货
    String WAIT_BUYER_CONFIRM_GOODS = "WAIT_BUYER_CONFIRM_GOODS";//等待收货
    String WAIT_BUYER_CONFIRM_GOODS_STR = "已发货";
    String TRADE_SUCCESS = "TRADE_SUCCESS";//交易成功
    String TRADE_BUYER_SIGNED = "TRADE_BUYER_SIGNED";//买家签收
    String TRADE_CLOSED = "TRADE_CLOSED";//交易关闭
    String TRADE_CLOSED_BY_USER = "TRADE_CLOSED_BY_USER";//应该是用户退款状态 此状态没有支付时间

    String[] VAILD_STATUS = {WAIT_SELLER_SEND_GOODS, WAIT_BUYER_CONFIRM_GOODS, TRADE_SUCCESS, TRADE_BUYER_SIGNED};

    List<String> VAILD_STATUS_LIST = Arrays.asList(VAILD_STATUS);
}
