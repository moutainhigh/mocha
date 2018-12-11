package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.SendMsg;
import com.efruit.micro.arkmanager.pojo.SendMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendMsgMapper {
    int countByExample(SendMsgExample example);

    int deleteByExample(SendMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SendMsg record);

    int insertSelective(SendMsg record);

    List<SendMsg> selectByExample(SendMsgExample example);

    SendMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SendMsg record, @Param("example") SendMsgExample example);

    int updateByExample(@Param("record") SendMsg record, @Param("example") SendMsgExample example);

    int updateByPrimaryKeySelective(SendMsg record);

    int updateByPrimaryKey(SendMsg record);
}