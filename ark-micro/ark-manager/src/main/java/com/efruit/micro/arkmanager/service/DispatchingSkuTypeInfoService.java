package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingSkuTypeInfo;

import java.util.List;
import java.util.Map;

public interface DispatchingSkuTypeInfoService {

    int save(DispatchingSkuTypeInfo areaInfo);

    int saveList(List<DispatchingSkuTypeInfo> areaInfo);

    int saveMap(Map<Long, DispatchingSkuTypeInfo> map);

    int update(DispatchingSkuTypeInfo areaInfo);

    DispatchingSkuTypeInfo getById(Long id);


}
