package com.efruit.micro.youzan.sdk.api;

import com.efruit.micro.youzan.sdk.model.YouzanMultistoreAddressGetParams;
import com.efruit.micro.youzan.sdk.model.YouzanMultistoreAddressGetResult;
import com.youzan.open.sdk.api.AbstractAPI;

public class YouzanMultistoreAddressGet extends AbstractAPI {

    public YouzanMultistoreAddressGet() {
    }

    public YouzanMultistoreAddressGet(YouzanMultistoreAddressGetParams apiParams) {
        this.params = apiParams;
    }

    public String getHttpMethod() {
        return "GET";
    }

    public String getVersion() {
        return "3.0.0";
    }

    public String getName() {
        return "youzan.multistore.offline.get";
    }

    public Class getResultModelClass() {
        return YouzanMultistoreAddressGetResult.class;
    }

    public Class getParamModelClass() {
        return YouzanMultistoreAddressGetResult.class;
    }

    public boolean hasFiles() {
        return  false ;
    }

}