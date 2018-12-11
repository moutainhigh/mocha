package com.efruit.micro.arkmanager.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.DateFormatHelper;
import com.efruit.micro.arkmanager.bean.*;
import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult.Books;
import com.efruit.micro.arkmanager.bean.DispatchingExportAreaOrderResult.FetchUser;
import com.efruit.micro.arkmanager.bean.DispatchingManageResult.ManageOrderDetails;
import com.efruit.micro.arkmanager.config.EnvConfig;
import com.efruit.micro.arkmanager.constant.DispatchingOrderConstant;
import com.efruit.micro.arkmanager.mapper.DispatchingOrderMapper;
import com.efruit.micro.arkmanager.mapper.DispatchingSynSignMapper;
import com.efruit.micro.arkmanager.mq.RabbitMq4Message;
import com.efruit.micro.arkmanager.pojo.*;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.utils.JodaDateUtil;
import com.efruit.micro.youzan.common.YouzanApiException;
import com.efruit.micro.youzan.def.ExpressType;
import com.efruit.micro.youzan.sdk.model.YouzanTradesSoldGetResult.*;
import com.efruit.micro.youzan.service.YouzanService;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanUsersWeixinFollowerGetResult.CrmWeixinFans;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DispatchingOrderServiceImpl implements DispatchingOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingOrderServiceImpl.class);
    @Autowired
    DispatchingOrderMapper mapper;
    @Autowired
    YouzanService youzanService;
    @Autowired
    private OrderSendDateHelper orderSendDateHelper;
    @Autowired
    DispatchingCourierInfoService courierInfoService;
    @Autowired
    DispatchingSynOrderBlackTitleInfoService blackTitleInfoService;

    @Autowired
    DispatchingAddressInfoService addressInfoService;
    @Autowired
    DispatchingFetchCodeInfoService fetchCodeInfoService;
    @Autowired
    RabbitMq4Message rabbitMq4Message;
    @Autowired
    SMSHelper smsHelper;
    @Autowired
    DispatchingTemplateHelper dispatchingTemplateHelper;
    @Autowired
    DispatchingSynSignMapper dispatchingSynSignMapper;
    @Autowired
    EnvConfig envConfig;
    @Autowired
    DispatchingSkuTypeInfoService skuTypeInfoService;
    @Autowired
    DispatchingCommodityInfoService commodityInfoService;
    @Autowired
    DispatchingBuyerInfoService buyerInfoService;
    @Autowired
    DispatchingOrderDetailsService orderDetailsService;
    @Autowired
    DispatchingAreaInfoService areaInfoService;

    private Set<String> updateData = new HashSet<>();
    //是否已经同步过 是：true，否：false
    private boolean isSynAddress;

    @Override
    public boolean save(DispatchingOrder obj) {
        return mapper.insert(obj) > 0;
    }

    @Override
    public boolean save(Map<String, DispatchingOrder> objs) {
        List<DispatchingOrder> objList = new ArrayList<>();
        for (String key : objs.keySet()) {
            objList.add(objs.get(key));
        }
        return save(objList);
    }

    @Override
    public int update(DispatchingOrder order) {
        return mapper.updateByPrimaryKey(order);
    }

    @Override
    public boolean buyerReceiptOK(String tIds) {
        final String[] tIdArray = tIds.split(",");
        int i = 0;
        for (String tid : tIdArray) {
            if (StringUtils.isEmpty(tid)) {
                continue;
            }
            final DispatchingOrder obj = new DispatchingOrder();
            obj.setFetchStatus(DispatchingOrderConstant.STATUS_YES);
            obj.setTid(tid);
            final int row = mapper.updateByPrimaryKeySelective(obj);
            i += row;
        }
        return i == tIdArray.length;
    }

    @Override
    public boolean save(List<DispatchingOrder> objs) {
        if (CollectionUtils.isEmpty(objs)) {
            return false;
        }
        LOGGER.info("-----save dispatching orders List data:{}", JSONObject.toJSONString(objs));
        return mapper.insertList(objs) == objs.size();
    }

    @Override
    public DispatchingOrder getById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void synOrderInfo(Date synDate) {
        //因为是今天下单，次天派送（如果是非工作日，到第一个工作日派送）
        Date startDate = JodaDateUtil.addDay(synDate, -1);
        Date endDate = JodaDateUtil.addSeconds(startDate, 86399);
        LOGGER.info("-----------------------synOrderInfo start Date:{}----------------",JodaDateUtil.date2str(startDate, JodaDateUtil.Pattern.yyyy_MM_dd));

        //是否已经同步，防止一天重复同步
        final List<DispatchingSynSign> dispatchingSynSign = dispatchingSynSignMapper.selectBySynDate(synDate);
        if (dispatchingSynSign != null && dispatchingSynSign.size() > 0) {
            LOGGER.info("synOrderInfo(), not need to syncOrder now. date : {}", DateFormatHelper.formatDate(synDate));
            return;
        }
        //从有赞获取前一天订单数据
        List<StructurizationTrade> structurizationTradeList = getDispatchingOrderDataFromYouZan(startDate, endDate);
        if (CollectionUtils.isEmpty(structurizationTradeList)) {
            LOGGER.info("synOrderInfo  YouZan syn orderList is NULL");
            return;
        }
        //发货时间，周末和节假日不发货
        Date sendDate = orderSendDateHelper.calStartSendDate(startDate);
        //保存数据集合
        manageListData(structurizationTradeList, sendDate);

        final DispatchingSynSign tmpSyncSign = new DispatchingSynSign();
        tmpSyncSign.setCreated(new Date());
        tmpSyncSign.setSynDate(synDate);
        dispatchingSynSignMapper.insert(tmpSyncSign);
    }

    /**
     * 从有赞获取数据
     *
     * @return
     */
    private List<StructurizationTrade> getDispatchingOrderDataFromYouZan(Date startDate, Date endDate) {
        List<StructurizationTrade> structurizationTradeList = null;
        LOGGER.info("synOrderInfo getDate from YouZan startDate:{},endDate:{}", JodaDateUtil.date2str(startDate),JodaDateUtil.date2str(endDate));
        try {
            structurizationTradeList = youzanService.syncOrderV4(startDate, endDate);
        } catch (YouzanApiException e) {
            LOGGER.info("synOrderInfo error.  syncOrderV4 msg:{}", e);
        }
        LOGGER.info("---------------------msg Data:{}", JSONObject.toJSONString(structurizationTradeList));
        return structurizationTradeList;
    }

    private void manageListData(List<StructurizationTrade> structurizationTradeList, Date sendDate) {
        updateData = new TreeSet<>();
        isSynAddress = false;
        Set<String> userTelSet = new HashSet<>();
        //取货码集合
        Map<Long, Set<DispatchingFetchCodeInfo>> fetchCodeMap = new TreeMap<>();
        //规格集合
        Map<Long, DispatchingSkuTypeInfo> skuTypeInfoMap = new HashMap<>();
        //商品集合
        Map<Long, DispatchingCommodityInfo> commodityInfoMap = new HashMap<>();
        //订单集合
        Map<String, DispatchingOrder> orderSMap = new HashMap<>();
        //订单详情集合
        List<DispatchingOrderDetailsInfo> orderDetailsInfos = new ArrayList<>();
        //手机号
        Set<String> telSet = new HashSet<>();
        List<DispatchingBuyerInfo> buyerList = new ArrayList<>();
        //循环获取订单
        for (StructurizationTrade structurizationTrade : structurizationTradeList) {
            //交易明细
            final StructurizationTradeOrderInfo structurizationTradeOrderInfo = structurizationTrade.getFullOrderInfo();
            if (structurizationTradeOrderInfo == null) {
                continue;
            }
            //订单详情
            final StructurizationOrderInfoDetail orderInfo = structurizationTradeOrderInfo.getOrderInfo();
            if (orderInfo == null) {
                continue;
            }
            //订单状态
            final String orderStatus = orderInfo.getStatus();
            if (!(orderStatus.equals(OrderServiceConstant.WAIT_SELLER_SEND_GOODS) || orderStatus.equals("WAIT_BUYER_CONFIRM_GOODS"))) {
                continue;
            }
            //TODO 目前仅支持自提订单
            if (orderInfo.getExpressType() != ExpressType.FETCH) {
                continue;
            }

            //地址类型转换为本地对象
            final DispatchingAddressInfo addressInfo = getDispatchingAddressInfo(structurizationTradeOrderInfo.getAddressInfo());
            if (addressInfo == null) {
                continue;
            }
            final StructurizationTradeBuyerInfoDetail buyerInfoDetail = structurizationTradeOrderInfo.getBuyerInfo();
            //获取购买者
            final String openId = getOpenId(structurizationTradeOrderInfo.getBuyerInfo());
            if (StringUtils.isEmpty(openId)) {
                continue;
            }
            final DispatchingBuyerInfo buyerInfo = getBuyer(buyerInfoDetail, addressInfo.getUser_name(), addressInfo.getUser_tel(), openId);
            if (!buyerInfo.getExist() && userTelSet.add(buyerInfo.getUserMobile())) {
                buyerList.add(buyerInfo);
            }
            //保存购买者
            final Long addressId = addressInfo.getId();
            //获取订单
            final String buyTel = buyerInfo.getUserMobile();
            final DispatchingOrder order = getDispatchingOrder(addressId, buyTel, structurizationTradeOrderInfo);
            if (order == null) {
                continue;
            }
            order.setSendTime(sendDate);

            StructurizationTradeItemDetail[] tradeItemDetails = structurizationTradeOrderInfo.getOrders();
            //获取规格
            skuTypeInfoMap.putAll(getSkuType(tradeItemDetails));
            //获取商品明细
            final Map<Long, DispatchingCommodityInfo> thisOrderCommodityMap = getCommodityInfo(tradeItemDetails);
            commodityInfoMap.putAll(thisOrderCommodityMap);

            orderSMap.put(order.getTid(), order);
            orderDetailsInfos.addAll(getOrderDetail(tradeItemDetails, order));
        }
        //保存规格
        skuTypeInfoService.saveMap(skuTypeInfoMap);
        //保存商品
        commodityInfoService.save(commodityInfoMap);
        //保存购买者
        buyerInfoService.saveList(buyerList);
        //保存配送订单
        save(orderSMap);
        //保存订单明细
        orderDetailsService.saveList(orderDetailsInfos);
    }

    /**
     * 获取订单详情
     *
     * @param tradeItemDetails
     * @param order
     * @return
     */
    private List<DispatchingOrderDetailsInfo> getOrderDetail(StructurizationTradeItemDetail[] tradeItemDetails, DispatchingOrder order) {
        List<DispatchingOrderDetailsInfo> list = new ArrayList<>();
        final String tId = order.getTid();
        for (StructurizationTradeItemDetail tradeItemDetail : tradeItemDetails) {
            final Long cid = tradeItemDetail.getItemId();
            final Long num = tradeItemDetail.getNum();
            final String oid = tradeItemDetail.getOid();
            DispatchingOrderDetailsInfo orderDetailsInfo = new DispatchingOrderDetailsInfo();
            orderDetailsInfo.setCid(cid);
            orderDetailsInfo.setTid(tId);
            orderDetailsInfo.setOrderNum(num);
            orderDetailsInfo.setOid(oid);
            orderDetailsInfo.setRefundState(DispatchingOrderConstant.ORDER_DETAILS_STATE);
            list.add(orderDetailsInfo);
        }
        return list;
    }

    /**
     * 获取地址信息
     *
     * @param addressInfo
     * @return
     */
    private DispatchingAddressInfo getDispatchingAddressInfo(StructurizationTradeAddressInfoDetail addressInfo) {
        //保存地址和用户信息
        DispatchingAddressInfo accountShopInfo = null;
        final String selfFetchInfo = addressInfo.getSelfFetchInfo();
        if (StringUtils.isNotEmpty(selfFetchInfo)) {
            accountShopInfo = JSONObject.parseObject(selfFetchInfo, DispatchingAddressInfo.class);
            final String userTel = accountShopInfo.getUser_tel().replaceAll("\\s*", "");
            accountShopInfo.setUser_tel(userTel);
            //初始化片区
            DispatchingAddressInfo objFromDB = addressInfoService.getDispatchingAddressByShopId(accountShopInfo.getId());
            //没有同步过
            if(!isSynAddress ) {
                if (objFromDB == null || objFromDB.getId() == 0L) {
                    //同步网点
                    addressInfoService.synYouZanOffline();
                    objFromDB = addressInfoService.getDispatchingAddressByShopId(accountShopInfo.getId());
                    isSynAddress = true;
                }
            }
            if (objFromDB == null) {
                return null;
            }
            Long areaId = objFromDB.getAreaId();
            if (areaId == null) {
                areaId = 0L;
            }
            accountShopInfo.setAreaId(areaId);
        }
        return accountShopInfo;
    }

    /**
     * 获取购买者信息
     *
     * @param name
     * @param tel
     * @param userId
     * @return
     */
    private DispatchingBuyerInfo getBuyer(StructurizationTradeBuyerInfoDetail buyerInfoDetail, String name, String tel, String userId) {
        final Long fansId = buyerInfoDetail.getFansId();
        DispatchingBuyerInfo buyerInfo = new DispatchingBuyerInfo();
        buyerInfo.setCreateTime(new Date());
        buyerInfo.setStatus(DispatchingOrderConstant.STATUS_YES);
        buyerInfo.setUserId(userId);
        buyerInfo.setUserName(name);
        buyerInfo.setUserMobile(tel);
        buyerInfo.setFansId(fansId);
        final DispatchingBuyerInfo obj = buyerInfoService.getById(tel);
        if (obj != null) {
            obj.setExist(true);
            return obj;
        }
        buyerInfo.setExist(false);
        return buyerInfo;
    }

    /**
     * 获取openId
     *
     * @param buyerInfoDetail
     * @return
     */
    private String getOpenId(StructurizationTradeBuyerInfoDetail buyerInfoDetail) {
        if (buyerInfoDetail == null) {
            LOGGER.info("insertDispatchingOrder buyerInfoDetail 购买者信息为NULL");
            return null;
        }
        CrmWeixinFans fans = null;
        try {
            fans = youzanService.getYouzanUserInfo(buyerInfoDetail.getFansId());
        } catch (YouzanApiException e) {
            LOGGER.info("syn dispatching order error. get buyer`s fans info from YouZan error", e);
        }
        if (fans == null) {
            LOGGER.info("insertDispatchingOrder CrmWeXinFans 购买者微信信息为NULL ");
            return null;
        }
        //获取openid,主要是发送消息
        String openId = fans.getWeixinOpenid();
        if (StringUtils.isEmpty(openId)) {
            LOGGER.info("insertDispatchingOrder openId 购买者微信openId为NULL ");
            return null;
        }
        return openId;

    }

    /**
     * 获取商品明细
     */
    private Map<Long, DispatchingCommodityInfo> getCommodityInfo(StructurizationTradeItemDetail[] tradeItemDetails) {
        if (tradeItemDetails == null || tradeItemDetails.length <= 0) {
            return new HashMap<>();
        }
        Map<Long, DispatchingCommodityInfo> commodityInfoMap = new HashMap<>();
        //保存配送订单信息
        for (StructurizationTradeItemDetail tradeItemDetail : tradeItemDetails) {
            DispatchingCommodityInfo commodityInfo = new DispatchingCommodityInfo();
            //规格
            final String skuDetail = tradeItemDetail.getSkuPropertiesName();
            Map<String, String> categoryMap = (Map<String, String>) JSONArray.parseArray(skuDetail).get(0);
            Long skuId = Long.parseLong(String.valueOf(categoryMap.get("v_id")));
            //判断商品是否需要添加到配送单里
            final String title = tradeItemDetail.getTitle();
            if (isContainBlackListKeyword(title)) {
                continue;
            }
            BeanUtils.copyProperties(tradeItemDetail, commodityInfo);
            commodityInfo.setCreateTime(new Date());
            commodityInfo.setStatus(DispatchingOrderConstant.STATUS_YES);
            commodityInfo.setSkuId(skuId);
            if (updateData.add(commodityInfo.getItemId().toString())) {
                if (commodityInfoService.getById(tradeItemDetail.getItemId()) != null) {
                    commodityInfoService.update(commodityInfo);
                } else {
                    commodityInfoMap.put(commodityInfo.getItemId(), commodityInfo);
                }
            }

        }
        return commodityInfoMap;
    }

    /**
     * 获取规格
     *
     * @param tradeItemDetails
     * @return
     */
    private Map<Long, DispatchingSkuTypeInfo> getSkuType(StructurizationTradeItemDetail[] tradeItemDetails) {
        if (tradeItemDetails == null || tradeItemDetails.length <= 0) {
            return Collections.EMPTY_MAP;
        }
        Map<Long, DispatchingSkuTypeInfo> skuTypeInfoMap = new HashMap<>();
        //保存配送订单信息
        for (StructurizationTradeItemDetail tradeItemDetail : tradeItemDetails) {
            //规格
            final String skuDetail = tradeItemDetail.getSkuPropertiesName();
            final Map<String, String> categoryMap = (Map) JSONArray.parseArray(skuDetail).get(0);
            final Long v_id = Long.parseLong(String.valueOf(categoryMap.get("v_id")));
            final String v = categoryMap.get("v");
            DispatchingSkuTypeInfo skuTypeInfo = new DispatchingSkuTypeInfo();
            skuTypeInfo.setId(v_id);
            skuTypeInfo.setTitle(v);
            skuTypeInfo.setSkupropertiesname(skuDetail);
            if (updateData.add(v_id.toString())) {
                if (skuTypeInfoService.getById(v_id) != null) {
                    skuTypeInfoService.update(skuTypeInfo);
                } else {
                    skuTypeInfoMap.put(v_id, skuTypeInfo);
                }
            }
        }
        return skuTypeInfoMap;
    }

    /**
     * 获取配送订单
     *
     * @param tradeOrderInfo
     */
    private DispatchingOrder getDispatchingOrder(Long addressId, String buyTel, StructurizationTradeOrderInfo tradeOrderInfo) {
        final StructurizationOrderInfoDetail orderInfo = tradeOrderInfo.getOrderInfo();
        if (getById(orderInfo.getTid()) != null) {
            return null;
        }
        if (mapper.selectByPrimaryKey(orderInfo.getTid()) != null) {
            return null;
        }
        StructurizationTradeRemarkInfoDetail remarkInfoDetail = tradeOrderInfo.getRemarkInfo();
        final String buyerMessage = remarkInfoDetail.getBuyerMessage();
        final String tradeDemo = remarkInfoDetail.getTradeMemo();
        DispatchingOrder order = new DispatchingOrder();
        BeanUtils.copyProperties(orderInfo, order);
        order.setAddressId(addressId);
        order.setBuyerExf(buyerMessage);
        order.setCreateTime(new Date());
        order.setTradeExf(tradeDemo);
        order.setBuyerId(buyTel);
        order.setFetchStatus(DispatchingOrderConstant.ORDER_STATUS_DISPATCHING);
        order.setStatus(OrderServiceConstant.WAIT_BUYER_CONFIRM_GOODS);
        order.setStatusStr(OrderServiceConstant.WAIT_BUYER_CONFIRM_GOODS_STR);
        return order;
    }

    private boolean isContainBlackListKeyword(String orderTile) {
        final List<DispatchingSynOrderBlackTitleInfo> blackTitleInfos = blackTitleInfoService.selectAllValidList();
        if (CollectionUtils.isEmpty(blackTitleInfos)) {
            return false;
        }
        for (DispatchingSynOrderBlackTitleInfo titleInfo : blackTitleInfos) {
            final String title = titleInfo.getTitle();
            if (!StringUtils.isEmpty(title) && StringUtils.contains(orderTile, title)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<DispatchingOrder> getOrderList(Date sendDate) {
        List<DispatchingOrder> orderList = mapper.selectByDateAndAddress(null,sendDate);
        return orderList;
    }

    @Override
    public List<DispatchingOrderListResult> getOrderList(Long addressId, Date sendDate) {
        List<DispatchingBuyerInfo> buyerInfoS = buyerInfoService.selectUserAndItemsByAddressAndDate(addressId, sendDate);
        List<DispatchingOrderListResult> resultList = new ArrayList<>();
        for (DispatchingBuyerInfo buyerInfo : buyerInfoS) {
            List<DispatchingItemInfo> itemInfoList = new ArrayList<>();
            List<DispatchingOrder> orderInfoList = buyerInfo.getOrderList();
            StringBuilder tIdS = new StringBuilder();
            int index = 0;
            int status = 0;
            for (DispatchingOrder orderInfo : orderInfoList) {
                status = orderInfo.getFetchStatus();
                if (index > 0) {
                    tIdS.append(",");
                }
                tIdS.append(orderInfo.getTid());
                itemInfoList.addAll(getDispatchingItemInfo(orderInfo, itemInfoList));
                index++;
            }
            DispatchingOrderListResult result = new DispatchingOrderListResult();
            final DispatchingFetchCodeInfo fetchCodeInfo = buyerInfo.getFetchCodeInfo();
            final String code = fetchCodeInfo.getCode();
            final String userName = buyerInfo.getUserName();
            final String userTel = buyerInfo.getUserMobile();
            final String userId = buyerInfo.getUserId();
            result.setName(userName);
            result.setMobile(userTel);
            result.setItemInfoList(itemInfoList);
            result.setTids(tIdS.toString());
            result.setUserId(userId);
            result.setFetchCode(code);
            result.setStatus(status);
            resultList.add(result);
        }
        LOGGER.info("----------------asdf  data:{}", JSONObject.toJSONString(resultList));
        return resultList;
    }


    @Override
    public Map<String, DispatchingExportAreaOrderResult> selectByDateAndAddress(Date sendDate) {
        Map<String, DispatchingExportAreaOrderResult> resultMap = new HashMap<>();
        final List<DispatchingOrder> dispatchingOrderList = mapper.selectByDateAndAddress(null, sendDate);
        for (DispatchingOrder order : dispatchingOrderList) {
            final DispatchingAddressInfo address = order.getAddress();
            final DispatchingAreaInfo area = address.getAreaInfo();
            DispatchingExportAreaOrderResult orderListResult;
            String areaName = DispatchingOrderConstant.NO_AREA_NAME;
            Long areaId = DispatchingOrderConstant.NO_AREA_ID;
            if (area != null && StringUtils.isNotEmpty(area.getaTitle())) {
                areaName = area.getaTitle();
                areaId = area.getId();
            }

            if (resultMap.containsKey(areaName)) {
                orderListResult = resultMap.get(areaName);
            } else {
                orderListResult = new DispatchingExportAreaOrderResult();
                orderListResult.setAreaName(areaName);
                orderListResult.setAreaId(areaId);
            }

            //获取取货人
            final FetchUser user = getFetchUser(order, orderListResult);
            final String userTel = user.getUserTel();
            final Integer fetchCode = Integer.parseInt(user.getFetchCode());
            Map<Integer, FetchUser> userMap = orderListResult.getUserMap();
            if (!resultMap.containsKey(areaName)) {
                userMap = new TreeMap<>();
                userMap.put(fetchCode, user);
                orderListResult.setUserMap(userMap);
                resultMap.put(areaName, orderListResult);
                continue;
            }
            if (!userMap.containsKey(fetchCode)) {
                userMap.put(fetchCode, user);
                continue;
            }
            final FetchUser _user = userMap.get(fetchCode);
            final List<Books> booksList = user.getBooksList();
            _user.getBooksList().addAll(booksList);
        }
        return resultMap;
    }

    private List<Books> getBooks(List<DispatchingOrderDetailsInfo> detailsInfoList, DispatchingExportAreaOrderResult orderListResult) {
        List<Books> booksList = new ArrayList<>();
        for (DispatchingOrderDetailsInfo orderDetailsInfo : detailsInfoList) {
            Books books = orderListResult.new Books();
            DispatchingCommodityInfo commodityInfo = orderDetailsInfo.getCommodityInfo();
            DispatchingSkuTypeInfo skuTypeInfo = commodityInfo.getSkuTypeInfo();
            final Long num = orderDetailsInfo.getOrderNum();
            final String commodityTitle = commodityInfo.getTitle();
            final Long skuId = skuTypeInfo.getId();
            final String skuTitle = skuTypeInfo.getTitle();
            books.setNum(num.intValue());
            books.setSpecification(skuTitle);
            books.setTitle(commodityTitle);
            books.setSkuId(skuId);
            booksList.add(books);
        }
        return booksList;
    }

    private FetchUser getFetchUser(DispatchingOrder orderInfo, DispatchingExportAreaOrderResult orderListResult) {
        DispatchingBuyerInfo buyerInfo = orderInfo.getBuyer();
        DispatchingAddressInfo address = orderInfo.getAddress();
        FetchUser user = orderListResult.new FetchUser();
        final String addressName = address.getName();
        final Long addressId = address.getId();
        final String userTel = buyerInfo.getUserMobile();
        final String userName = buyerInfo.getUserName();
        final DispatchingFetchCodeInfo fetchCodeInfo = buyerInfo.getFetchCodeInfo();
        if (fetchCodeInfo != null) {
            final String fetchCode = fetchCodeInfo.getCode();
            user.setFetchCode(fetchCode);
        }
        user.setUserTel(userTel);
        user.setUserName(userName);
        user.setAddressName(addressName);
        user.setAddressId(addressId);
        List<DispatchingOrderDetailsInfo> orderDetailsInfoList = orderInfo.getOrderDetailsInfoList();
        List<Books> bookList = getBooks(orderDetailsInfoList, orderListResult);
        user.setBooksList(bookList);
        return user;
    }

    private List<DispatchingItemInfo> getDispatchingItemInfo(DispatchingOrder orderInfo, List<DispatchingItemInfo> allItemInfoList) {
        List<DispatchingItemInfo> itemInfoList = new ArrayList<>();
        final List<DispatchingOrderDetailsInfo> orderDetailsInfoS = orderInfo.getOrderDetailsInfoList();
        for (DispatchingOrderDetailsInfo orderDetailsInfo : orderDetailsInfoS) {
            DispatchingItemInfo itemInfo = new DispatchingItemInfo();
            final DispatchingCommodityInfo commodityInfo = orderDetailsInfo.getCommodityInfo();
            final DispatchingSkuTypeInfo skuTypeInfo = commodityInfo.getSkuTypeInfo();
            final Long orderNum = orderDetailsInfo.getOrderNum();
            final String title = commodityInfo.getTitle();
            final String sku = skuTypeInfo.getTitle();
            final Long skuId = skuTypeInfo.getId();
            final Long cId = commodityInfo.getItemId();
            itemInfo.setcId(cId);
            itemInfo.setTitle(title);
            itemInfo.setSkuId(skuId);
            itemInfo.setSku(sku);
            itemInfo.setCount(orderNum.intValue());
            if (isExistBookOfOrder(allItemInfoList, orderNum.intValue(), cId)) {
                continue;
            }
            itemInfoList.add(itemInfo);
        }
        return itemInfoList;
    }

    /**
     * 如果商品已经存在，就设置个数
     *
     * @param itemInfoList
     * @param count
     * @param itemId
     * @return
     */
    private boolean isExistBookOfOrder(List<DispatchingItemInfo> itemInfoList, int count, Long itemId) {
        if (CollectionUtils.isEmpty(itemInfoList)) {
            return false;
        }
        for (DispatchingItemInfo itemInfo : itemInfoList) {
            if (itemInfo.getcId().intValue() == itemId.intValue()) {
                final int num = itemInfo.getCount();
                itemInfo.setCount(count + num);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<DispatchingManageResult> managerOrderList(DispatchingManageParam param) {
        List<DispatchingManageResult> dispatchingManageResultList = new ArrayList<>();
        List<DispatchingOrder> orderList = mapper.managerOrderList(param);
        for (DispatchingOrder order : orderList) {
            DispatchingManageResult manageResult = new DispatchingManageResult();
            final String tid = order.getTid();
            final DispatchingAddressInfo address = order.getAddress();
            final DispatchingAreaInfo area = address.getAreaInfo();
            String areaName = DispatchingOrderConstant.NO_AREA_NAME;
            if (area != null && StringUtils.isNotEmpty(area.getaTitle())) {
                areaName = area.getaTitle();
            }
            final Date reissueTime = order.getReissueTime();
            Date sendTime = order.getSendTime();
            final int status = order.getFetchStatus();
            final String addressName = address.getName();
            final Long addressId = address.getId();
            manageResult.setTid(tid);
            manageResult.setAddressId(addressId);
            manageResult.setAddressName(addressName);
            manageResult.setAreaName(areaName);
            boolean isReissue = reissueTime != null ? true : false;
            sendTime = reissueTime != null ? reissueTime : sendTime;
            manageResult.setReissue(isReissue);
            manageResult.setSendDate(sendTime);

            DispatchingBuyerInfo buyerInfo = order.getBuyer();
            final String buyerName = buyerInfo.getUserName();
            final String buyerTel = buyerInfo.getUserMobile();
            final String code = buyerInfo.getFetchCodeInfo().getCode();
            manageResult.setStatus(status);
            manageResult.setBuyerName(buyerName);
            manageResult.setBuyerTel(buyerTel);
            manageResult.setFetchCode(code);

            final List<ManageOrderDetails> manageOrderDetailsList = getManageOrderDetailsList(order, manageResult);
            manageResult.setOrderDetailsList(manageOrderDetailsList);
            dispatchingManageResultList.add(manageResult);
        }
        return dispatchingManageResultList;
    }


    /**
     * 获取订单详情
     */
    private List<ManageOrderDetails> getManageOrderDetailsList(DispatchingOrder order, DispatchingManageResult manageResult) {
        List<ManageOrderDetails> manageOrderDetailsList = new ArrayList<>();
        final List<DispatchingOrderDetailsInfo> orderDetailsInfoList = order.getOrderDetailsInfoList();
        for (DispatchingOrderDetailsInfo orderDetailsInfo : orderDetailsInfoList) {
            final DispatchingCommodityInfo commodityInfo = orderDetailsInfo.getCommodityInfo();
            final DispatchingSkuTypeInfo skuTypeInfo = commodityInfo.getSkuTypeInfo();
            final Long num = orderDetailsInfo.getOrderNum();
            final String title = commodityInfo.getTitle();
            final String img = commodityInfo.getPicPath();
            final String skuTitle = skuTypeInfo.getTitle();
            final Long cid = commodityInfo.getItemId();

            ManageOrderDetails manageOrderDetails = manageResult.new ManageOrderDetails();
            manageOrderDetails.setImg(img);
            manageOrderDetails.setCid(cid);
            manageOrderDetails.setNum(num.intValue());
            manageOrderDetails.setSkuTitle(skuTitle);
            manageOrderDetails.setTitle(title);
            manageOrderDetailsList.add(manageOrderDetails);
        }
        return manageOrderDetailsList;
    }

    @Override
    public int updateOrder(DispatchingManageParam param) {
        //参数
        final String tid = param.getTid();
        final Long addressId = param.getAddressId();
        final String tel = param.getBuyerTel();
        final Date sendDate = param.getSendDate();

        //片区id
        final Long _areaId = addressInfoService.getDispatchingAddressByShopId(addressId).getAreaId();
        DispatchingFetchCodeInfo fetchCodeInfo = new DispatchingFetchCodeInfo();
        fetchCodeInfo.setAreaId(_areaId);
        fetchCodeInfo.setSendDate(sendDate);
        fetchCodeInfo.setUserMobile(tel);
        //如果不存在在同一个片区，同一个日期，不存在取货码，就直接保存，否则就更改
        final List<DispatchingFetchCodeInfo> fetchCodeInfoList = fetchCodeInfoService.selectBySelective(fetchCodeInfo);
        fetchCodeInfo.setAddressId(addressId);
        if(CollectionUtils.isEmpty(fetchCodeInfoList)){
            LOGGER.info("----根据片区id:{},sendDate:{},tel:{} 未查到取货码信息，重新生成",_areaId,sendDate,tel);
            //该片区最大的取货码
            final int maxCode = fetchCodeInfoService.getMaxCodeByAddressSendDate(_areaId, sendDate);
            String code = String.valueOf(maxCode + 1);
            fetchCodeInfo.setCode(code);
            //生成新的取货码
            fetchCodeInfoService.save(fetchCodeInfo);
            //修改order
            //修改订单信息
            DispatchingOrder order = getById(tid);
            final String oldTel = order.getBuyerId();
            order.setAddressId(addressId);
            order.setBuyerId(tel);
            order.setFetchStatus(DispatchingOrderConstant.ORDER_STATUS_REISSUE);
            order.setReissueTime(sendDate);
            order.setSendTime(sendDate);
            LOGGER.info("---修改配送订单 Data:{}",JSONObject.toJSONString(order));
            mapper.updateByPrimaryKeySelective(order);

            //修改用户信息
            final DispatchingBuyerInfo buyerInfo = buyerInfoService.getById(tel);
            if(buyerInfo == null){
                buyerInfoService.updateTel(oldTel,tel);
            }
            return 1;
        }
        final Long id = fetchCodeInfoList.get(0).getId();
        fetchCodeInfo.setId(id);
        LOGGER.info("---修改取货码 Data:{}",JSONObject.toJSONString(fetchCodeInfo));
        fetchCodeInfoService.updateSelevte(fetchCodeInfo);

        //修改订单信息
        DispatchingOrder order = getById(tid);
        order.setAddressId(addressId);
        order.setFetchStatus(DispatchingOrderConstant.ORDER_STATUS_REISSUE);
        order.setReissueTime(sendDate);
        order.setSendTime(sendDate);
        mapper.updateByPrimaryKeySelective(order);
        LOGGER.info("---修改订单电话 Data:{}",JSONObject.toJSONString(order));
        return 1;
    }

    @Override
    public int countManagerOrderList(DispatchingManageParam param) {
        return mapper.countManagerOrderList(param);
    }
}
