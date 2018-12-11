package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.ShopInfoMapper;
import com.efruit.micro.arkmanager.pojo.ShopInfo;
import com.efruit.micro.arkmanager.pojo.ShopInfoExample;
import com.efruit.micro.arkmanager.service.ShopInfoService;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanMultistoreOfflineSearchResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopInfoServiceImpl implements ShopInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopInfoServiceImpl.class);

    @Autowired
    ShopInfoMapper shopInfoMapper;

    @Autowired
    YouzanService youzanService;

    @Override
    public int getShopInfoCount() {
        ShopInfoExample example = new ShopInfoExample();
        return shopInfoMapper.countByExample(example);
    }

    @Override
    public List<ShopInfo> getShopInfoList() {
        ShopInfoExample example = new ShopInfoExample();
        return shopInfoMapper.selectByExample(example);
    }

    @Override
    public boolean saveShopInfoList(List<ShopInfo> shopInfoList) {
        return shopInfoMapper.insertList(shopInfoList) > 0;
    }

    @Override
    public boolean saveShopInfo(ShopInfo shopInfo) {
        return shopInfoMapper.insert(shopInfo) > 0;
    }

    @Override
    public boolean deleteShopInfo(Long youzanId) {
        ShopInfoExample example = new ShopInfoExample();
        final ShopInfoExample.Criteria criteria = example.createCriteria();
        criteria.andYouzanIdEqualTo(youzanId);
        return shopInfoMapper.deleteByExample(example) > 0;
    }

    @Override
    public ShopInfo getShopInfoByYouzanId(Long youzanId) {
        ShopInfoExample example = new ShopInfoExample();
        final ShopInfoExample.Criteria criteria = example.createCriteria();
        criteria.andYouzanIdEqualTo(youzanId);
        final List<ShopInfo> shopInfos = shopInfoMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(shopInfos)) {
            return shopInfos.get(0);
        }
        return null;
    }

    @Transactional
    @Async
    @Override
    public void syncYouzanShopInfo() {
        List<YouzanMultistoreOfflineSearchResult.AccountShopOffline> accountShopOfflines = null;
        try {
            accountShopOfflines = youzanService.syncAddressList();
        } catch (YouzanApiException e) {
            LOGGER.info("syncYouzanShopInfo error.", e);
        }

        if (accountShopOfflines == null) {
            LOGGER.info("accountShopOfflines == null , return...");
            return;
        }

        final List<ShopInfo> shopInfos = toShopInfoList(accountShopOfflines);

        if (CollectionUtils.isEmpty(shopInfos)) {
            LOGGER.info("shopInfos is empty , return...");
            return;
        }

        final int shopInfoCount = getShopInfoCount();
        if (shopInfoCount > 0) {
            final boolean deleteAllShopInfo = deleteAllShopInfo();
            if (!deleteAllShopInfo) {
                throw new RuntimeException("deleteAllShopInfo error.");
            }
        }

        final boolean saveShopInfoList = saveShopInfoList(shopInfos);
        if (!saveShopInfoList) {
            throw new RuntimeException("saveShopInfoList error.");
        }
    }

    @Override
    public boolean deleteAllShopInfo() {
        ShopInfoExample example = new ShopInfoExample();
        return shopInfoMapper.deleteByExample(example) > 0;
    }

    private List<ShopInfo> toShopInfoList(List<YouzanMultistoreOfflineSearchResult.AccountShopOffline> youzanShopList) {
        List<ShopInfo> result = new ArrayList<>();
        for (YouzanMultistoreOfflineSearchResult.AccountShopOffline youzanshop : youzanShopList) {
            final ShopInfo shopInfo = toShopInfo(youzanshop);
            result.add(shopInfo);
        }
        return result;
    }

    private ShopInfo toShopInfo(YouzanMultistoreOfflineSearchResult.AccountShopOffline youzanshop) {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setAddress(youzanshop.getAddress());
        shopInfo.setProvince(youzanshop.getProvince());
        shopInfo.setArea(youzanshop.getArea());
        shopInfo.setCity(youzanshop.getCity());
        shopInfo.setCreatedTime(youzanshop.getCreatedTime());
        shopInfo.setUpdatedTime(youzanshop.getUpdatedTime());
        shopInfo.setPhone1(youzanshop.getPhone1());
        shopInfo.setPhone2(youzanshop.getPhone2());
        shopInfo.setDescription(youzanshop.getDescription());
        shopInfo.setIsSelfFetch(youzanshop.getIsSelfFetch().intValue());
        shopInfo.setIsStore(youzanshop.getIsStore().intValue());
        shopInfo.setKdtid(youzanshop.getKdtId());
        shopInfo.setSid(youzanshop.getSid());
        shopInfo.setYouzanId(youzanshop.getId());
        shopInfo.setLat(youzanshop.getLat());
        shopInfo.setLng(youzanshop.getLng());
        shopInfo.setShopName(youzanshop.getName());
        return shopInfo;
    }
}
