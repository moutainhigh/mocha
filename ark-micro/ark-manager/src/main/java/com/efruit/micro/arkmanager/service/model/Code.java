package com.efruit.micro.arkmanager.service.model;

//状态码
public enum Code {
    success(800, "success"),
    parameter_error(801, "parameter is error"),
    order_not_exist(802, "order does not exist"),//订单不存在
    order_completed(803, "the order has been completed"),//订单已经完成
    service_error(819, "service is error"),
    system_error(820, "system error");
    private int code;
    private String msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
