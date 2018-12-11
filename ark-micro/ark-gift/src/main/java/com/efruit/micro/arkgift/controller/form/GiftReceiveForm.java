package com.efruit.micro.arkgift.controller.form;

import org.apache.commons.lang3.StringUtils;

import com.efruit.micro.arkgift.domain.GiftRecord;

/**
 * 领取礼物表单
 * @author wangyang
 *
 */
public class GiftReceiveForm {
	
	private String orderId;
	private String openId;
	private String name;
	private String phone;
	private String province;
	private String city;
	private String area;
	private String address;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 判断属性是否为空
	 */
	public boolean isValid() {
		return StringUtils.isNotEmpty(orderId) && StringUtils.isNotEmpty(openId) && StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(phone)
				&& StringUtils.isNotEmpty(province) && StringUtils.isNotEmpty(city) && StringUtils.isNotEmpty(area) && StringUtils.isNotEmpty(address);
	}
	public GiftRecord getGiftRecord() {
		GiftRecord rec = new GiftRecord();
		rec.setTid(this.orderId);
		rec.setWxOpenId(this.openId);
		rec.setName(name);
		rec.setPhone(phone);
		rec.setProvince(this.province);
		rec.setCity(this.city);
		rec.setArea(this.area);
		rec.setAddress(this.address);
		return rec;
	}
}
