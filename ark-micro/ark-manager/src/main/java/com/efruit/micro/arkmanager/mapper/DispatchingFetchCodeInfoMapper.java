package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingFetchCodeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DispatchingFetchCodeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingFetchCodeInfo record);

    int insertSelective(DispatchingFetchCodeInfo record);

    DispatchingFetchCodeInfo selectByPrimaryKey(Long id);

    DispatchingFetchCodeInfo selectByAddressTelSendDate(DispatchingFetchCodeInfo record);

    int updateByPrimaryKeySelective(DispatchingFetchCodeInfo record);

    int updateByPrimaryKey(DispatchingFetchCodeInfo record);

    int insertList(List<DispatchingFetchCodeInfo> records);

    List<DispatchingFetchCodeInfo> selectBySendTime(Date sendDate);

    List<DispatchingFetchCodeInfo> selectBySelective(DispatchingFetchCodeInfo record);

    int updateAreaByAddress(@Param("addressId")Long addressId, @Param("areaId")Long areaId);

    int getMaxCodeByAddressSendDate(Long addressId, Date sendTime);
}