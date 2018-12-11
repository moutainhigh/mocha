package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingCommodityInfo;

import java.util.List;

public interface DispatchingCommodityInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingCommodityInfo record);

    int insertList(List<DispatchingCommodityInfo> record);

    int insertSelective(DispatchingCommodityInfo record);

    DispatchingCommodityInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchingCommodityInfo record);

    int updateByPrimaryKey(DispatchingCommodityInfo record);
}