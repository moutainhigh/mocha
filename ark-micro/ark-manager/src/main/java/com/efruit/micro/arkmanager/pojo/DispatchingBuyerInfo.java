package com.efruit.micro.arkmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class DispatchingBuyerInfo {
    private String userName;

    private String userId;

    private Long fansId;

    private String userMobile;

    private Integer status;

    private Date createTime;

    //记录数据库是否已经存在
    @JSONField(serialize = false)
    private Boolean isExist;

    private int count;
    private List<DispatchingOrder> orderList;
    private DispatchingFetchCodeInfo fetchCodeInfo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DispatchingOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<DispatchingOrder> orderList) {
        this.orderList = orderList;
    }

    public DispatchingFetchCodeInfo getFetchCodeInfo() {
        return fetchCodeInfo;
    }

    public void setFetchCodeInfo(DispatchingFetchCodeInfo fetchCodeInfo) {
        this.fetchCodeInfo = fetchCodeInfo;
    }

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    public DispatchingBuyerInfo(){}
    public DispatchingBuyerInfo(String userMobile) {
        this.userMobile = userMobile;
    }

    public Boolean getExist() {
        return isExist;
    }

    public void setExist(Boolean exist) {
        isExist = exist;
    }
}