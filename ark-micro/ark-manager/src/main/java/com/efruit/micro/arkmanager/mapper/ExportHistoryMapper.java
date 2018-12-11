package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.ExportHistory;
import com.efruit.micro.arkmanager.pojo.ExportHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExportHistoryMapper {
    int countByExample(ExportHistoryExample example);

    int deleteByExample(ExportHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExportHistory record);

    int insertSelective(ExportHistory record);

    List<ExportHistory> selectByExample(ExportHistoryExample example);

    ExportHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExportHistory record, @Param("example") ExportHistoryExample example);

    int updateByExample(@Param("record") ExportHistory record, @Param("example") ExportHistoryExample example);

    int updateByPrimaryKeySelective(ExportHistory record);

    int updateByPrimaryKey(ExportHistory record);
}