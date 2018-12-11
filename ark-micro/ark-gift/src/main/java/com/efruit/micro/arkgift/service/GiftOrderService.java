package com.efruit.micro.arkgift.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efruit.micro.arkgift.domain.GiftActivities;
import com.efruit.micro.arkgift.domain.GiftOrder;
import com.efruit.micro.arkgift.mapper.GiftOrderMapper;
import com.efruit.micro.arkgift.util.StringUtil;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult;

/**
 * 礼物订单相关的服务
 *
 * @author wangyang
 */
@Service
@Transactional
public class GiftOrderService {

    @Autowired
    private GiftOrderMapper giftOrderMapper;
    @Autowired
    private YouzanService youzanService;

    /**
     * 创建订单
     *
     * @param activities 活动信息
     * @param num        购买数量
     * @param gift_msg   祝福语
     */
    public GiftOrder createOrder(GiftActivities activities, Integer num, String gift_msg, String openId) {
        GiftOrder order = new GiftOrder();
        order.setId(StringUtil.getOrderNo());
        order.setWxOpenId(openId);
        try {
            YouzanUsersWeixinFollowerGetResult.CrmWeixinFans user = youzanService.getYouzanUserInfoByWxOpenId(openId);
            order.setWxNick(user.getNick());
            order.setWxPicUrl(user.getAvatar());
        } catch (YouzanApiException e) {
            System.out.println(e.getMessage());
        }
        order.setNum(num);
        order.setRemainNum(num);
        order.setGiftMsg(gift_msg);
        order.setActId(activities.getId());
        order.setStatus(0);
        order.setActName(activities.getActName());
        order.setItemName(activities.getItemName());
        order.setItemStandard(activities.getItemStandard());
        order.setItemPrice(activities.getItemPrice());
        order.setFreightPrice(activities.getFreightPrice());
        order.setShareDes(activities.getShareDes());
        order.setShareIcon(activities.getShareIcon());
        order.setShareTitle(activities.getShareTitle());
        //计算支付金额
        order.setPayMoney(activities.getItemPrice().multiply(new BigDecimal(num)).add(activities.getFreightPrice().multiply(new BigDecimal(num))));
        int i = giftOrderMapper.insert(order);
        if (i > 0) {
            return order;
        }
        return null;
    }

    /**
     * 根据订单号获取信息
     *
     * @param orderId 订单号
     */
    @Transactional(readOnly = true)
    public GiftOrder getOrder(String orderId) {
        return giftOrderMapper.selectById(orderId);
    }

    /**
     * 剩余量减1
     *
     * @param orderId 订单号
     * @param state   订单状态，1已经付款2礼物领全部领取完
     * @return
     */
    public int decrement(String orderId, int state) {
        return giftOrderMapper.decrement(orderId, state);
    }

    /**
     * 支付成功修改状态
     *
     * @param orderId    订单号
     * @param payOrderId 支付订单号
     */
    public boolean updatePay(String orderId, String payOrderId) {
        GiftOrder giftOrder = getOrder(orderId);
        if (giftOrder != null && giftOrder.getStatus() == 0) {
            giftOrder.setStatus(1);
            giftOrder.setExpireTime(new Date(System.currentTimeMillis() + 60 * 1000 * 60 * 24));
            giftOrder.setPayNo(payOrderId);
            int i = giftOrderMapper.updateByIdSelective(giftOrder);
            return i == 0 ? false : true;
        }
        return false;
    }

    /**
     * 根据openid获取购买礼物列表
     *
     * @param openid
     * @param pageNum  页数，默认1
     * @param pageSize 每页条数，默认10
     * @return
     */
    public PageInfo<GiftOrder> selectByOpenid(String openid, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageNum, pageSize);
        List<GiftOrder> list = giftOrderMapper.selectByOpenid(openid);
        PageInfo<GiftOrder> pageInfo = new PageInfo<GiftOrder>(list);
        if (pageNum > pageInfo.getPages()) {
            pageInfo.setList(null);
        }
        return pageInfo;
    }

    public List<GiftOrder> getGiftOrderListByOpenId(String openid, String actId) {
        return giftOrderMapper.selectActOrderListByOpenId(openid, actId);
    }
}
