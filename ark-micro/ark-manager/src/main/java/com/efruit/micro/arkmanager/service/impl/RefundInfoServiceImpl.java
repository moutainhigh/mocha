package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSON;
import com.efruit.micro.arkmanager.bean.MsgPushEntity;
import com.efruit.micro.arkmanager.mapper.RefundInfoMapper;
import com.efruit.micro.arkmanager.pojo.RefundInfo;
import com.efruit.micro.arkmanager.service.RefundInfoService;
import com.efruit.micro.arkmanager.utils.RefundHelper;
import com.efruit.micro.youzan.bean.ArkOrder;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RefundInfoServiceImpl implements RefundInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefundInfoServiceImpl.class);

    private static final int REFUND_INFO_STATUS_DEFAULT = 0;
    private static final int REFUND_INFO_STATUS_REFUND_REQUEST_SUCCESS = 1;
    private static final int REFUND_INFO_STATUS_REFUND_SUCEESS = 2;

    private static final String INFO_PREF = "REFUND";

    @Autowired
    RefundInfoMapper refundInfoMapper;

    @Autowired
    YouzanService youzanService;

    @Override
    public void processPush(MsgPushEntity msgPushEntity) {
        final String decodedMsg = msgPushEntity.getDecodedMsg();
        if (StringUtils.isEmpty(decodedMsg)) {
            LOGGER.info("processPush error. decodedMsg is empty.");
            return;
        }

        final RefundEntity entity = JSON.parseObject(decodedMsg, RefundEntity.class);
        final String tid = entity.getTid();
        if (StringUtils.isEmpty(tid)) {
            LOGGER.info("processPush error. tid is empty.");
            return;
        }

        ArkOrder arkOrder = null;
        try {
            arkOrder = youzanService.getArkOrderByTid(tid);
        } catch (YouzanApiException e) {
            LOGGER.info("processPush getArkOrderByTid error.", e);
        }

        if (arkOrder == null) {
            return;
        }

        final String transaction = arkOrder.getTransaction();
        final String outerTransactions = arkOrder.getOuterTransactions();
        if (StringUtils.isAnyBlank(transaction, outerTransactions)) {
            return;
        }

        RefundInfo refundInfo = new RefundInfo();
        refundInfo.setTransaction(transaction);
        refundInfo.setOutertransactions(outerTransactions);
        refundInfo.setId(INFO_PREF + System.currentTimeMillis());
        refundInfo.setCreated(new Date());
        refundInfo.setMsgType(msgPushEntity.getType());

        refundInfo.setTid(tid);
        refundInfo.setOids(entity.getOids());
        refundInfo.setRefundId(entity.getRefundId());
        refundInfo.setRefundReason(entity.getRefundReason());
        refundInfo.setRefundType(entity.getRefundType());
        refundInfo.setStatus(REFUND_INFO_STATUS_DEFAULT);

        long refundFeeValue = 0L;
        final String refundFee = entity.getRefundedFee();
        try {
            refundFeeValue = (long) (Double.parseDouble(refundFee) * 100L);
        } catch (Exception e) {
            LOGGER.info("parseLong error, ", e);
        }
        refundInfo.setRefundedFee(refundFeeValue);
        refundInfo.setRefundTime(entity.getUpdateTime());

        final boolean sucSave = saveRefundInfo(refundInfo);
        if (sucSave) {
            RefundHelper.Entity refundRequest = new RefundHelper.Entity();
            refundRequest.setMchRefundNo(refundInfo.getId());
            final Long refundedFee = refundInfo.getRefundedFee();
            refundRequest.setRefundAmount(refundedFee);
            refundRequest.setPayAmount(arkOrder.getPayment());
            refundRequest.setPayOrderId(refundInfo.getTransaction());
            refundRequest.setChannelPayOrderNo(refundInfo.getOutertransactions());
            final boolean sucRefund = RefundHelper.refundOrder(refundRequest);
            if (sucRefund) {
                refundInfo.setStatus(REFUND_INFO_STATUS_REFUND_REQUEST_SUCCESS);
                updateRefundInfo(refundInfo);
            }
        }
    }

    @Override
    public boolean saveRefundInfo(RefundInfo refundInfo) {
        return refundInfoMapper.insert(refundInfo) > 0;
    }

    @Override
    public boolean updateRefundInfoStatus() {
        return false;
    }

    @Override
    public boolean updateRefundInfo(RefundInfo refundInfo) {
        return refundInfoMapper.updateByPrimaryKey(refundInfo) > 0;
    }

    private static class RefundEntity {
        private Date updateTime;
        private String refundType;
        private String refundedFee;
        private String refundReason;
        private String oids;
        private String refundId;
        private String tid;

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public String getRefundType() {
            return refundType;
        }

        public void setRefundType(String refundType) {
            this.refundType = refundType;
        }

        public String getRefundedFee() {
            return refundedFee;
        }

        public void setRefundedFee(String refundedFee) {
            this.refundedFee = refundedFee;
        }

        public String getRefundReason() {
            return refundReason;
        }

        public void setRefundReason(String refundReason) {
            this.refundReason = refundReason;
        }

        public String getOids() {
            return oids;
        }

        public void setOids(String oids) {
            this.oids = oids;
        }

        public String getRefundId() {
            return refundId;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }
}
