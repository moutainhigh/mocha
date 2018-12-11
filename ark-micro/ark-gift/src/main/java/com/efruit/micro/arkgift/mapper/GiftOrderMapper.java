package com.efruit.micro.arkgift.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.efruit.micro.arkgift.domain.GiftOrder;

@Mapper
public interface GiftOrderMapper {

    int insert(GiftOrder giftOrder);

    GiftOrder selectById(String id);

    int updateByIdSelective(GiftOrder giftOrder);

	int decrement(@Param("orderId") String orderId,@Param("state") int state);

	List<GiftOrder> selectByOpenid(@Param("openid") String openid);

	List<GiftOrder> selectActOrderListByOpenId(@Param("openid") String openid, @Param("actId") String actId);

}