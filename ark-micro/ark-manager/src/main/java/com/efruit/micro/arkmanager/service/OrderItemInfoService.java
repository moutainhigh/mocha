package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.OrderItemInfo;

import java.util.List;

public interface OrderItemInfoService {
    boolean saveOrderItemInfo(OrderItemInfo orderItemInfo);

    boolean saveOrderItemInfoList(List<OrderItemInfo> orderItemInfoList);

    List<OrderItemInfo> getOrderItemInfoListByTid(String tid);
}
