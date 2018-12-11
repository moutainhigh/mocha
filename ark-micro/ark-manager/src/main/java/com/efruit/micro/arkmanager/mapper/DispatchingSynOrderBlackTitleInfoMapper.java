package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingSynOrderBlackTitleInfo;

import java.util.List;

public interface DispatchingSynOrderBlackTitleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingSynOrderBlackTitleInfo record);

    int insertSelective(DispatchingSynOrderBlackTitleInfo record);

    DispatchingSynOrderBlackTitleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchingSynOrderBlackTitleInfo record);

    int updateByPrimaryKey(DispatchingSynOrderBlackTitleInfo record);

    List<DispatchingSynOrderBlackTitleInfo> selectAllValidList();

}