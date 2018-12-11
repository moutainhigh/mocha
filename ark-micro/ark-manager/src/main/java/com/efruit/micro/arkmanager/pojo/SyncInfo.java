package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class SyncInfo {
    private Long id;

    private Date created;

    private Date lastOrderDate;

    private String lastOrderTid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public String getLastOrderTid() {
        return lastOrderTid;
    }

    public void setLastOrderTid(String lastOrderTid) {
        this.lastOrderTid = lastOrderTid == null ? null : lastOrderTid.trim();
    }
}