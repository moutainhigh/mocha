package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DeliverUserInfo;

import java.util.List;

public interface DeliverUserService {
    boolean saveDeliverUser(DeliverUserInfo deliverUserInfo);

    List<DeliverUserInfo> getAllDeliverUserInfoList();

    List<DeliverUserInfo> getAllEnableDeliverUserInfoList();
}
