package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingBuyerInfo;

import java.util.Date;
import java.util.List;

/**
 * 购买者
 */
public interface DispatchingBuyerInfoService {

    int save(DispatchingBuyerInfo obj);

    int saveList(List<DispatchingBuyerInfo> objList);

    int update(DispatchingBuyerInfo obj);

    int updateTel(String oldTel, String newTel);

    DispatchingBuyerInfo getById(String userMobile);

    DispatchingBuyerInfo getByUserId(String userId);

    DispatchingBuyerInfo getBySelective(DispatchingBuyerInfo obj);

    List<DispatchingBuyerInfo> selectUserAndItemsByAddressAndDate(Long address, Date sendDate);

    List<DispatchingBuyerInfo> getSendMsgBuyer(Long address, Date sendDate);


}
