package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkcommon.utils.DateFormatHelper;
import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.bean.OrderCountModifyInfo;
import com.efruit.micro.arkmanager.bean.OrderModifyInfo;
import com.efruit.micro.arkmanager.bean.QueryResult;
import com.efruit.micro.arkmanager.constant.OrderPeriodType;
import com.efruit.micro.arkmanager.constant.OrderType;
import com.efruit.micro.arkmanager.exception.YouzanOrderSyncException;
import com.efruit.micro.arkmanager.mapper.AOrderMapper;
import com.efruit.micro.arkmanager.mapper.ModifyCountHistoryMapper;
import com.efruit.micro.arkmanager.mapper.ModifyOrderHistoryMapper;
import com.efruit.micro.arkmanager.pojo.*;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.utils.DateTimeHelper;
import com.efruit.micro.arkmanager.utils.SkuDays;
import com.efruit.micro.arkmanager.utils.StatusParser;
import com.efruit.micro.arkmanager.utils.TargetIdUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewOrderServiceImpl implements NewOrderService, OrderServiceConstant {

    private static final int MIN_MODIFY_COUNT = -5;
    private static final int MAX_MODIFY_COUNT = 5;

    private static final Logger LOGGER = LoggerFactory.getLogger(NewOrderServiceImpl.class);

    @Autowired
    private AOrderMapper orderMapper;

    @Autowired
    private YouzanOrderService youzanOrderService;

    @Autowired
    private HolidayInfoService holidayInfoService;

    @Autowired
    private OrderSendDateHelper orderSendDateHelper;

    @Autowired
    private ModifyCountHistoryMapper modifyCountHistoryMapper;

    @Autowired
    private OrderDelayService orderDelayService;

    @Autowired
    private ModifyOrderHistoryMapper modifyOrderHistoryMapper;

    @Autowired
    private SyncInfoService syncInfoService;

    private boolean processOrder(AOrder newOrder) {
        LOGGER.info("start processOrder() tid : {}", newOrder.getTid());
        boolean result = false;

        final String newOrderTid = newOrder.getTid();
        final AOrder existOrder = getOrderByTid(newOrderTid);
        // 订单之前已经同步过
        if (existOrder != null) {
            LOGGER.info("processOrder() tid : {}, existOrder != null, need process existOrder.", newOrder.getTid());
            final String existOrderYouzanStatus = existOrder.getYouzanStatus();
            final String newOrderYouzanStatus = newOrder.getYouzanStatus();

            final boolean isExistOrderVaild = VAILD_STATUS_LIST.contains(existOrderYouzanStatus);
            final boolean isNewOrderVaild = VAILD_STATUS_LIST.contains(newOrderYouzanStatus);

            if (!isExistOrderVaild && isNewOrderVaild) {// 旧订单不可用，新订单可用（如：之前未付款，现在付款了）
                // TODO 计算发货周期
                processNewOrder(newOrder);
                newOrder.setId(existOrder.getId());
                result = orderMapper.updateByPrimaryKey(newOrder) > 0;
            } else if (isExistOrderVaild && !isNewOrderVaild) { // 旧订单可用，新订单不可用（如：之前付款，现在退款了）
                // TODO 更新订单状态,
                newOrder.setId(existOrder.getId());
                result = orderMapper.updateByPrimaryKey(newOrder) > 0;
            } else {
                // TODO 更新订单状态
                newOrder.setId(existOrder.getId());
                result = orderMapper.updateByPrimaryKey(newOrder) > 0;
            }

        } else {
            LOGGER.info("processOrder() tid : {}, existOrder == null, need process newOrder.", newOrder.getTid());
            processNewOrder(newOrder);
            result = orderMapper.insert(newOrder) > 0;
        }

        return result;
    }

    private void processNewOrder(AOrder order) {

        final String productSku = order.getProductSku();
        order.setOrderPeriodType(OrderPeriodType.parse(productSku));
        order.setOrderType(OrderType.NEW);

        final String youzanStatus = order.getYouzanStatus();
        final boolean isOrderVaild = VAILD_STATUS_LIST.contains(youzanStatus);
        if (isOrderVaild) {
            final SkuDays orderSkuDays = SkuDays.parse(productSku);
            final int days = orderSkuDays.getDays();
            order.setInitialOrderDay(days);
            order.setRenewLaterDay(days);
            order.setOrderValidStatus(ORDER_STATUS_VALID);

            final Date payTime = order.getPayTime();
            final Date orderStartSendDate = orderSendDateHelper.calStartSendDate(payTime);
            order.setOrderStartSendDate(orderStartSendDate);

            final Date lastDate = orderSendDateHelper.calLastDate(orderStartSendDate, days);
            order.setLastDate(lastDate);
        }
    }

    private boolean isOrderEmpty() {
        return orderMapper.countByExample(new AOrderExample()) == 0;
    }

    @Override
    public ArkCommonResult loadOrderList() {
        LOGGER.info("loadOrderList() start ...");
        if (!isOrderEmpty()) {
            final Date lastOrderDate = getLastSyncDate();
            return loadOrderList(lastOrderDate, new Date());
        }
        List<AOrder> allOrder = null;
        try {
            allOrder = youzanOrderService.getAllOrder();
        } catch (YouzanOrderSyncException e) {
            return ArkCommonResult.fail(e.getMessage());
        }

        if (allOrder == null) {
            return ArkCommonResult.fail();
        }

        for (AOrder order : allOrder) {
            processNewOrder(order);
        }

        final int result = saveOrderList(allOrder);
        if (result > 0 && result != allOrder.size()) {
            return ArkCommonResult.fail("Sync Order failed, result : " + result + ", allOrder.size() : " + allOrder.size());
        }

        final AOrder lastOrder = orderMapper.getLastOrder();
        saveSyncInfo(lastOrder.getCreated(), lastOrder.getTid());

        return ArkCommonResult.ok();
    }

    private Date getLastSyncDate() {
        final SyncInfo lastSyncInfo = syncInfoService.getLastSyncInfo();
        Date lastOrderDate = null;
        if (lastSyncInfo != null) {
            lastOrderDate = lastSyncInfo.getLastOrderDate();
        }

        if (lastOrderDate == null) {
            AOrder order = orderMapper.getLastOrder();
            lastOrderDate = order.getCreated();
        }
        return lastOrderDate;
    }

    private void saveSyncInfo(Date lastDate, String lastTid) {
        SyncInfo syncInfo = new SyncInfo();
        syncInfo.setCreated(new Date());
        syncInfo.setLastOrderDate(lastDate);
        syncInfo.setLastOrderTid(lastTid);
        syncInfoService.saveSyncInfo(syncInfo);
    }

    private int saveOrderList(List<AOrder> orderList) {
        return orderMapper.insertOrderList(orderList);
    }

    @Override
    public ArkCommonResult loadOrderList(Date start, Date end) {
        List<AOrder> orderList = null;
        try {
            orderList = youzanOrderService.getOrderList(start, end);
        } catch (YouzanOrderSyncException e) {
            return ArkCommonResult.fail("loadOrderList error : " + e.getMessage());
        }

        if (orderList == null) {
            return ArkCommonResult.fail();
        }

        SyncInfo syncInfo = new SyncInfo();
        syncInfo.setCreated(new Date());
        DateTime lastDateTime = null;
        for (AOrder order : orderList) {
            final boolean isSuccess = processOrder(order);
            if (!isSuccess) {
                if (syncInfo.getLastOrderDate() != null) {
                    syncInfoService.saveSyncInfo(syncInfo);
                }
                return ArkCommonResult.fail("processOrder fail, tid : " + order.getTid());
            }

            final Date created = order.getCreated();
            if (lastDateTime == null) {
                lastDateTime = new DateTime(created);
            } else {
                lastDateTime = DateTimeHelper.maxDateTime(lastDateTime, new DateTime(created));
            }
            syncInfo.setLastOrderTid(order.getTid());
            syncInfo.setLastOrderDate(lastDateTime.toDate());
        }

        if (syncInfo.getLastOrderDate() != null) {
            syncInfoService.saveSyncInfo(syncInfo);
        }

        return ArkCommonResult.ok();
    }

    @Override
    public ArkCommonResult addOrder(AOrder order) {
        final boolean isSuccess = processOrder(order);
        if (isSuccess) {
            return ArkCommonResult.ok();
        }
        return ArkCommonResult.fail();
    }

    @Override
    public ArkCommonResult getOrderList(OrderCondition condition) {
        final int selectFrom = condition.getSelectFrom();
        if (selectFrom == OrderCondition.SELECT_FROM_DELIVER_EXPORT) {
            condition.setEndDate(null);
            condition.setStartDate(null);
            condition.setSize(0);
            condition.setPage(0);
            condition.setIndex(0);
        } else if (selectFrom == OrderCondition.SELECT_FROM_CUSTOM_BATCH_TAGGING) {
            condition.setTargetDate(null);
            condition.setSize(0);
            condition.setPage(0);
            condition.setIndex(0);
        } else {
            final Date startDate = condition.getStartDate();
            final Date endDate = condition.getEndDate();
            if (startDate != null || endDate != null) {
                condition.setTargetDate(null);
            }
            if (condition.getPage() == 0) {
                condition.setPage(DEFAULT_PAGE);
            }

            if (condition.getSize() <= 0) {
                condition.setSize(MIN_PAGE_SIZE);
            }

            condition.setIndex((condition.getPage() - 1) * condition.getSize());
        }

        final boolean onlyNeedValid = StatusParser.toBoolean(condition.getOnlyNeedValid());
        if (onlyNeedValid) {
            condition.setOrderStatusList(VAILD_STATUS_LIST);
        }
        List<AOrder> resultData = new ArrayList<>();

        List<AOrder> orderList = orderMapper.getOrderList(condition);
        if (!CollectionUtils.isEmpty(orderList)) {
            resultData.addAll(orderList);
        }
        int count = orderMapper.getOrderListCount(condition);
        QueryResult<AOrder> queryResult = new QueryResult<>();
        queryResult.setCount(count);
        queryResult.setList(resultData);
        return ArkCommonResult.ok(queryResult);
    }

    @Override
    public AOrder getOrderById(long orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public AOrder getOrderByTid(String tid) {
        AOrderExample orderExample = new AOrderExample();
        AOrderExample.Criteria exampleCriteria = orderExample.createCriteria();
        exampleCriteria.andTidEqualTo(tid);
        final List<AOrder> orders = orderMapper.selectByExample(orderExample);
        if (!CollectionUtils.isEmpty(orders)) {
            return orders.get(0);
        }

        return null;
    }

    @Override
    public ArkCommonResult modifyOrderCount(OrderCountModifyInfo modifyInfo) {

        final long orderId = modifyInfo.getOrderId();
        final long orderParentId = modifyInfo.getOrderParentId();

        final long targetId = TargetIdUtils.getTargetId(orderId, orderParentId);

        final AOrder order = orderMapper.selectByPrimaryKey(targetId);
        if (order == null) {
            return ArkCommonResult.fail("Order is null, orderId : " + orderId + ", orderParentId : " + orderParentId);
        }

        int modifyCount = modifyInfo.getModifyCount();
        final int fromType = modifyInfo.getFromType();
        if (fromType != OrderCountModifyInfo.FROME_TYPE_DELAY) {
            if (modifyCount < MIN_MODIFY_COUNT) {
                modifyCount = MIN_MODIFY_COUNT;
            } else if (modifyCount > MAX_MODIFY_COUNT) {
                modifyCount = MAX_MODIFY_COUNT;
            }
        }

        final Integer beforeCount = order.getRenewLaterDay();
        int afterCount = beforeCount + modifyCount;
        if (afterCount < 0) {
            afterCount = 0;
        }
        order.setRenewLaterDay(afterCount);
        final boolean updateSuc = orderMapper.updateByPrimaryKeySelective(order) > 0;
        if (!updateSuc) {
            return ArkCommonResult.fail("modify error.");
        }

        final ModifyCountHistory countHistory = new ModifyCountHistory();
        countHistory.setOrderId(targetId);
        countHistory.setModifyCount(modifyCount);
        countHistory.setBeforeCount(beforeCount);
        countHistory.setAfterCount(afterCount);
        countHistory.setModifyTime(new Date());
        countHistory.setModifyMsg(modifyInfo.getModifyMsg());
        countHistory.setModifyUser(modifyInfo.getModifyUser());
        countHistory.setFromType(modifyInfo.getFromType());
        modifyCountHistoryMapper.insert(countHistory);

        return ArkCommonResult.ok(countHistory);
    }

    @Override
    public ArkCommonResult updateOrderDelay(OrderModifyInfo modifyInfo) {
        LOGGER.info("updateOrderDelay() deleteCount : {}", modifyInfo);
        final long orderId = modifyInfo.getOrderId();
        final long orderParentId = modifyInfo.getOrderParentId();
        final long targetId = TargetIdUtils.getTargetId(orderId, orderParentId);

        if (targetId < 0) {
            return ArkCommonResult.fail("targetId < 0, please check!");
        }

        final AOrder oldOrder = getOrderById(targetId);
        if (oldOrder == null) {
            return ArkCommonResult.fail("oldOrder == null, please check!");
        }

        // 目前可用延期信息
        final List<Date> oldDateList = getValidDelayDate(targetId);

        ModifyOrderHistory orderHistory = new ModifyOrderHistory();
        orderHistory.setOrderId(targetId);
        orderHistory.setModifyTime(new Date());
        orderHistory.setModifyFrom(1);
        orderHistory.setModifyUser("Admin");
        orderHistory.setBeforeOrderInfo(oldOrder.toString());
        orderHistory.setBeforeDelayInfo(DateFormatHelper.formatDateList(oldDateList));

        // 先更新订单信息
        final int updateCount = updateOrderInfo(modifyInfo, oldOrder);
        if (updateCount <= 0) {
            return ArkCommonResult.fail("update order error.");
        }

        final List<Date> dayList = modifyInfo.getDayList();
        // 新增的可用延期信息
        final List<Date> newDateList = getCanDelayDateList(dayList);
        if (CollectionUtils.isEmpty(newDateList)) {
            orderHistory.setAfterOrderInfo(oldOrder.toString());
            orderHistory.setAfterOrderInfo(DateFormatHelper.formatDateList(oldDateList));
            modifyOrderHistoryMapper.insert(orderHistory);
            return ArkCommonResult.ok();
        }

        // 处理当前延期信息与新增的延期信息合并
        final int beforeSaveCount = oldDateList == null ? 0 : oldDateList.size();

        // 修改延期列表
        final int deleteCount = orderDelayService.deleteOrderDelay(targetId);
        LOGGER.info("updateOrderDelay() deleteCount : {}", deleteCount);

        final List<OrderDelay> newOrderDelayList = toOrderDelayList(newDateList, targetId);
        final int afterSaveCount = orderDelayService.saveOrderDelayList(newOrderDelayList);

        // 修改剩余天数
        int changeCount = afterSaveCount - beforeSaveCount;

        OrderCountModifyInfo countModifyInfo = new OrderCountModifyInfo();
        countModifyInfo.setOrderId(targetId);
        countModifyInfo.setModifyCount(changeCount);
        countModifyInfo.setFromType(OrderCountModifyInfo.FROME_TYPE_DELAY);
        modifyOrderCount(countModifyInfo);

        // 记录修改历史
        final AOrder newOrder = getOrderById(targetId);
        final List<Date> newDelayDateList = getValidDelayDate(targetId);
        orderHistory.setAfterOrderInfo(newOrder.toString());
        orderHistory.setAfterDelayInfo(DateFormatHelper.formatDateList(newDelayDateList));
        modifyOrderHistoryMapper.insert(orderHistory);

        return ArkCommonResult.ok();
    }

    @Override
    public List<String> getAddressList() {
        return orderMapper.getAddressList();
    }

    @Override
    public List<AOrder> getOrderListByTids(List<String> tids) {
        AOrderExample example = new AOrderExample();
        final AOrderExample.Criteria criteria = example.createCriteria();
        criteria.andTidIn(tids);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<AOrder> getOrderListByMobile(List<String> mobiles) {
        AOrderExample example = new AOrderExample();
        final AOrderExample.Criteria criteria = example.createCriteria();
        criteria.andReceiverMobileIn(mobiles);
        return orderMapper.selectByExample(example);
    }

    @Override
    public int getOrderListCountByUserId(String userId) {
        OrderCondition orderCondition = new OrderCondition();
        orderCondition.setOnlyNeedValid(1);
        orderCondition.setUserId(userId);
        orderCondition.setOrderStatusList(VAILD_STATUS_LIST);
        return orderMapper.getOrderListCountByUserId(orderCondition);
    }

    @Override
    public List<String> getUserIdListByMobile(String mobile) {
        final List<String> userIdListByMobile = orderMapper.getUserIdListByMobile(mobile);
        return userIdListByMobile;
    }

    private List<Date> getValidDelayDate(long targetId) {
        OrderCondition orderCondition = new OrderCondition();
        orderCondition.setTargetDate(new Date());
        orderCondition.setOrderId(targetId);
        // 当前的可用的延期信息
        return orderDelayService.getValidDelayDate(orderCondition);
    }

    private int updateOrderInfo(OrderModifyInfo modifyInfo, AOrder orderById) {
        final String receiverAddress = modifyInfo.getReceiverAddress();
        if (!StringUtils.isEmpty(receiverAddress)) {
            orderById.setReceiverAddress(receiverAddress);
        }

        final String receiverName = modifyInfo.getReceiverName();
        if (!StringUtils.isEmpty(receiverName)) {
            orderById.setReceiverName(receiverName);
        }

        final String receiverMobile = modifyInfo.getReceiverMobile();
        if (!StringUtils.isEmpty(receiverMobile)) {
            orderById.setReceiverMobile(receiverMobile);
        }

        final String adminMsg = modifyInfo.getAdminMsg();
        if (!StringUtils.isEmpty(adminMsg)) {
            orderById.setAdminMsg(adminMsg);
        }

        return orderMapper.updateByPrimaryKeySelective(orderById);
    }

    private List<Date> getCanDelayDateList(List<Date> dayList) {
        final List<Date> canDelayList = new ArrayList<>();

        final DateTime tomorrow = DateTimeHelper.getTomorrow();
        for (Date date : dayList) {
            if (!holidayInfoService.isWorkDay(date)) {
                continue;
            }

            DateTime dateTime = new DateTime(date);
            if (dateTime.getMillis() < tomorrow.getMillis()) {
                continue;
            }

            canDelayList.add(date);
        }
        return canDelayList;
    }

    private List<OrderDelay> toOrderDelayList(List<Date> dateList, long orderId) {
        List<OrderDelay> result = new ArrayList<>();
        for (Date date : dateList) {
            OrderDelay orderDelay = new OrderDelay();
            orderDelay.setOrderId(orderId);
            orderDelay.setOrderDelayDate(date);
            result.add(orderDelay);
        }

        return result;
    }

    private List<Date> toDateList(List<OrderDelay> orderDelays) {
        List<Date> result = new ArrayList<>();
        for (OrderDelay orderDelay : orderDelays) {
            result.add(orderDelay.getOrderDelayDate());
        }

        return result;
    }



}
