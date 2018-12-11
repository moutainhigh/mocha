package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.bean.OrderCountModifyInfo;
import com.efruit.micro.arkmanager.bean.OrderModifyInfo;
import com.efruit.micro.arkmanager.pojo.AOrder;

import java.util.Date;
import java.util.List;

public interface NewOrderService {

    ArkCommonResult loadOrderList();

    ArkCommonResult loadOrderList(Date start, Date end);

    ArkCommonResult addOrder(AOrder order);

    ArkCommonResult getOrderList(OrderCondition condition);

    AOrder getOrderById(long orderId);

    AOrder getOrderByTid(String tid);

    ArkCommonResult modifyOrderCount(OrderCountModifyInfo modifyInfo);

    ArkCommonResult updateOrderDelay(OrderModifyInfo modifyInfo);

    // 获取配送点列表
    List<String> getAddressList();

    List<AOrder> getOrderListByTids(List<String> tids);

    List<AOrder> getOrderListByMobile(List<String> mobiles);

    /**
     * 查询用户购买过的有效订单总数（有效订单：指已付款、已经交易成功等）
     * @param userId
     * @return
     * @see OrderServiceConstant#VAILD_STATUS_LIST
     */
    int getOrderListCountByUserId(String userId);

    List<String> getUserIdListByMobile(String mobile);

}
