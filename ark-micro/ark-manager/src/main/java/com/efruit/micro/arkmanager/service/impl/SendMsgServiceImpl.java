package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.def.SendMsgDef;
import com.efruit.micro.arkmanager.mapper.SendMsgMapper;
import com.efruit.micro.arkmanager.pojo.SendMsg;
import com.efruit.micro.arkmanager.pojo.SendMsgExample;
import com.efruit.micro.arkmanager.service.SendMsgService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


@Service
public class SendMsgServiceImpl implements SendMsgService {

    @Autowired
    SendMsgMapper sendMsgMapper;

    @Override
    public boolean saveSendMsg(SendMsg sendMsg) {
        return sendMsgMapper.insert(sendMsg) > 0;
    }

    @Override
    public SendMsg getSendMsg(String userId) {
        SendMsgExample example = new SendMsgExample();
        final SendMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        final List<SendMsg> sendMsgs = sendMsgMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(sendMsgs)) {
            return sendMsgs.get(0);
        }
        return null;
    }

    @Override
    public SendMsg getSendMsg(String userId, boolean isSuccess, int sendReason) {
        SendMsgExample example = new SendMsgExample();
        final SendMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andSuccessEqualTo(SendMsgDef.parse(isSuccess));
        criteria.andSendReasonEqualTo(sendReason);
        final List<SendMsg> sendMsgs = sendMsgMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(sendMsgs)) {
            return sendMsgs.get(0);
        }
        return null;
    }

    @Override
    public boolean hasSendBefore(String urserId, int sendReason) {
        final SendMsg sendMsg = getSendMsg(urserId, true, sendReason);
        return sendMsg != null;
    }

    @Override
    public boolean isSendByDate(String userId, Date date, int sendReason) {
        SendMsgExample example = new SendMsgExample();
        final SendMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andSuccessEqualTo(SendMsgDef.parse(true));
        criteria.andSendReasonEqualTo(sendReason);
        final DateTime now = DateTime.now();
        DateTime start = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0, 0);
        DateTime end = start.plusDays(1);
        criteria.andSendDateBetween(start.toDate(), end.toDate());
        final List<SendMsg> sendMsgs = sendMsgMapper.selectByExample(example);
        return !CollectionUtils.isEmpty(sendMsgs);
    }
}
