package com.efruit.micro.arkpay.def;

public class PayKeyDef {
    /**
     * 商户ID
     */
    public static final String KEY_MCHID = "mchId";

    /**
     * 商户订单号
     */
    public static final String KEY_MCHORDERNO = "mchOrderNo";

    /**
     * 支付渠道ID, WX_NATIVE(微信扫码),WX_JSAPI(微信公众号或微信小程序),WX_APP(微信APP),WX_MWEB(微信H5),ALIPAY_WAP(支付宝手机支付),ALIPAY_PC(支付宝网站支付),ALIPAY_MOBILE(支付宝移动支付)
     */
    public static final String KEY_CHANNELID = "channelId";

    /**
     * 支付金额,单位分
     */
    public static final String KEY_AMOUNT = "amount";

    /**
     * 币种, cny-人民币
     */
    public static final String KEY_CURRENCY = "currency";

    /**
     * 户地址,微信H5支付时要真实的
     */
    public static final String KEY_CLIENTIP = "clientIp";

    /**
     * 设备
     */
    public static final String KEY_DEVICE = "device";

    /**
     * 商品主题
     */
    public static final String KEY_SUBJECT = "subject";

    /**
     * 商品详情
     */
    public static final String KEY_BODY = "body";

    /**
     * 回调URL
     */
    public static final String KEY_NOTIFYURL = "notifyUrl";

    /**
     * 扩展参数1
     */
    public static final String KEY_PARAM1 = "param1";

    /**
     * 扩展参数2
     */
    public static final String KEY_PARAM2 = "param2";

    /**
     * 不同渠道对应的其他信息
     */
    public static final String KEY_EXTRA = "extra";

    /**
     * 签名
     */
    public static final String KEY_SIGN = "sign";

}
