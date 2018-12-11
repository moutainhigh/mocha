package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingSynSign;
import com.efruit.micro.arkmanager.pojo.DispatchingSynSignExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DispatchingSynSignMapper {
    int countByExample(DispatchingSynSignExample example);

    int deleteByExample(DispatchingSynSignExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchingSynSign record);

    int insertSelective(DispatchingSynSign record);

    List<DispatchingSynSign> selectByExample(DispatchingSynSignExample example);

    DispatchingSynSign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchingSynSign record, @Param("example") DispatchingSynSignExample example);

    int updateByExample(@Param("record") DispatchingSynSign record, @Param("example") DispatchingSynSignExample example);

    int updateByPrimaryKeySelective(DispatchingSynSign record);

    int updateByPrimaryKey(DispatchingSynSign record);

    List<DispatchingSynSign> selectBySynDate(Date synDate);
}