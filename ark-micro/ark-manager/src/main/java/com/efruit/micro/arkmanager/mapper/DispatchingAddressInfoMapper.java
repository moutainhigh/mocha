package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.bean.DispatchingAddressListResult;
import com.efruit.micro.arkmanager.bean.DispatchingCondition;
import com.efruit.micro.arkmanager.pojo.DispatchingAddressInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DispatchingAddressInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingAddressInfo record);

    int insertSelective(DispatchingAddressInfo record);

    DispatchingAddressInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchingAddressInfo record);

    int updateByPrimaryKey(DispatchingAddressInfo record);

    int insertList(List<DispatchingAddressInfo> accountShopInfoList);

    List<DispatchingAddressInfo> selectByLatAndLonInAddressIds(DispatchingCondition condition);

    List<DispatchingAddressInfo> selectBySendTime(Date sendDate, Double lat, Double lon);

    List<DispatchingAddressInfo> selectByDateAndAddress(@Param("sendDate") Date sendDate, @Param("addressId") Long id);
    List<DispatchingAddressInfo> selectAll();
}