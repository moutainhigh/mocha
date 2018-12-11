package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.OrderItemInfo;
import com.efruit.micro.arkmanager.pojo.OrderItemInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemInfoMapper {
    int countByExample(OrderItemInfoExample example);

    int deleteByExample(OrderItemInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderItemInfo record);

    int insertSelective(OrderItemInfo record);

    List<OrderItemInfo> selectByExample(OrderItemInfoExample example);

    OrderItemInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderItemInfo record, @Param("example") OrderItemInfoExample example);

    int updateByExample(@Param("record") OrderItemInfo record, @Param("example") OrderItemInfoExample example);

    int updateByPrimaryKeySelective(OrderItemInfo record);

    int updateByPrimaryKey(OrderItemInfo record);

    int insertList(List<OrderItemInfo> orderItemInfoList);
}