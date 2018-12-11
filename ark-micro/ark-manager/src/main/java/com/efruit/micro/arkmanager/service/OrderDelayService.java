package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.pojo.OrderDelay;

import java.util.Date;
import java.util.List;

public interface OrderDelayService {

    /**
     * 根据orderId获取所有的其当前所有的延期信息
     * @param orderId
     * @return
     */
    List<OrderDelay> getAllOrderDelayListByOrderId(long orderId);


    /**
     * 根据orderId有效的延期信息，即有效的日期列表
     * @return
     */
    List<Date> getValidDelayDate(OrderCondition orderCondition);

    int saveOrderDelayList(List<OrderDelay> orderDelays);

    int deleteOrderDelay(long orderId);

}
