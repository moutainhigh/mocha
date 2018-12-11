package com.efruit.micro.arkpay.controller;

import com.efruit.micro.arkcommon.utils.PayDigestUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsOrderController {

    private final static Logger _log = LoggerFactory.getLogger(GoodsOrderController.class);

    static final String mchId = "10000001";
    // 加签key
    static final String reqKey = "WbmjVf8h6d0kJL3zgGZN7KJEb2xSL0jaY5qiJdKwPSgG0JdH6NbHVE3VNbwU";
    // 验签key
    static final String resKey = "qzkPo1O3DsIQx542DraG5crgmFcgLvOyeDbPO3XIsCvlu8glWsMo1ulKMcCG";

    /**
     * 接收支付中心通知
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/payNotify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        _log.info("====== 开始处理支付中心通知 ======");
        Map<String,Object> paramMap = request2payResponseMap(request, new String[]{
                "payOrderId","mchId","mchOrderNo","channelId","amount","currency","status", "clientIp",
                "device",  "subject", "channelOrderNo", "param1",
                "param2","paySuccTime","backType","sign"
        });
        _log.info("支付中心通知请求参数,paramMap={}", paramMap);
        if (!verifyPayResponse(paramMap)) {
            String errorMessage = "verify request param failed.";
            _log.warn(errorMessage);
            outResult(response, "fail");
            return;
        }
        String payOrderId = (String) paramMap.get("payOrderId");
        String mchOrderNo = (String) paramMap.get("mchOrderNo");
        String resStr = "";
        // 处理业务
//        try {
//            GoodsOrder goodsOrder = goodsOrderService.getGoodsOrder(mchOrderNo);
//            if(goodsOrder != null && goodsOrder.getStatus() == Constant.GOODS_ORDER_STATUS_COMPLETE) {
//                outResult(response, "success");
//                return;
//            }
//            // 执行业务逻辑
//            int ret = goodsOrderService.updateStatus4Success(mchOrderNo);
//            // ret返回结果
//            // 等于1表示处理成功,返回支付中心success
//            // 其他值,返回支付中心fail,让稍后再通知
//            if(ret == 1) {
//                ret = goodsOrderService.updateStatus4Complete(mchOrderNo);
//                if(ret == 1) {
//                    resStr = "success";
//                }else {
//                    resStr = "fail";
//                }
//            }else {
//                resStr = "fail";
//            }
//        }catch (Exception e) {
//            resStr = "fail";
//            _log.error(e, "执行业务异常,payOrderId=%s.mchOrderNo=%s", payOrderId, mchOrderNo);
//        }
        _log.info("响应支付中心通知结果:{},payOrderId={},mchOrderNo={}", resStr, payOrderId, mchOrderNo);
        outResult(response, resStr);
        _log.info("====== 支付中心通知处理完成 ======");
    }

    @RequestMapping("/notify_test")
    public void notifyTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        outResult(response, "success");
    }

    void outResult(HttpServletResponse response, String content) {
        response.setContentType("text/html");
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(content);
            _log.error("response xxpay complete.");
        } catch (IOException e) {
//            _log.error(e, "response xxpay write exception.");
        }
    }

    public Map<String, Object> request2payResponseMap(HttpServletRequest request, String[] paramArray) {
        Map<String, Object> responseMap = new HashMap<>();
        for (int i = 0;i < paramArray.length; i++) {
            String key = paramArray[i];
            String v = request.getParameter(key);
            if (v != null) {
                responseMap.put(key, v);
            }
        }
        return responseMap;
    }

    private boolean verifyPayResponse(Map<String,Object> map) {
        String mchId = (String) map.get("mchId");
        String payOrderId = (String) map.get("payOrderId");
        String mchOrderNo = (String) map.get("mchOrderNo");
        String amount = (String) map.get("amount");
        String sign = (String) map.get("sign");

        if (StringUtils.isEmpty(mchId)) {
            _log.warn("Params error. mchId={}", mchId);
            return false;
        }
        if (StringUtils.isEmpty(payOrderId)) {
            _log.warn("Params error. payOrderId={}", payOrderId);
            return false;
        }
        if (StringUtils.isEmpty(amount) || !NumberUtils.isNumber(amount)) {
            _log.warn("Params error. amount={}", amount);
            return false;
        }
        if (StringUtils.isEmpty(sign)) {
            _log.warn("Params error. sign={}", sign);
            return false;
        }

        // 验证签名
        if (!verifySign(map)) {
            _log.warn("verify params sign failed. payOrderId={}", payOrderId);
            return false;
        }

//        // 根据payOrderId查询业务订单,验证订单是否存在
//        GoodsOrder goodsOrder = goodsOrderService.getGoodsOrder(mchOrderNo);
//        if(goodsOrder == null) {
//            _log.warn("业务订单不存在,payOrderId={},mchOrderNo={}", payOrderId, mchOrderNo);
//            return false;
//        }
//        // 核对金额
//        if(goodsOrder.getAmount() != Long.parseLong(amount)) {
//            _log.warn("支付金额不一致,dbPayPrice={},payPrice={}", goodsOrder.getAmount(), amount);
//            return false;
//        }
        return true;
    }

    private boolean verifySign(Map<String, Object> map) {
        String mchId = (String) map.get("mchId");
        if(!this.mchId.equals(mchId)) return false;
        String localSign = PayDigestUtil.getSign(map, resKey, "sign");
        String sign = (String) map.get("sign");
        return localSign.equalsIgnoreCase(sign);
    }

}