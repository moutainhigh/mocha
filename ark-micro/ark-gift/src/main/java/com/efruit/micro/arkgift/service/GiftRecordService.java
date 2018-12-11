package com.efruit.micro.arkgift.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efruit.micro.arkgift.controller.form.GiftReceiveForm;
import com.efruit.micro.arkgift.domain.GiftOrder;
import com.efruit.micro.arkgift.domain.GiftRecord;
import com.efruit.micro.arkgift.mapper.GiftRecordMapper;
import com.efruit.micro.arkgift.util.StringUtil;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult;

/**
 * 礼物领取记录服务
 * @author wangyang
 */
@Service
@Transactional
public class GiftRecordService {
	
	@Autowired
	private GiftOrderService giftOrderService;
	@Autowired
	private GiftRecordMapper giftRecordMapper;
	@Autowired
	private YouzanService youzanService;
	
	/**
	 * 获取礼物领取记录
	 * @param orderId 订单ID
	 * @return
	 */
	public List<GiftRecord> getRecList(String orderId) {
		return giftRecordMapper.getRecList(orderId);
	}
	
	/**
	 * 领取礼物
	 * @param form 提交表单
	 * @return
	 */
	public String receive(GiftReceiveForm form) {
		GiftOrder giftOrder = giftOrderService.getOrder(form.getOrderId());
		if(giftOrder.getStatus() == 0) {
			return "礼物还没付款，不能领取哦";
		}
		if(giftOrder.getRemainNum() <= 0) {
			return "手慢了，已经被领取完了";
		}
		if(giftOrder.getExpireTime().getTime() <= new Date().getTime()) {
			return "对不起，礼物已经过时";
		}
		GiftRecord rec = getRecListByOpenidAndOrderId(form.getOrderId(),form.getOpenId());
		if(rec != null) {
			return "不好意思，您已经领取过了";
		}
		GiftRecord newRec = form.getGiftRecord();
		newRec.setId(StringUtil.getOrderNo());
		newRec.setActId(giftOrder.getActId());
		newRec.setStatus(0);
		try {
			YouzanUsersWeixinFollowerGetResult.CrmWeixinFans user = youzanService.getYouzanUserInfoByWxOpenId(newRec.getWxOpenId());
			newRec.setWxNick(user.getNick());
			newRec.setWxPicUrl(user.getAvatar());
		} catch (YouzanApiException e) {
			System.out.println(e.getMessage());
		}
		
		int state = giftOrder.getStatus();
		if(giftOrder.getRemainNum() == 1) {
			state = 2;	//全部领取完成
		}
		int i = giftOrderService.decrement(form.getOrderId(),state);
		if(i > 0) {
			insert(newRec);
		}
		
		return null;
	}
	
	/**
	 * 插入领取记录
	 * @param giftRecord
	 * @return 
	 */
	private int insert(GiftRecord giftRecord) {
		return giftRecordMapper.insert(giftRecord);
	}
	
	/**
	 * 根据订单号和openid获取记录
	 * @param orderId
	 * @param openId
	 * @return
	 */
	private GiftRecord getRecListByOpenidAndOrderId(String orderId, String openId) {
		return giftRecordMapper.getRecListByOpenidAndOrderId(orderId,openId);
	}
}
