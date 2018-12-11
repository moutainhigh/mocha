package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.mapper.DispatchingOrderDetailsInfoMapper;
import com.efruit.micro.arkmanager.pojo.DispatchingOrder;
import com.efruit.micro.arkmanager.pojo.DispatchingOrderDetailsInfo;
import com.efruit.micro.arkmanager.service.DispatchingOrderDetailsService;
import com.efruit.micro.arkmanager.service.DispatchingOrderService;
import com.efruit.micro.arkmanager.utils.JodaDateUtil;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * 购买者
 */
@Service
public class DispatchingOrderDetailsServiceImpl implements DispatchingOrderDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingOrderDetailsServiceImpl.class);

    @Autowired
    DispatchingOrderDetailsInfoMapper mapper;
    @Autowired
    DispatchingOrderService orderService;
    @Autowired
    YouzanService youzanService;


    @Override
    public int save(DispatchingOrderDetailsInfo obj) {
        return mapper.insert(obj);
    }

    @Override
    public int saveList(List<DispatchingOrderDetailsInfo> objs) {
        if (CollectionUtils.isEmpty(objs)) {
            return 0;
        }
        return mapper.insertList(objs);
    }

    @Override
    public void synOrderRefundState() {
        //查询今天的配送的订单
        final Date today = JodaDateUtil.getDateCuryyyy_MM_dd();
        final List<DispatchingOrder> orderList = orderService.getOrderList(today);
        YouzanTradeGetResult youzanTradeGetResult = null;
        //根据tid查询有赞中订单详情，是否出现退款信息
        for (DispatchingOrder order : orderList) {
            final String tid = order.getTid();
            try {
                youzanTradeGetResult = youzanService.getYouzanTradeGetResultByTid(tid);
            } catch (YouzanApiException e) {
                LOGGER.info("----SyncDispatchingOrderRefundStatusTask 根据tid获取有赞订单详情错误tid:{},erorMsg:{}", tid, e.getMessage());
            }
            if (youzanTradeGetResult == null) {
                continue;
            }
            final YouzanTradeGetResult.StructurizationTradeRefundInfoDetail[] refundInfoDetails = youzanTradeGetResult.getRefundOrder();
            if (refundInfoDetails == null || refundInfoDetails.length == 0) {
                continue;
            }
            for (YouzanTradeGetResult.StructurizationTradeRefundInfoDetail refundInfoDetail : refundInfoDetails) {
                final YouzanTradeGetResult.StructurizationTradeRefundItemDetail[] oids = refundInfoDetail.getOids();
                final String status = String.valueOf(refundInfoDetail.getRefundState());
                for (YouzanTradeGetResult.StructurizationTradeRefundItemDetail refundItemDetail : oids) {
                    final String oid = refundItemDetail.getOid();
                    mapper.updateRefundStateByTidOid(status, tid, oid);
                }
            }

        }
    }

    @Override
    public int update(DispatchingOrderDetailsInfo obj) {
        return mapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public int updateRefundStateByTidOid(String refundState, String tid, String oid) {
        return mapper.updateRefundStateByTidOid(refundState, tid, oid);
    }

    @Override
    public DispatchingOrderDetailsInfo getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
