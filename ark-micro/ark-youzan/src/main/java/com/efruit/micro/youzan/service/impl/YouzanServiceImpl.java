package com.efruit.micro.youzan.service.impl;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkcommon.utils.HttpClientUtil;
import com.efruit.micro.arkcommon.utils.JsonUtils;
import com.efruit.micro.youzan.bean.ArkOrder;
import com.efruit.micro.youzan.common.*;
import com.efruit.micro.youzan.sdk.api.YouzanMultistoreAddressGet;
import com.efruit.micro.youzan.sdk.model.YouzanMultistoreAddressGetParams;
import com.efruit.micro.youzan.sdk.model.YouzanMultistoreAddressGetResult;
import com.efruit.micro.youzan.service.YouzanConfigStorage;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.*;
import com.youzan.open.sdk.gen.v3_0_0.model.*;
import com.youzan.open.sdk.gen.v4_0_0.api.YouzanTradeGet;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetParams;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class YouzanServiceImpl implements YouzanService {

    @Value("${youzan.client_id}")
    private String client_id;

    @Value("${youzan.client_secret}")
    private String client_secret;

    @Value("${youzan.shop_id}")
    private String shop_id;

    @Value("${youzan.token_url}")
    private String tokenUrl;


    @Autowired
    private YouzanConfigStorage youzanConfigStorage;

    @Override
    public YouzanToken getToken() {
        final String tokenJson = youzanConfigStorage.getTokenJson();
        if (!StringUtils.isEmpty(tokenJson)) {
            final YouzanToken youzanToken = JsonUtils.jsonToPojo(tokenJson, YouzanToken.class);
            if (TokenUtils.isVaild(youzanToken)) {
                return youzanToken;
            }
        }

        Map<String, String> params = new HashMap<>();
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("grant_type", "silent");
        params.put("kdt_id", shop_id);
        String result = HttpClientUtil.doPost(tokenUrl, params);

        YouzanToken tmpToken = JsonUtils.jsonToPojo(result, YouzanToken.class);
        if (tmpToken != null) {
            tmpToken.setCreateTime(System.currentTimeMillis());
            youzanConfigStorage.setTokenJson(JsonUtils.objectToJson(tmpToken));
        }

        return tmpToken;
    }

    @Override
    public List<com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult.StructurizationTrade> syncOrderV4(Date start, Date end) throws YouzanApiException {
        YouzanToken token = getToken();
        if (!TokenUtils.isVaild(token)) {
            throw new YouzanApiException("Youzan token invalid, please check.");
        }

        final String accessToken = token.getAccessToken();
        TradesSoldGetV4Helper helper = new TradesSoldGetV4Helper(accessToken);
        final List<com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult.StructurizationTrade> resultPair = helper.getTradeList(start, end);
        // 有可能查询区间是真的没有订单
        if (resultPair == null) {
            return new ArrayList<>();
        }

        return resultPair;
    }

    @Override
    public ArkCommonResult syncOrder(Date start, Date end) throws YouzanApiException {
        YouzanToken token = getToken();
        if (!TokenUtils.isVaild(token)) {
            return ArkCommonResult.build(ErrorKeyDef.TOKEN_INVAILD.getErrorCode(), ErrorKeyDef.TOKEN_INVAILD.getMsg());
        }

        final String accessToken = token.getAccessToken();
        TradesSoldGetHelper helper = new TradesSoldGetHelper(accessToken);
        final Pair<Long, List<YouzanTradesSoldGetResult.TradeDetailV2>> resultPair = helper.getTradeList(start, end);

        final Long totalResults = resultPair.getLeft();
        // 有可能查询区间是真的没有订单
        if (totalResults == 0) {
            return ArkCommonResult.ok(new ArrayList<ArkOrder>());
        }

        final List<YouzanTradesSoldGetResult.TradeDetailV2> tradeList = resultPair.getRight();

        final List<ArkOrder> record = TradesSoldGetHelper.toArkOrderList(tradeList);
        if (!CollectionUtils.isEmpty(record)) {
            return ArkCommonResult.ok(record);
        }

        return ArkCommonResult.build(ErrorKeyDef.DEFAULT.getErrorCode(), "sync error.");
    }

    @Override
    public ArkOrder getArkOrderByTid(String tid) throws YouzanApiException {
        if (StringUtils.isEmpty(tid)) {
            return null;
        }

        YouzanToken token = getToken();
        if (token == null) {
            return null;
        }

        try {
            final String accessToken = token.getAccessToken();

            YZClient client = new DefaultYZClient(new Token(accessToken));
            YouzanTradeGetParams youzanTradeGetParams = new YouzanTradeGetParams();

            youzanTradeGetParams.setTid(tid);

            YouzanTradeGet youzanTradeGet = new YouzanTradeGet();
            youzanTradeGet.setAPIParams(youzanTradeGetParams);
            YouzanTradeGetResult result = client.invoke(youzanTradeGet);

            final Long fansId = result.getFullOrderInfo().getBuyerInfo().getFansId();
            final YouzanUsersWeixinFollowerGetResult.CrmWeixinFans youzanUserInfo = getYouzanUserInfo(fansId);

            return ArkOrderPojoHelper.toArkOrder(result, youzanUserInfo);
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }

    }

    @Override
    public YouzanTradeGetResult getYouzanTradeGetResultByTid(String tid) throws YouzanApiException{
        if (StringUtils.isEmpty(tid)) {
            return null;
        }
        YouzanToken token = getToken();
        if (token == null) {
            return null;
        }
        try {
            final String accessToken = token.getAccessToken();

            YZClient client = new DefaultYZClient(new Token(accessToken));
            YouzanTradeGetParams youzanTradeGetParams = new YouzanTradeGetParams();

            youzanTradeGetParams.setTid(tid);

            YouzanTradeGet youzanTradeGet = new YouzanTradeGet();
            youzanTradeGet.setAPIParams(youzanTradeGetParams);
            YouzanTradeGetResult result = client.invoke(youzanTradeGet);
            return result;
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }
    }

    @Override
    public List<YouzanUmpCouponsUnfinishedSearchResult.UmpCoupon> getYouzanConponList() throws YouzanApiException {
        YouzanToken token = getToken();
        if (token == null) {
            return null;
        }

        try {
            String accessToken = token.getAccessToken();
            YZClient client = new DefaultYZClient(new Token(accessToken));
            YouzanUmpCouponsUnfinishedSearchParams youzanUmpCouponsUnfinishedSearchParams = new YouzanUmpCouponsUnfinishedSearchParams();

            YouzanUmpCouponsUnfinishedSearch youzanUmpCouponsUnfinishedSearch = new YouzanUmpCouponsUnfinishedSearch();
            youzanUmpCouponsUnfinishedSearch.setAPIParams(youzanUmpCouponsUnfinishedSearchParams);
            YouzanUmpCouponsUnfinishedSearchResult couponsResult = client.invoke(youzanUmpCouponsUnfinishedSearch);
            YouzanUmpCouponsUnfinishedSearchResult.UmpCoupon[] coupons = couponsResult.getCoupons();
            ArrayList<YouzanUmpCouponsUnfinishedSearchResult.UmpCoupon> umpCoupons = new ArrayList<>(Arrays.asList(coupons));
            return umpCoupons;
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }

    }

    @Override
    public YouzanUmpPromocodeAddResult.UmpPromotionCode addCode(String title, String code) throws YouzanApiException {
        YouzanToken token = getToken();
        if (token == null) {
            return null;
        }

        try {
            String accessToken = token.getAccessToken();
            YZClient client = new DefaultYZClient(new Token(accessToken));
            YouzanUmpPromocodeAddParams youzanUmpPromocodeAddParams = new YouzanUmpPromocodeAddParams();

            youzanUmpPromocodeAddParams.setTitle(title);
            youzanUmpPromocodeAddParams.setCodeType("general");
            youzanUmpPromocodeAddParams.setCode(code);
            youzanUmpPromocodeAddParams.setTotal(1000L);
            youzanUmpPromocodeAddParams.setValue(50.0f);
            youzanUmpPromocodeAddParams.setIsAtLeast(1L);
            youzanUmpPromocodeAddParams.setAtLeast(299.0f);
            youzanUmpPromocodeAddParams.setQuota(1L);
            youzanUmpPromocodeAddParams.setStartAt(new DateTime(2018, 7, 2, 0, 0).toDate());
            youzanUmpPromocodeAddParams.setEndAt(new DateTime(2018, 11, 1, 0, 0).toDate());
            // 暂时不需要打标签
            //        youzanUmpPromocodeAddParams.setMarkTagIds("3930109");
            youzanUmpPromocodeAddParams.setRangeType("PART");
            youzanUmpPromocodeAddParams.setSpecifyItemIds("412669687");
            youzanUmpPromocodeAddParams.setExpireNotice(0L);
            youzanUmpPromocodeAddParams.setIsForbidPreference(1L);
            youzanUmpPromocodeAddParams.setDescription("此优惠码为老用户专属优惠码，新用户领取后下单立减50元。");

            YouzanUmpPromocodeAdd youzanUmpPromocodeAdd = new YouzanUmpPromocodeAdd();
            youzanUmpPromocodeAdd.setAPIParams(youzanUmpPromocodeAddParams);
            YouzanUmpPromocodeAddResult result = client.invoke(youzanUmpPromocodeAdd);
            YouzanUmpPromocodeAddResult.UmpPromotionCode promocode = result.getPromocode();
            return promocode;
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }

    }

    @Override
    public YouzanUsersWeixinFollowerGetResult.CrmWeixinFans getYouzanUserInfo(long fansId) throws YouzanApiException {
        YouzanToken token = getToken();
        if (token == null) {
            return null;
        }

        try {
            final String accessToken = token.getAccessToken();
            YZClient client = new DefaultYZClient(new Token(accessToken));
            YouzanUsersWeixinFollowerGetParams youzanUsersWeixinFollowerGetParams = new YouzanUsersWeixinFollowerGetParams();

            youzanUsersWeixinFollowerGetParams.setFansId(fansId);

            YouzanUsersWeixinFollowerGet youzanUsersWeixinFollowerGet = new YouzanUsersWeixinFollowerGet();
            youzanUsersWeixinFollowerGet.setAPIParams(youzanUsersWeixinFollowerGetParams);
            YouzanUsersWeixinFollowerGetResult result = client.invoke(youzanUsersWeixinFollowerGet);
            final YouzanUsersWeixinFollowerGetResult.CrmWeixinFans user = result.getUser();
            return user;
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }

    }

    @Override
    public YouzanUsersWeixinFollowerGetResult.CrmWeixinFans getYouzanUserInfoByWxOpenId(String openId) throws YouzanApiException {
        YouzanToken token = getToken();
        if (token == null) {
            return null;
        }

        try {
            final String accessToken = token.getAccessToken();
            YZClient client = new DefaultYZClient(new Token(accessToken));
            YouzanUsersWeixinFollowerGetParams youzanUsersWeixinFollowerGetParams = new YouzanUsersWeixinFollowerGetParams();

            youzanUsersWeixinFollowerGetParams.setWeixinOpenid(openId);

            YouzanUsersWeixinFollowerGet youzanUsersWeixinFollowerGet = new YouzanUsersWeixinFollowerGet();
            youzanUsersWeixinFollowerGet.setAPIParams(youzanUsersWeixinFollowerGetParams);
            YouzanUsersWeixinFollowerGetResult result = client.invoke(youzanUsersWeixinFollowerGet);
            final YouzanUsersWeixinFollowerGetResult.CrmWeixinFans user = result.getUser();
            return user;
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }
    }

    @Override
    public List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> getFansList() throws YouzanApiException {
        List<YouzanUsersWeixinFollowersInfoPullResult.WeixinFansCustomerInfo> result = new ArrayList<>();
        YouzanToken token = getToken();
        if (token == null) {
            return result;
        }

        try {
            final String accessToken = token.getAccessToken();
            FansGetHelper getHelper = new FansGetHelper(accessToken);
            return getHelper.getFansList();
        } catch (Exception e) {
            throw new YouzanApiException(e);
        }
    }

    @Override
    public List<YouzanMultistoreOfflineSearchResult.AccountShopOffline> syncAddressList() throws YouzanApiException {
        YouzanToken token = getToken();
        if (!TokenUtils.isVaild(token)) {
            throw new YouzanApiException("Youzan token invalid, please check.");
        }

        final String accessToken = token.getAccessToken();

        YZClient client = new DefaultYZClient(new Token(accessToken));
        YouzanMultistoreOfflineSearchParams youzanMultistoreOfflineSearchParams = new YouzanMultistoreOfflineSearchParams();

        final long pageSize = 30L;
        youzanMultistoreOfflineSearchParams.setPageSize(pageSize);
        youzanMultistoreOfflineSearchParams.setPageNo(1L);

        YouzanMultistoreOfflineSearch youzanMultistoreOfflineSearch = new YouzanMultistoreOfflineSearch();
        youzanMultistoreOfflineSearch.setAPIParams(youzanMultistoreOfflineSearchParams);
        YouzanMultistoreOfflineSearchResult result = client.invoke(youzanMultistoreOfflineSearch);

        final Long totalResults = result.getCount();
        long totalPageSize;
        if (totalResults % pageSize == 0) {
            totalPageSize = (totalResults / pageSize);
        } else {
            totalPageSize = (totalResults / pageSize) + 1;
        }

        final List<YouzanMultistoreOfflineSearchResult.AccountShopOffline> shopResultList = new ArrayList<>();

        for (long i = 1; i <= totalPageSize; i++) {
            youzanMultistoreOfflineSearchParams.setPageNo(i);
            final YouzanMultistoreOfflineSearchResult tempResult = client.invoke(youzanMultistoreOfflineSearch);
            final YouzanMultistoreOfflineSearchResult.AccountShopOffline[] shopArray = tempResult.getList();
            shopResultList.addAll(Arrays.asList(shopArray));
        }

        if (shopResultList.size() != totalResults) {
            throw new YouzanApiException("syncAddressList error : shopResultList != totalResults");
        }

        return shopResultList;
    }


    @Override
    public YouzanMultistoreAddressGetResult getAddressDetails(Long id) throws YouzanApiException {
        YouzanToken token = getToken();
        if (!TokenUtils.isVaild(token)) {
            throw new YouzanApiException("Youzan token invalid, please check.");
        }
        final String accessToken = token.getAccessToken();
        YZClient client = new DefaultYZClient(new Token(accessToken));
        YouzanMultistoreAddressGetParams youzanMultistoreAddressGetParams = new YouzanMultistoreAddressGetParams();
        youzanMultistoreAddressGetParams.setId(id);
        YouzanMultistoreAddressGet youzanMultistoreAddressGet = new YouzanMultistoreAddressGet();
        youzanMultistoreAddressGet.setAPIParams(youzanMultistoreAddressGetParams);
        YouzanMultistoreAddressGetResult result = client.invoke(youzanMultistoreAddressGet);
        if (result == null) {
            throw new YouzanApiException("syncAddressList error : result == null");
        }
        return result;
    }

    @Override
    public YouzanItemGetResult.ItemDetailOpenModel getYouzanItemByAlias(String alias) throws YouzanApiException {
        YouzanToken token = getToken();
        if (!TokenUtils.isVaild(token)) {
            throw new YouzanApiException("Youzan token invalid, please check.");
        }

        final Token auth = new Token(token.getAccessToken());
        YZClient client = new DefaultYZClient(auth);
        YouzanItemGetParams youzanItemGetParams = new YouzanItemGetParams();
        youzanItemGetParams.setAlias(alias);

        YouzanItemGet youzanItemGet = new YouzanItemGet();
        youzanItemGet.setAPIParams(youzanItemGetParams);
        YouzanItemGetResult result = client.invoke(youzanItemGet);
        final YouzanItemGetResult.ItemDetailOpenModel item = result.getItem();
        return item;
    }
}
