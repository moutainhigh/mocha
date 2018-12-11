package com.efruit.micro.arkmanager.utils;


import com.efruit.micro.arkmanager.bean.OrderCondition;

public class BatchTagCondition extends OrderCondition {

    private String wxTagName;

    public String getWxTagName() {
        return wxTagName;
    }

    public void setWxTagName(String wxTagName) {
        this.wxTagName = wxTagName;
    }
}
