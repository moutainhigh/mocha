package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult;
import com.efruit.micro.arkmanager.mapper.*;
import com.efruit.micro.arkmanager.pojo.*;
import com.efruit.micro.arkmanager.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DispatchingFetchCodeInfoServiceImpl implements DispatchingFetchCodeInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingFetchCodeInfoServiceImpl.class);
    @Autowired
    DispatchingFetchCodeInfoMapper fetchCodeInfoMapper;
    @Autowired
    DispatchingOrderService orderService;
    @Autowired
    DispatchingAreaInfoService areaInfoService;


    @Override
    public int save(DispatchingFetchCodeInfo fetchCodeInfo) {
        return fetchCodeInfoMapper.insert(fetchCodeInfo);
    }

    @Override
    public int update(DispatchingFetchCodeInfo fetchCodeInfo) {
        return fetchCodeInfoMapper.updateByPrimaryKey(fetchCodeInfo);
    }

    @Override
    public int updateSelevte(DispatchingFetchCodeInfo fetchCodeInfo) {
        return fetchCodeInfoMapper.updateByPrimaryKeySelective(fetchCodeInfo);
    }

    @Override
    public void insertList(List<DispatchingFetchCodeInfo> fetchCodeInfos) {
        fetchCodeInfoMapper.insertList(fetchCodeInfos);
    }

    @Override
    public List<DispatchingFetchCodeInfo> getListBySendTime(Date sendTime) {
        return fetchCodeInfoMapper.selectBySendTime(sendTime);
    }

    @Override
    public int getMaxCodeByAddressSendDate(Long areaId, Date sendTime) {
        return fetchCodeInfoMapper.getMaxCodeByAddressSendDate(areaId, sendTime);
    }

    @Override
    public DispatchingFetchCodeInfo selectByAddressTelSendDate(DispatchingFetchCodeInfo obj) {
        return fetchCodeInfoMapper.selectByAddressTelSendDate(obj);
    }

    @Override
    public List<DispatchingFetchCodeInfo> selectBySelective(DispatchingFetchCodeInfo obj) {
        return fetchCodeInfoMapper.selectBySelective(obj);
    }

    @Override
    public int updateAreaByAddress(Long addressId, Long areaId) {
        return fetchCodeInfoMapper.updateAreaByAddress(addressId,areaId);
    }

    /**
     * 保存取货码
     */
    @Override
    public void insertDispatchingFetchCodeInfo(Date sendDate) {
        final List<DispatchingFetchCodeInfo> isExistList = getListBySendTime(sendDate);
        if(CollectionUtils.isNotEmpty(isExistList))   {
            return;
        }
        List<DispatchingAreaInfo> areaItemList = areaInfoService.getItemBySendDate(sendDate);
        List<DispatchingFetchCodeInfo> fetchCodeInfoList = new ArrayList<>();
        Set<String> telSet = new HashSet<>();
        for (DispatchingAreaInfo areaItem : areaItemList){
            int fetchCode = 100;
            final Long areaId = areaItem.getId();
            final List<DispatchingAddressInfo> addressInfoList = areaItem.getAddressInfoList();
            for(DispatchingAddressInfo addressInfo : addressInfoList){
                final Long addressId = addressInfo.getId();
                final List<DispatchingOrder> orderList = addressInfo.getOrderList();
                for(DispatchingOrder order : orderList){
                    final DispatchingBuyerInfo buyerInfo = order.getBuyer();
                    final String userTel = buyerInfo.getUserMobile();
                    DispatchingFetchCodeInfo fetchCodeInfo = new DispatchingFetchCodeInfo();
                    fetchCodeInfo.setSendDate(sendDate);
                    fetchCodeInfo.setAddressId(addressId);
                    fetchCodeInfo.setAreaId(areaId);
                    fetchCodeInfo.setUserMobile(userTel);
                    if(telSet.add(userTel) && CollectionUtils.isEmpty(selectBySelective(fetchCodeInfo))) {
                        fetchCodeInfo.setCode(String.valueOf(fetchCode++));
                        fetchCodeInfoList.add(fetchCodeInfo);
                    }
                }

            }
        }
        if (CollectionUtils.isNotEmpty(fetchCodeInfoList)) {
            LOGGER.info("---start save fetchCode data:{}", JSONObject.toJSONString(fetchCodeInfoList));
            insertList(fetchCodeInfoList);
        }

    }

}
