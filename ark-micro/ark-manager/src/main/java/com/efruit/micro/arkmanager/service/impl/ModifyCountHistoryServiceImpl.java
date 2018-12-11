package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.ModifyCountHistoryMapper;
import com.efruit.micro.arkmanager.pojo.ModifyCountHistory;
import com.efruit.micro.arkmanager.pojo.ModifyCountHistoryExample;
import com.efruit.micro.arkmanager.service.ModifyCountHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModifyCountHistoryServiceImpl implements ModifyCountHistoryService {

    @Autowired
    private ModifyCountHistoryMapper modifyCountHistoryMapper;

    @Override
    public List<ModifyCountHistory> getModifyCountHistoryByOrderId(long orderId, int type) {
        ModifyCountHistoryExample example = new ModifyCountHistoryExample();
        example.setOrderByClause("id desc");
        final ModifyCountHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        criteria.andFromTypeEqualTo(type);
        final List<ModifyCountHistory> modifyCountHistories = modifyCountHistoryMapper.selectByExample(example);
        return modifyCountHistories;
    }

    @Override
    public boolean saveModifyCountHistory(ModifyCountHistory history) {
        if (history == null) {
            return false;
        }
        return modifyCountHistoryMapper.insert(history) > 0;
    }
}
