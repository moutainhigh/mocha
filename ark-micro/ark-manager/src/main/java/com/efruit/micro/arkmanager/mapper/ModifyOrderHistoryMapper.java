package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.ModifyOrderHistory;
import com.efruit.micro.arkmanager.pojo.ModifyOrderHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModifyOrderHistoryMapper {
    int countByExample(ModifyOrderHistoryExample example);

    int deleteByExample(ModifyOrderHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModifyOrderHistory record);

    int insertSelective(ModifyOrderHistory record);

    List<ModifyOrderHistory> selectByExample(ModifyOrderHistoryExample example);

    ModifyOrderHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModifyOrderHistory record, @Param("example") ModifyOrderHistoryExample example);

    int updateByExample(@Param("record") ModifyOrderHistory record, @Param("example") ModifyOrderHistoryExample example);

    int updateByPrimaryKeySelective(ModifyOrderHistory record);

    int updateByPrimaryKey(ModifyOrderHistory record);
}