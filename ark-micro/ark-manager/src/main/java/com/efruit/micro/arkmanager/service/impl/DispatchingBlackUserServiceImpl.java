package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DispatchingBlackUserMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingBlackUser;
import com.efruit.micro.arkmanager.pojo.DispatchingBlackUserExample;
import com.efruit.micro.arkmanager.service.DispatchingBlackUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchingBlackUserServiceImpl implements DispatchingBlackUserService {

    @Autowired
    DispatchingBlackUserMapper dispatchingBlackUserMapper;

    @Override
    public boolean isBlackUserByMobile(String mobile) {
        DispatchingBlackUserExample example = new DispatchingBlackUserExample();
        final DispatchingBlackUserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        final List<DispatchingBlackUser> dispatchingBlackUsers = dispatchingBlackUserMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(dispatchingBlackUsers)) {
            return true;
        }
        return false;
    }
}
