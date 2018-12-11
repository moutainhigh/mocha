package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.RefundInfo;
import com.efruit.micro.arkmanager.pojo.RefundInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundInfoMapper {
    int countByExample(RefundInfoExample example);

    int deleteByExample(RefundInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RefundInfo record);

    int insertSelective(RefundInfo record);

    List<RefundInfo> selectByExample(RefundInfoExample example);

    RefundInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RefundInfo record, @Param("example") RefundInfoExample example);

    int updateByExample(@Param("record") RefundInfo record, @Param("example") RefundInfoExample example);

    int updateByPrimaryKeySelective(RefundInfo record);

    int updateByPrimaryKey(RefundInfo record);
}