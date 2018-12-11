package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingFetchCodeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DispatchingFetchCodeInfoService {
    int save(DispatchingFetchCodeInfo fetchCodeInfo);

    void insertList(List<DispatchingFetchCodeInfo> fetchCodeInfos);

    int update(DispatchingFetchCodeInfo fetchCodeInfo);

    int updateSelevte(DispatchingFetchCodeInfo fetchCodeInfo);

    int updateAreaByAddress(Long addressId, Long areaId);

    List<DispatchingFetchCodeInfo> getListBySendTime(Date sendTime);

    List<DispatchingFetchCodeInfo> selectBySelective(DispatchingFetchCodeInfo obj);

    int getMaxCodeByAddressSendDate(Long areaId, Date sendTime);

    DispatchingFetchCodeInfo selectByAddressTelSendDate(DispatchingFetchCodeInfo obj);

    void insertDispatchingFetchCodeInfo(Date sendDate);
}
