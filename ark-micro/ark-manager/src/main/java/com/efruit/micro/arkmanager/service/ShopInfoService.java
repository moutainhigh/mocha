package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.ShopInfo;

import java.util.List;

public interface ShopInfoService {

    int getShopInfoCount();

    List<ShopInfo> getShopInfoList();

    boolean saveShopInfoList(List<ShopInfo> shopInfoList);

    boolean saveShopInfo(ShopInfo shopInfo);

    boolean deleteShopInfo(Long youzanId);

    ShopInfo getShopInfoByYouzanId(Long youzanId);

    void syncYouzanShopInfo();

    boolean deleteAllShopInfo();
}
