package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingAddressInfo;
import com.efruit.micro.arkmanager.pojo.DispatchingAreaInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DispatchingAreaInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingAreaInfo record);

    int insertSelective(DispatchingAreaInfo record);

    DispatchingAreaInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchingAreaInfo record);

    int updateByPrimaryKey(DispatchingAreaInfo record);

    List<DispatchingAreaInfo> selectByStatus(int a_status);

    List<DispatchingAreaInfo> selectByDate(@Param("sendDate") Date sendDate, @Param("addressId") Long id);

}