package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class ModifyOrderHistory {
    private Long id;

    private Long orderId;

    private String modifyUser;

    private Integer modifyFrom;

    private Date modifyTime;

    private String beforeOrderInfo;

    private String afterOrderInfo;

    private String beforeDelayInfo;

    private String afterDelayInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Integer getModifyFrom() {
        return modifyFrom;
    }

    public void setModifyFrom(Integer modifyFrom) {
        this.modifyFrom = modifyFrom;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getBeforeOrderInfo() {
        return beforeOrderInfo;
    }

    public void setBeforeOrderInfo(String beforeOrderInfo) {
        this.beforeOrderInfo = beforeOrderInfo == null ? null : beforeOrderInfo.trim();
    }

    public String getAfterOrderInfo() {
        return afterOrderInfo;
    }

    public void setAfterOrderInfo(String afterOrderInfo) {
        this.afterOrderInfo = afterOrderInfo == null ? null : afterOrderInfo.trim();
    }

    public String getBeforeDelayInfo() {
        return beforeDelayInfo;
    }

    public void setBeforeDelayInfo(String beforeDelayInfo) {
        this.beforeDelayInfo = beforeDelayInfo == null ? null : beforeDelayInfo.trim();
    }

    public String getAfterDelayInfo() {
        return afterDelayInfo;
    }

    public void setAfterDelayInfo(String afterDelayInfo) {
        this.afterDelayInfo = afterDelayInfo == null ? null : afterDelayInfo.trim();
    }
}