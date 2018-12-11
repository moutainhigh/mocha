package com.efruit.micro.arkmanager.bean;


import com.efruit.micro.arkcommon.utils.DateFormatHelper;

import java.util.Date;
import java.util.List;

//订单查询条件
public class OrderCondition {
    public static final int SELECT_FROM_DEFALT = 1;
    public static final int SELECT_FROM_DELIVER = 2;
    public static final int SELECT_FROM_DELIVER_EXPORT = 3;
    public static final int SELECT_FROM_CUSTOM_BATCH_TAGGING = 4;

    private String userNickName;//昵称搜索
    private String productName;//商品名称
    private Date startDate;//开始时间
    private Date endDate;//结束时间
    private Date targetDate;
    private String userId;//用户id
    private String receiverMobile;//手机号
    private String receiverAddress;//配送点
    private String receiverName;
    private int onlyNeedValid;// 只搜索有效订单，1 : 是 , 0 : 否，默认是0

    private List<String> orderStatusList;
    private long orderId;

    private int orderValidStatus;//订单有效状态
    private int orderType;//订单类型，1、首次新购订单 2、续费订单
    private int orderPeriodType;// 订单周期类型，1：按月 2：按日
    private int orderBy;//排序 1：倒序  2：正序
    private int index;
    private int page;
    private int size;

    private String productSku;
    private long minFee;
    private long maxFee;

    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public long getMinFee() {
        return minFee;
    }

    public void setMinFee(long minFee) {
        this.minFee = minFee;
    }

    public long getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(long maxFee) {
        this.maxFee = maxFee;
    }

    private int selectFrom = SELECT_FROM_DEFALT;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public List<String> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(List<String> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOrderValidStatus() {
        return orderValidStatus;
    }

    public void setOrderValidStatus(int orderValidStatus) {
        this.orderValidStatus = orderValidStatus;
    }


    public int getOrderType() {
        return orderType;
    }


    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }


    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public int getOnlyNeedValid() {
        return onlyNeedValid;
    }

    public void setOnlyNeedValid(int onlyNeedValid) {
        this.onlyNeedValid = onlyNeedValid;
    }

    public int getOrderPeriodType() {
        return orderPeriodType;
    }

    public void setOrderPeriodType(int orderPeriodType) {
        this.orderPeriodType = orderPeriodType;
    }

    public int getSelectFrom() {
        return selectFrom;
    }

    public void setSelectFrom(int selectFrom) {
        this.selectFrom = selectFrom;
    }

    @Override
    public String toString() {
        return "OrderCondition{" +
                "userNickName='" + userNickName + '\'' +
                ", productName='" + productName + '\'' +
                ", startDate=" + DateFormatHelper.formatDate(startDate) +
                ", endDate=" + DateFormatHelper.formatDate(endDate) +
                ", targetDate=" + DateFormatHelper.formatDate(targetDate) +
                ", userId='" + userId + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", onlyNeedValid=" + onlyNeedValid +
                ", orderStatusList=" + orderStatusList +
                ", orderId=" + orderId +
                ", orderValidStatus=" + orderValidStatus +
                ", orderType=" + orderType +
                ", orderPeriodType=" + orderPeriodType +
                ", orderBy=" + orderBy +
                ", index=" + index +
                ", page=" + page +
                ", size=" + size +
                ", productSku='" + productSku + '\'' +
                ", minFee=" + minFee +
                ", maxFee=" + maxFee +
                ", selectFrom=" + selectFrom +
                '}';
    }


}
