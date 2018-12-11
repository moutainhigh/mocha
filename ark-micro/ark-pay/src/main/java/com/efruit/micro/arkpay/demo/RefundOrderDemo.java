package com.efruit.micro.arkpay.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.HttpClientUtil;
import com.efruit.micro.arkcommon.utils.PayDigestUtil;

import java.util.Map;

public class RefundOrderDemo {

    // 商户ID
    static final String mchId = "10000001";//20001223,20001245
    // 加签key
    static final String reqKey = "WbmjVf8h6d0kJL3zgGZN7KJEb2xSL0jaY5qiJdKwPSgG0JdH6NbHVE3VNbwU";
    // 验签key
    static final String repKey = "qzkPo1O3DsIQx542DraG5crgmFcgLvOyeDbPO3XIsCvlu8glWsMo1ulKMcCG";

    static final String baseUrl = "http://pay.efruitpro.com/api";
    //    static final String baseUrl = "http://localhost:9001/api";
    static final String notifyUrl = "http://127.0.0.1:8081/goods/notify_test?rt=success"; // 本地环境测试,可到ngrok.cc网站注册

    public static void main(String[] args) {
        refundOrderTest();
        //quryPayOrderTest("1494774484058", "P0020170910211048000001");
    }

    // 退款
    static String refundOrderTest() {
        JSONObject paramMap = new JSONObject();
        paramMap.put("mchId", mchId);                               // 商户ID
        paramMap.put("mchRefundNo", "REFUND" + System.currentTimeMillis());     // 商户订单号
        // 支付渠道ID, WX_NATIVE(微信扫码),WX_JSAPI(微信公众号或微信小程序),WX_APP(微信APP),WX_MWEB(微信H5),ALIPAY_WAP(支付宝手机支付),ALIPAY_PC(支付宝网站支付),ALIPAY_MOBILE(支付宝移动支付)
        paramMap.put("channelId", "WX_JSAPI");
        paramMap.put("amount", 1);  // 退款金额
        paramMap.put("currency", "cny");                            // 币种, cny-人民币
        paramMap.put("clientIp", "211.94.116.218");                 // 用户地址,微信H5支付时要真实的
        paramMap.put("device", "WEB");                              // 设备
        paramMap.put("subject", "退款测试");
        paramMap.put("body", "退款测试");
        paramMap.put("notifyUrl", notifyUrl);                       // 回调URL
        paramMap.put("param1", "");                                 // 扩展参数1
        paramMap.put("param2", "");                                 // 扩展参数2
        paramMap.put("channelUser", "xxx@example.com");  // 退款用户，可以填写用户的手机号、或者openId
        paramMap.put("payOrderId", "P0020181015214517000179");// 商家支付单号


        //{"h5_info": {"type":"Wap","wap_url": "https://pay.qq.com","wap_name": "腾讯充值"}}

        String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
        paramMap.put("sign", reqSign);                              // 签名
        String reqJSON = paramMap.toJSONString();
        System.out.println("请求支付中心退款接口,请求数据:" + reqJSON);
        String url = baseUrl + "/refund/create_order?";
        String result = HttpClientUtil.doPostJson(url, reqJSON);
        System.out.println("请求支付中心退款接口,响应数据:" + result);
        Map retMap = JSON.parseObject(result);
        if ("SUCCESS".equals(retMap.get("retCode")) && "SUCCESS".equalsIgnoreCase(retMap.get("resCode").toString())) {
            // 验签
            String checkSign = PayDigestUtil.getSign(retMap, repKey, "sign", "payParams");
            String retSign = (String) retMap.get("sign");
            if (checkSign.equals(retSign)) {
                System.out.println("=========支付中心退款验签成功=========");
            } else {
                System.err.println("=========支付中心退款验签失败=========");
                return null;
            }
        }
        return retMap.get("transOrderId") + "";
    }

}
