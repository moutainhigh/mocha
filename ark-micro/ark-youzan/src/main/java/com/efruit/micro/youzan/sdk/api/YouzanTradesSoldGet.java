package com.efruit.micro.youzan.sdk.api;

import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetParams;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import com.youzan.open.sdk.api.AbstractAPI;

public class YouzanTradesSoldGet extends AbstractAPI {

    public YouzanTradesSoldGet() {
    }

    public YouzanTradesSoldGet(YouzanTradesSoldGetParams apiParams) {
        this.params = apiParams;
    }

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getVersion() {
        return "4.0.0";
    }

    @Override
    public String getName() {
        return "youzan.trades.sold.get";
    }

    @Override
    public Class getResultModelClass() {
        return YouzanTradesSoldGetResult.class;
    }

    @Override
    public Class getParamModelClass() {
        return YouzanTradesSoldGetParams.class;
    }

    @Override
    public boolean hasFiles() {
        return false;
    }

}
