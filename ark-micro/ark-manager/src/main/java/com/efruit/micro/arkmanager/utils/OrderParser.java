package com.efruit.micro.arkmanager.utils;


import com.efruit.micro.arkmanager.pojo.AOrder;
import com.efruit.micro.youzan.bean.ArkOrder;

import java.util.Date;

import static com.efruit.micro.arkmanager.service.OrderServiceConstant.ORDER_STATUS_VALID;


public class OrderParser {

    public static AOrder toOrder(ArkOrder arkOrder) {
        AOrder order = new AOrder();
        order.setUserNickname(arkOrder.getUserNickname());
        order.setReceiverAddress(arkOrder.getReceiverAddress());
        order.setBuyerMsg(arkOrder.getBuyerMsg());
        order.setShippingType(arkOrder.getShippingType());
        order.setReceiverName(arkOrder.getReceiverName());
        order.setReceiverMobile(arkOrder.getReceiverMobile());
        order.setTid(arkOrder.getTid());
        order.setYouzanStatus(arkOrder.getStatus());
        order.setTradeMsg(arkOrder.getTradeMsg());
        order.setUserId(arkOrder.getUserId());
        order.setProductPrice(arkOrder.getProductPrice());
        order.setProductSku(arkOrder.getProductSku());
        order.setProductName(arkOrder.getProductName());
        order.setPayTime(arkOrder.getPayTime());
        order.setPayment(arkOrder.getPayment());
        order.setCreated(arkOrder.getCreated());
        order.setItemCount(arkOrder.getItemCount().intValue());

        order.setSkuName(arkOrder.getSkuName());

        order.setUpdateDate(new Date());
        order.setOrderValidStatus(ORDER_STATUS_VALID);
        return order;
    }
}
