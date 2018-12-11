package com.efruit.micro.arkgift.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.efruit.micro.arkgift.service.GiftOrderService;
import com.efruit.micro.arkgift.util.PayUtil;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Value("${pay.mchId}")
	private String mchId;
	@Value("${pay.repKey}")
	private String repKey;
	
	@Autowired
	private GiftOrderService giftOrderService; 
	
	/**
     * 接收支付中心通知
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/payNotify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> paramMap = PayUtil.request2payResponseMap(request, new String[]{
                "payOrderId","mchId","mchOrderNo","channelId","amount","currency","status", "clientIp",
                "device",  "subject", "channelOrderNo", "param1",
                "param2","paySuccTime","backType","sign"
        });
        
        String payOrderId = (String) paramMap.get("payOrderId");
        String mchOrderNo = (String) paramMap.get("mchOrderNo");
        System.out.println("支付回调，支付流水号："+payOrderId + "，订单号："+mchOrderNo);
        
        if (!PayUtil.verifyPayResponse(paramMap,mchId,repKey)) {
            PayUtil.outResult(response, "fail");
            return;
        }
        
        String resStr = "SUCCESS";
        giftOrderService.updatePay(mchOrderNo,payOrderId);
        
        PayUtil.outResult(response, resStr);
    }
}
