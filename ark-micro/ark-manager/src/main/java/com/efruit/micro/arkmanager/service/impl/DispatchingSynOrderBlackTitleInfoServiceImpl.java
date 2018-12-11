package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DispatchingSynOrderBlackTitleInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingSynOrderBlackTitleInfo;
import com.efruit.micro.arkmanager.service.DispatchingSynOrderBlackTitleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchingSynOrderBlackTitleInfoServiceImpl implements DispatchingSynOrderBlackTitleInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingSynOrderBlackTitleInfoServiceImpl.class);
    @Autowired
    DispatchingSynOrderBlackTitleInfoMapper blackTitleInfoMapper;


    @Override
    public int save(DispatchingSynOrderBlackTitleInfo blackTitleInfo) {
        return blackTitleInfoMapper.insert(blackTitleInfo);
    }

    @Override
    public List<DispatchingSynOrderBlackTitleInfo> selectAllValidList() {
        return blackTitleInfoMapper.selectAllValidList();
    }
}
