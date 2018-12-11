package com.efruit.micro.arkmanager.service;



import com.efruit.micro.arkmanager.pojo.SendMsg;

import java.util.Date;

public interface SendMsgService {

    boolean saveSendMsg(SendMsg sendMsg);

    SendMsg getSendMsg(String userId);

    SendMsg getSendMsg(String userId, boolean isSuccess, int sendReason);

    boolean hasSendBefore(String userId, int sendReason);

    boolean isSendByDate(String userId, Date date, int sendReason);

}
