package com.efruit.micro.arkgift.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.efruit.micro.arkgift.domain.GiftActivities;

@Mapper
public interface GiftActivitiesMapper {
	
	GiftActivities selectById(String id);

    int insert(GiftActivities giftActivities);

    int updateByIdSelective(GiftActivities giftActivities);

    int updateById(GiftActivities giftActivities);

	GiftActivities getCurrValidInfo();
}