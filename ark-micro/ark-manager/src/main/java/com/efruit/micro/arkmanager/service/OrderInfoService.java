package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.OrderInfo;
import com.efruit.micro.youzan.common.YouzanApiException;

import java.util.List;

public interface OrderInfoService {
    boolean saveYouzanOrder(OrderInfo orderInfo);

    boolean saveYouzanOrderList(List<OrderInfo> orderInfoList);

    OrderInfo getOrderInfoByTid(String tid);

    int countOrderInfo();

    OrderInfo getLastOrderInfo();
}
