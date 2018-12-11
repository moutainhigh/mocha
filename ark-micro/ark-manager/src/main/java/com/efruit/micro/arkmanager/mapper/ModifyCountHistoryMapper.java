package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.ModifyCountHistory;
import com.efruit.micro.arkmanager.pojo.ModifyCountHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModifyCountHistoryMapper {
    int countByExample(ModifyCountHistoryExample example);

    int deleteByExample(ModifyCountHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModifyCountHistory record);

    int insertSelective(ModifyCountHistory record);

    List<ModifyCountHistory> selectByExample(ModifyCountHistoryExample example);

    ModifyCountHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModifyCountHistory record, @Param("example") ModifyCountHistoryExample example);

    int updateByExample(@Param("record") ModifyCountHistory record, @Param("example") ModifyCountHistoryExample example);

    int updateByPrimaryKeySelective(ModifyCountHistory record);

    int updateByPrimaryKey(ModifyCountHistory record);
}