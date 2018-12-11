package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingBuyerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DispatchingBuyerInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingBuyerInfo record);

    int insertList(List<DispatchingBuyerInfo> records);

    int insertSelective(DispatchingBuyerInfo record);

    DispatchingBuyerInfo selectByPrimaryKey(String userMobile);

    int updateByPrimaryKeySelective(DispatchingBuyerInfo record);

    int updateByPrimaryKey(DispatchingBuyerInfo record);

    DispatchingBuyerInfo getByUserId(String userId);

    DispatchingBuyerInfo getBySelective(DispatchingBuyerInfo obj);

    List<DispatchingBuyerInfo> selectUserAndItems(@Param("addressId") Long addressId, @Param("sendDate") Date sendDate);

    List<DispatchingBuyerInfo> getSendMsgBuyer(Long addressId, Date sendDate);

    int updateTel(@Param("oldTel") String oldTel, @Param("newTel") String newTel);
}