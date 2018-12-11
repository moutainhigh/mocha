package com.efruit.micro.arkmanager.constant;

import com.efruit.micro.arkmanager.utils.SkuDays;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class OrderPeriodType {
    public static final int PERIOD_MONTH = 1;
    public static final int PERIOD_DAY = 2;
    public static final int PERIOD_WEEK = 3;
    public static final int PERIOD_HALF_MONTH = 4;
    public static final int PERIOD_QUARTER = 5;

    public static final Map<Integer, String> MAP = new HashMap<>();

    private static final Map<String, Integer> SKU_TO_PERIOD_TYPE_MAP = new HashMap<>();

    static {
        MAP.put(PERIOD_MONTH, "按月");
        MAP.put(PERIOD_DAY, "按日");
        MAP.put(PERIOD_WEEK, "按周");
        MAP.put(PERIOD_HALF_MONTH, "按半月");
        MAP.put(PERIOD_QUARTER, "按季");

        SKU_TO_PERIOD_TYPE_MAP.put(SkuDays.MONTH.getSku(), PERIOD_MONTH);
        SKU_TO_PERIOD_TYPE_MAP.put(SkuDays.WEEK.getSku(), PERIOD_WEEK);
        SKU_TO_PERIOD_TYPE_MAP.put(SkuDays.HALF_MONTH.getSku(), PERIOD_HALF_MONTH);
        SKU_TO_PERIOD_TYPE_MAP.put(SkuDays.QUARTER.getSku(), PERIOD_QUARTER);
    }

    public static int parse(String sku) {
        if (StringUtils.isEmpty(sku)) {
            return PERIOD_DAY;
        }
        final Integer type = SKU_TO_PERIOD_TYPE_MAP.get(sku);
        if (type != null) {
            return PERIOD_MONTH;
        }
        return PERIOD_DAY;
    }
}
