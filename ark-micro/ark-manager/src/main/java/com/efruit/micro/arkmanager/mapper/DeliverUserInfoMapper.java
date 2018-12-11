package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DeliverUserInfo;
import com.efruit.micro.arkmanager.pojo.DeliverUserInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliverUserInfoMapper {
    int countByExample(DeliverUserInfoExample example);

    int deleteByExample(DeliverUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeliverUserInfo record);

    int insertSelective(DeliverUserInfo record);

    List<DeliverUserInfo> selectByExample(DeliverUserInfoExample example);

    DeliverUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeliverUserInfo record, @Param("example") DeliverUserInfoExample example);

    int updateByExample(@Param("record") DeliverUserInfo record, @Param("example") DeliverUserInfoExample example);

    int updateByPrimaryKeySelective(DeliverUserInfo record);

    int updateByPrimaryKey(DeliverUserInfo record);
}