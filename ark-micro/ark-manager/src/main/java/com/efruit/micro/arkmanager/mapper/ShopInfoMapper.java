package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.ShopInfo;
import com.efruit.micro.arkmanager.pojo.ShopInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopInfoMapper {
    int countByExample(ShopInfoExample example);

    int deleteByExample(ShopInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    List<ShopInfo> selectByExample(ShopInfoExample example);

    ShopInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopInfo record, @Param("example") ShopInfoExample example);

    int updateByExample(@Param("record") ShopInfo record, @Param("example") ShopInfoExample example);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);

    int insertList(List<ShopInfo> shopInfos);
}