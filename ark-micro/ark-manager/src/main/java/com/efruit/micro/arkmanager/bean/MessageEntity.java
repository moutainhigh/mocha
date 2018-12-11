package com.efruit.micro.arkmanager.bean;

public class MessageEntity {
    private String userId;
    private String userMobile;
    private String fetchName;
    private String fetchCode;
    private String deliverName;
    private String deliverMobile;
    private String deliverLat;
    private String deliverLon;
    private String extraParam;
    private String addressDetail;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getFetchName() {
        return fetchName;
    }

    public void setFetchName(String fetchName) {
        this.fetchName = fetchName;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverMobile() {
        return deliverMobile;
    }

    public void setDeliverMobile(String deliverMobile) {
        this.deliverMobile = deliverMobile;
    }

    public String getDeliverLat() {
        return deliverLat;
    }

    public void setDeliverLat(String deliverLat) {
        this.deliverLat = deliverLat;
    }

    public String getDeliverLon() {
        return deliverLon;
    }

    public void setDeliverLon(String deliverLon) {
        this.deliverLon = deliverLon;
    }

    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    public String getFetchCode() {
        return fetchCode;
    }

    public void setFetchCode(String fetchCode) {
        this.fetchCode = fetchCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}
