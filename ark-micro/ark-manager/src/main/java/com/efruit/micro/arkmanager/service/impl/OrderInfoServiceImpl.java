package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.OrderInfoMapper;
import com.efruit.micro.arkmanager.pojo.OrderInfo;
import com.efruit.micro.arkmanager.pojo.OrderInfoExample;
import com.efruit.micro.arkmanager.service.OrderInfoService;
import com.efruit.micro.youzan.service.YouzanService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    @Autowired
    YouzanService youzanService;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Override
    public boolean saveYouzanOrder(OrderInfo orderInfo) {
        return orderInfoMapper.insert(orderInfo) > 0;
    }

    @Override
    public boolean saveYouzanOrderList(List<OrderInfo> orderInfoList) {
        if (CollectionUtils.isEmpty(orderInfoList)) {
            return false;
        }

        return orderInfoMapper.insertList(orderInfoList) == orderInfoList.size();
    }

    @Override
    public OrderInfo getOrderInfoByTid(String tid) {
        OrderInfoExample example = new OrderInfoExample();
        final OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andTidEqualTo(tid);
        final List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(orderInfos)) {
            return orderInfos.get(0);
        }
        return null;
    }

    @Override
    public int countOrderInfo() {
        OrderInfoExample example = new OrderInfoExample();
        return orderInfoMapper.countByExample(example);
    }

    @Override
    public OrderInfo getLastOrderInfo() {
        return orderInfoMapper.getLastOrderInfo();
    }
}
