package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class OrderItemInfo {
    private Long id;

    private String tid;

    private String oid;

    private Long itemType;

    private String title;

    private Long num;

    private String outerSkuId;

    private Long price;

    private Long totalFee;

    private Long itemId;

    private Long skuId;

    private String skuPropertiesName;

    private Date startDeliverDate;

    private Date endDeliverDate;

    private Long deliverCount;

    private String adminMsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Long getItemType() {
        return itemType;
    }

    public void setItemType(Long itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId == null ? null : outerSkuId.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuPropertiesName() {
        return skuPropertiesName;
    }

    public void setSkuPropertiesName(String skuPropertiesName) {
        this.skuPropertiesName = skuPropertiesName == null ? null : skuPropertiesName.trim();
    }

    public Date getStartDeliverDate() {
        return startDeliverDate;
    }

    public void setStartDeliverDate(Date startDeliverDate) {
        this.startDeliverDate = startDeliverDate;
    }

    public Date getEndDeliverDate() {
        return endDeliverDate;
    }

    public void setEndDeliverDate(Date endDeliverDate) {
        this.endDeliverDate = endDeliverDate;
    }

    public Long getDeliverCount() {
        return deliverCount;
    }

    public void setDeliverCount(Long deliverCount) {
        this.deliverCount = deliverCount;
    }

    public String getAdminMsg() {
        return adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg == null ? null : adminMsg.trim();
    }
}