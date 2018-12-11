package com.efruit.micro.youzan.common;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SkuInfoMap {

    private static final Map<String, String> INFO_MAP = new HashMap<>();

    static {
        INFO_MAP.put("0000011", "包月");
        INFO_MAP.put("0000013", "一周");
        INFO_MAP.put("0000014", "半月");
        INFO_MAP.put("0000015", "季度");
    }

    public static boolean isPeriodType(String sku) {
        if (StringUtils.isEmpty(sku)) {
            return false;
        }

        if (INFO_MAP.containsKey(sku)) {
            return true;
        }

        return false;
    }
}
