package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult;
import com.efruit.micro.arkmanager.bean.DispatchingManageParam;
import com.efruit.micro.arkmanager.bean.DispatchingManageResult;
import com.efruit.micro.arkmanager.bean.DispatchingOrderListResult;
import com.efruit.micro.arkmanager.pojo.DispatchingOrder;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DispatchingOrderService {

    boolean save(DispatchingOrder obj);

    boolean save(List<DispatchingOrder> obj);

    int update(DispatchingOrder order);

    boolean save(Map<String, DispatchingOrder> obj);

    DispatchingOrder getById(String id);

    /**
     * 与有赞同步订单派送信息
     */
    void synOrderInfo(Date synDate);

    List<DispatchingOrderListResult> getOrderList(Long addressId, Date sendDate);

    List<DispatchingOrder> getOrderList(Date sendDate);

    boolean buyerReceiptOK(String tIds);

    Map<String, DispatchingExportAreaOrderResult> selectByDateAndAddress(Date sendDate);

    int countManagerOrderList(DispatchingManageParam param);

    List<DispatchingManageResult> managerOrderList(DispatchingManageParam param);

    int updateOrder(DispatchingManageParam param);

}
