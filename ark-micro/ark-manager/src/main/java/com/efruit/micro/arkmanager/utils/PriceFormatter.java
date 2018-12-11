package com.efruit.micro.arkmanager.utils;

import java.text.DecimalFormat;

public class PriceFormatter {
//    取整数部分 + 保留2位小数
    private static final DecimalFormat DEFAULT_FORMAT = new DecimalFormat("#.00");

    public static String format(long val) {
        return DEFAULT_FORMAT.format(val / 100.f);
    }
}
