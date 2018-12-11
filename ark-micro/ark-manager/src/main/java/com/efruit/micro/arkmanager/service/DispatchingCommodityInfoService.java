package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingCommodityInfo;

import java.util.List;
import java.util.Map;

/**
 * 商品
 */
public interface DispatchingCommodityInfoService {

    int save(DispatchingCommodityInfo areaInfo);

    int saveList(List<DispatchingCommodityInfo> areaInfoList);

    int save(Map<Long, DispatchingCommodityInfo> areaInfoMap);

    int update(DispatchingCommodityInfo areaInfo);

    DispatchingCommodityInfo getById(Long id);


}
