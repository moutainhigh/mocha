package com.efruit.micro.arkmanager.bean;

import java.util.Date;

//配送查询
public class DispatchingCondition {

    private Double lat;//纬度
    private Double lon;//经度
    private Long id; //地址id
    private Date searchDate;//查询时间
    private String courierMobile;//快递员手机号
    private String courierName;//快递员名字
    private String addressDetails;//配送点的具体地址
    private DispatchingAddress dispatchingAddress;//配送地址信息
    //订单id E开头的
    private String tid;
    //订单状态
    //WAIT_SELLER_SEND_GOODS    等待发货
    //WAIT_BUYER_CONFIRM_GOODS  等待收货
    //TRADE_SUCCESS             交易成功
    //TRADE_BUYER_SIGNED        买家签收
    private String orderStatus;
    private String buyerTel;
    //用户openId
    private String userId;
    //订单状态，1：装配 （已付款） 2：待发出（已发车） 3:待配送（包含1,2） 4:订单完成
    private int status;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
    }

    public String getCourierMobile() {
        return courierMobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourierMobile(String courierMobile) {
        this.courierMobile = courierMobile;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public DispatchingAddress getDispatchingAddress() {
        return dispatchingAddress;
    }

    public void setDispatchingAddress(DispatchingAddress dispatchingAddress) {
        this.dispatchingAddress = dispatchingAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }
    public String getBuyerTel() {
        return buyerTel;
    }
    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }
}
