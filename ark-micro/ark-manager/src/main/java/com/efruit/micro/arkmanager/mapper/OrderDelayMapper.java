package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.pojo.OrderDelay;
import com.efruit.micro.arkmanager.pojo.OrderDelayExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderDelayMapper {
    int countByExample(OrderDelayExample example);

    int deleteByExample(OrderDelayExample example);

    int deleteByPrimaryKey(Integer delayId);

    int insert(OrderDelay record);

    int insertSelective(OrderDelay record);

    List<OrderDelay> selectByExample(OrderDelayExample example);

    OrderDelay selectByPrimaryKey(Integer delayId);

    int updateByExampleSelective(@Param("record") OrderDelay record, @Param("example") OrderDelayExample example);

    int updateByExample(@Param("record") OrderDelay record, @Param("example") OrderDelayExample example);

    int updateByPrimaryKeySelective(OrderDelay record);

    int updateByPrimaryKey(OrderDelay record);

    List<OrderDelay> getOrderDelayByOrderId(OrderCondition condition);

    List<Date> getValidDelayDate(OrderCondition orderCondition);

    int insertList(List<OrderDelay> orderDelays);
}