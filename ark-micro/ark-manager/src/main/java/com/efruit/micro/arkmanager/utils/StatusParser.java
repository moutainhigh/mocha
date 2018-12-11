package com.efruit.micro.arkmanager.utils;

public class StatusParser {
    private static final int DEFAULT_TRUE_VALUE = 1;
    private static final int DEFAULT_FALSE_VALUE = 0;

    public static boolean toBoolean(int status) {
        if (status == DEFAULT_TRUE_VALUE) {
            return true;
        }

        return false;
    }

    public static int toInt(Boolean status) {
        if (status != null && status) {
            return DEFAULT_TRUE_VALUE;
        }

        return DEFAULT_FALSE_VALUE;
    }
}
