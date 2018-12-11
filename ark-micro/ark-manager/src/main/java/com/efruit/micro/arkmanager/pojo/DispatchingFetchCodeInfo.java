package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class DispatchingFetchCodeInfo {
    private Long id;

    private Long addressId;

    private Long areaId;

    private String userMobile;

    private String code;

    private Date sendDate;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    private DispatchingBuyerInfo buyerInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public DispatchingFetchCodeInfo(Long addressId, String userMobile, String code, Date sendDate) {
        this.addressId = addressId;
        this.userMobile = userMobile;
        this.code = code;
        this.sendDate = sendDate;
    }

    public DispatchingFetchCodeInfo(Long areaId, Long addressId, String userMobile, Date sendDate) {
        this.areaId = areaId;
        this.addressId = addressId;
        this.userMobile = userMobile;
        this.sendDate = sendDate;
    }

    public DispatchingFetchCodeInfo() {
    }

    public DispatchingBuyerInfo getBuyerInfo() {
        return buyerInfo;
    }

    public void setBuyerInfo(DispatchingBuyerInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
    }
}