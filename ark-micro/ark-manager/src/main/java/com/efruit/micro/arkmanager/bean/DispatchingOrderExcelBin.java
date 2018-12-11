package com.efruit.micro.arkmanager.bean;

public class DispatchingOrderExcelBin {
    // 顺序必须与成员变量定义的顺序一致，否则会错乱
//    public static final String[] DEFAULT_HEADER = {"商品名称", "规格", "数量", "配送地点", "收货人", "电话", "备注"};

    private String itemName;
    private String skuInfo;
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

    public String getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(String skuInfo) {
        this.skuInfo = skuInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
