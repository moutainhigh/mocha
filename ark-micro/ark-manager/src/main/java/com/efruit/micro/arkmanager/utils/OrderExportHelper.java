package com.efruit.micro.arkmanager.utils;

import com.efruit.micro.arkmanager.bean.OrderExcelBin;
import com.efruit.micro.arkmanager.pojo.AOrder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderExportHelper {

    public static final String[] DEFAULT_HEADER = {"商品名称", "数量", "配送地点", "收货人", "电话", "备注"};

    public static List<OrderExcelBin> parse(List<AOrder> orderList) {

        final List<OrderExcelBin> result = new ArrayList<>();

        if (CollectionUtils.isEmpty(orderList)) {
            return result;
        }

        for (AOrder order : orderList) {
            OrderExcelBin excelBin = new OrderExcelBin();
            final Integer itemCount = order.getItemCount();
            if (itemCount != null) {
                excelBin.setCount(itemCount);
            }
            excelBin.setItemName(order.getProductName());
            excelBin.setReceiver(order.getReceiverName());
            excelBin.setMobile(order.getReceiverMobile());
            excelBin.setAddress(order.getReceiverAddress());
            final String msg = OrderExportHelper.getMsg(order);
            excelBin.setMsg(msg);
            result.add(excelBin);
        }

        return result;
    }

    public static String getMsg(AOrder order) {
        StringBuilder sb = new StringBuilder();
        final String buyerMsg = order.getBuyerMsg();
        if (!StringUtils.isEmpty(buyerMsg)) {
            sb.append("买家备注 : " + buyerMsg + "\n");
        }
        final String tradeMsg = order.getTradeMsg();
        if (!StringUtils.isEmpty(tradeMsg)) {
            sb.append("卖家备注 : " + tradeMsg + "\n");
        }

        final String adminMsg = order.getAdminMsg();
        if (!StringUtils.isEmpty(adminMsg)) {
            sb.append("管理员备注 : " + adminMsg + "\n");
        }

        return sb.toString();
    }
}
