package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.bean.DispatchingManageParam;
import com.efruit.micro.arkmanager.pojo.DispatchingOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DispatchingOrderMapper {
    int deleteByPrimaryKey(String tid);

    int insert(DispatchingOrder record);

    int insertList(List<DispatchingOrder> records);

    int insertSelective(DispatchingOrder record);

    DispatchingOrder selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(DispatchingOrder record);

    int updateByPrimaryKey(DispatchingOrder record);

    List<DispatchingOrder> selectBySelective(DispatchingOrder record);

    List<DispatchingOrder> selectByDateAndAddress(@Param("addressId") Long addressId, @Param("sendDate") Date sendDate);

    List<DispatchingOrder> managerOrderList(DispatchingManageParam param);
    int countManagerOrderList(DispatchingManageParam param);
}