package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DispatchingBuyerInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingBuyerInfo;
import com.efruit.micro.arkmanager.service.DispatchingBuyerInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 购买者
 */
@Service
public class DispatchingBuyerInfoServiceImpl implements DispatchingBuyerInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingBuyerInfoServiceImpl.class);

    @Autowired
    DispatchingBuyerInfoMapper mapper;


    @Override
    public DispatchingBuyerInfo getBySelective(DispatchingBuyerInfo obj) {
        return mapper.getBySelective(obj);
    }

    @Override
    public int save(DispatchingBuyerInfo obj) {
        return mapper.insert(obj);
    }

    @Override
    public int update(DispatchingBuyerInfo obj) {
        return mapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public int updateTel(String oldTel, String newTel) {
        LOGGER.info("----修改电话oldTel:{},newTel:{}",oldTel,newTel);
        return mapper.updateTel(oldTel,newTel);
    }

    @Override
    public DispatchingBuyerInfo getByUserId(String userId) {
        return mapper.getByUserId(userId);
    }

    @Override
    public DispatchingBuyerInfo getById(String userMobile) {
        return mapper.selectByPrimaryKey(userMobile);
    }

    @Override
    public List<DispatchingBuyerInfo> selectUserAndItemsByAddressAndDate(Long address, Date sendDate) {
        return mapper.selectUserAndItems(address, sendDate);
    }

    @Override
    public List<DispatchingBuyerInfo> getSendMsgBuyer(Long address, Date sendDate) {
        return mapper.getSendMsgBuyer(address, sendDate);
    }

    @Override
    public int saveList(List<DispatchingBuyerInfo> objList) {
        return mapper.insertList(objList);
    }
}
