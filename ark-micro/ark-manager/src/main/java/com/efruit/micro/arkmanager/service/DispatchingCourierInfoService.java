package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingCourierInfo;

import java.util.List;

public interface DispatchingCourierInfoService {
    int save(DispatchingCourierInfo courierInfo);

    int update(DispatchingCourierInfo courierInfo);

    DispatchingCourierInfo getCourierInfoByMobile(String mobile);

    DispatchingCourierInfo selectByMobile(String mobile);

    List<DispatchingCourierInfo> selectAll();

    int delete(Long id);
}
