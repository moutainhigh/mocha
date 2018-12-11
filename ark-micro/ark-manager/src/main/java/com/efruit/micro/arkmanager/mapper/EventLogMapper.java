package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.EventLog;
import com.efruit.micro.arkmanager.pojo.EventLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventLogMapper {
    int countByExample(EventLogExample example);

    int deleteByExample(EventLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EventLog record);

    int insertSelective(EventLog record);

    List<EventLog> selectByExample(EventLogExample example);

    EventLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EventLog record, @Param("example") EventLogExample example);

    int updateByExample(@Param("record") EventLog record, @Param("example") EventLogExample example);

    int updateByPrimaryKeySelective(EventLog record);

    int updateByPrimaryKey(EventLog record);
}