package com.efruit.micro.arkmanager.service;


import com.efruit.micro.arkmanager.pojo.ModifyCountHistory;

import java.util.List;

public interface ModifyCountHistoryService {
    /**
     * 根据orderId获取修改天数历史记录
     * @param orderId
     * @return
     */
    List<ModifyCountHistory> getModifyCountHistoryByOrderId(long orderId, int type);

    boolean saveModifyCountHistory(ModifyCountHistory history);

}
