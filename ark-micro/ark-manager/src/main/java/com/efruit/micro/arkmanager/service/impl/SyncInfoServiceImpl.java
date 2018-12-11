package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.SyncInfoMapper;
import com.efruit.micro.arkmanager.pojo.SyncInfo;
import com.efruit.micro.arkmanager.service.SyncInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyncInfoServiceImpl implements SyncInfoService {

    @Autowired
    private SyncInfoMapper syncInfoMapper;

    @Override
    public SyncInfo getLastSyncInfo() {
        return syncInfoMapper.getLastSyncInfo();
    }

    @Override
    public boolean saveSyncInfo(SyncInfo info) {
        return syncInfoMapper.insert(info) > 0;
    }
}
