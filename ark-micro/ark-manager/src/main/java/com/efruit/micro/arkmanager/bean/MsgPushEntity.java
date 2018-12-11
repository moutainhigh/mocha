package com.efruit.micro.arkmanager.bean;

import java.io.Serializable;

/**
 * 消息接收类
 *
 * 示例：
 *
 * {
 *     "msg":"%7B%22order_promotion%22:%7B%22adjust_fee%22:%220.00%22%7D,%22refund_order%22:[],%22full_order_info%22:%7B%22address_info%22:%7B%22self_fetch_info%22:%22%7B%5C%22address_detail%5C%22:%5C%22%E9%87%91%E9%9A%85%E5%98%89%E5%8D%8E%E5%A4%A7%E5%8E%A6D%E5%BA%A7%5C%22,%5C%22city%5C%22:%5C%22%E5%8C%97%E4%BA%AC%E5%B8%82%5C%22,%5C%22county%5C%22:%5C%22%E6%B5%B7%E6%B7%80%E5%8C%BA%5C%22,%5C%22id%5C%22:52722896,%5C%22is_optional_self_fetch_time%5C%22:0,%5C%22is_super_store%5C%22:0,%5C%22kdt_id%5C%22:40553542,%5C%22lat%5C%22:40.042801,%5C%22lon%5C%22:116.314423,%5C%22name%5C%22:%5C%22%E9%87%91%E9%9A%85%E5%98%89%E5%8D%8E%E5%A4%A7%E5%8E%A6D%E5%BA%A7%5C%22,%5C%22province%5C%22:%5C%22%E5%8C%97%E4%BA%AC%E5%B8%82%5C%22,%5C%22tel%5C%22:%5C%2213346181440%5C%22,%5C%22user_name%5C%22:%5C%22Kenneth%EF%BC%88%E5%A4%9A%E5%90%83%E6%B0%B4%E6%9E%9C%E5%86%85%E8%B4%AD%EF%BC%89%5C%22,%5C%22user_tel%5C%22:%5C%2213631276294%5C%22,%5C%22user_time%5C%22:%5C%22%E8%AF%B7%E5%B0%BD%E5%BF%AB%E5%88%B0%E8%87%AA%E6%8F%90%E7%82%B9%E6%8F%90%E8%B4%A7%5C%22%7D%22,%22delivery_address%22:%22%E9%87%91%E9%9A%85%E5%98%89%E5%8D%8E%E5%A4%A7%E5%8E%A6D%E5%BA%A7%22,%22delivery_postal_code%22:%22%22,%22receiver_name%22:%22Kenneth%EF%BC%88%E5%A4%9A%E5%90%83%E6%B0%B4%E6%9E%9C%E5%86%85%E8%B4%AD%EF%BC%89%22,%22delivery_province%22:%22%E5%8C%97%E4%BA%AC%E5%B8%82%22,%22delivery_city%22:%22%E5%8C%97%E4%BA%AC%E5%B8%82%22,%22delivery_district%22:%22%E6%B5%B7%E6%B7%80%E5%8C%BA%22,%22address_extra%22:%22%7B%7D%22,%22receiver_tel%22:%2213631276294%22%7D,%22remark_info%22:%7B%22buyer_message%22:%22%22%7D,%22pay_info%22:%7B%22outer_transactions%22:[%224200000188201808251321884699%22],%22post_fee%22:%220.00%22,%22total_fee%22:%2289.00%22,%22payment%22:%2289.00%22,%22transaction%22:[%22180825151214000005%22]%7D,%22buyer_info%22:%7B%22buyer_phone%22:%2213631276294%22,%22fans_type%22:1,%22buyer_id%22:109054703,%22fans_id%22:5208806293,%22fans_nickname%22:%22Kenneth%20(%E7%BD%97%E5%81%A5%E8%BE%89)%22%7D,%22orders%22:[%7B%22outer_sku_id%22:%220000013%22,%22goods_url%22:%22https://h5.youzan.com/v2/showcase/goods%3Falias=2fz4x2walbw46%22,%22item_id%22:412669687,%22outer_item_id%22:%22%22,%22item_type%22:0,%22num%22:1,%22sku_id%22:36238040,%22sku_properties_name%22:%22[%7B%5C%22k%5C%22:%5C%22%E5%A5%97%E9%A4%90%5C%22,%5C%22k_id%5C%22:506,%5C%22v%5C%22:%5C%22%E4%B8%80%E5%91%A8%EF%BC%885%E4%B8%AA%E5%B7%A5%E4%BD%9C%E6%97%A5%EF%BC%8C18%E5%85%83/%E6%97%A5%EF%BC%89%5C%22,%5C%22v_id%5C%22:25237127%7D,%7B%5C%22k%5C%22:%5C%22%E5%8F%91%E8%B4%A7%E6%97%B6%E9%97%B4%5C%22,%5C%22k_id%5C%22:28098,%5C%22v%5C%22:%5C%2211%E7%82%B9%E5%89%8D%E4%B8%8B%E5%8D%9514-17%E7%82%B9%E9%85%8D%E9%80%81%EF%BC%8C%E5%90%A6%E5%88%99%E6%AC%A1%E6%97%A5%E9%80%81%5C%22,%5C%22v_id%5C%22:25668260%7D]%22,%22pic_path%22:%22https://img.yzcdn.cn/upload_files/2018/07/19/FqH4jqRB54leQUS3wKPuwtD-pazx.jpg%22,%22oid%22:%221467904813679773657%22,%22title%22:%22%E5%A4%9A%E5%90%83%E6%B0%B4%E6%9E%9C%20%C2%B7%20%E4%BC%98%E4%BA%AB%E9%A4%90%EF%BC%88%E4%B8%80%E5%91%A8%E5%90%83%E5%88%B020%E7%A7%8D%E6%B0%B4%E6%9E%9C%EF%BC%81%EF%BC%89%22,%22buyer_messages%22:%22%22,%22is_present%22:false,%22points_price%22:%220%22,%22price%22:%2289.00%22,%22total_fee%22:%2289.00%22,%22alias%22:%222fz4x2walbw46%22,%22payment%22:%2289.00%22%7D],%22source_info%22:%7B%22is_offline_order%22:false,%22source%22:%7B%22platform%22:%22wx%22,%22wx_entrance%22:%22direct_buy%22%7D%7D,%22order_info%22:%7B%22consign_time%22:%22%22,%22order_extra%22:%7B%22is_from_cart%22:%22false%22,%22is_points_order%22:%220%22%7D,%22created%22:%222018-08-25%2015:12:13%22,%22status_str%22:%22%E5%BE%85%E5%8F%91%E8%B4%A7%22,%22expired_time%22:%222018-08-25%2015:32:13%22,%22success_time%22:%22%22,%22type%22:0,%22tid%22:%22E20180825151213075100007%22,%22confirm_time%22:%22%22,%22pay_time%22:%222018-08-25%2015:12:18%22,%22update_time%22:%222018-08-25%2015:12:20%22,%22pay_type_str%22:%22WEIXIN_DAIXIAO%22,%22is_retail_order%22:false,%22pay_type%22:10,%22team_type%22:0,%22refund_state%22:0,%22close_type%22:0,%22status%22:%22WAIT_SELLER_SEND_GOODS%22,%22express_type%22:1,%22order_tags%22:%7B%22is_message_notify%22:true,%22is_payed%22:true,%22is_use_ump%22:true,%22is_secured_transactions%22:true%7D%7D%7D%7D",
 *     "sendCount":0,
 *     "mode":1,
 *     "app_id":null,
 *     "client_id":"376e07bcf6e8054c17",
 *     "version":1535181140,
 *     "type":"trade_TradeBuyerPay",
 *     "id":"E20180825151213075100007",
 *     "sign":"0b3af587fce407c0b90b9a5d611b31c8",
 *     "kdt_id":40553542,
 *     "test":false,
 *     "status":"WAIT_SELLER_SEND_GOODS",
 *     "kdt_name":"多吃水果极速达"
 * }
 */
