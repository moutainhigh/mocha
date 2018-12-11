package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingWhiteUser;

public interface DispatchingWhiteUserMapper {
    int deleteByPrimaryKey(String openid);

    int insert(DispatchingWhiteUser record);

    int insertSelective(DispatchingWhiteUser record);

    DispatchingWhiteUser selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(DispatchingWhiteUser record);

    int updateByPrimaryKey(DispatchingWhiteUser record);
}