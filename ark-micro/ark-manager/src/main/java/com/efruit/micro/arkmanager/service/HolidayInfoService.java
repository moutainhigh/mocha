package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkmanager.pojo.HolidayInfo;

import java.util.Date;
import java.util.List;

public interface HolidayInfoService {
    List<HolidayInfo> getHolidayInfoList();

    boolean saveHolidayInfo(HolidayInfo holidayInfo);

    HolidayInfo getHolidayInfoByDate(Date date);

    boolean isWorkDay(Date date);

    // 获取未来工作日列表
    List<Date> getWorkDayList(int count);

}
