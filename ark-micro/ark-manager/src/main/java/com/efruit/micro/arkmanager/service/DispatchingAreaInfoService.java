package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingAreaInfo;

import java.util.Date;
import java.util.List;

public interface DispatchingAreaInfoService {

    int save(DispatchingAreaInfo areaInfo);

    int update(DispatchingAreaInfo areaInfo);

    List<DispatchingAreaInfo> getByStatus(int a_status);

    List<DispatchingAreaInfo> getItemBySendDate(Date sendDate);

    DispatchingAreaInfo getById(Long id);

    Long synAreaByAddressId(Long addressId);

}
