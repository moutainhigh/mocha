package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.FansInfo;
import com.efruit.micro.arkmanager.pojo.FansInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FansInfoMapper {
    int countByExample(FansInfoExample example);

    int deleteByExample(FansInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FansInfo record);

    int insertSelective(FansInfo record);

    List<FansInfo> selectByExample(FansInfoExample example);

    FansInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FansInfo record, @Param("example") FansInfoExample example);

    int updateByExample(@Param("record") FansInfo record, @Param("example") FansInfoExample example);

    int updateByPrimaryKeySelective(FansInfo record);

    int updateByPrimaryKey(FansInfo record);

    int insertList(List<FansInfo> fansInfoList);
}