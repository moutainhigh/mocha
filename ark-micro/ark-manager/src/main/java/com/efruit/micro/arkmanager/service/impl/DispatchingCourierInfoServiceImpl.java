package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DispatchingCourierInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingCourierInfo;
import com.efruit.micro.arkmanager.service.DispatchingCourierInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchingCourierInfoServiceImpl implements DispatchingCourierInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingCourierInfoServiceImpl.class);

    @Autowired
    DispatchingCourierInfoMapper courierInfoMapper;

    @Override
    public int save(DispatchingCourierInfo courierInfo) {
        if (selectByMobile(courierInfo.getMobile().replaceAll("\\s*", "")) != null) {
            return 0;
        }
        return courierInfoMapper.insert(courierInfo);
    }

    @Override
    public int update(DispatchingCourierInfo courierInfo) {
        return courierInfoMapper.updateByPrimaryKeySelective(courierInfo);
    }

    @Override
    public DispatchingCourierInfo getCourierInfoByMobile(String mobile) {
        return courierInfoMapper.selectByMobile(mobile);
    }

    @Override
    public DispatchingCourierInfo selectByMobile(String mobile) {
        return courierInfoMapper.selectByMobile(mobile);
    }

    @Override
    public List<DispatchingCourierInfo> selectAll() {
        return courierInfoMapper.selectAll();
    }

    @Override
    public int delete(Long id) {
        return courierInfoMapper.deleteByPrimaryKey(id);
    }
}
