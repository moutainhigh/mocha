package com.efruit.micro.arkmanager.bean;

import java.util.Date;
import java.util.List;

//用户延迟订单
public class OrderModifyInfo {
    private String receiverName;//收货人
    private String receiverMobile;//手机号
    private String receiverAddress;//配送点
    private String adminMsg;//备注
    private List<Date> dayList;//选择的天列表
    private long orderId;//订单id
    private long orderParentId;

    public List<Date> getDayList() {
        return dayList;
    }

    public void setDayList(List<Date> dayList) {
        this.dayList = dayList;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getAdminMsg() {
        return adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg;
    }

    public long getOrderParentId() {
        return orderParentId;
    }

    public void setOrderParentId(long orderParentId) {
        this.orderParentId = orderParentId;
    }

    @Override
    public String toString() {
        return "OrderModifyInfo{" +
                "receiverName='" + receiverName + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", adminMsg='" + adminMsg + '\'' +
                ", dayList=" + dayList +
                ", orderId=" + orderId +
                ", orderParentId=" + orderParentId +
                '}';
    }
}
