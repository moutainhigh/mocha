package com.efruit.micro.arkgift.controller.form;

import org.apache.commons.lang3.StringUtils;

/**
 * 创建礼物订单表单数据
 * @author wangyang
 */
public class CreateOrderForm {
	
	private String act_id;
	private Integer num; 
	private String gift_msg;
	private String openId;
	
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getGift_msg() {
		return gift_msg;
	}
	public void setGift_msg(String gift_msg) {
		this.gift_msg = gift_msg;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	public boolean isValid() {
		if(StringUtils.isNotEmpty(act_id) && num != null && num > 0 && StringUtils.isNotEmpty(openId)) {
			return true;
		}
		return false;
	}
}
