package com.efruit.micro.arkmanager.utils;

public class ThreadUtils {

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignore) {
        }
    }
}
