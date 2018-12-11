package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.FansCustomerInfo;
import com.efruit.micro.arkmanager.pojo.FansCustomerInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FansCustomerInfoMapper {
    int countByExample(FansCustomerInfoExample example);

    int deleteByExample(FansCustomerInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FansCustomerInfo record);

    int insertSelective(FansCustomerInfo record);

    List<FansCustomerInfo> selectByExample(FansCustomerInfoExample example);

    FansCustomerInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FansCustomerInfo record, @Param("example") FansCustomerInfoExample example);

    int updateByExample(@Param("record") FansCustomerInfo record, @Param("example") FansCustomerInfoExample example);

    int updateByPrimaryKeySelective(FansCustomerInfo record);

    int updateByPrimaryKey(FansCustomerInfo record);

    int insertList(List<FansCustomerInfo> fansCustomerInfoList);
}