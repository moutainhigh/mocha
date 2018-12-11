package com.efruit.micro.youzan.bean;

import java.util.Date;

public class ArkOrder {
    private Long id;

    private String userId;// 微信openId

    private String tid;

    private String userNickname;// 微信昵称

    private String receiverName;

    private String receiverMobile;

    private String productName;

    private String productSku;

    private String skuName;

    private Long productPrice;

    private Long payment;

    private Date created;

    private Date payTime;

    private String receiverAddress;

    private String shippingType;

    private String buyerMsg;

    private String tradeMsg;

    private String status;

    private Long itemCount;

    private Long buyerId; // 有赞buyerId

    private long fansId; // 有赞fansId

    private String fetchInfoAddressDetail;

    private String fetchInfoCity; // 北京

    private String fetchInfoCountry; // 海淀区

    private String fetchInfoProvince; // 北京市

    private Long fetchInfoId;

    private String fetchInfoName;

    private Double fetchInfoLat; // 配送点经纬度

    private Double fetchInfoLon; // 配送点经纬度

    private String unionId;

    private String transaction;

    private String outerTransactions;

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

    public String getFetchInfoName() {
        return fetchInfoName;
    }

    public void setFetchInfoName(String fetchInfoName) {
        this.fetchInfoName = fetchInfoName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public long getFansId() {
        return fansId;
    }

    public void setFansId(long fansId) {
        this.fansId = fansId;
    }

    public String getFetchInfoAddressDetail() {
        return fetchInfoAddressDetail;
    }

    public void setFetchInfoAddressDetail(String fetchInfoAddressDetail) {
        this.fetchInfoAddressDetail = fetchInfoAddressDetail;
    }

    public String getFetchInfoCity() {
        return fetchInfoCity;
    }

    public void setFetchInfoCity(String fetchInfoCity) {
        this.fetchInfoCity = fetchInfoCity;
    }

    public String getFetchInfoCountry() {
        return fetchInfoCountry;
    }

    public void setFetchInfoCountry(String fetchInfoCountry) {
        this.fetchInfoCountry = fetchInfoCountry;
    }

    public Long getFetchInfoId() {
        return fetchInfoId;
    }

    public void setFetchInfoId(Long fetchInfoId) {
        this.fetchInfoId = fetchInfoId;
    }

    public Double getFetchInfoLat() {
        return fetchInfoLat;
    }

    public void setFetchInfoLat(Double fetchInfoLat) {
        this.fetchInfoLat = fetchInfoLat;
    }

    public Double getFetchInfoLon() {
        return fetchInfoLon;
    }

    public void setFetchInfoLon(Double fetchInfoLon) {
        this.fetchInfoLon = fetchInfoLon;
    }

    public String getFetchInfoProvince() {
        return fetchInfoProvince;
    }

    public void setFetchInfoProvince(String fetchInfoProvince) {
        this.fetchInfoProvince = fetchInfoProvince;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getOuterTransactions() {
        return outerTransactions;
    }

    public void setOuterTransactions(String outerTransactions) {
        this.outerTransactions = outerTransactions;
    }
}