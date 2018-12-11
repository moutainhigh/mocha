package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingSkuTypeInfo;

import java.util.List;

public interface DispatchingSkuTypeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingSkuTypeInfo record);

    int insertList(List<DispatchingSkuTypeInfo> record);

    int insertSelective(DispatchingSkuTypeInfo record);

    DispatchingSkuTypeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchingSkuTypeInfo record);

    int updateByPrimaryKey(DispatchingSkuTypeInfo record);
}