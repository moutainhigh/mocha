package com.efruit.micro.arkmanager.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {

    private static final int[] WORK_DAYS = {
            DateTimeConstants.MONDAY,
            DateTimeConstants.TUESDAY,
            DateTimeConstants.WEDNESDAY,
            DateTimeConstants.THURSDAY,
            DateTimeConstants.FRIDAY};

    public static boolean isWorkDay(Date date) {
        return isWorkDay(new DateTime(date));
    }

    public static boolean isWorkDay(DateTime dateTime) {
        final int dayOfWeek = dateTime.getDayOfWeek();
        for (int days : WORK_DAYS) {
            if (dayOfWeek == days) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWeekEndDay(DateTime dateTime) {
        final int dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek == DateTimeConstants.SATURDAY || dayOfWeek == DateTimeConstants.SUNDAY;
    }

    /**
     * 获取明天开始时间
     * @return
     */
    public static DateTime getTomorrow() {
        final DateTime tomorrow = DateTime.now().plusDays(1)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);
        return tomorrow;
    }

    public static DateTime maxDateTime(DateTime other, DateTime another) {
        if (other.getMillis() > another.getMillis()) {
            return other;
        } else {
            return another;
        }
    }

    public static Date getDateShort(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }
}
