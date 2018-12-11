package com.efruit.micro.arkmanager.utils;

import com.efruit.micro.arkmanager.bean.SimpleTradeInfo;
import com.efruit.micro.arkmanager.bean.TradeInfoVo;
import com.efruit.micro.arkmanager.service.OrderServiceConstant;
import com.efruit.micro.youzan.common.OrderSkuProperties;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class TradeInfoHelper {

    public static List<TradeInfoVo> calTradeInfo(List<YouzanTradesSoldGetResult.StructurizationTrade> youzanTradeList) {
        List<TradeInfoVo> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(youzanTradeList)) {
            return result;
        }

        final Map<Long, List<SimpleTradeInfo>> calMap = new HashMap<>();

        for (YouzanTradesSoldGetResult.StructurizationTrade tmpTrade : youzanTradeList) {
            final YouzanTradesSoldGetResult.StructurizationTradeOrderInfo fullOrderInfo = tmpTrade.getFullOrderInfo();
            final YouzanTradesSoldGetResult.StructurizationOrderInfoDetail orderInfo = fullOrderInfo.getOrderInfo();

            final String status = orderInfo.getStatus();
            final boolean valid = OrderServiceConstant.VAILD_STATUS_LIST.contains(status);
            if (!valid) {
                continue;
            }

            final YouzanTradesSoldGetResult.StructurizationTradeItemDetail[] itemDetails = fullOrderInfo.getOrders();
            for (YouzanTradesSoldGetResult.StructurizationTradeItemDetail itemDetail : itemDetails) {
                final Long itemId = itemDetail.getItemId();
                final Long skuId = itemDetail.getSkuId();
                final String skuPropertiesName = itemDetail.getSkuPropertiesName();
                final List<String> skuDetail = OrderSkuProperties.extractSkuNameInfo(skuPropertiesName);
                final String title = itemDetail.getTitle();

                if (itemId == null || skuId == null) {
                    continue;
                }

                SimpleTradeInfo tmpSimpleTradeInfo = new SimpleTradeInfo();
                tmpSimpleTradeInfo.setItemId(String.valueOf(itemId));
                tmpSimpleTradeInfo.setSkuId(String.valueOf(skuId));
                tmpSimpleTradeInfo.setSkuDetail(skuDetail);
                tmpSimpleTradeInfo.setItemName(title);

                final List<SimpleTradeInfo> simpleTradeInfos = calMap.get(skuId);
                if (simpleTradeInfos != null) {
                    simpleTradeInfos.add(tmpSimpleTradeInfo);
                } else {
                    List<SimpleTradeInfo> tmpTradeInfos = new ArrayList<>();
                    tmpTradeInfos.add(tmpSimpleTradeInfo);
                    calMap.put(skuId, tmpTradeInfos);
                }
            }

        }

        for (Long key : calMap.keySet()) {
            final List<SimpleTradeInfo> tradeInfos = calMap.get(key);
            if (!CollectionUtils.isEmpty(tradeInfos)) {
                final SimpleTradeInfo simpleTradeInfo = tradeInfos.get(0);
                TradeInfoVo tradeInfoVo = new TradeInfoVo();
                tradeInfoVo.setItemId(simpleTradeInfo.getItemId());
                tradeInfoVo.setItemName(simpleTradeInfo.getItemName());
                tradeInfoVo.setSkuDetail(simpleTradeInfo.getSkuDetail());
                tradeInfoVo.setSkuId(simpleTradeInfo.getSkuId());
                tradeInfoVo.setTotal(tradeInfos.size());
                result.add(tradeInfoVo);
            }

        }

        sortByCount(result);
        return result;
    }

    private static void sortByCount(List<TradeInfoVo> datas) {
        if (CollectionUtils.isEmpty(datas)) {
            return;
        }
        Collections.sort(datas, new Comparator<TradeInfoVo>() {
            @Override
            public int compare(TradeInfoVo o1, TradeInfoVo o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }

                final long o1Total = o1.getTotal();
                final long o2Total = o2.getTotal();
                if (o1Total == o2Total) {
                    return 0;
                } else if (o1Total > o2Total) {// 按销量倒序
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

}
