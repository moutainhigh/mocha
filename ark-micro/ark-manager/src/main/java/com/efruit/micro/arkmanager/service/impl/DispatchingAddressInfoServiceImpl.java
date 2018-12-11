package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.DateFormatHelper;
import com.efruit.micro.arkmanager.bean.*;
import com.efruit.micro.arkmanager.constant.DispatchingOrderConstant;
import com.efruit.micro.arkmanager.mapper.*;
import com.efruit.micro.arkmanager.pojo.*;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.utils.JodaDateUtil;
import com.efruit.micro.arkmanager.utils.map.GaoDeMapUtils;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult.StructurizationTrade;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanMultistoreOfflineGetResult;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanMultistoreOfflineSearchResult.AccountShopOffline;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DispatchingAddressInfoServiceImpl implements DispatchingAddressInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingAddressInfoServiceImpl.class);

    @Autowired
    DispatchingAddressInfoMapper mapper;

    @Autowired
    DispatchingBlackUserService dispatchingBlackUserService;
    @Autowired
    YouzanService youzanService;
    @Autowired
    DispatchingAreaInfoService areaInfoService;
    @Autowired
    DispatchingFetchCodeInfoService fetchCodeInfoService;

    @Override
    public int saveShopInfo(DispatchingAddressInfo addressInfo) {
        final Long id = addressInfo.getId();
        if (id != null) {
            DispatchingAddressInfo _address = mapper.selectByPrimaryKey(id);
            if (_address != null) {
                //更新地址，需要考虑更新该地址下的用户取货码对应的片区id
                mapper.updateByPrimaryKey(addressInfo);
                //修改该地址的取货码信息
                final Long addressId = addressInfo.getId();
                final Long areaId = addressInfo.getAreaId();
                fetchCodeInfoService.updateAreaByAddress(addressId,areaId);
                return 0;
            }
        }
        return mapper.insert(addressInfo);
    }

    @Override
    public boolean saveShopInfoList(List<DispatchingAddressInfo> accountShopInfoList) {
        if (CollectionUtils.isEmpty(accountShopInfoList)) {
            return false;
        }
        return mapper.insertList(accountShopInfoList) == accountShopInfoList.size();
    }

    @Override
    public List<DispatchingAddressListResult> getDispatchingAddressInfo(DispatchingCondition condition) {
        if (condition.getLon() == null || condition.getLat() == null) {
            condition.setLat(0d);
            condition.setLon(0d);
        }
        //已经根据定位排好序的地址列表
        List<DispatchingAddressInfo> addressInfoS = mapper.selectBySendTime(condition.getSearchDate(), condition.getLat(), condition.getLon());
        if (CollectionUtils.isEmpty(addressInfoS)) {
            return Collections.EMPTY_LIST;
        }
        List<DispatchingAddressListResult> resultList = new ArrayList<>();
        for (DispatchingAddressInfo address : addressInfoS) {
            DispatchingAddressListResult result = new DispatchingAddressListResult();
            int userNum = 0;
            int booksNum = 0;
            Set<String> buyerIdSet = new HashSet<>();
            final List<DispatchingOrder> orderList = address.getOrderList();
            for (DispatchingOrder order : orderList) {
                final String buyerId = order.getBuyerId();
                final int fetchStatus = order.getFetchStatus();
                final List<DispatchingOrderDetailsInfo> commodityInfoS = order.getOrderDetailsInfoList();
                if (fetchStatus == DispatchingOrderConstant.STATUS_NO) {
                    if (buyerIdSet.add(buyerId)) {
                        userNum++;
                    }
                    for (DispatchingOrderDetailsInfo orderDetailsInfo : commodityInfoS) {
                        booksNum += orderDetailsInfo.getOrderNum().intValue();
                    }
                }
            }
            final String name = address.getName();
            final String nameDetails = address.getAddress();
            final Long id = address.getId();
            final int distance = address.getDistance();
            result.setId(id);
            result.setAddress_detail(nameDetails);
            result.setName(name);
            result.setOrderNum(booksNum);
            result.setUserNum(userNum);
            result.setDistance(distance);
            resultList.add(result);
        }
        return resultList;
    }

    @Override
    public DispatchingAddressInfo getDispatchingAddressByShopId(Long shopId) {
        return mapper.selectByPrimaryKey(shopId);
    }

    /**
     * 保存地址信息
     */
    @Override
    public void insertDispatchingAddress(List<DispatchingAddressInfo> addressInfoS) {
        if (CollectionUtils.isNotEmpty(addressInfoS)) {
            LOGGER.info("-----save address list data:{}", JSONObject.toJSONString(addressInfoS));
            mapper.insertList(addressInfoS);
        }
    }

    @Override
    public void synYouZanOffline() {
        LOGGER.info("-----------------------synYouZanOffline start----------------");
        //从有赞获取数据
        List<AccountShopOffline> accountShopOfflineList = null;
        try {
            accountShopOfflineList = youzanService.syncAddressList();
            LOGGER.info("from YouZan Data:{}",JSONObject.toJSONString(accountShopOfflineList));
        } catch (YouzanApiException e) {
            LOGGER.info("synOrderInfo error.  syncOrderV4 msg:{}", e);
        }
        if (CollectionUtils.isNotEmpty(accountShopOfflineList)) {
            for (AccountShopOffline accountShopOffline : accountShopOfflineList) {
                //校验是否已经保存
                final Long id = accountShopOffline.getId();
                DispatchingAddressInfo addressInfo = new DispatchingAddressInfo();
                BeanUtils.copyProperties(accountShopOffline, addressInfo);
                final String latStr = addressInfo.getLat();
                final String lngStr = addressInfo.getLng();
                double[] local =  GaoDeMapUtils.baidu2AMap(Double.parseDouble(latStr),Double.parseDouble(lngStr));
                addressInfo.setLat(String.valueOf(local[0]));
                addressInfo.setLng(String.valueOf(local[1]));
                Long areaId = areaInfoService.synAreaByAddressId(id);
                if (areaId == null) {
                    areaId = DispatchingOrderConstant.NO_AREA_ID;
                }
                addressInfo.setAreaId(areaId);
                saveShopInfo(addressInfo);
            }
        }
        LOGGER.info("-----------------------synYouZanOffline end----------------");
    }

    @Override
    public List<DispatchingAddressInfo> selectByDateAndId(Date sendDate, Long id) {
        return mapper.selectByDateAndAddress(sendDate, id);
    }

    @Override
    public List<DispatchingAddressInfo> selectAll() {
        return mapper.selectAll();
    }
}
