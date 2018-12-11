package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DispatchingAreaInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingAreaInfo;
import com.efruit.micro.arkmanager.service.DispatchingAreaInfoService;
import com.efruit.micro.arkmanager.service.DispatchingOrderService;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.sdk.model.YouzanMultistoreAddressGetResult;
import com.efruit.micro.youzan.service.YouzanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DispatchingAreaInfoServiceImpl implements DispatchingAreaInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingAreaInfoServiceImpl.class);

    @Autowired
    DispatchingAreaInfoMapper mapper;

    @Autowired
    YouzanService youzanService;
    @Autowired
    DispatchingOrderService orderService;

    private static final int STATUS_YES = 1;

    private static final int STATUS_NO = 0;


    @Override
    public int save(DispatchingAreaInfo areaInfo) {
        final Long id = areaInfo.getId();
        if (id != null) {
            DispatchingAreaInfo _area = mapper.selectByPrimaryKey(id);
            if (_area != null) {
                update(areaInfo);
                return 0;
            }
        }
        return mapper.insert(areaInfo);
    }

    @Override
    public int update(DispatchingAreaInfo areaInfo) {
        return mapper.updateByPrimaryKeySelective(areaInfo);
    }

    @Override
    public List<DispatchingAreaInfo> getByStatus(int a_status) {
        return mapper.selectByStatus(a_status);
    }

    @Override
    public DispatchingAreaInfo getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Long synAreaByAddressId(Long addressId) {
        YouzanMultistoreAddressGetResult addressResult = null;
        try {
            //获取网点详情
            addressResult = youzanService.getAddressDetails(addressId);
        } catch (YouzanApiException e) {
            LOGGER.info("AreaInfoService error.  synAreaByAddressId msg:{}", e);
        }
        if (addressResult == null) {
            return null;
        }
        //获取标签（是个数组，取第一个）
        YouzanMultistoreAddressGetResult.OfflineTagIdAndNameDTO[] tags = addressResult.getTagIds();
        if (tags != null && tags.length > 0) {
            final Long tagId = tags[0].getId();
            final String tagName = tags[0].getName();
            DispatchingAreaInfo areaInfo = new DispatchingAreaInfo();
            areaInfo.setId(tagId);
            areaInfo.setaTitle(tagName);
            areaInfo.setaStatus(STATUS_YES);
            areaInfo.setUpdateTime(new Date());
            areaInfo.setCreateTime(new Date());
            save(areaInfo);
            return tagId;
        }
        return null;
    }

    @Override
    public List<DispatchingAreaInfo> getItemBySendDate(Date sendDate) {
        return mapper.selectByDate(sendDate,null);
    }
}
