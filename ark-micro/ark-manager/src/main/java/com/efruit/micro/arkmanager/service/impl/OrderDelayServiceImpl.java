package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.mapper.OrderDelayMapper;
import com.efruit.micro.arkmanager.pojo.OrderDelay;
import com.efruit.micro.arkmanager.pojo.OrderDelayExample;
import com.efruit.micro.arkmanager.service.OrderDelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderDelayServiceImpl implements OrderDelayService {

    @Autowired
    private OrderDelayMapper orderDelayMapper;

    @Override
    public List<OrderDelay> getAllOrderDelayListByOrderId(long orderId) {
        OrderDelayExample example = new OrderDelayExample();
        final OrderDelayExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderDelayMapper.selectByExample(example);
    }

    @Override
    public List<Date> getValidDelayDate(OrderCondition orderCondition) {
        return orderDelayMapper.getValidDelayDate(orderCondition);
    }

    @Override
    public int saveOrderDelayList(List<OrderDelay> orderDelays) {
        return orderDelayMapper.insertList(orderDelays);
    }

    @Override
    public int deleteOrderDelay(long orderId) {
        OrderDelayExample example = new OrderDelayExample();
        final OrderDelayExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderDelayMapper.deleteByExample(example);
    }
}
