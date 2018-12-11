package com.efruit.micro.arkmanager.pojo;

import java.util.Date;
import java.util.List;

public class OrderInfo {
    private Long id;

    private String status;

    private String statusStr;

    private Date created;

    private Date payTime;

    private Date updateTime;

    private Integer expressType;

    private Integer payType;

    private String tid;

    private Long fansType;

    private Long buyerId;

    private Long fansId;

    private String fansNickname;

    private String buyerMessage;

    private String tradeMemo;

    private Long totalFee;

    private Long postFee;

    private Long payment;

    private String deliveryAddress;

    private String deliveryPostalCode;

    private String receiverName;

    private String receiverTel;

    private String deliveryProvince;

    private String deliveryCity;

    private String deliveryDistrict;

    private Long selfFetchId;

    private String selfFetchName;

    private String selfFetchTel;

    private String selfFetchUser;

    private String selfFetchUserTel;

    private String lon;

    private String lat;

    private List<OrderItemInfo> orderItemInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr == null ? null : statusStr.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getExpressType() {
        return expressType;
    }

    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public Long getFansType() {
        return fansType;
    }

    public void setFansType(Long fansType) {
        this.fansType = fansType;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    public String getFansNickname() {
        return fansNickname;
    }

    public void setFansNickname(String fansNickname) {
        this.fansNickname = fansNickname == null ? null : fansNickname.trim();
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    public String getTradeMemo() {
        return tradeMemo;
    }

    public void setTradeMemo(String tradeMemo) {
        this.tradeMemo = tradeMemo == null ? null : tradeMemo.trim();
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }

    public void setDeliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode == null ? null : deliveryPostalCode.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel == null ? null : receiverTel.trim();
    }

    public String getDeliveryProvince() {
        return deliveryProvince;
    }

    public void setDeliveryProvince(String deliveryProvince) {
        this.deliveryProvince = deliveryProvince == null ? null : deliveryProvince.trim();
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity == null ? null : deliveryCity.trim();
    }

    public String getDeliveryDistrict() {
        return deliveryDistrict;
    }

    public void setDeliveryDistrict(String deliveryDistrict) {
        this.deliveryDistrict = deliveryDistrict == null ? null : deliveryDistrict.trim();
    }

    public Long getSelfFetchId() {
        return selfFetchId;
    }

    public void setSelfFetchId(Long selfFetchId) {
        this.selfFetchId = selfFetchId;
    }

    public String getSelfFetchName() {
        return selfFetchName;
    }

    public void setSelfFetchName(String selfFetchName) {
        this.selfFetchName = selfFetchName == null ? null : selfFetchName.trim();
    }

    public String getSelfFetchTel() {
        return selfFetchTel;
    }

    public void setSelfFetchTel(String selfFetchTel) {
        this.selfFetchTel = selfFetchTel == null ? null : selfFetchTel.trim();
    }

    public String getSelfFetchUser() {
        return selfFetchUser;
    }

    public void setSelfFetchUser(String selfFetchUser) {
        this.selfFetchUser = selfFetchUser == null ? null : selfFetchUser.trim();
    }

    public String getSelfFetchUserTel() {
        return selfFetchUserTel;
    }

    public void setSelfFetchUserTel(String selfFetchUserTel) {
        this.selfFetchUserTel = selfFetchUserTel == null ? null : selfFetchUserTel.trim();
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public List<OrderItemInfo> getOrderItemInfos() {
        return orderItemInfos;
    }

    public void setOrderItemInfos(List<OrderItemInfo> orderItemInfos) {
        this.orderItemInfos = orderItemInfos;
    }
}