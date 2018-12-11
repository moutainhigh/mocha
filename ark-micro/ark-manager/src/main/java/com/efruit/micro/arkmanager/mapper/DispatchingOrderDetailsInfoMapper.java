package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.DispatchingOrderDetailsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DispatchingOrderDetailsInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DispatchingOrderDetailsInfo record);

    int insertList(List<DispatchingOrderDetailsInfo> objs);

    int insertSelective(DispatchingOrderDetailsInfo record);

    DispatchingOrderDetailsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DispatchingOrderDetailsInfo record);

    int updateRefundStateByTidOid(@Param("refundState") String refundState, @Param("tid") String tid, @Param("oid") String oid);

    int updateByPrimaryKey(DispatchingOrderDetailsInfo record);
}