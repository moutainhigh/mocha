package com.efruit.micro.arkmanager.pojo;

import java.util.Date;
import java.util.List;

public class AOrder {
    private Long id;

    private String userId;

    private String tid;

    private String userNickname;

    private String receiverName;

    private String receiverMobile;

    private String productName;

    private String productSku;

    private Long productPrice;

    private Long payment;

    private Date created;

    private Date payTime;

    private String receiverAddress;

    private String shippingType;

    private String buyerMsg;

    private String tradeMsg;

    private String youzanStatus;

    private Integer orderValidStatus;

    private Long renewOrderParentId;

    private Integer orderType;

    private Integer orderPeriodType;

    private Date updateDate;

    private Date orderStartSendDate;

    private Integer initialOrderDay;

    private Integer renewLaterDay;

    private Integer itemCount;

    private String adminMsg;

    private Date lastDate;

    private String skuName;

    private List<Date> delays;

    public List<Date> getDelays() {
        return delays;
    }

    public void setDelays(List<Date> delays) {
        this.delays = delays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku == null ? null : productSku.trim();
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
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

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType == null ? null : shippingType.trim();
    }

    public String getBuyerMsg() {
        return buyerMsg;
    }

    public void setBuyerMsg(String buyerMsg) {
        this.buyerMsg = buyerMsg == null ? null : buyerMsg.trim();
    }

    public String getTradeMsg() {
        return tradeMsg;
    }

    public void setTradeMsg(String tradeMsg) {
        this.tradeMsg = tradeMsg == null ? null : tradeMsg.trim();
    }

    public String getYouzanStatus() {
        return youzanStatus;
    }

    public void setYouzanStatus(String youzanStatus) {
        this.youzanStatus = youzanStatus == null ? null : youzanStatus.trim();
    }

    public Integer getOrderValidStatus() {
        return orderValidStatus;
    }

    public void setOrderValidStatus(Integer orderValidStatus) {
        this.orderValidStatus = orderValidStatus;
    }

    public Long getRenewOrderParentId() {
        return renewOrderParentId;
    }

    public void setRenewOrderParentId(Long renewOrderParentId) {
        this.renewOrderParentId = renewOrderParentId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderPeriodType() {
        return orderPeriodType;
    }

    public void setOrderPeriodType(Integer orderPeriodType) {
        this.orderPeriodType = orderPeriodType;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getOrderStartSendDate() {
        return orderStartSendDate;
    }

    public void setOrderStartSendDate(Date orderStartSendDate) {
        this.orderStartSendDate = orderStartSendDate;
    }

    public Integer getInitialOrderDay() {
        return initialOrderDay;
    }

    public void setInitialOrderDay(Integer initialOrderDay) {
        this.initialOrderDay = initialOrderDay;
    }

    public Integer getRenewLaterDay() {
        return renewLaterDay;
    }

    public void setRenewLaterDay(Integer renewLaterDay) {
        this.renewLaterDay = renewLaterDay;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getAdminMsg() {
        return adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg == null ? null : adminMsg.trim();
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }
}