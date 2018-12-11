package com.efruit.micro.arkmanager.bean;

public class OrderCountModifyInfo {
    public static final int FROME_TYPE_ADMIN = 1;
    public static final int FROME_TYPE_DELAY = 2;

    private long orderId;
    private long orderParentId;
    private String modifyUser;
    private String modifyMsg;
    private int modifyCount;
    private int fromType = FROME_TYPE_ADMIN;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderParentId() {
        return orderParentId;
    }

    public void setOrderParentId(long orderParentId) {
        this.orderParentId = orderParentId;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyMsg() {
        return modifyMsg;
    }

    public void setModifyMsg(String modifyMsg) {
        this.modifyMsg = modifyMsg;
    }

    public int getModifyCount() {
        return modifyCount;
    }

    public void setModifyCount(int modifyCount) {
        this.modifyCount = modifyCount;
    }

    public int getFromType() {
        return fromType;
    }

    public void setFromType(int fromType) {
        this.fromType = fromType;
    }
}
