package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.OrderInfo;
import com.efruit.micro.arkmanager.pojo.OrderInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoMapper {
    int countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int insertList(List<OrderInfo> orderInfoList);

    OrderInfo getLastOrderInfo();
}