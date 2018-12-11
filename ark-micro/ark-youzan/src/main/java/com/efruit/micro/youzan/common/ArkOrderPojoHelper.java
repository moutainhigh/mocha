package com.efruit.micro.youzan.common;

import com.efruit.micro.youzan.bean.ArkOrder;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradesSoldGetResult;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class ArkOrderPojoHelper {

    public static ArkOrder toArkOrder(YouzanTradesSoldGetResult.TradeDetailV2 tradeDetail) {
        if (tradeDetail == null) {
            return null;
        }

        ArkOrder arkOrder = new ArkOrder();
        final YouzanTradesSoldGetResult.FansInfo fansInfo = tradeDetail.getFansInfo();
        String fansWeixinOpenid = fansInfo.getFansWeixinOpenid();
        arkOrder.setUserId(fansWeixinOpenid);
        arkOrder.setTid(tradeDetail.getTid());
        String fansNickname = fansInfo.getFansNickname();
        arkOrder.setUserNickname(fansNickname);
        arkOrder.setReceiverName(tradeDetail.getReceiverName());
        arkOrder.setReceiverMobile(tradeDetail.getReceiverMobile());
        arkOrder.setFansId(fansInfo.getFansId());
        arkOrder.setBuyerId(fansInfo.getBuyerId());

        YouzanTradesSoldGetResult.TradeOrderV2 tradeOrder = tradeDetail.getOrders()[0];
        arkOrder.setProductName(tradeOrder.getTitle());
        arkOrder.setProductSku(tradeOrder.getOuterSkuId());
        arkOrder.setProductPrice((long) (tradeOrder.getPrice() * 100));
        arkOrder.setItemCount(tradeOrder.getNum());

        arkOrder.setPayment((long) (tradeDetail.getPayment() * 100));
        arkOrder.setCreated(tradeDetail.getCreated());
        arkOrder.setPayTime(tradeDetail.getPayTime());
        arkOrder.setReceiverAddress(tradeDetail.getReceiverAddress());
        arkOrder.setShippingType(tradeDetail.getShippingType());
        arkOrder.setBuyerMsg(tradeDetail.getBuyerMessage());
        arkOrder.setTradeMsg(tradeDetail.getTradeMemo());
        arkOrder.setStatus(tradeDetail.getStatus());

        final YouzanTradesSoldGetResult.TradeFetch fetchDetail = tradeDetail.getFetchDetail();
        if (fetchDetail != null) {
            arkOrder.setFetchInfoId(fetchDetail.getShopId());
            arkOrder.setFetchInfoCity(fetchDetail.getShopCity());
            arkOrder.setFetchInfoProvince(fetchDetail.getShopState());
            arkOrder.setFetchInfoCountry(fetchDetail.getShopDistrict());
            arkOrder.setFetchInfoAddressDetail(fetchDetail.getShopAddress());
            arkOrder.setFetchInfoName(fetchDetail.getShopName());
        }

        arkOrder.setSkuName(tradeOrder.getSkuPropertiesName());

        return arkOrder;
    }

    public static ArkOrder toArkOrder(com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult youzanTradeGetResult, YouzanUsersWeixinFollowerGetResult.CrmWeixinFans weixinFans) {
        if (youzanTradeGetResult == null) {
            return null;
        }

        ArkOrder arkOrder = new ArkOrder();
        final com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationTradeOrderInfo fullOrderInfo = youzanTradeGetResult.getFullOrderInfo();

        final com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationTradeBuyerInfoDetail buyerInfo = fullOrderInfo.getBuyerInfo();
        final String fansNickname = buyerInfo.getFansNickname();
        final Long fansId = buyerInfo.getFansId();
        final Long buyerId = buyerInfo.getBuyerId();

        arkOrder.setUserNickname(fansNickname);
        arkOrder.setUserId(weixinFans.getWeixinOpenid());
        arkOrder.setUnionId(weixinFans.getUnionId());
        arkOrder.setFansId(fansId);
        arkOrder.setBuyerId(buyerId);

        final com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationOrderInfoDetail orderInfo = fullOrderInfo.getOrderInfo();
        final Date created = orderInfo.getCreated();
        final Date payTime = orderInfo.getPayTime();
        final String status = orderInfo.getStatus();
        final String tid = orderInfo.getTid();

        arkOrder.setTid(tid);
        arkOrder.setCreated(created);
        arkOrder.setPayTime(payTime);
        arkOrder.setStatus(status);

        final com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationTradeItemDetail[] orders = fullOrderInfo.getOrders();
        com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationTradeItemDetail tradeItemDetail = orders[0];
//        final Float payment = tradeItemDetail.getPayment();
        final String outerSkuId = tradeItemDetail.getOuterSkuId();
        final Long num = tradeItemDetail.getNum();
        final String buyerMessages = tradeItemDetail.getBuyerMessages();
        final String skuPropertiesName = tradeItemDetail.getSkuPropertiesName();
        final String skuName = getSkuName(skuPropertiesName);
        final String title = tradeItemDetail.getTitle();
        final Float price = tradeItemDetail.getPrice();

        arkOrder.setProductPrice((long) (price * 100));
        arkOrder.setProductSku(outerSkuId);
        arkOrder.setItemCount(num);
        arkOrder.setBuyerMsg(buyerMessages);
        arkOrder.setSkuName(skuName);
        arkOrder.setProductName(title);

        final com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationTradeAddressInfoDetail addressInfo = fullOrderInfo.getAddressInfo();
        final String receiverName = addressInfo.getReceiverName();
        final String receiverTel = addressInfo.getReceiverTel();
        final String deliveryAddress = addressInfo.getDeliveryAddress();
        final String selfFetchInfoStr = addressInfo.getSelfFetchInfo();
        OrderSelfFetchInfo selfFetchInfo = OrderSelfFetchInfo.fromJson(selfFetchInfoStr);
        if (selfFetchInfo != null) {
            arkOrder.setFetchInfoAddressDetail(selfFetchInfo.getAddress_detail());
            arkOrder.setFetchInfoCity(selfFetchInfo.getCity());
            arkOrder.setFetchInfoProvince(selfFetchInfo.getProvince());
            arkOrder.setFetchInfoCountry(selfFetchInfo.getCounty());
            arkOrder.setFetchInfoLat(selfFetchInfo.getLat());
            arkOrder.setFetchInfoLon(selfFetchInfo.getLon());
            arkOrder.setFetchInfoId(selfFetchInfo.getId());
            arkOrder.setFetchInfoName(selfFetchInfo.getName());
        }

        arkOrder.setReceiverName(receiverName);
        arkOrder.setReceiverMobile(receiverTel);
        arkOrder.setReceiverAddress(deliveryAddress);

        final com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult.StructurizationTradeRemarkInfoDetail remarkInfo = fullOrderInfo.getRemarkInfo();
        final String tradeMemo = remarkInfo.getTradeMemo();
        arkOrder.setTradeMsg(tradeMemo);

        final YouzanTradeGetResult.StructurizationTradePayInfoDetail payInfo = fullOrderInfo.getPayInfo();
        final String[] transactions = payInfo.getTransaction();
        if (transactions.length > 0) {
            arkOrder.setTransaction(transactions[0]);
        }

        final String[] outerTransactions = payInfo.getOuterTransactions();
        if (outerTransactions.length > 0) {
            arkOrder.setOuterTransactions(outerTransactions[0]);
        }

        final Float payment = payInfo.getPayment();
        if (payment != null && payment >= 0) {
            arkOrder.setPayment((long) (payment * 100));
        }

        return arkOrder;
    }

    // [{"k":"规格","k_id":14,"v":"净果500g+","v_id":25477014},{"k":"发货时间","k_id":28098,"v":"次日14-17点之间送达","v_id":25569958},{"k":"配送打包","k_id":25477032,"v":"免配送费，免餐盒费（损坏包赔）","v_id":25477046}]
    private static String getSkuName(String propertiesName) {
        final List<OrderSkuProperties> propertiesList = OrderSkuProperties.parse(propertiesName);
        if (CollectionUtils.isEmpty(propertiesList)) {
            return "";
        }

        OrderSkuProperties skuProperties = null;

        for (OrderSkuProperties properties : propertiesList) {
            final String k = properties.getK();
            if (StringUtils.equalsIgnoreCase(k, "规格")) {
                skuProperties = properties;
                break;
            }
        }

        if (skuProperties == null) {
            return "";
        }

        return skuProperties.getV();
    }

}
