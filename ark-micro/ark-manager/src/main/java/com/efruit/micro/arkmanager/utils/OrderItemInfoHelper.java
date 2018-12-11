package com.efruit.micro.arkmanager.utils;

import com.efruit.micro.arkmanager.pojo.OrderInfo;
import com.efruit.micro.arkmanager.pojo.OrderItemInfo;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemInfoHelper {

    public static List<OrderItemInfo> getOrderItemInfoList(List<OrderInfo> orderInfoList) {
        final List<OrderItemInfo> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(orderInfoList)) {
            return result;
        }

        for (OrderInfo orderInfo : orderInfoList) {
            final List<OrderItemInfo> orderItemInfos = orderInfo.getOrderItemInfos();
            if (!CollectionUtils.isEmpty(orderItemInfos)) {
                result.addAll(orderItemInfos);
            }
        }

        return result;
    }
}
