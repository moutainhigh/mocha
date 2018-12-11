package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class DispatchingCommodityInfo {
    private Long itemId;

    private String title;

    private int status;

    private Long itemType;

    private String picPath;

    private String alias;

    private Date createTime;

    private Long skuId;

    private Long num;

    private DispatchingSkuTypeInfo skuTypeInfo;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getItemType() {
        return itemType;
    }

    public void setItemType(Long itemType) {
        this.itemType = itemType;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public DispatchingSkuTypeInfo getSkuTypeInfo() {
        return skuTypeInfo;
    }

    public void setSkuTypeInfo(DispatchingSkuTypeInfo skuTypeInfo) {
        this.skuTypeInfo = skuTypeInfo;
    }
}