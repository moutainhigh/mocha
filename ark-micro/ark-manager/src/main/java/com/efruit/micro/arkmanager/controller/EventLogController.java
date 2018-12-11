package com.efruit.micro.arkmanager.controller;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.pojo.EventLog;
import com.efruit.micro.arkmanager.service.EventLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/log")
public class EventLogController {

    @Autowired
    EventLogService eventLogService;

    @PostMapping(path = "/page")
    public ArkCommonResult saveEvent(@RequestBody EventEntity eventEntity) {
        if (eventEntity == null) {
            return ArkCommonResult.fail();
        }

        final String sourceFrom = eventEntity.getSourceFrom();
        if (StringUtils.isEmpty(sourceFrom)) {
            return ArkCommonResult.fail();
        }

        final EventLog eventLog = parse(eventEntity);
        eventLogService.saveEventLog(eventLog);
        return ArkCommonResult.ok();
    }

    private EventLog parse(EventEntity eventEntity) {
        EventLog eventLog = new EventLog();
        eventLog.setCreated(new Date());
        eventLog.setDevice(eventEntity.getDevice());
        eventLog.setPlatfrom(eventEntity.getPlatfrom());
        eventLog.setSourceFrom(eventEntity.getSourceFrom());
        eventLog.setTestType(eventEntity.getTestType());
        eventLog.setuId(eventEntity.getUid());
        return eventLog;
    }

    public static class EventEntity {
        private String sourceFrom;
        private String testType;
        private String uid;
        private String device;
        private String platfrom;

        public String getSourceFrom() {
            return sourceFrom;
        }

        public void setSourceFrom(String sourceFrom) {
            this.sourceFrom = sourceFrom;
        }

        public String getTestType() {
            return testType;
        }

        public void setTestType(String testType) {
            this.testType = testType;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getPlatfrom() {
            return platfrom;
        }

        public void setPlatfrom(String platfrom) {
            this.platfrom = platfrom;
        }

        @Override
        public String toString() {
            return "EventEntity{" +
                    "sourceFrom='" + sourceFrom + '\'' +
                    ", testType='" + testType + '\'' +
                    ", uid='" + uid + '\'' +
                    ", device='" + device + '\'' +
                    ", platfrom='" + platfrom + '\'' +
                    '}';
        }
    }



}
