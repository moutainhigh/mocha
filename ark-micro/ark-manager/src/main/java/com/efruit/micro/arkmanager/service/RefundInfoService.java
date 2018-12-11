package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.bean.MsgPushEntity;
import com.efruit.micro.arkmanager.pojo.RefundInfo;

public interface RefundInfoService {

    void processPush(MsgPushEntity msgPushEntity);

    boolean saveRefundInfo(RefundInfo refundInfo);

    boolean updateRefundInfoStatus();

    boolean updateRefundInfo(RefundInfo refundInfo);
}
