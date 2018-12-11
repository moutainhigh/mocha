package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingSynOrderBlackTitleInfo;
import java.util.List;

public interface DispatchingSynOrderBlackTitleInfoService {
    int save(DispatchingSynOrderBlackTitleInfo blackTitleInfo);
    List<DispatchingSynOrderBlackTitleInfo> selectAllValidList();

}
