package com.efruit.micro.arkmanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.JsonUtils;
import com.efruit.micro.arkmanager.bean.MsgPushEntity;
import com.efruit.micro.arkmanager.mq.RabbitMq4Push;
import com.efruit.micro.arkmanager.service.CouponService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * PushController
 * 有赞推送服务消息接收
 * 依赖SPRING 3.0或以上版本
 */
@RequestMapping("/coupon")
@Controller
public class YouzanPushController {
    private static final Logger LOGGER = LoggerFactory.getLogger(YouzanPushController.class);

    @Value("${youzan.client_id}")
    private String client_id;

    @Value("${youzan.client_secret}")
    private String client_secret;

    @Autowired
    private RabbitMq4Push rabbitMq4Push;

    private static final int SERVICE_MODE = 1; //服务商

    private static final JSONObject SUC_RES = new JSONObject();

    static {
        SUC_RES.put("code", 0);
        SUC_RES.put("msg", "success");
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object push(@RequestBody MsgPushEntity entity) {

        final JSONObject res = SUC_RES;
        /**
         *  判断是否为心跳检查消息
         *  1.是则直接返回
         */
        if (entity.isTest()) {
            return res;
        }

        /**
         * 解析消息推送的模式  这步判断可以省略
         * 0-商家自由消息推送 1-服务商消息推送
         * 以服务商 举例
         * 判断是否为服务商类型的消息
         * 否则直接返回
         */
        if (entity.getMode() != SERVICE_MODE) {
            return res;
        }

        /**
         * 判断消息是否合法
         * 解析sign
         * MD5 工具类开发者可以自行引入
         */
        final String entityMsg = entity.getMsg();
        String signSrc = client_id + entityMsg + client_secret;
        String sign = DigestUtils.md5DigestAsHex(signSrc.getBytes());
        if (!sign.equals(entity.getSign())) {
            return res;
        }

        /**
         * 对于msg 先进行URI解码
         */
        String decodeMsg = "";
        try {
            decodeMsg = URLDecoder.decode(entityMsg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        LOGGER.info("processPushV3() decodeMsg : {} \n", decodeMsg);
        if (StringUtils.isEmpty(decodeMsg)) {
            return res;
        }

        entity.setDecodedMsg(decodeMsg);

        /**
         *  ..........
         *  接下来是一些业务处理
         *  判断当前消息的类型 比如交易
         *
         */
        rabbitMq4Push.send(JSON.toJSONString(entity));
        return res;
    }



    /**
     * 交易信息V3 ：
     * msg 结构示例：
     * {
     *     "order_promotion":{
     *         "adjust_fee":"0.00"
     *     },
     *     "refund_order":[
     *
     *     ],
     *     "full_order_info":{
     *         "address_info":{
     *             "self_fetch_info":"{"address_detail":"金隅嘉华大厦D座","city":"北京市","county":"海淀区","id":52722896,"is_optional_self_fetch_time":0,"is_super_store":0,"kdt_id":40553542,"lat":40.042801,"lon":116.314423,"name":"金隅嘉华大厦D座","province":"北京市","tel":"13346181440","user_name":"Kenneth（多吃水果内购）","user_tel":"13631276294","user_time":"请尽快到自提点提货"}",
     *             "delivery_address":"金隅嘉华大厦D座",
     *             "delivery_postal_code":"",
     *             "receiver_name":"Kenneth（多吃水果内购）",
     *             "delivery_province":"北京市",
     *             "delivery_city":"北京市",
     *             "delivery_district":"海淀区",
     *             "address_extra":"{}",
     *             "receiver_tel":"13631276294"
     *         },
     *         "remark_info":{
     *             "buyer_message":""
     *         },
     *         "pay_info":{
     *             "outer_transactions":[
     *                 "4200000188201808251321884699"
     *             ],
     *             "post_fee":"0.00",
     *             "total_fee":"89.00",
     *             "payment":"89.00",
     *             "transaction":[
     *                 "180825151214000005"
     *             ]
     *         },
     *         "buyer_info":{
     *             "buyer_phone":"13631276294",
     *             "fans_type":1,
     *             "buyer_id":109054703,
     *             "fans_id":5208806293,
     *             "fans_nickname":"Kenneth"
     *         },
     *         "orders":[
     *             {
     *                 "outer_sku_id":"0000013",
     *                 "goods_url":"https://h5.youzan.com/v2/showcase/goods?alias=2fz4x2walbw46",
     *                 "item_id":412669687,
     *                 "outer_item_id":"",
     *                 "item_type":0,
     *                 "num":1,
     *                 "sku_id":36238040,
     *                 "sku_properties_name":"[{"k":"套餐","k_id":506,"v":"一周（5个工作日，18元/日）","v_id":25237127},{"k":"发货时间","k_id":28098,"v":"11点前下单14-17点配送，否则次日送","v_id":25668260}]",
     *                 "pic_path":"https://img.yzcdn.cn/upload_files/2018/07/19/FqH4jqRB54leQUS3wKPuwtD-pazx.jpg",
     *                 "oid":"1467904813679773657",
     *                 "title":"多吃水果 · 优享餐（一周吃到20种水果！）",
     *                 "buyer_messages":"",
     *                 "is_present":false,
     *                 "points_price":"0",
     *                 "price":"89.00",
     *                 "total_fee":"89.00",
     *                 "alias":"2fz4x2walbw46",
     *                 "payment":"89.00"
     *             }
     *         ],
     *         "source_info":{
     *             "is_offline_order":false,
     *             "source":{
     *                 "platform":"wx",
     *                 "wx_entrance":"direct_buy"
     *             }
     *         },
     *         "order_info":{
     *             "consign_time":"",
     *             "order_extra":{
     *                 "is_from_cart":"false",
     *                 "is_points_order":"0"
     *             },
     *             "created":"2018-08-25 15:12:13",
     *             "status_str":"待发货",
     *             "expired_time":"2018-08-25 15:32:13",
     *             "success_time":"",
     *             "type":0,
     *             "tid":"E20180825151213075100007",
     *             "confirm_time":"",
     *             "pay_time":"2018-08-25 15:12:18",
     *             "update_time":"2018-08-25 15:12:20",
     *             "pay_type_str":"WEIXIN_DAIXIAO",
     *             "is_retail_order":false,
     *             "pay_type":10,
     *             "team_type":0,
     *             "refund_state":0,
     *             "close_type":0,
     *             "status":"WAIT_SELLER_SEND_GOODS",
     *             "express_type":1,
     *             "order_tags":{
     *                 "is_message_notify":true,
     *                 "is_payed":true,
     *                 "is_use_ump":true,
     *                 "is_secured_transactions":true
     *             }
     *         }
     *     }
     * }
     */

}
