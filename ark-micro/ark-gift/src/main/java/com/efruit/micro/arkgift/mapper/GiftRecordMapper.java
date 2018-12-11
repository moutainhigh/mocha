package com.efruit.micro.arkgift.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.efruit.micro.arkgift.domain.GiftRecord;

@Mapper
public interface GiftRecordMapper {

    int insert(GiftRecord giftRecord);

    GiftRecord selectById(String id);

	List<GiftRecord> getRecList(String tid);

	GiftRecord getRecListByOpenidAndOrderId(@Param("tid") String orderId,@Param("openid") String openId);

}