public class MsgPushEntity implements Serializable {


    private String msg;

    private int sendCount;

    private int mode; //  默认0 : appid  1 :client

    private String app_id;

    private String client_id;

    private Long version;

    private String type;

    private String id;

    private String sign;

    private Integer kdt_id;

    private boolean test = false;

    private String status;

    private String kdt_name;

    private String decodedMsg;

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSendCount() {
        return sendCount;
    }

    public void setSendCount(int sendCount) {
        this.sendCount = sendCount;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Integer getKdt_id() {
        return kdt_id;
    }

    public void setKdt_id(Integer kdt_id) {
        this.kdt_id = kdt_id;
    }

    public String getKdt_name() {
        return kdt_name;
    }

    public void setKdt_name(String kdt_name) {
        this.kdt_name = kdt_name;
    }

    public String getDecodedMsg() {
        return decodedMsg;
    }

    public void setDecodedMsg(String decodedMsg) {
        this.decodedMsg = decodedMsg;
    }

    @Override
    public String toString() {
        return "MsgPushEntity{" +
                "msg='" + msg + '\'' +
                ", sendCount=" + sendCount +
                ", mode=" + mode +
                ", app_id='" + app_id + '\'' +
                ", client_id='" + client_id + '\'' +
                ", version=" + version +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", sign='" + sign + '\'' +
                ", kdt_id=" + kdt_id +
                ", test=" + test +
                ", status='" + status + '\'' +
                ", kdt_name='" + kdt_name + '\'' +
                '}';
    }
}
