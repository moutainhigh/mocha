package com.efruit.micro.arkpay.def;

/**
 * 不同渠道对应的其他信息, key 定义
 */
public class ExtraKeyDef {

    /**
     * 微信公众号支付需要(WX_JSAPI)，微信openId
     */
    public static final String KEY_OPENID = "openId";

    /**
     * 微信扫码支付需要(WX_NATIVE)
     */
    public static final String KEY_PRODUCTID = "productId";

    /**
     * 微信H5支付需要(WX_MWEB)
     */
    public static final String KEY_SCENEINFO = "sceneInfo";

}
