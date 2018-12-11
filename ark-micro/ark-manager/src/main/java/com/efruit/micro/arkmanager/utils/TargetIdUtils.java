package com.efruit.micro.arkmanager.utils;

public class TargetIdUtils {
    public static long getTargetId(long orderId, long orderParentId) {
        if (orderParentId > 0) {
            return orderParentId;
        }

        return orderId;
    }
}
