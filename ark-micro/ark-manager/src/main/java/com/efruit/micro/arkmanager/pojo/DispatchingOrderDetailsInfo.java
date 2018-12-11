package com.efruit.micro.arkmanager.pojo;

public class DispatchingOrderDetailsInfo {
    private Long id;

    private String tid;

    private Long cid;

    private Long orderNum;

    private String oid;

    private String refundState;

    private DispatchingCommodityInfo commodityInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public DispatchingCommodityInfo getCommodityInfo() {
        return commodityInfo;
    }

    public void setCommodityInfo(DispatchingCommodityInfo commodityInfo) {
        this.commodityInfo = commodityInfo;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }
}