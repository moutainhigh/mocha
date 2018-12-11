package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkmanager.pojo.SyncInfo;

public interface SyncInfoService {
    SyncInfo getLastSyncInfo();

    boolean saveSyncInfo(SyncInfo info);

}
