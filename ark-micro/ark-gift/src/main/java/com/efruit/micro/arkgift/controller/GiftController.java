package com.efruit.micro.arkgift.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.efruit.micro.arkgift.domain.GiftOrder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkgift.service.GiftActivitiesService;
import com.efruit.micro.arkgift.service.GiftOrderService;
import com.efruit.micro.arkgift.service.GiftPayService;
import com.efruit.micro.arkgift.service.GiftRecordService;
import com.efruit.micro.arkgift.controller.form.CreateOrderForm;
import com.efruit.micro.arkgift.controller.form.GiftReceiveForm;
import com.efruit.micro.arkgift.domain.GiftActivities;
import com.efruit.micro.arkgift.util.WebUtil;

/**
 * 送礼相关的接口
 *
 * @author wangyang
 */
@RestController
@RequestMapping("gift")
public class GiftController {

    @Autowired
    private GiftActivitiesService giftActivitiesService;
    @Autowired
    private GiftOrderService giftOrderService;
    @Autowired
    private GiftRecordService giftRecordService;
    @Autowired
    private GiftPayService giftPayService;

    /**
     * 创建订单
     *
     * @param act_id   活动编号
     * @param num      购买数量
     * @param gift_msg 祝福语
     */
    @RequestMapping("createOrder")
    public ArkCommonResult createOrder(HttpServletRequest request, @RequestBody CreateOrderForm form) {
        if (!form.isValid()) {
            return ArkCommonResult.fail("参数不完整");
        }
        GiftActivities act = giftActivitiesService.selectById(form.getAct_id());
        if (act != null) {
            String ss = checkActivities(act);
            if (StringUtils.isNotEmpty(ss)) {
                ArkCommonResult.fail(ss);
            }

            final String openId = form.getOpenId();
            final String actId = act.getId();

            final List<GiftOrder> giftOrderListByOpenId = giftOrderService.getGiftOrderListByOpenId(openId, actId);
            if (!CollectionUtils.isEmpty(giftOrderListByOpenId)) {
                final int size = giftOrderListByOpenId.size();
                final Integer maxBuyCount = act.getMaxBuyCount();
                if (maxBuyCount != null && size >= maxBuyCount) {
                    return ArkCommonResult.fail("当前活动商品同一个用户只能购买" + maxBuyCount + "次");
                }
            }

            JSONObject result = giftPayService.createOrder(act, form.getNum(), form.getGift_msg(), openId, WebUtil.getClientIp(request));
            if (result != null) {
                System.out.println(result);
                return ArkCommonResult.ok(result);
            } else {
                return ArkCommonResult.fail();
            }
        }

        return ArkCommonResult.fail("活动信息有误");
    }

    /**
     * 检查活动信息是否有效
     *
     * @param act
     * @return
     */
    private String checkActivities(GiftActivities act) {
        if (act.getEndDate().getTime() > new Date().getTime())
            return "此活动已经过期";
        if (act.getValid() != 1)
            return "此活动无效";

        return null;
    }

    /**
     * 礼物领取
     */
    @RequestMapping("receive")
    public ArkCommonResult receive(@RequestBody GiftReceiveForm form) {
        if (form.isValid()) {
            String msg = giftRecordService.receive(form);
            if (StringUtils.isEmpty(msg)) {
                return ArkCommonResult.ok();
            } else {
                return ArkCommonResult.fail(msg);
            }
        }
        return ArkCommonResult.fail("表单填写完整");
    }

    /**
     * 获取礼物订单信息
     *
     * @param order_id 订单ID
     */
    @RequestMapping("getOrder")
    public ArkCommonResult getOrder(@RequestParam String order_id) {
        return ArkCommonResult.ok(giftOrderService.getOrder(order_id));
    }

    /**
     * 获取礼物领取列表
     *
     * @param order_id 订单ID
     */
    @RequestMapping("recList")
    public ArkCommonResult recList(@RequestParam String order_id) {
        return ArkCommonResult.ok(giftRecordService.getRecList(order_id));
    }

    /**
     * 获取礼物活动信息
     *
     * @param act_id 活动编号
     */
    @RequestMapping("getInfo")
    public ArkCommonResult getInfo(String act_id) {
        if (StringUtils.isNotEmpty(act_id)) {
            return ArkCommonResult.ok(giftActivitiesService.selectById(act_id));
        } else {
            return ArkCommonResult.ok(giftActivitiesService.getCurrValidInfo());
        }
    }

    /**
     * 根据openid获取过买过的礼物
     *
     * @param act_id   活动编号
     * @param pageNum  页数，默认1
     * @param pageSize 每页条数，默认10
     */
    @RequestMapping("getGiftList")
    public ArkCommonResult getGiftList(@RequestParam String openid, Integer pageNum, Integer pageSize) {
        return ArkCommonResult.ok(giftOrderService.selectByOpenid(openid, pageNum, pageSize));
    }
}
