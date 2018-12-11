package com.efruit.micro.arkmanager.service;

import com.efruit.micro.arkmanager.pojo.DispatchingAreaInfo;
import com.efruit.micro.arkmanager.pojo.DispatchingOrderDetailsInfo;

import java.util.List;

/**
 * 订单详情
 */
public interface DispatchingOrderDetailsService {

    int save(DispatchingOrderDetailsInfo obj);

    int saveList(List<DispatchingOrderDetailsInfo> objList);

    int update(DispatchingOrderDetailsInfo obj);

    DispatchingOrderDetailsInfo getById(Long id);

    int updateRefundStateByTidOid(String refundState, String tid, String oid);

    /**
     * 同步订单详情中的退款状态
     */
    void synOrderRefundState();

}
