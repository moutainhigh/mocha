package com.efruit.micro.arkgift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efruit.micro.arkgift.domain.GiftActivities;
import com.efruit.micro.arkgift.mapper.GiftActivitiesMapper;

/**
 * 操作礼物活动相关的服务
 * @author wangyang
 */
@Service
@Transactional
public class GiftActivitiesService {
	
	@Autowired
	private GiftActivitiesMapper giftActivitiesMapper;
	
	/**
	 * 根据编号获取礼物信息
	 * @param id 礼物编号
	 * @return
	 */
	@Transactional(readOnly=true)
	public GiftActivities selectById(String id) {
		return giftActivitiesMapper.selectById(id);
	}
	
	/**
	 * 获取当前有效的活动信息
	 * @return
	 */
	public GiftActivities getCurrValidInfo() {
		return giftActivitiesMapper.getCurrValidInfo();
	}
}
