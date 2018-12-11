package com.efruit.micro.arkmanager.utils;

import org.apache.commons.lang3.StringUtils;

public enum SkuDays {
    DAY("DAY", 1),
    MONTH("0000011", 22),
    WEEK("0000013", 5),
    HALF_MONTH("0000014", 11),
    QUARTER("0000014", 66);

    String sku;
    int days;

    SkuDays(String sku, int days) {
        this.sku = sku;
        this.days = days;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public static SkuDays parse(String sku) {
        if (StringUtils.equalsIgnoreCase(sku, SkuDays.MONTH.getSku())) {
            return SkuDays.MONTH;
        }

        return SkuDays.DAY;
    }
}
