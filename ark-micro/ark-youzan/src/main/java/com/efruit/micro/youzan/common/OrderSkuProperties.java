package com.efruit.micro.youzan.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

// [{"k":"规格","k_id":14,"v":"净果500g+","v_id":25477014},{"k":"发货时间","k_id":28098,"v":"次日14-17点之间送达","v_id":25569958},{"k":"配送打包","k_id":25477032,"v":"免配送费，免餐盒费（损坏包赔）","v_id":25477046}]
public class OrderSkuProperties {
    private String k;
    private String k_id;
    private String v;
    private String v_id;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getK_id() {
        return k_id;
    }

    public void setK_id(String k_id) {
        this.k_id = k_id;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getV_id() {
        return v_id;
    }

    public void setV_id(String v_id) {
        this.v_id = v_id;
    }

    public static List<OrderSkuProperties> parse(String jsonStr) {
        List<OrderSkuProperties> result = new ArrayList<>();
        if (StringUtils.isEmpty(jsonStr)) {
            return result;
        }

        final List<OrderSkuProperties> orderSkuProperties = JSONObject.parseArray(jsonStr, OrderSkuProperties.class);
        if (CollectionUtils.isEmpty(orderSkuProperties)) {
            return result;
        }

        return orderSkuProperties;
    }

    public static List<String> extractSkuNameInfo(String skuPropertiesName) {
        final List<OrderSkuProperties> propertiesList = OrderSkuProperties.parse(skuPropertiesName);
        List<String> result = new ArrayList<>();
        for (OrderSkuProperties properties : propertiesList) {
            final String propertiesK = properties.getK();
            final String propertiesV = properties.getV();
            final String value = propertiesK + " : " + propertiesV;
            result.add(value);
        }

        return result;
    }

    public static String extractFirst(String skuPropertiesName) {
        final List<OrderSkuProperties> propertiesList = OrderSkuProperties.parse(skuPropertiesName);
        if (CollectionUtils.isEmpty(propertiesList)) {
            return "";
        }

        final OrderSkuProperties first = propertiesList.get(0);
        return first.getK() + " : " + first.getV();
    }

    public static String extractFirstValue(String skuPropertiesName) {
        final List<OrderSkuProperties> propertiesList = OrderSkuProperties.parse(skuPropertiesName);
        if (CollectionUtils.isEmpty(propertiesList)) {
            return "";
        }

        final OrderSkuProperties first = propertiesList.get(0);
        return first.getV();
    }
}
