package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class RefundInfo {
    private String id;

    private String tid;

    private String msgType;

    private Date created;

    private Date refundTime;

    private String refundType;

    private Long refundedFee;

    private String refundReason;

    private String refundId;

    private String oids;

    private String transaction;

    private Integer status;

    private String outertransactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    public Long getRefundedFee() {
        return refundedFee;
    }

    public void setRefundedFee(Long refundedFee) {
        this.refundedFee = refundedFee;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId == null ? null : refundId.trim();
    }

    public String getOids() {
        return oids;
    }

    public void setOids(String oids) {
        this.oids = oids == null ? null : oids.trim();
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction == null ? null : transaction.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOutertransactions() {
        return outertransactions;
    }

    public void setOutertransactions(String outertransactions) {
        this.outertransactions = outertransactions == null ? null : outertransactions.trim();
    }
}