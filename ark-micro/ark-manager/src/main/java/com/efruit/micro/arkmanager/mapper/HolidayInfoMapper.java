package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.HolidayInfo;
import com.efruit.micro.arkmanager.pojo.HolidayInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HolidayInfoMapper {
    int countByExample(HolidayInfoExample example);

    int deleteByExample(HolidayInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HolidayInfo record);

    int insertSelective(HolidayInfo record);

    List<HolidayInfo> selectByExample(HolidayInfoExample example);

    HolidayInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HolidayInfo record, @Param("example") HolidayInfoExample example);

    int updateByExample(@Param("record") HolidayInfo record, @Param("example") HolidayInfoExample example);

    int updateByPrimaryKeySelective(HolidayInfo record);

    int updateByPrimaryKey(HolidayInfo record);
}