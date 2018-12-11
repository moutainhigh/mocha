package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.FansCustomerInfo;

import java.util.List;

public interface FansCustomInfoService {

    int getFansCustomerInfoCount();

    List<FansCustomerInfo> getFansCustomerInfoList();

    boolean saveFansCustomerInfoList(List<FansCustomerInfo> fansCustomerInfoList);

    boolean saveFansCustomerInfoListByPage(List<FansCustomerInfo> fansCustomerInfoList);

    void syncFansCustomerInfoFromYouzan();

    boolean deleteAllFansCustomerInfo();
}
