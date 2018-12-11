package com.efruit.micro.arkpay.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.HttpClientUtil;
import com.efruit.micro.arkcommon.utils.PayDigestUtil;
import com.efruit.micro.arkpay.def.PayChannelDef;

import java.util.Map;

/**
 * Created by dingzhiwei on 16/5/5.
 */
public class PayOrderDemo {

    // 商户ID
    static final String mchId = "10000001";//20001223,20001245
    // 加签key
    static final String reqKey = "WbmjVf8h6d0kJL3zgGZN7KJEb2xSL0jaY5qiJdKwPSgG0JdH6NbHVE3VNbwU";
    // 验签key
    static final String repKey = "qzkPo1O3DsIQx542DraG5crgmFcgLvOyeDbPO3XIsCvlu8glWsMo1ulKMcCG";

    static final String baseUrl = "http://pay.efruitpro.com/api";
    //    static final String baseUrl = "http://localhost:3020/api";
    //static final String notifyUrl = "http://www.baidu.com"; // 本地环境测试,可到ngrok.cc网站注册
//    static final String notifyUrl = "http://gift.efruitpro.com/goods/payNotify";
    static final String notifyUrl = "http://37c45476.ngrok.io/goods/payNotify";

    public static void main(String[] args) {
        payOrderTest();
//        quryPayOrderTest("1537948136483", "P0020180926154857000004");
    }

    // 统一下单
    static String payOrderTest() {
        JSONObject paramMap = new JSONObject();
        paramMap.put("mchId", mchId);                               // 商户ID
        paramMap.put("mchOrderNo", System.currentTimeMillis());     // 商户订单号
        // 支付渠道ID, WX_NATIVE(微信扫码),WX_JSAPI(微信公众号或微信小程序),WX_APP(微信APP),WX_MWEB(微信H5),ALIPAY_WAP(支付宝手机支付),ALIPAY_PC(支付宝网站支付),ALIPAY_MOBILE(支付宝移动支付)
        paramMap.put("channelId", PayChannelDef.PAY_CHANNEL_WX_JSAPI);
        paramMap.put("amount", 1);                                  // 支付金额,单位分
        paramMap.put("currency", "cny");                            // 币种, cny-人民币
        paramMap.put("clientIp", "211.94.116.218");                 // 用户地址,微信H5支付时要真实的
        paramMap.put("device", "WEB");                              // 设备
        paramMap.put("subject", "efruit支付测试");
        paramMap.put("body", "efruit支付测试");
        paramMap.put("notifyUrl", notifyUrl);                       // 回调URL
        paramMap.put("param1", "");                                 // 扩展参数1
        paramMap.put("param2", "");                                 // 扩展参数2
        paramMap.put("extra", "{\"openId\": \"oVVo002pfxCNo4Yki2rNZY44e144\", \"productId\": \"120989823\"}");// 必须为有效的openId

        String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
        paramMap.put("sign", reqSign);                              // 签名
        final String reqJSON = paramMap.toJSONString();
        System.out.println("请求支付中心下单接口,请求数据:" + reqJSON);
        String url = baseUrl + "/pay/create_order?";
        String result = HttpClientUtil.doPostJson(url, reqJSON);
        System.out.println("请求支付中心下单接口,响应数据:" + result);
        Map retMap = JSON.parseObject(result);
        if ("SUCCESS".equals(retMap.get("retCode")) && "SUCCESS".equalsIgnoreCase(retMap.get("resCode").toString())) {
            // 验签
            String checkSign = PayDigestUtil.getSign(retMap, repKey, "sign", "payParams");
            String retSign = (String) retMap.get("sign");
            if (checkSign.equals(retSign)) {
                System.out.println("=========支付中心下单验签成功=========");
            } else {
                System.err.println("=========支付中心下单验签失败=========");
                return null;
            }
        }
        return retMap.get("payOrderId") + "";
    }

    static String quryPayOrderTest(String mchOrderNo, String payOrderId) {
        JSONObject paramMap = new JSONObject();
        paramMap.put("mchId", mchId);                               // 商户ID
        paramMap.put("mchOrderNo", mchOrderNo);                     // 商户订单号
        paramMap.put("payOrderId", payOrderId);                     // 支付订单号
        paramMap.put("executeNotify", "true");                      // 是否执行回调,true或false,如果为true当订单状态为支付成功(2)时,支付中心会再次回调一次业务系统

        String reqSign = PayDigestUtil.getSign(paramMap, reqKey);
        paramMap.put("sign", reqSign);                              // 签名
        String reqData = paramMap.toJSONString();
        System.out.println("请求支付中心查单接口,请求数据:" + reqData);
        String url = baseUrl + "/pay/query_order?";
        String result = HttpClientUtil.doPostJson(url, reqData);
        System.out.println("请求支付中心查单接口,响应数据:" + result);
        Map retMap = JSON.parseObject(result);
        if ("SUCCESS".equals(retMap.get("retCode")) && "SUCCESS".equalsIgnoreCase(retMap.get("resCode").toString())) {
            // 验签
            String checkSign = PayDigestUtil.getSign(retMap, repKey, "sign", "payParams");
            String retSign = (String) retMap.get("sign");
            if (checkSign.equals(retSign)) {
                System.out.println("=========支付中心查单验签成功=========");
            } else {
                System.err.println("=========支付中心查单验签失败=========");
                return null;
            }
        }
        return retMap.get("payOrderId") + "";
    }

}
