package com.efruit.micro.arkmanager.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkmanager.bean.DispatchingCondition;
import com.efruit.micro.arkmanager.bean.MsgPushEntity;
import com.efruit.micro.arkmanager.pojo.DispatchingOrder;
import com.efruit.micro.arkmanager.service.CouponService;
import com.efruit.micro.arkmanager.service.DispatchingOrderService;
import com.efruit.micro.arkmanager.service.OrderServiceConstant;
import com.efruit.micro.arkmanager.service.RefundInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = MqConfig.YOUZAN_PUSH_QUEUE_NAME)
public class PushReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(PushReceiver.class);

    @Autowired
    CouponService couponService;
    @Autowired
    DispatchingOrderService orderService;

    @Autowired
    RefundInfoService refundInfoService;

    @RabbitHandler
    public void onMessage(String msgEntityJson) {
        LOGGER.info("PushReceiver onMessage : {}", msgEntityJson);
        if (StringUtils.isEmpty(msgEntityJson)) {
            return;
        }

        MsgPushEntity pushEntity = null;
        try {
            pushEntity = JSON.parseObject(msgEntityJson, MsgPushEntity.class);
        } catch (Exception e) {
            LOGGER.error("PushReceiver error.", e);
        }

        if (pushEntity == null) {
            return;
        }

        final String status = pushEntity.getStatus();

        if (StringUtils.equals(OrderServiceConstant.WAIT_SELLER_SEND_GOODS, status)) {
            onWaitConfirmPush(pushEntity);
        } else if (StringUtils.equals(OrderServiceConstant.TRADE_SUCCESS, status)) {
            onTradeSuccess(pushEntity);
        }

        final String type = pushEntity.getType();
        if (StringUtils.equals("trade_refund_RefundSellerAgree", type)) {
            onRefundSellerAgree(pushEntity);// 买家申请退款-卖家同意退款
        } else if (StringUtils.equals("trade_refund_RefundSellerCreated", type)) {
            onRefundSellerCreated(pushEntity);// 卖家主动退款
        }

    }

    private void onRefundSellerCreated(MsgPushEntity pushEntity) {
        refundInfoService.processPush(pushEntity);
    }

    private void onRefundSellerAgree(MsgPushEntity pushEntity) {
        refundInfoService.processPush(pushEntity);
    }

    /**
     * 买家确认收货
     *
     * @param pushEntity
     */
    private void onTradeSuccess(MsgPushEntity pushEntity) {
        //确认收货后，修改本地的订单信息
        //订单id
        LOGGER.info("[onTradeSuccessThe] youZan customer received the goods successfully data:{}",
                JSONObject.toJSONString(pushEntity));
        DispatchingOrder order = new DispatchingOrder();
        order.setStatus(pushEntity.getStatus());
        order.setTid(pushEntity.getId());
        orderService.update(order);
    }

    /**
     * 买家支付成功
     *
     * @param pushEntity
     */
    private void onWaitConfirmPush(MsgPushEntity pushEntity) {
        couponService.processCouponPush(pushEntity);
    }

}
