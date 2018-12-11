package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.SyncInfo;
import com.efruit.micro.arkmanager.pojo.SyncInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SyncInfoMapper {
    int countByExample(SyncInfoExample example);

    int deleteByExample(SyncInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncInfo record);

    int insertSelective(SyncInfo record);

    List<SyncInfo> selectByExample(SyncInfoExample example);

    SyncInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncInfo record, @Param("example") SyncInfoExample example);

    int updateByExample(@Param("record") SyncInfo record, @Param("example") SyncInfoExample example);

    int updateByPrimaryKeySelective(SyncInfo record);

    int updateByPrimaryKey(SyncInfo record);

    SyncInfo getLastSyncInfo();
}