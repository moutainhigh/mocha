package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DeliverUserInfoMapper;
import com.efruit.micro.arkmanager.pojo.DeliverUserInfo;
import com.efruit.micro.arkmanager.pojo.DeliverUserInfoExample;
import com.efruit.micro.arkmanager.service.DeliverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliverUserServiceImpl implements DeliverUserService {

    @Autowired
    private DeliverUserInfoMapper deliverUserInfoMapper;

    @Override
    public boolean saveDeliverUser(DeliverUserInfo deliverUserInfo) {
        return deliverUserInfoMapper.insert(deliverUserInfo) > 0;
    }

    @Override
    public List<DeliverUserInfo> getAllDeliverUserInfoList() {
        DeliverUserInfoExample example = new DeliverUserInfoExample();
        return deliverUserInfoMapper.selectByExample(example);
    }

    @Override
    public List<DeliverUserInfo> getAllEnableDeliverUserInfoList() {
        DeliverUserInfoExample example = new DeliverUserInfoExample();
        final DeliverUserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsEnableEqualTo(1);
        return deliverUserInfoMapper.selectByExample(example);
    }
}
