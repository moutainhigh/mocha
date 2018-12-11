package com.efruit.micro.youzan.service;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.youzan.bean.ArkOrder;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.common.YouzanToken;
import com.efruit.micro.youzan.sdk.model.YouzanMultistoreAddressGetResult;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult;
import com.youzan.open.sdk.gen.v3_0_0.model.*;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;

import java.util.Date;
import java.util.List;

public interface YouzanService {

    YouzanToken getToken();

    List<YouzanTradesSoldGetResult.StructurizationTrade> syncOrderV4(Date start, Date end) throws YouzanApiException;

    ArkCommonResult syncOrder(Date start, Date end) throws YouzanApiException;

    ArkOrder getArkOrderByTid(String tid) throws YouzanApiException;

    YouzanTradeGetResult getYouzanTradeGetResultByTid(String tid) throws YouzanApiException;

    List<YouzanUmpCouponsUnfinishedSearchResult.UmpCoupon> getYouzanConponList() throws YouzanApiException;

    YouzanUmpPromocodeAddResult.UmpPromotionCode addCode(String title, String code) throws YouzanApiException;

    /**
     * 根据微信粉丝用户的fans_id 获取用户信息
     * @param fansId
     * @return
     * @throws YouzanApiException
     */
    YouzanUsersWeixinFollowerGetResult.CrmWeixinFans getYouzanUserInfo(long fansId) throws YouzanApiException;

    /**
     * 根据微信粉丝用户的open_id 获取用户信息
     * @param openId
     * @return
     * @throws YouzanApiException
     */
    YouzanUsersWeixinFollowerGetResult.CrmWeixinFans getYouzanUserInfoByWxOpenId(String openId) throws YouzanApiException;

    /**
     * 获取所有微信粉丝用户信息
     * @return
     * @throws YouzanApiException
     */
    List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> getFansList() throws YouzanApiException;

    List<YouzanMultistoreOfflineSearchResult.AccountShopOffline> syncAddressList() throws YouzanApiException;

    YouzanItemGetResult.ItemDetailOpenModel getYouzanItemByAlias(String alias) throws YouzanApiException;

    YouzanMultistoreAddressGetResult getAddressDetails(Long id) throws YouzanApiException;
}
