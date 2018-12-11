package com.efruit.micro.arkmanager.utils;

import com.efruit.micro.arkmanager.pojo.OrderInfo;
import com.efruit.micro.arkmanager.pojo.OrderItemInfo;
import com.efruit.micro.youzan.common.OrderSelfFetchInfo;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoParseHelper {

    public static List<OrderInfo> toOrderInfoList(List<YouzanTradesSoldGetResult.StructurizationTrade> YouzanTradesSoldGetResultList) {
        if (CollectionUtils.isEmpty(YouzanTradesSoldGetResultList)) {
            return null;
        }

        final List<OrderInfo> orderInfoList = new ArrayList<>();

        for (YouzanTradesSoldGetResult.StructurizationTrade trade : YouzanTradesSoldGetResultList) {
            orderInfoList.add(toOrderInfo(trade));
        }

        return orderInfoList;
    }

    public static OrderInfo toOrderInfo(YouzanTradesSoldGetResult.StructurizationTrade YouzanTradesSoldGetResult) {

        OrderInfo resuleOrderInfo = new OrderInfo();

        final YouzanTradesSoldGetResult.StructurizationTradeOrderInfo fullOrderInfo = YouzanTradesSoldGetResult.getFullOrderInfo();

        final YouzanTradesSoldGetResult.StructurizationTradeBuyerInfoDetail buyerInfo = fullOrderInfo.getBuyerInfo();
        final String fansNickname = buyerInfo.getFansNickname();
        final Long fansId = buyerInfo.getFansId();
        final Long buyerId = buyerInfo.getBuyerId();
        final Long fansType = buyerInfo.getFansType();
        resuleOrderInfo.setFansNickname(fansNickname);
        resuleOrderInfo.setFansId(fansId);
        resuleOrderInfo.setBuyerId(buyerId);
        resuleOrderInfo.setFansType(fansType);

        final YouzanTradesSoldGetResult.StructurizationTradeRemarkInfoDetail remarkInfo = fullOrderInfo.getRemarkInfo();
        final String buyerMessage = remarkInfo.getBuyerMessage();
        final String tradeMemo = remarkInfo.getTradeMemo();
        resuleOrderInfo.setBuyerMessage(buyerMessage);
        resuleOrderInfo.setTradeMemo(tradeMemo);

        final YouzanTradesSoldGetResult.StructurizationTradePayInfoDetail payInfo = fullOrderInfo.getPayInfo();
        final Float payment = payInfo.getPayment();
        final Float totalFee = payInfo.getTotalFee();
        final Float postFee = payInfo.getPostFee();
        resuleOrderInfo.setPayment((long) (payment * 100L));
        resuleOrderInfo.setTotalFee((long) (totalFee * 100L));
        resuleOrderInfo.setPostFee((long) (postFee * 100L));

        final YouzanTradesSoldGetResult.StructurizationOrderInfoDetail orderInfo = fullOrderInfo.getOrderInfo();
        final Date created = orderInfo.getCreated();
        final Date payTime = orderInfo.getPayTime();
        final String status = orderInfo.getStatus();
        final String tid = orderInfo.getTid();
        final String statusStr = orderInfo.getStatusStr();
        resuleOrderInfo.setCreated(created);
        resuleOrderInfo.setPayTime(payTime);
        resuleOrderInfo.setStatus(status);
        resuleOrderInfo.setTid(tid);
        resuleOrderInfo.setStatusStr(statusStr);
        resuleOrderInfo.setUpdateTime(orderInfo.getUpdateTime());
        resuleOrderInfo.setExpressType(orderInfo.getExpressType().intValue());
        resuleOrderInfo.setPayType(orderInfo.getPayType().intValue());

        final YouzanTradesSoldGetResult.StructurizationTradeItemDetail[] orders = fullOrderInfo.getOrders();
        List<OrderItemInfo> orderItemInfoList = new ArrayList<>();
        for (YouzanTradesSoldGetResult.StructurizationTradeItemDetail tradeItemDetail : orders) {
            OrderItemInfo orderItemInfo = new OrderItemInfo();
            orderItemInfo.setItemId(tradeItemDetail.getItemId());
            orderItemInfo.setOid(tradeItemDetail.getOid());
            orderItemInfo.setItemType(tradeItemDetail.getItemType());
            orderItemInfo.setOuterSkuId(tradeItemDetail.getOuterSkuId());
            orderItemInfo.setNum(tradeItemDetail.getNum());
            orderItemInfo.setPrice((long) (tradeItemDetail.getPrice() * 100));
            orderItemInfo.setTotalFee((long) (tradeItemDetail.getTotalFee() * 100));
            orderItemInfo.setSkuPropertiesName(tradeItemDetail.getSkuPropertiesName());
            orderItemInfo.setTid(tid);
            orderItemInfo.setTitle(tradeItemDetail.getTitle());
            orderItemInfo.setSkuId(tradeItemDetail.getSkuId());
            orderItemInfoList.add(orderItemInfo);
        }
        resuleOrderInfo.setOrderItemInfos(orderItemInfoList);

        final YouzanTradesSoldGetResult.StructurizationTradeAddressInfoDetail addressInfo = fullOrderInfo.getAddressInfo();
        final String receiverName = addressInfo.getReceiverName();
        final String receiverTel = addressInfo.getReceiverTel();
        final String deliveryAddress = addressInfo.getDeliveryAddress();
        final String selfFetchInfoStr = addressInfo.getSelfFetchInfo();
        resuleOrderInfo.setReceiverName(receiverName);
        resuleOrderInfo.setReceiverTel(receiverTel);
        resuleOrderInfo.setDeliveryAddress(deliveryAddress);

        resuleOrderInfo.setDeliveryProvince(addressInfo.getDeliveryProvince());
        resuleOrderInfo.setDeliveryCity(addressInfo.getDeliveryCity());
        resuleOrderInfo.setDeliveryPostalCode(addressInfo.getDeliveryPostalCode());
        resuleOrderInfo.setDeliveryDistrict(addressInfo.getDeliveryDistrict());

        final OrderSelfFetchInfo selfFetchInfo = OrderSelfFetchInfo.fromJson(selfFetchInfoStr);
        if (selfFetchInfo != null) {
            resuleOrderInfo.setSelfFetchId(selfFetchInfo.getId());
            resuleOrderInfo.setSelfFetchName(selfFetchInfo.getName());
            resuleOrderInfo.setSelfFetchTel(selfFetchInfo.getTel());
            resuleOrderInfo.setSelfFetchUser(selfFetchInfo.getUser_name());
            resuleOrderInfo.setSelfFetchUserTel(selfFetchInfo.getUser_tel());
            final Double lon = selfFetchInfo.getLon();
            resuleOrderInfo.setLon(String.valueOf(lon));
            final Double lat = selfFetchInfo.getLat();
            resuleOrderInfo.setLat(String.valueOf(lat));
        }

        return resuleOrderInfo;
    }

}
