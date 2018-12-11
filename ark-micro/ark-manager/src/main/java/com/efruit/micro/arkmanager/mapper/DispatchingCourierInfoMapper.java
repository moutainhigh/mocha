package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingCourierInfo;

import java.util.List;

public interface DispatchingCourierInfoMapper {
    int deleteByPrimaryKey(Long id);
    int insert(DispatchingCourierInfo record);
    int insertSelective(DispatchingCourierInfo record);
    DispatchingCourierInfo selectByPrimaryKey(Long id);
    DispatchingCourierInfo selectByMobile(String mobile);
    int updateByPrimaryKeySelective(DispatchingCourierInfo record);
    int updateByPrimaryKey(DispatchingCourierInfo record);
    List<DispatchingCourierInfo> selectAll();
}