package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.pojo.AOrder;
import com.efruit.micro.arkmanager.pojo.AOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AOrderMapper {
    int countByExample(AOrderExample example);

    int deleteByExample(AOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AOrder record);

    int insertSelective(AOrder record);

    List<AOrder> selectByExample(AOrderExample example);

    AOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AOrder record, @Param("example") AOrderExample example);

    int updateByExample(@Param("record") AOrder record, @Param("example") AOrderExample example);

    int updateByPrimaryKeySelective(AOrder record);

    int updateByPrimaryKey(AOrder record);

    //查询有效订单
    List<AOrder> getOrderList(OrderCondition condition);

    int getOrderListCount(OrderCondition condition);

    AOrder getOrderById(long orderId);

    //获取最后一条订单
    AOrder getLastOrder();

    List<String> getAddressList();

    int insertOrderList(List<AOrder> orderList);

    int getOrderListCountByUserId(OrderCondition condition);

    List<String> getUserIdListByMobile(@Param("mobile") String mobile);
}