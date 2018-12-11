package com.efruit.micro.arkgift.service;

import java.math.BigDecimal;

import com.efruit.micro.arkcommon.utils.PayDigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.HttpClientUtil;
import com.efruit.micro.arkgift.domain.GiftActivities;
import com.efruit.micro.arkgift.domain.GiftOrder;
import com.efruit.micro.arkpay.def.PayChannelDef;

/**
 * 礼物支付相关服务
 *
 * @author wangyang
 */
@Service
public class GiftPayService {

    @Value("${pay.address}")
    private String address;
    @Value("${pay.mchId}")
    private String mchId;
    @Value("${pay.reqKey}")
    private String reqKey;
    @Value("${pay.repKey}")
    private String repKey;
    @Value("${pay.currency}")
    private String currency;
    @Value("${pay.noticeHost}")
    private String noticeHost;

    @Autowired
    private GiftOrderService giftOrderService;

    /**
     * 创建订单
     *
     * @param activities 活动信息
     * @param num        购买数量
     * @param gift_msg   祝福语
     */
    @Transactional
    public JSONObject createOrder(GiftActivities activities, Integer num, String gift_msg, String openId, String ip) {
        GiftOrder order = giftOrderService.createOrder(activities, num, gift_msg, openId);
        if (order != null) {
            JSONObject paramMap = new JSONObject();
            paramMap.put("mchId", mchId);
            paramMap.put("mchOrderNo", order.getId());
            paramMap.put("channelId", PayChannelDef.PAY_CHANNEL_WX_JSAPI);
            paramMap.put("amount", order.getPayMoney().multiply(new BigDecimal(100)).intValue());
            paramMap.put("currency", "cny");
            paramMap.put("clientIp", ip);
            paramMap.put("device", "WEB");
            paramMap.put("subject", activities.getActName());
            paramMap.put("body", activities.getItemName() + " X " + num);
            paramMap.put("notifyUrl", noticeHost + "/pay/payNotify");
            paramMap.put("param1", "");
            paramMap.put("param2", "");
            paramMap.put("extra", "{\"openId\": \"" + openId + "\"}");

            String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
            paramMap.put("sign", reqSign);
            final String reqJSON = paramMap.toJSONString();
            String result = HttpClientUtil.doPostJson(address, reqJSON);
            JSONObject retMap = JSON.parseObject(result);
            if ("SUCCESS".equals(retMap.get("retCode")) && "SUCCESS".equalsIgnoreCase(retMap.get("resCode").toString())) {
                String checkSign = PayDigestUtil.getSign(retMap, repKey, "sign", "payParams");
                String retSign = (String) retMap.get("sign");
                if (checkSign.equals(retSign)) {
                    JSONObject jo = retMap.getJSONObject("payParams");
                    jo.put("mchOrderNo", order.getId());
                    return jo;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
