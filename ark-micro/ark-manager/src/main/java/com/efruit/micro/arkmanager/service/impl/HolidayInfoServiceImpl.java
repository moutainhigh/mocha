package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.HttpClientUtil;
import com.efruit.micro.arkmanager.mapper.HolidayInfoMapper;
import com.efruit.micro.arkmanager.pojo.HolidayInfo;
import com.efruit.micro.arkmanager.pojo.HolidayInfoExample;
import com.efruit.micro.arkmanager.service.HolidayInfoService;
import com.efruit.micro.arkmanager.utils.DateTimeHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HolidayInfoServiceImpl implements HolidayInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HolidayInfoServiceImpl.class);

    // 指定日期的字符串，多个日期之间用逗号,隔开。格式 '2018-02-23'。
    // 示例：http://lanfly.vicp.io/api/holiday/batch?d=2017-10-01,2018-6-01,2018-10-1
    private static final String API = "http://lanfly.vicp.io/api/holiday/batch?d=%s";

    private static final String DATE_FORMATE = "yyyy-MM-dd";

    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DATE_FORMATE);

    @Autowired
    private HolidayInfoMapper holidayInfoMapper;

    private final Map<String, HolidayInfo> cacheHolidayInfoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        final List<HolidayInfo> holidayInfoList = getHolidayInfoList();
        if (CollectionUtils.isEmpty(holidayInfoList)) {
            LOGGER.info("getHolidayInfoList() is empty. pls check.");
            return;
        }

        for (HolidayInfo holidayInfo : holidayInfoList) {
            final Date dayDate = holidayInfo.getDayDate();
            DateTime dateTime = new DateTime(dayDate);
            cacheHolidayInfoMap.put(dateTime.toString(DATE_FORMATE), holidayInfo);
        }
    }

    @Override
    public List<HolidayInfo> getHolidayInfoList() {
        HolidayInfoExample example = new HolidayInfoExample();
        final List<HolidayInfo> holidayInfos = holidayInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(holidayInfos)) {
            final int year = DateTime.now().getYear();
            final List<HolidayInfo> holidayInfosList = loadFromApi(year);
            for (HolidayInfo holidayInfo : holidayInfosList) {
                saveHolidayInfo(holidayInfo);
            }
            return holidayInfosList;
        }
        return holidayInfos;
    }

    @Override
    public boolean saveHolidayInfo(HolidayInfo holidayInfo) {
        if (holidayInfo == null) {
            return false;
        }
        final HolidayInfo holidayInfoByDate = getHolidayInfoByDate(holidayInfo.getDayDate());
        if (holidayInfoByDate != null) {
            return false;
        }

        return holidayInfoMapper.insert(holidayInfo) > 0;

    }

    @Override
    public HolidayInfo getHolidayInfoByDate(Date date) {
        HolidayInfoExample example = new HolidayInfoExample();
        final HolidayInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDayDateEqualTo(date);
        final List<HolidayInfo> holidayInfos = holidayInfoMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(holidayInfos)) {
            return holidayInfos.get(0);
        }

        return null;
    }

    @Override
    public boolean isWorkDay(Date date) {
        if (date == null) {
            return false;
        }

        DateTime dateTime = new DateTime(date);
        final String dateStr = dateTime.toString(DATE_FORMATE);
        final HolidayInfo holidayInfo = cacheHolidayInfoMap.get(dateStr);

        if (holidayInfo != null && !holidayInfo.isDateHoliday()) { // 调休日
            return true;
        } else if (holidayInfo != null && holidayInfo.isDateHoliday()) {// 法定假期
            return false;
        } else if (holidayInfo == null && DateTimeHelper.isWeekEndDay(dateTime)) {// 周末
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Date> getWorkDayList(int count) {
        List<Date> result = new ArrayList<>();
        final DateTime now = DateTime.now()
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        DateTime startDateTime = null;
        do {
            if (startDateTime == null) {
                startDateTime = now.plusDays(1);
            } else {
                startDateTime = startDateTime.plusDays(1);
            }

            final Date workDate = startDateTime.toDate();
            final boolean workDay = isWorkDay(workDate);
            if (workDay) {
                result.add(startDateTime.toDate());
            }
        } while (result.size() < count);

        return result;
    }

    private List<HolidayInfo> loadFromApi(int year) {
        List<HolidayInfo> result = new ArrayList<>();

        final List<String> dateString = getDateString(year);
        final String join = StringUtils.join(dateString, ",");

        final String json = HttpClientUtil.doGet(String.format(API, join));
        if (StringUtils.isEmpty(join)) {
            return result;
        }

        final JSONObject jsonObj = JSONObject.parseObject(json, JSONObject.class);
        final int code = jsonObj.getIntValue("code");
        if (code != 0) {
            return result;
        }

        final JSONObject holidayJSONObj = jsonObj.getJSONObject("holiday");
        if (holidayJSONObj == null || holidayJSONObj.isEmpty()) {
            return result;
        }

        for (Map.Entry<String, Object> entry : holidayJSONObj.entrySet()) {

            final Object value = entry.getValue();
            if (!(value instanceof JSONObject)) {
                continue;
            }

            JSONObject holiday = (JSONObject) value;

            final String entryKey = entry.getKey();

            HolidayInfo holidayInfo = new HolidayInfo();
            Date date = null;
            try {
                date = DEFAULT_DATE_FORMAT.parse(entryKey);
            } catch (ParseException e) {
                LOGGER.info("parse error, key : {} ", entryKey, e);
            }
            if (date == null) {
                continue;
            }
            holidayInfo.setDayDate(date);

            final boolean isHoliday = holiday.getBooleanValue("holiday");
            holidayInfo.setHoliday(isHoliday ? HolidayInfo.IS_HOLIDAY : HolidayInfo.IS_NOT_HOLIDAY);

            final String name = holiday.getString("name");
            holidayInfo.setNameDesc(name);

            result.add(holidayInfo);

        }
        return result;
    }

    private List<String> getDateString(int year) {
        List<String> result = new ArrayList<>();

        DateTime start = new DateTime(year, 1, 1, 0, 0);
        DateTime end = start.plusYears(1).minusDays(1);

        do {
            final String startDate = start.toString(DATE_FORMATE);
            result.add(startDate);
            start = start.plusDays(1);
        } while (start.getMillis() <= end.getMillis());

        return result;
    }
}
