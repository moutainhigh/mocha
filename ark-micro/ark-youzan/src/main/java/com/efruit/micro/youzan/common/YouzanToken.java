package com.efruit.micro.youzan.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YouzanToken {
    @JsonProperty(value = "access_token")
    private String accessToken;

    private long createTime;// 单位：ms
    @JsonProperty(value = "expires_in")
    private int expiresIn; // 有效时间，单位：秒

    @JsonProperty(value = "scope")
    private String scope;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String access_token) {
        this.accessToken = access_token;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expires_in) {
        this.expiresIn = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
