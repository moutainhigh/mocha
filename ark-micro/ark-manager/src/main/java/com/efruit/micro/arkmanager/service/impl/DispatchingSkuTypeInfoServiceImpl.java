package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkmanager.mapper.DispatchingSkuTypeInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingSkuTypeInfo;
import com.efruit.micro.arkmanager.service.DispatchingSkuTypeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 规格类型
 */
@Service
public class DispatchingSkuTypeInfoServiceImpl implements DispatchingSkuTypeInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingSkuTypeInfoServiceImpl.class);

    @Autowired
    DispatchingSkuTypeInfoMapper mapper;


    @Override
    public int save(DispatchingSkuTypeInfo obj) {
        return mapper.insert(obj);
    }

    @Override
    public int saveList(List<DispatchingSkuTypeInfo> obj) {
        return mapper.insertList(obj);
    }

    @Override
    public int saveMap(Map<Long, DispatchingSkuTypeInfo> map) {
        LOGGER.info("---save SkuType data:{}", JSONObject.toJSONString(map));
        if(map == null || map.size()==0){
            return 0;
        }
        List<DispatchingSkuTypeInfo> dispatchingSkuTypeInfos = new ArrayList<>();
        for (Long key : map.keySet()) {
            dispatchingSkuTypeInfos.add(map.get(key));
        }
        return mapper.insertList(dispatchingSkuTypeInfos);
    }

    @Override
    public int update(DispatchingSkuTypeInfo obj) {
        return mapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public DispatchingSkuTypeInfo getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
