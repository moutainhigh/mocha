package com.efruit.micro.youzan.common;

public enum ErrorKeyDef {
    DEFAULT(-1, "error"),
    TOKEN_INVAILD(10000, "TOKEN INVAILD.")
    ;

    private int errorCode;
    private String msg;

    private ErrorKeyDef(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
