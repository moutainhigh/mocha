package com.efruit.micro.arkmanager.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderSendDateHelper {
    private static final int MAX_START_DATE_CAL_COUNT = 14;

    @Autowired
    private HolidayInfoService holidayInfoService;

    public Date calStartSendDate(Date payTime) {
        DateTime payDateTime = new DateTime(payTime);
        DateTime startSendDate = null;
        int count = 0;

        while (count < MAX_START_DATE_CAL_COUNT) {
            count++;
            if (startSendDate == null) {
                startSendDate = payDateTime.plusDays(1);
            } else {
                startSendDate = startSendDate.plusDays(1);
            }

            final Date date = startSendDate.toDate();
            if (holidayInfoService.isWorkDay(date)) {
                return date;
            }
        }

        return payDateTime.plusDays(1).toDate();
    }

    public Date calLastDate(Date startDate, Integer dayCount) {
        if (startDate == null || dayCount == null || dayCount <= 0) {
            return null;
        }

        DateTime lastDate = null;
        int count = 0;
        while (count < dayCount) {
            if (lastDate == null) {
                lastDate = new DateTime(startDate);
            } else {
                lastDate = lastDate.plusDays(1);
            }

            final boolean workDay = holidayInfoService.isWorkDay(lastDate.toDate());
            if (workDay) {
                count++;
            }
        }

        return lastDate.toDate();
    }
}
