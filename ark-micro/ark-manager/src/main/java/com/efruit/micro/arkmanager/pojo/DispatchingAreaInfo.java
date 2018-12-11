package com.efruit.micro.arkmanager.pojo;

import java.util.Date;
import java.util.List;

public class DispatchingAreaInfo {
    private Long id;

    private String aTitle;

    private Integer aStatus;

    private Date updateTime;

    private Date createTime;

    private List<DispatchingAddressInfo> addressInfoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle == null ? null : aTitle.trim();
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<DispatchingAddressInfo> getAddressInfoList() {
        return addressInfoList;
    }
    public void setAddressInfoList(List<DispatchingAddressInfo> addressInfoList) {
        this.addressInfoList = addressInfoList;
    }
}