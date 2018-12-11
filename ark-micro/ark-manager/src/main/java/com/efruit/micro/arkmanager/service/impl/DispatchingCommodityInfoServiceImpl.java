package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkmanager.mapper.DispatchingCommodityInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingCommodityInfo;
import com.efruit.micro.arkmanager.service.DispatchingCommodityInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 商品
 */
@Service
public class DispatchingCommodityInfoServiceImpl implements DispatchingCommodityInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingCommodityInfoServiceImpl.class);

    @Autowired
    DispatchingCommodityInfoMapper mapper;


    @Override
    public int save(DispatchingCommodityInfo obj) {
        return mapper.insert(obj);
    }

    @Override
    public int update(DispatchingCommodityInfo obj) {
        return mapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public DispatchingCommodityInfo getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveList(List<DispatchingCommodityInfo> areaInfoList) {
        LOGGER.info("-----save commodityList data:{}", JSONObject.toJSONString(areaInfoList));
        return mapper.insertList(areaInfoList);
    }

    @Override
    public int save(Map<Long, DispatchingCommodityInfo> areaInfoMap) {
        if(areaInfoMap==null || areaInfoMap.size()==0){
            return 0;
        }
        List<DispatchingCommodityInfo> list = new ArrayList<>();
        for (Long key : areaInfoMap.keySet()) {
            list.add(areaInfoMap.get(key));
        }
        return saveList(list);
    }
}
