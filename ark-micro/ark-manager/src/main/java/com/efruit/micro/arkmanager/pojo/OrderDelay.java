package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class OrderDelay {
    private Integer delayId;

    private Long orderId;

    private Date orderDelayDate;

    public Integer getDelayId() {
        return delayId;
    }

    public void setDelayId(Integer delayId) {
        this.delayId = delayId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDelayDate() {
        return orderDelayDate;
    }

    public void setOrderDelayDate(Date orderDelayDate) {
        this.orderDelayDate = orderDelayDate;
    }

    @Override
    public String toString() {
        return "OrderDelay{" +
                "delayId=" + delayId +
                ", orderId=" + orderId +
                ", orderDelayDate=" + orderDelayDate +
                '}';
    }
}