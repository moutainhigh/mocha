package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingBlackUser;
import com.efruit.micro.arkmanager.pojo.DispatchingBlackUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DispatchingBlackUserMapper {
    int countByExample(DispatchingBlackUserExample example);

    int deleteByExample(DispatchingBlackUserExample example);

    int deleteByPrimaryKey(String openid);

    int insert(DispatchingBlackUser record);

    int insertSelective(DispatchingBlackUser record);

    List<DispatchingBlackUser> selectByExample(DispatchingBlackUserExample example);

    DispatchingBlackUser selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") DispatchingBlackUser record, @Param("example") DispatchingBlackUserExample example);

    int updateByExample(@Param("record") DispatchingBlackUser record, @Param("example") DispatchingBlackUserExample example);

    int updateByPrimaryKeySelective(DispatchingBlackUser record);

    int updateByPrimaryKey(DispatchingBlackUser record);
}