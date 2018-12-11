package com.efruit.micro.arkmanager.bean;

public class OrderExcelBin {

    // 顺序必须与成员变量定义的顺序一致，否则会错乱
//    public static final String[] DEFAULT_HEADER = OrderExportHelper.DEFAULT_HEADER;

    private String itemName;
    private int count;
    private String address;
    private String receiver;
    private String mobile;
    private String msg;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
