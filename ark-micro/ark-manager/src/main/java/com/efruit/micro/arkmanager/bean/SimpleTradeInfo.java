package com.efruit.micro.arkmanager.bean;

import java.util.List;

public class SimpleTradeInfo {
    private String itemId;
    private String skuId;
    private String itemName;
    private List<String> skuDetail;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<String> getSkuDetail() {
        return skuDetail;
    }

    public void setSkuDetail(List<String> skuDetail) {
        this.skuDetail = skuDetail;
    }
}
