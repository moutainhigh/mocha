package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkmanager.exception.YouzanOrderSyncException;
import com.efruit.micro.arkmanager.pojo.AOrder;

import java.util.Date;
import java.util.List;

public interface YouzanOrderService {
    List<AOrder> getAllOrder() throws YouzanOrderSyncException;

    List<AOrder> getOrderList(Date start, Date end) throws YouzanOrderSyncException;
}
