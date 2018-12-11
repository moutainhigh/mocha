package com.efruit.micro.arkmanager.mapper;

import com.efruit.micro.arkmanager.pojo.WechatFansInfo;
import com.efruit.micro.arkmanager.pojo.WechatFansInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WechatFansInfoMapper {
    int countByExample(WechatFansInfoExample example);

    int deleteByExample(WechatFansInfoExample example);

    int deleteByPrimaryKey(String unionid);

    int insert(WechatFansInfo record);

    int insertSelective(WechatFansInfo record);

    List<WechatFansInfo> selectByExample(WechatFansInfoExample example);

    WechatFansInfo selectByPrimaryKey(String unionid);

    int updateByExampleSelective(@Param("record") WechatFansInfo record, @Param("example") WechatFansInfoExample example);

    int updateByExample(@Param("record") WechatFansInfo record, @Param("example") WechatFansInfoExample example);

    int updateByPrimaryKeySelective(WechatFansInfo record);

    int updateByPrimaryKey(WechatFansInfo record);

    int insertList(List<WechatFansInfo> list);

    List<String> selectAllUnionId();

    List<WechatFansInfo> getWechatFansInfoByDate(Date targetDate);
}