package com.efruit.micro.arkmanager.pojo;

import java.util.Date;

public class HolidayInfo {
    public static final int IS_HOLIDAY = 1;
    public static final int IS_NOT_HOLIDAY = 2;

    private Long id;

    private Date dayDate;

    private Integer holiday;

    private String nameDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }

    public String getNameDesc() {
        return nameDesc;
    }

    public void setNameDesc(String nameDesc) {
        this.nameDesc = nameDesc == null ? null : nameDesc.trim();
    }

    public boolean isDateHoliday() {
        return (holiday != null) && (holiday == IS_HOLIDAY);
    }
}