package com.efruit.micro.arkmanager.bean;

import java.util.List;

//配送地址列表
public class DispatchingOrderListResult {
    private String name;
    private String mobile;
    private String userId;
    private int status;
    private String fetchCode;
    private String tids;
    private List<DispatchingItemInfo> itemInfoList;

    public DispatchingOrderListResult() {

    }

    public DispatchingOrderListResult(String name, String mobile, String userId, int status, List<DispatchingItemInfo> orderMapList) {
        this.name = name;
        this.mobile = mobile;
        this.userId = userId;
        this.status = status;
        this.itemInfoList = orderMapList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public List<DispatchingItemInfo> getItemInfoList() {
        return itemInfoList;
    }

    public void setItemInfoList(List<DispatchingItemInfo> itemInfoList) {
        this.itemInfoList = itemInfoList;
    }

    public String getFetchCode() {
        return fetchCode;
    }

    public void setFetchCode(String fetchCode) {
        this.fetchCode = fetchCode;
    }

    public String getTids() {
        return tids;
    }

    public void setTids(String tids) {
        this.tids = tids;
    }
}



