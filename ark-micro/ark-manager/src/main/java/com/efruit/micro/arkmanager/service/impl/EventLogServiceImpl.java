package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.EventLogMapper;
import com.efruit.micro.arkmanager.pojo.EventLog;
import com.efruit.micro.arkmanager.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EventLogServiceImpl implements EventLogService {

    @Autowired
    EventLogMapper eventLogMapper;

    @Override
    @Async
    public void saveEventLog(EventLog eventLog) {
        eventLogMapper.insert(eventLog);
    }
}
