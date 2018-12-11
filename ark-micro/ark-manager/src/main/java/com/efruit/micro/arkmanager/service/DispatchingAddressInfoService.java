package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.bean.DispatchingAddressListResult;
import com.efruit.micro.arkmanager.bean.DispatchingCondition;
import com.efruit.micro.arkmanager.pojo.DispatchingAddressInfo;

import java.util.Date;
import java.util.List;

public interface DispatchingAddressInfoService {

    int saveShopInfo(DispatchingAddressInfo dispatchingAddressInfo);

    boolean saveShopInfoList(List<DispatchingAddressInfo> dispatchingAddressInfoList);

    List<DispatchingAddressListResult> getDispatchingAddressInfo(DispatchingCondition condition);

    DispatchingAddressInfo getDispatchingAddressByShopId(Long shopId);

    void insertDispatchingAddress(List<DispatchingAddressInfo> addressInfos);

    void synYouZanOffline();

    List<DispatchingAddressInfo> selectByDateAndId(Date sendDate, Long id);
    List<DispatchingAddressInfo> selectAll();
}
