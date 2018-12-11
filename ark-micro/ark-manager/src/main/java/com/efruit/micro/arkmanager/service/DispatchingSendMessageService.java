package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.bean.DispatchingCondition;
import com.efruit.micro.arkmanager.bean.MessageEntity;

/**
 * 配送发送消息
 */
public interface DispatchingSendMessageService {

    void processMessageSend(MessageEntity messageEntity);

    ArkCommonResult sendSms(DispatchingCondition condition);
}
