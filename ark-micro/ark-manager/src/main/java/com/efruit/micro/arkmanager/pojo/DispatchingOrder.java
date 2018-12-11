package com.efruit.micro.arkmanager.pojo;

import java.util.Date;
import java.util.List;

public class DispatchingOrder {
    private String tid;

    private String status;

    private String statusStr;

    private Long expressType;

    private String payTypeStr;

    private String buyerExf;

    private String tradeExf;

    private int fetchStatus;

    private Long type;

    private Long payType;

    private Date sendTime;

    private Date payTime;

    private Date created;

    private Date updateTime;

    private Date expiredTime;

    private Date confirmTime;

    private Date consignTime;

    private Long refundState;

    private Date createTime;

    private Long addressId;

    private String buyerId;

    private Date reissueTime;

    private DispatchingBuyerInfo buyer;
    private DispatchingAddressInfo address;
    private List<DispatchingOrderDetailsInfo> orderDetailsInfoList;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
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

    public Long getExpressType() {
        return expressType;
    }

    public void setExpressType(Long expressType) {
        this.expressType = expressType;
    }

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr == null ? null : payTypeStr.trim();
    }

    public String getBuyerExf() {
        return buyerExf;
    }

    public void setBuyerExf(String buyerExf) {
        this.buyerExf = buyerExf == null ? null : buyerExf.trim();
    }

    public String getTradeExf() {
        return tradeExf;
    }

    public void setTradeExf(String tradeExf) {
        this.tradeExf = tradeExf == null ? null : tradeExf.trim();
    }

    public int getFetchStatus() {
        return fetchStatus;
    }

    public void setFetchStatus(int fetchStatus) {
        this.fetchStatus = fetchStatus;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public Long getRefundState() {
        return refundState;
    }

    public void setRefundState(Long refundState) {
        this.refundState = refundState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public DispatchingBuyerInfo getBuyer() {
        return buyer;
    }

    public void setBuyer(DispatchingBuyerInfo buyer) {
        this.buyer = buyer;
    }

    public DispatchingAddressInfo getAddress() {
        return address;
    }

    public void setAddress(DispatchingAddressInfo address) {
        this.address = address;
    }

    public List<DispatchingOrderDetailsInfo> getOrderDetailsInfoList() {
        return orderDetailsInfoList;
    }

    public void setOrderDetailsInfoList(List<DispatchingOrderDetailsInfo> orderDetailsInfoList) {
        this.orderDetailsInfoList = orderDetailsInfoList;
    }
    public Date getReissueTime() {
        return reissueTime;
    }
    public void setReissueTime(Date reissueTime) {
        this.reissueTime = reissueTime;
    }
}