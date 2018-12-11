package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.OrderItemInfoMapper;
import com.efruit.micro.arkmanager.pojo.OrderItemInfo;
import com.efruit.micro.arkmanager.pojo.OrderItemInfoExample;
import com.efruit.micro.arkmanager.service.OrderItemInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemInfoServiceImpl implements OrderItemInfoService {

    @Autowired
    OrderItemInfoMapper orderItemInfoMapper;

    @Override
    public boolean saveOrderItemInfo(OrderItemInfo orderItemInfo) {
        return orderItemInfoMapper.insert(orderItemInfo) > 0;
    }

    @Override
    public boolean saveOrderItemInfoList(List<OrderItemInfo> orderItemInfoList) {
        if (CollectionUtils.isEmpty(orderItemInfoList)) {
            return false;
        }
        return orderItemInfoMapper.insertList(orderItemInfoList) == orderItemInfoList.size();
    }

    @Override
    public List<OrderItemInfo> getOrderItemInfoListByTid(String tid) {
        OrderItemInfoExample example = new OrderItemInfoExample();
        final OrderItemInfoExample.Criteria criteria = example.createCriteria();
        criteria.andTidEqualTo(tid);
        return orderItemInfoMapper.selectByExample(example);
    }
}
