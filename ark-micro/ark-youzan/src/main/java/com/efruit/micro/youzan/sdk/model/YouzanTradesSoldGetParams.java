package com.efruit.micro.youzan.sdk.model;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.youzan.open.sdk.model.APIParams;
import com.youzan.open.sdk.model.ByteWrapper;
import com.youzan.open.sdk.model.FileParams;

import java.util.List;
import java.util.Map;
import java.util.Date;

public class YouzanTradesSoldGetParams implements APIParams, FileParams {

    /**
     * 买家id
     */
    private Long buyerId;
    /**
     * 交易创建结束时间，例:2017-01-01 12:00:00; 开始时间和结束时间的跨度不能大于3个月; 结束时间必须大于开始时间; 开始时间和结束时间必须成对出现
     */
    private Date endCreated;
    /**
     * 交易状态更新的结束时间，例:2017-01-01 12:00:00; 开始时间和结束时间的跨度不能大于3个月; 结束时间必须大于开始时间; 开始时间和结束时间必须成对出现
     */
    private Date endUpdate;
    /**
     * 粉丝id
     */
    private Long fansId;
    /**
     * 粉丝类型
     */
    private Long fansType;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 门店id
     */
    private Long offlineId;
    /**
     * 来源
     */
    private String orderSource;
    /**
     * 页码
     */
    private Long pageNo;
    /**
     * 每页条数
     */
    private Long pageSize;
    /**
     * 收货人昵称
     */
    private String receiverName;
    /**
     * 收货人手机号
     */
    private String receiverPhone;
    /**
     * 交易创建的开始时间 例:2017-01-01 12:00:00; 开始时间和结束时间的跨度不能大于3个月; 结束时间必须大于开始时间; 开始时间和结束时间必须成对出现
     */
    private Date startCreated;
    /**
     * 交易状态更新的开始时间 例:2017-01-01 12:00:00; 开始时间和结束时间的跨度不能大于3个月; 结束时间必须大于开始时间; 开始时间和结束时间必须成对出现
     */
    private Date startUpdate;
    /**
     * 订单状态，一次只能查询一种状态
     * 待付款：WAIT_BUYER_PAY
     * 待发货：WAIT_SELLER_SEND_GOODS
     * 等待买家确认：WAIT_BUYER_CONFIRM_GOODS
     * 订单完成：TRADE_SUCCESS
     * 订单关闭：TRADE_CLOSE
     * 退款中：TRADE_REFUND
     */
    private String status;
    /**
     * 订单号
     */
    private String tid;
    /**
     * 订单类型
     * NORMAL：普通订单
     * PEERPAY：代付
     * GIFT：我要送人
     * FX_CAIGOUDAN：分销采购单
     * PRESENT：赠品
     * WISH：心愿单
     * QRCODE：二维码订单
     * QRCODE_3RD：线下收银台订单
     * FX_MERGED：合并付货款
     * VERIFIED：1分钱实名认证
     * PINJIAN：品鉴
     * REBATE：返利
     * FX_QUANYUANDIAN：全员开店
     * FX_DEPOSIT：保证金
     * PF：批发
     * GROUP：拼团
     * HOTEL：酒店
     * TAKE_AWAY：外卖
     * CATERING_OFFLINE：堂食点餐
     * CATERING_QRCODE：外卖买单
     * BEAUTY_APPOINTMENT：美业预约单
     * BEAUTY_SERVICE：美业服务单
     * KNOWLEDGE_PAY：知识付费
     * GIFT_CARD：礼品卡
     */
    private String type;

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getBuyerId() {
        return this.buyerId;
    }

    public void setEndCreated(Date endCreated) {
        this.endCreated = endCreated;
    }

    public Date getEndCreated() {
        return this.endCreated;
    }

    public void setEndUpdate(Date endUpdate) {
        this.endUpdate = endUpdate;
    }

    public Date getEndUpdate() {
        return this.endUpdate;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    public Long getFansId() {
        return this.fansId;
    }

    public void setFansType(Long fansType) {
        this.fansType = fansType;
    }

    public Long getFansType() {
        return this.fansType;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setOfflineId(Long offlineId) {
        this.offlineId = offlineId;
    }

    public Long getOfflineId() {
        return this.offlineId;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageNo() {
        return this.pageNo;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    public void setStartCreated(Date startCreated) {
        this.startCreated = startCreated;
    }

    public Date getStartCreated() {
        return this.startCreated;
    }

    public void setStartUpdate(Date startUpdate) {
        this.startUpdate = startUpdate;
    }

    public Date getStartUpdate() {
        return this.startUpdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTid() {
        return this.tid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }


    public Map<String, Object> toParams() {
        Map<String, Object> params = Maps.newHashMap();
        if (buyerId != null) {
            params.put("buyer_id", buyerId);
        }
        if (endCreated != null) {
            params.put("end_created", endCreated);
        }
        if (endUpdate != null) {
            params.put("end_update", endUpdate);
        }
        if (fansId != null) {
            params.put("fans_id", fansId);
        }
        if (fansType != null) {
            params.put("fans_type", fansType);
        }
        if (itemId != null) {
            params.put("item_id", itemId);
        }
        if (offlineId != null) {
            params.put("offline_id", offlineId);
        }
        if (orderSource != null) {
            params.put("order_source", orderSource);
        }
        if (pageNo != null) {
            params.put("page_no", pageNo);
        }
        if (pageSize != null) {
            params.put("page_size", pageSize);
        }
        if (receiverName != null) {
            params.put("receiver_name", receiverName);
        }
        if (receiverPhone != null) {
            params.put("receiver_phone", receiverPhone);
        }
        if (startCreated != null) {
            params.put("start_created", startCreated);
        }
        if (startUpdate != null) {
            params.put("start_update", startUpdate);
        }
        if (status != null) {
            params.put("status", status);
        }
        if (tid != null) {
            params.put("tid", tid);
        }
        if (type != null) {
            params.put("type", type);
        }
        return params;
    }

    public Multimap<String, ByteWrapper> toFileParams() {
        Multimap<String, ByteWrapper> params = ArrayListMultimap.create();

        return params;
    }


}