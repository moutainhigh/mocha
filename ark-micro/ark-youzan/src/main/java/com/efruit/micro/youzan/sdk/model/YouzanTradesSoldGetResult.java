package com.efruit.micro.youzan.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youzan.open.sdk.model.APIResult;

import java.util.Date;

public class YouzanTradesSoldGetResult implements APIResult {

    @JsonProperty(value = "full_order_info_list")
    /**
     * 交易基础信息结构体
     */
    private StructurizationTrade[] fullOrderInfoList;
    @JsonProperty(value = "total_results")
    /**
     * 搜索订单总条数
     */
    private Long totalResults;

    public void setFullOrderInfoList(StructurizationTrade[] fullOrderInfoList) {
        this.fullOrderInfoList = fullOrderInfoList;
    }

    public StructurizationTrade[] getFullOrderInfoList() {
        return this.fullOrderInfoList;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Long getTotalResults() {
        return this.totalResults;
    }

    public static class StructurizationOrderInfoDetailExtra {
        @JsonProperty(value = "is_from_cart")
        /**
         * 是否来自购物车 是：true 不是：false
         */
        private String isFromCart;
        @JsonProperty(value = "cashier_id")
        /**
         * 收银员id
         */
        private String cashierId;
        @JsonProperty(value = "cashier_name")
        /**
         * 收银员名字
         */
        private String cashierName;
        @JsonProperty(value = "invoice_title")
        /**
         * 发票抬头
         */
        private String invoiceTitle;
        @JsonProperty(value = "settle_time")
        /**
         * 结算时间
         */
        private String settleTime;
        @JsonProperty(value = "is_parent_order")
        /**
         * 是否父单(分销合并订单) 是：1 其他：null
         */
        private String isParentOrder;
        @JsonProperty(value = "is_sub_order")
        /**
         * 是否子单(分销买家订单) 是：1 其他：null
         */
        private String isSubOrder;
        @JsonProperty(value = "fx_order_no")
        /**
         * 分销单订单号
         */
        private String fxOrderNo;
        @JsonProperty(value = "fx_kdt_id")
        /**
         * 分销店铺id
         */
        private String fxKdtId;
        @JsonProperty(value = "parent_order_no")
        /**
         * 父单号
         */
        private String parentOrderNo;
        @JsonProperty(value = "purchase_order_no")
        /**
         * 采购单订单号
         */
        private String purchaseOrderNo;
        @JsonProperty(value = "dept_id")
        /**
         * 美业分店id
         */
        private String deptId;
        @JsonProperty(value = "create_device_id")
        /**
         * 下单设备号
         */
        private String createDeviceId;

        public void setIsFromCart(String isFromCart) {
            this.isFromCart = isFromCart;
        }

        public String getIsFromCart() {
            return this.isFromCart;
        }

        public void setCashierId(String cashierId) {
            this.cashierId = cashierId;
        }

        public String getCashierId() {
            return this.cashierId;
        }

        public void setCashierName(String cashierName) {
            this.cashierName = cashierName;
        }

        public String getCashierName() {
            return this.cashierName;
        }

        public void setInvoiceTitle(String invoiceTitle) {
            this.invoiceTitle = invoiceTitle;
        }

        public String getInvoiceTitle() {
            return this.invoiceTitle;
        }

        public void setSettleTime(String settleTime) {
            this.settleTime = settleTime;
        }

        public String getSettleTime() {
            return this.settleTime;
        }

        public void setIsParentOrder(String isParentOrder) {
            this.isParentOrder = isParentOrder;
        }

        public String getIsParentOrder() {
            return this.isParentOrder;
        }

        public void setIsSubOrder(String isSubOrder) {
            this.isSubOrder = isSubOrder;
        }

        public String getIsSubOrder() {
            return this.isSubOrder;
        }

        public void setFxOrderNo(String fxOrderNo) {
            this.fxOrderNo = fxOrderNo;
        }

        public String getFxOrderNo() {
            return this.fxOrderNo;
        }

        public void setFxKdtId(String fxKdtId) {
            this.fxKdtId = fxKdtId;
        }

        public String getFxKdtId() {
            return this.fxKdtId;
        }

        public void setParentOrderNo(String parentOrderNo) {
            this.parentOrderNo = parentOrderNo;
        }

        public String getParentOrderNo() {
            return this.parentOrderNo;
        }

        public void setPurchaseOrderNo(String purchaseOrderNo) {
            this.purchaseOrderNo = purchaseOrderNo;
        }

        public String getPurchaseOrderNo() {
            return this.purchaseOrderNo;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getDeptId() {
            return this.deptId;
        }

        public void setCreateDeviceId(String createDeviceId) {
            this.createDeviceId = createDeviceId;
        }

        public String getCreateDeviceId() {
            return this.createDeviceId;
        }

    }

    public static class StructurizationTrade {
        @JsonProperty(value = "full_order_info")
        /**
         * 交易基础信息结构体
         */
        private StructurizationTradeOrderInfo fullOrderInfo;
        @JsonProperty(value = "refund_order")
        /**
         * 订单退款信息结构体
         */
        private StructurizationTradeRefundInfoDetail[] refundOrder;
        @JsonProperty(value = "delivery_order")
        /**
         * 交易物流信息结构体
         */
        private StructurizationTradeDeliveryDetail[] deliveryOrder;
        @JsonProperty(value = "order_promotion")
        /**
         * 交易优惠信息结构体
         */
        private StructurizationTradePromotionInfoDetail orderPromotion;

        public void setFullOrderInfo(StructurizationTradeOrderInfo fullOrderInfo) {
            this.fullOrderInfo = fullOrderInfo;
        }

        public StructurizationTradeOrderInfo getFullOrderInfo() {
            return this.fullOrderInfo;
        }

        public void setRefundOrder(StructurizationTradeRefundInfoDetail[] refundOrder) {
            this.refundOrder = refundOrder;
        }

        public StructurizationTradeRefundInfoDetail[] getRefundOrder() {
            return this.refundOrder;
        }

        public void setDeliveryOrder(StructurizationTradeDeliveryDetail[] deliveryOrder) {
            this.deliveryOrder = deliveryOrder;
        }

        public StructurizationTradeDeliveryDetail[] getDeliveryOrder() {
            return this.deliveryOrder;
        }

        public void setOrderPromotion(StructurizationTradePromotionInfoDetail orderPromotion) {
            this.orderPromotion = orderPromotion;
        }

        public StructurizationTradePromotionInfoDetail getOrderPromotion() {
            return this.orderPromotion;
        }

    }

    public static class StructurizationTradeBuyerInfoDetail {
        @JsonProperty(value = "buyer_id")
        /**
         * 买家id
         */
        private Long buyerId;
        @JsonProperty(value = "buyer_phone")
        /**
         * 买家手机号
         */
        private String buyerPhone;
        @JsonProperty(value = "fans_type")
        /**
         * 粉丝类型
         1:自有粉丝; 9:代销粉丝
         */
        private Long fansType;
        @JsonProperty(value = "fans_id")
        /**
         * 粉丝id
         */
        private Long fansId;
        @JsonProperty(value = "fans_nickname")
        /**
         * 粉丝昵称
         */
        private String fansNickname;

        public void setBuyerId(Long buyerId) {
            this.buyerId = buyerId;
        }

        public Long getBuyerId() {
            return this.buyerId;
        }

        public void setBuyerPhone(String buyerPhone) {
            this.buyerPhone = buyerPhone;
        }

        public String getBuyerPhone() {
            return this.buyerPhone;
        }

        public void setFansType(Long fansType) {
            this.fansType = fansType;
        }

        public Long getFansType() {
            return this.fansType;
        }

        public void setFansId(Long fansId) {
            this.fansId = fansId;
        }

        public Long getFansId() {
            return this.fansId;
        }

        public void setFansNickname(String fansNickname) {
            this.fansNickname = fansNickname;
        }

        public String getFansNickname() {
            return this.fansNickname;
        }

    }

    public static class StructurizationTradeRefundInfoDetail {
        @JsonProperty(value = "refund_type")
        /**
         * 退款类型
         1:退款 - 买家申请退款; 2:退款 - 商家主动退款; 3:退款 - 一键退款
         */
        private Long refundType;
        @JsonProperty(value = "refund_fee")
        /**
         * 退款金额
         */
        private Float refundFee;
        @JsonProperty(value = "refund_id")
        /**
         * 退款id
         */
        private String refundId;
        @JsonProperty(value = "refund_state")
        /**
         * 退款状态
         1:买家已经申请退款，等待卖家同意;  10:卖家拒绝退款;  20:卖家已经同意退货，等待买家退货;  30:买家已经退货，等待卖家确认收货;  40:卖家未收到货,拒绝退款;  50:退款关闭;  60:退款成功;
         */
        private Long refundState;
        @JsonProperty(value = "oids")
        /**
         * 退款交易明细信息
         */
        private StructurizationTradeRefundItemDetail[] oids;

        public void setRefundType(Long refundType) {
            this.refundType = refundType;
        }

        public Long getRefundType() {
            return this.refundType;
        }

        public void setRefundFee(Float refundFee) {
            this.refundFee = refundFee;
        }

        public Float getRefundFee() {
            return this.refundFee;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public String getRefundId() {
            return this.refundId;
        }

        public void setRefundState(Long refundState) {
            this.refundState = refundState;
        }

        public Long getRefundState() {
            return this.refundState;
        }

        public void setOids(StructurizationTradeRefundItemDetail[] oids) {
            this.oids = oids;
        }

        public StructurizationTradeRefundItemDetail[] getOids() {
            return this.oids;
        }

    }

    public static class StructurizationTradeDeliveryItemDetail {
        @JsonProperty(value = "oid")
        /**
         * 交易明细id
         */
        private String oid;

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getOid() {
            return this.oid;
        }

    }

    public static class StructurizationTradeDeliveryDetail {
        @JsonProperty(value = "pk_id")
        /**
         * 包裹id
         */
        private Long pkId;
        @JsonProperty(value = "express_state")
        /**
         * 物流状态
         0:待发货; 1:已发货
         */
        private Long expressState;
        @JsonProperty(value = "express_type")
        /**
         * 物流类型
         0:手动发货; 1:系统自动发货
         */
        private Long expressType;
        @JsonProperty(value = "oids")
        /**
         * 交易明细发货信息
         */
        private StructurizationTradeDeliveryItemDetail[] oids;

        public void setPkId(Long pkId) {
            this.pkId = pkId;
        }

        public Long getPkId() {
            return this.pkId;
        }

        public void setExpressState(Long expressState) {
            this.expressState = expressState;
        }

        public Long getExpressState() {
            return this.expressState;
        }

        public void setExpressType(Long expressType) {
            this.expressType = expressType;
        }

        public Long getExpressType() {
            return this.expressType;
        }

        public void setOids(StructurizationTradeDeliveryItemDetail[] oids) {
            this.oids = oids;
        }

        public StructurizationTradeDeliveryItemDetail[] getOids() {
            return this.oids;
        }

    }

    public static class StructurizationTradePromotionInfoDetail {
        @JsonProperty(value = "item")
        /**
         * 订单商品级优惠结构结构体
         */
        private StructurizationTradePromotionItemDetail[] item;
        @JsonProperty(value = "order")
        /**
         * 优惠明细结构体
         */
        private StructurizationTradePromotionDetail[] order;
        @JsonProperty(value = "item_discount_fee")
        /**
         * 商品优惠总金额
         */
        private Float itemDiscountFee;
        @JsonProperty(value = "order_discount_fee")
        /**
         * 订单优惠总金额
         */
        private Float orderDiscountFee;

        public void setItem(StructurizationTradePromotionItemDetail[] item) {
            this.item = item;
        }

        public StructurizationTradePromotionItemDetail[] getItem() {
            return this.item;
        }

        public void setOrder(StructurizationTradePromotionDetail[] order) {
            this.order = order;
        }

        public StructurizationTradePromotionDetail[] getOrder() {
            return this.order;
        }

        public void setItemDiscountFee(Float itemDiscountFee) {
            this.itemDiscountFee = itemDiscountFee;
        }

        public Float getItemDiscountFee() {
            return this.itemDiscountFee;
        }

        public void setOrderDiscountFee(Float orderDiscountFee) {
            this.orderDiscountFee = orderDiscountFee;
        }

        public Float getOrderDiscountFee() {
            return this.orderDiscountFee;
        }

    }

    public static class StructurizationTradeRemarkInfoDetail {
        @JsonProperty(value = "buyer_message")
        /**
         * 订单买家留言
         */
        private String buyerMessage;
        @JsonProperty(value = "star")
        /**
         * 订单标星等级 0-5
         */
        private Long star;
        @JsonProperty(value = "trade_memo")
        /**
         * 订单商家备注
         */
        private String tradeMemo;

        public void setBuyerMessage(String buyerMessage) {
            this.buyerMessage = buyerMessage;
        }

        public String getBuyerMessage() {
            return this.buyerMessage;
        }

        public void setStar(Long star) {
            this.star = star;
        }

        public Long getStar() {
            return this.star;
        }

        public void setTradeMemo(String tradeMemo) {
            this.tradeMemo = tradeMemo;
        }

        public String getTradeMemo() {
            return this.tradeMemo;
        }

    }

    public static class StructurizationTradeSourceInfo {
        @JsonProperty(value = "is_offline_order")
        /**
         * 是否来自线下订单
         */
        private Boolean isOfflineOrder;
        @JsonProperty(value = "source")
        /**
         * 订单来源平台
         */
        private StructurizationTradeSource source;

        public void setIsOfflineOrder(Boolean isOfflineOrder) {
            this.isOfflineOrder = isOfflineOrder;
        }

        public Boolean getIsOfflineOrder() {
            return this.isOfflineOrder;
        }

        public void setSource(StructurizationTradeSource source) {
            this.source = source;
        }

        public StructurizationTradeSource getSource() {
            return this.source;
        }

    }

    public static class StructurizationTradeItemDetail {
        @JsonProperty(value = "oid")
        /**
         * 订单明细id
         */
        private String oid;
        @JsonProperty(value = "item_type")
        /**
         * 订单类型
         0:普通类型商品; 1:拍卖商品; 5:餐饮商品; 10:分销商品; 20:会员卡商品; 21:礼品卡商品; 23:有赞会议商品; 24:周期购; 30:收银台商品; 31:知识付费商品; 35:酒店商品; 40:普通服务类商品; 182:普通虚拟商品; 183:电子卡券商品; 201:外部会员卡商品; 202:外部直接收款商品; 203:外部普通商品; 205:mock不存在商品; 206:小程序二维码
         */
        private Long itemType;
        @JsonProperty(value = "title")
        /**
         * 商品名称
         */
        private String title;
        @JsonProperty(value = "num")
        /**
         * 商品数量
         */
        private Long num;
        @JsonProperty(value = "outer_sku_id")
        /**
         * 商家编码
         */
        private String outerSkuId;
        @JsonProperty(value = "buyer_messages")
        /**
         * 商品留言
         */
        private String buyerMessages;
        @JsonProperty(value = "price")
        /**
         * 单商品原价
         */
        private Float price;
        @JsonProperty(value = "total_fee")
        /**
         * 商品优惠后总价
         */
        private Float totalFee;
        @JsonProperty(value = "payment")
        /**
         * 商品最终均摊价
         */
        private Float payment;
        @JsonProperty(value = "item_id")
        /**
         * 商品id
         */
        private Long itemId;
        @JsonProperty(value = "sku_id")
        /**
         * 规格id（无规格商品也会有值）
         */
        private Long skuId;
        @JsonProperty(value = "sku_properties_name")
        /**
         * 规格信息（无规格商品为空）
         */
        private String skuPropertiesName;
        @JsonProperty(value = "outer_item_id")
        /**
         * 商品编码
         */
        private String outerItemId;
        @JsonProperty(value = "points_price")
        /**
         * 商品积分价（非积分商品则为0）
         */
        private String pointsPrice;
        @JsonProperty(value = "pic_path")
        /**
         * 商品图片地址
         */
        private String picPath;

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getOid() {
            return this.oid;
        }

        public void setItemType(Long itemType) {
            this.itemType = itemType;
        }

        public Long getItemType() {
            return this.itemType;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

        public void setNum(Long num) {
            this.num = num;
        }

        public Long getNum() {
            return this.num;
        }

        public void setOuterSkuId(String outerSkuId) {
            this.outerSkuId = outerSkuId;
        }

        public String getOuterSkuId() {
            return this.outerSkuId;
        }

        public void setBuyerMessages(String buyerMessages) {
            this.buyerMessages = buyerMessages;
        }

        public String getBuyerMessages() {
            return this.buyerMessages;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public Float getPrice() {
            return this.price;
        }

        public void setTotalFee(Float totalFee) {
            this.totalFee = totalFee;
        }

        public Float getTotalFee() {
            return this.totalFee;
        }

        public void setPayment(Float payment) {
            this.payment = payment;
        }

        public Float getPayment() {
            return this.payment;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public Long getItemId() {
            return this.itemId;
        }

        public void setSkuId(Long skuId) {
            this.skuId = skuId;
        }

        public Long getSkuId() {
            return this.skuId;
        }

        public void setSkuPropertiesName(String skuPropertiesName) {
            this.skuPropertiesName = skuPropertiesName;
        }

        public String getSkuPropertiesName() {
            return this.skuPropertiesName;
        }

        public void setOuterItemId(String outerItemId) {
            this.outerItemId = outerItemId;
        }

        public String getOuterItemId() {
            return this.outerItemId;
        }

        public void setPointsPrice(String pointsPrice) {
            this.pointsPrice = pointsPrice;
        }

        public String getPointsPrice() {
            return this.pointsPrice;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getPicPath() {
            return this.picPath;
        }

    }

    public static class StructurizationTradePromotionDetail {
        @JsonProperty(value = "promotion_type")
        /**
         * 优惠类型
         tuan:团购返现
         auction:降价拍
         groupOn:多人拼团
         pointsExchange:积分抵扣
         seckill:秒杀
         packageBuy:优惠套餐
         presentExchange:赠品领取
         goodsScan:商品扫码
         customerDiscount:会员折扣
         timelimitedDiscount:限时折扣
         paidPromotion:支付有礼
         periodBuy:周期购
         scanReduce:收款码优惠
         meetReduce:满减送
         cashBack:订单返现
         supplierMeetReduce:供货商满包邮
         bale:打包一口价
         coupon:优惠卡券
         entireDiscount:整单优惠
         groupOnHeaderDiscount:团长优惠
         customerPostageFree:会员包邮
         periodBuyPostageFree:周期购包邮
         ignoreOddChange:抹零
         pfGuideMarketing:引导促销
         */
        private String promotionType;
        @JsonProperty(value = "promotion_title")
        /**
         * 优惠别名
         */
        private String promotionTitle;
        @JsonProperty(value = "promotion_type_name")
        /**
         * 优惠类型描述
         */
        private String promotionTypeName;
        @JsonProperty(value = "promotion_type_id")
        /**
         * 优惠类型id
         */
        private Long promotionTypeId;
        @JsonProperty(value = "discount_fee")
        /**
         * 优惠金额
         */
        private Float discountFee;
        @JsonProperty(value = "promotion_condition")
        /**
         * 优惠描述
         */
        private String promotionCondition;
        @JsonProperty(value = "promotion_content")
        /**
         * 优惠活动别名
         */
        private String promotionContent;
        @JsonProperty(value = "promotion_id")
        /**
         * 优惠id
         */
        private Long promotionId;

        public void setPromotionType(String promotionType) {
            this.promotionType = promotionType;
        }

        public String getPromotionType() {
            return this.promotionType;
        }

        public void setPromotionTitle(String promotionTitle) {
            this.promotionTitle = promotionTitle;
        }

        public String getPromotionTitle() {
            return this.promotionTitle;
        }

        public void setPromotionTypeName(String promotionTypeName) {
            this.promotionTypeName = promotionTypeName;
        }

        public String getPromotionTypeName() {
            return this.promotionTypeName;
        }

        public void setPromotionTypeId(Long promotionTypeId) {
            this.promotionTypeId = promotionTypeId;
        }

        public Long getPromotionTypeId() {
            return this.promotionTypeId;
        }

        public void setDiscountFee(Float discountFee) {
            this.discountFee = discountFee;
        }

        public Float getDiscountFee() {
            return this.discountFee;
        }

        public void setPromotionCondition(String promotionCondition) {
            this.promotionCondition = promotionCondition;
        }

        public String getPromotionCondition() {
            return this.promotionCondition;
        }

        public void setPromotionContent(String promotionContent) {
            this.promotionContent = promotionContent;
        }

        public String getPromotionContent() {
            return this.promotionContent;
        }

        public void setPromotionId(Long promotionId) {
            this.promotionId = promotionId;
        }

        public Long getPromotionId() {
            return this.promotionId;
        }

    }

    public static class StructurizationTradeOrderInfo {
        @JsonProperty(value = "order_info")
        /**
         * 交易明细详情
         */
        private StructurizationOrderInfoDetail orderInfo;
        @JsonProperty(value = "source_info")
        /**
         * 订单来源
         */
        private StructurizationTradeSourceInfo sourceInfo;
        @JsonProperty(value = "buyer_info")
        /**
         * 订单买家信息结构体
         */
        private StructurizationTradeBuyerInfoDetail buyerInfo;
        @JsonProperty(value = "pay_info")
        /**
         * 交易支付信息结构体
         */
        private StructurizationTradePayInfoDetail payInfo;
        @JsonProperty(value = "remark_info")
        /**
         * 订单标记信息结构体
         */
        private StructurizationTradeRemarkInfoDetail remarkInfo;
        @JsonProperty(value = "address_info")
        /**
         * 订单收货地址信息结构体
         */
        private StructurizationTradeAddressInfoDetail addressInfo;
        @JsonProperty(value = "orders")
        /**
         * 订单明细结构体
         */
        private StructurizationTradeItemDetail[] orders;

        public void setOrderInfo(StructurizationOrderInfoDetail orderInfo) {
            this.orderInfo = orderInfo;
        }

        public StructurizationOrderInfoDetail getOrderInfo() {
            return this.orderInfo;
        }

        public void setSourceInfo(StructurizationTradeSourceInfo sourceInfo) {
            this.sourceInfo = sourceInfo;
        }

        public StructurizationTradeSourceInfo getSourceInfo() {
            return this.sourceInfo;
        }

        public void setBuyerInfo(StructurizationTradeBuyerInfoDetail buyerInfo) {
            this.buyerInfo = buyerInfo;
        }

        public StructurizationTradeBuyerInfoDetail getBuyerInfo() {
            return this.buyerInfo;
        }

        public void setPayInfo(StructurizationTradePayInfoDetail payInfo) {
            this.payInfo = payInfo;
        }

        public StructurizationTradePayInfoDetail getPayInfo() {
            return this.payInfo;
        }

        public void setRemarkInfo(StructurizationTradeRemarkInfoDetail remarkInfo) {
            this.remarkInfo = remarkInfo;
        }

        public StructurizationTradeRemarkInfoDetail getRemarkInfo() {
            return this.remarkInfo;
        }

        public void setAddressInfo(StructurizationTradeAddressInfoDetail addressInfo) {
            this.addressInfo = addressInfo;
        }

        public StructurizationTradeAddressInfoDetail getAddressInfo() {
            return this.addressInfo;
        }

        public void setOrders(StructurizationTradeItemDetail[] orders) {
            this.orders = orders;
        }

        public StructurizationTradeItemDetail[] getOrders() {
            return this.orders;
        }

    }

    public static class StructurizationTradeSource {
        @JsonProperty(value = "platform")
        /**
         * 平台
         wx:微信; merchant_3rd:商家自有app; buyer_v:买家版; browser:系统浏览器; alipay:支付宝;qq:腾讯QQ; wb:微博; other:其他
         */
        private String platform;
        @JsonProperty(value = "wx_entrance")
        /**
         * 微信平台细分
         wx_gzh:微信公众号; yzdh:有赞大号; merchant_xcx:商家小程序; yzdh_xcx:有赞大号小程序; direct_buy:直接购买
         */
        private String wxEntrance;

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPlatform() {
            return this.platform;
        }

        public void setWxEntrance(String wxEntrance) {
            this.wxEntrance = wxEntrance;
        }

        public String getWxEntrance() {
            return this.wxEntrance;
        }

    }

    public static class StructurizationTradePayInfoDetail {
        @JsonProperty(value = "total_fee")
        /**
         * 优惠前商品总价
         */
        private Float totalFee;
        @JsonProperty(value = "post_fee")
        /**
         * 邮费
         */
        private Float postFee;
        @JsonProperty(value = "payment")
        /**
         * 最终支付价格
         payment=orders.payment的总和
         */
        private Float payment;
        @JsonProperty(value = "transaction")
        /**
         * 有赞支付流水号
         */
        private String[] transaction;
        @JsonProperty(value = "outer_transactions")
        /**
         * 外部支付单号
         */
        private String[] outerTransactions;

        public void setTotalFee(Float totalFee) {
            this.totalFee = totalFee;
        }

        public Float getTotalFee() {
            return this.totalFee;
        }

        public void setPostFee(Float postFee) {
            this.postFee = postFee;
        }

        public Float getPostFee() {
            return this.postFee;
        }

        public void setPayment(Float payment) {
            this.payment = payment;
        }

        public Float getPayment() {
            return this.payment;
        }

        public void setTransaction(String[] transaction) {
            this.transaction = transaction;
        }

        public String[] getTransaction() {
            return this.transaction;
        }

        public void setOuterTransactions(String[] outerTransactions) {
            this.outerTransactions = outerTransactions;
        }

        public String[] getOuterTransactions() {
            return this.outerTransactions;
        }

    }

    public static class StructurizationTradeRefundItemDetail {
        @JsonProperty(value = "oid")
        /**
         * 交易明细id
         */
        private String oid;

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getOid() {
            return this.oid;
        }

    }

    public static class StructurizationOrderInfoDetailTags {
        @JsonProperty(value = "is_virtual")
        /**
         * 是否虚拟订单
         */
        private Boolean isVirtual;
        @JsonProperty(value = "is_purchase_order")
        /**
         * 是否采购单
         */
        private Boolean isPurchaseOrder;
        @JsonProperty(value = "is_fenxiao_order")
        /**
         * 是否分销单
         */
        private Boolean isFenxiaoOrder;
        @JsonProperty(value = "is_member")
        /**
         * 是否会员订单
         */
        private Boolean isMember;
        @JsonProperty(value = "is_preorder")
        /**
         * 是否预订单
         */
        private Boolean isPreorder;
        @JsonProperty(value = "is_offline_order")
        /**
         * 是否线下订单
         */
        private Boolean isOfflineOrder;
        @JsonProperty(value = "is_multi_store")
        /**
         * 是否多门店订单
         */
        private Boolean isMultiStore;
        @JsonProperty(value = "is_settle")
        /**
         * 是否结算
         */
        private Boolean isSettle;
        @JsonProperty(value = "is_payed")
        /**
         * 是否支付
         */
        private Boolean isPayed;
        @JsonProperty(value = "is_secured_transactions")
        /**
         * 是否担保交易
         */
        private Boolean isSecuredTransactions;
        @JsonProperty(value = "is_postage_free")
        /**
         * 是否享受免邮
         */
        private Boolean isPostageFree;
        @JsonProperty(value = "is_feedback")
        /**
         * 是否有维权
         */
        private Boolean isFeedback;
        @JsonProperty(value = "is_refund")
        /**
         * 是否有退款
         */
        private Boolean isRefund;

        public void setIsVirtual(Boolean isVirtual) {
            this.isVirtual = isVirtual;
        }

        public Boolean getIsVirtual() {
            return this.isVirtual;
        }

        public void setIsPurchaseOrder(Boolean isPurchaseOrder) {
            this.isPurchaseOrder = isPurchaseOrder;
        }

        public Boolean getIsPurchaseOrder() {
            return this.isPurchaseOrder;
        }

        public void setIsFenxiaoOrder(Boolean isFenxiaoOrder) {
            this.isFenxiaoOrder = isFenxiaoOrder;
        }

        public Boolean getIsFenxiaoOrder() {
            return this.isFenxiaoOrder;
        }

        public void setIsMember(Boolean isMember) {
            this.isMember = isMember;
        }

        public Boolean getIsMember() {
            return this.isMember;
        }

        public void setIsPreorder(Boolean isPreorder) {
            this.isPreorder = isPreorder;
        }

        public Boolean getIsPreorder() {
            return this.isPreorder;
        }

        public void setIsOfflineOrder(Boolean isOfflineOrder) {
            this.isOfflineOrder = isOfflineOrder;
        }

        public Boolean getIsOfflineOrder() {
            return this.isOfflineOrder;
        }

        public void setIsMultiStore(Boolean isMultiStore) {
            this.isMultiStore = isMultiStore;
        }

        public Boolean getIsMultiStore() {
            return this.isMultiStore;
        }

        public void setIsSettle(Boolean isSettle) {
            this.isSettle = isSettle;
        }

        public Boolean getIsSettle() {
            return this.isSettle;
        }

        public void setIsPayed(Boolean isPayed) {
            this.isPayed = isPayed;
        }

        public Boolean getIsPayed() {
            return this.isPayed;
        }

        public void setIsSecuredTransactions(Boolean isSecuredTransactions) {
            this.isSecuredTransactions = isSecuredTransactions;
        }

        public Boolean getIsSecuredTransactions() {
            return this.isSecuredTransactions;
        }

        public void setIsPostageFree(Boolean isPostageFree) {
            this.isPostageFree = isPostageFree;
        }

        public Boolean getIsPostageFree() {
            return this.isPostageFree;
        }

        public void setIsFeedback(Boolean isFeedback) {
            this.isFeedback = isFeedback;
        }

        public Boolean getIsFeedback() {
            return this.isFeedback;
        }

        public void setIsRefund(Boolean isRefund) {
            this.isRefund = isRefund;
        }

        public Boolean getIsRefund() {
            return this.isRefund;
        }

    }

    public static class StructurizationTradeAddressInfoDetail {
        @JsonProperty(value = "receiver_name")
        /**
         * 收货人姓名
         */
        private String receiverName;
        @JsonProperty(value = "receiver_tel")
        /**
         * 收货人手机号
         */
        private String receiverTel;
        @JsonProperty(value = "delivery_province")
        /**
         * 省
         */
        private String deliveryProvince;
        @JsonProperty(value = "delivery_city")
        /**
         * 市
         */
        private String deliveryCity;
        @JsonProperty(value = "delivery_district")
        /**
         * 区
         */
        private String deliveryDistrict;
        @JsonProperty(value = "delivery_address")
        /**
         * 详细地址
         */
        private String deliveryAddress;
        @JsonProperty(value = "address_extra")
        /**
         * 字段为json格式，需要开发者自行解析
         lng、lon（经纬度）；
         checkOutTime（酒店退房时间）；
         recipients（入住人）；
         checkInTime（酒店入住时间）；
         idCardNumber（海淘身份证信息）；
         areaCode（邮政编码）
         */
        private String addressExtra;
        @JsonProperty(value = "delivery_postal_code")
        /**
         * 邮政编码
         */
        private String deliveryPostalCode;
        @JsonProperty(value = "self_fetch_info")
        /**
         * 到店自提信息 json格式
         */
        private String selfFetchInfo;

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getReceiverName() {
            return this.receiverName;
        }

        public void setReceiverTel(String receiverTel) {
            this.receiverTel = receiverTel;
        }

        public String getReceiverTel() {
            return this.receiverTel;
        }

        public void setDeliveryProvince(String deliveryProvince) {
            this.deliveryProvince = deliveryProvince;
        }

        public String getDeliveryProvince() {
            return this.deliveryProvince;
        }

        public void setDeliveryCity(String deliveryCity) {
            this.deliveryCity = deliveryCity;
        }

        public String getDeliveryCity() {
            return this.deliveryCity;
        }

        public void setDeliveryDistrict(String deliveryDistrict) {
            this.deliveryDistrict = deliveryDistrict;
        }

        public String getDeliveryDistrict() {
            return this.deliveryDistrict;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public String getDeliveryAddress() {
            return this.deliveryAddress;
        }

        public void setAddressExtra(String addressExtra) {
            this.addressExtra = addressExtra;
        }

        public String getAddressExtra() {
            return this.addressExtra;
        }

        public void setDeliveryPostalCode(String deliveryPostalCode) {
            this.deliveryPostalCode = deliveryPostalCode;
        }

        public String getDeliveryPostalCode() {
            return this.deliveryPostalCode;
        }

        public void setSelfFetchInfo(String selfFetchInfo) {
            this.selfFetchInfo = selfFetchInfo;
        }

        public String getSelfFetchInfo() {
            return this.selfFetchInfo;
        }

    }

    public static class StructurizationTradePromotionItemDetail {
        @JsonProperty(value = "is_present")
        /**
         * 是否赠品
         */
        private Boolean isPresent;
        @JsonProperty(value = "oid")
        /**
         * 交易明细id
         */
        private String oid;
        @JsonProperty(value = "item_id")
        /**
         * 商品id
         */
        private Long itemId;
        @JsonProperty(value = "sku_id")
        /**
         * 规格id
         */
        private Long skuId;
        @JsonProperty(value = "promotions")
        /**
         * 优惠明细结构体
         */
        private StructurizationTradePromotionDetail[] promotions;

        public void setIsPresent(Boolean isPresent) {
            this.isPresent = isPresent;
        }

        public Boolean getIsPresent() {
            return this.isPresent;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getOid() {
            return this.oid;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public Long getItemId() {
            return this.itemId;
        }

        public void setSkuId(Long skuId) {
            this.skuId = skuId;
        }

        public Long getSkuId() {
            return this.skuId;
        }

        public void setPromotions(StructurizationTradePromotionDetail[] promotions) {
            this.promotions = promotions;
        }

        public StructurizationTradePromotionDetail[] getPromotions() {
            return this.promotions;
        }

    }

    public static class StructurizationOrderInfoDetail {
        @JsonProperty(value = "status")
        /**
         * 主订单状态
         WAIT_BUYER_PAY （等待买家付款）；
         WAIT_CONFIRM（待确认，包含待成团、待接单等等。即：买家已付款，等待成团或等待接单）；
         WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）；
         WAIT_BUYER_CONFIRM_GOODS (等待买家确认收货，即：卖家已发货) ；
         TRADE_SUCCESS（买家已签收以及订单成功）；
         TRADE_CLOSED（交易关闭）；
         */
        private String status;
        @JsonProperty(value = "type")
        /**
         * 主订单类型
         0:普通订单; 1:送礼订单; 2:代付; 3:分销采购单; 4:赠品; 5:心愿单; 6:二维码订单; 7:合并付货款; 8:1分钱实名认证; 9:品鉴; 10:拼团; 15:返利; 35:酒店; 40:外卖; 41:堂食点餐; 46:外卖买单; 51:全员开店; 52:保证金; 61:线下收银台订单; 71:美业预约单; 72:美业服务单; 75:知识付费; 81:礼品卡; 100:批发
         */
        private Long type;
        @JsonProperty(value = "tid")
        /**
         * 订单号
         */
        private String tid;
        @JsonProperty(value = "status_str")
        /**
         * 主订单状态描述
         */
        private String statusStr;
        @JsonProperty(value = "pay_type")
        /**
         * 支付类型
         0:默认值,未支付; 1:微信自有支付; 2:支付宝wap; 3:支付宝wap; 5:财付通; 7:代付; 8:联动优势; 9:货到付款; 10:大账号代销; 11:受理模式; 12:百付宝; 13:sdk支付; 14:合并付货款; 15:赠品; 16:优惠兑换; 17:自动付货款; 18:爱学贷; 19:微信wap; 20:微信红包支付; 21:返利; 22:ump红包; 24:易宝支付; 25:储值卡; 27:qq支付; 28:有赞E卡支付; 29:微信条码; 30:支付宝条码; 33:礼品卡支付; 35:会员余额; 72:微信扫码二维码支付; 100:代收账户; 300:储值账户; 400:保证金账户; 101:收款码; 102:微信; 103:支付宝; 104:刷卡; 105:二维码台卡; 106:储值卡; 107:有赞E卡; 110:标记收款-自有微信支付; 111:标记收款-自有支付宝; 112:标记收款-自有POS刷卡; 113:通联刷卡支付; 200:记账账户; 201:现金
         */
        private Long payType;
        @JsonProperty(value = "team_type")
        /**
         * 店铺类型
         0:微商城; 1:微小店; 2:爱学贷微商城; 3:批发店铺; 4:批发商城; 5:外卖; 6:美业; 7:超级门店; 8:收银; 9:收银加微商城; 10:零售总部; 99:有赞开放平台平台型应用创建的店铺
         */
        private Long teamType;
        @JsonProperty(value = "close_type")
        /**
         * 关闭类型
         0:未关闭; 1:过期关闭; 2:标记退款; 3:订单取消; 4:买家取消; 5:卖家取消; 6:部分退款; 10:无法联系上买家; 11:买家误拍或重拍了; 12:买家无诚意完成交易; 13:已通过银行线下汇款; 14:已通过同城见面交易; 15:已通过货到付款交易; 16:已通过网上银行直接汇款; 17:已经缺货无法交易
         */
        private Long closeType;
        @JsonProperty(value = "express_type")
        /**
         * 物流类型
         0:快递发货; 1:到店自提; 2:同城配送; 9:无需发货（虚拟商品订单）
         */
        private Long expressType;
        @JsonProperty(value = "order_tags")
        /**
         * 订单信息打标
         */
        private StructurizationOrderInfoDetailTags orderTags;
        @JsonProperty(value = "order_extra")
        /**
         * 订单扩展字段
         */
        private StructurizationOrderInfoDetailExtra orderExtra;
        @JsonProperty(value = "created")
        /**
         * 订单创建时间
         */
        private Date created;
        @JsonProperty(value = "update_time")
        /**
         * 订单更新时间
         */
        private Date updateTime;
        @JsonProperty(value = "expired_time")
        /**
         * 订单过期时间（未付款将自动关单）
         */
        private Date expiredTime;
        @JsonProperty(value = "pay_time")
        /**
         * 订单支付时间
         */
        private Date payTime;
        @JsonProperty(value = "consign_time")
        /**
         * 订单发货时间（当所有商品发货后才会更新）
         */
        private Date consignTime;
        @JsonProperty(value = "confirm_time")
        /**
         * 订单确认时间（多人拼团成团）
         */
        private Date confirmTime;
        @JsonProperty(value = "refund_state")
        /**
         * 退款状态
         0:未退款; 1:部分退款中; 2:部分退款成功; 11:全额退款中; 12:全额退款成功
         */
        private Long refundState;
        @JsonProperty(value = "is_retail_order")
        /**
         * 是否零售订单
         */
        private Boolean isRetailOrder;
        @JsonProperty(value = "success_time")
        /**
         * 订单成功时间
         */
        private Date successTime;
        @JsonProperty(value = "offline_id")
        /**
         * 网点id
         */
        private Long offlineId;

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public Long getType() {
            return this.type;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTid() {
            return this.tid;
        }

        public void setStatusStr(String statusStr) {
            this.statusStr = statusStr;
        }

        public String getStatusStr() {
            return this.statusStr;
        }

        public void setPayType(Long payType) {
            this.payType = payType;
        }

        public Long getPayType() {
            return this.payType;
        }

        public void setTeamType(Long teamType) {
            this.teamType = teamType;
        }

        public Long getTeamType() {
            return this.teamType;
        }

        public void setCloseType(Long closeType) {
            this.closeType = closeType;
        }

        public Long getCloseType() {
            return this.closeType;
        }

        public void setExpressType(Long expressType) {
            this.expressType = expressType;
        }

        public Long getExpressType() {
            return this.expressType;
        }

        public void setOrderTags(StructurizationOrderInfoDetailTags orderTags) {
            this.orderTags = orderTags;
        }

        public StructurizationOrderInfoDetailTags getOrderTags() {
            return this.orderTags;
        }

        public void setOrderExtra(StructurizationOrderInfoDetailExtra orderExtra) {
            this.orderExtra = orderExtra;
        }

        public StructurizationOrderInfoDetailExtra getOrderExtra() {
            return this.orderExtra;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public Date getCreated() {
            return this.created;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Date getUpdateTime() {
            return this.updateTime;
        }

        public void setExpiredTime(Date expiredTime) {
            this.expiredTime = expiredTime;
        }

        public Date getExpiredTime() {
            return this.expiredTime;
        }

        public void setPayTime(Date payTime) {
            this.payTime = payTime;
        }

        public Date getPayTime() {
            return this.payTime;
        }

        public void setConsignTime(Date consignTime) {
            this.consignTime = consignTime;
        }

        public Date getConsignTime() {
            return this.consignTime;
        }

        public void setConfirmTime(Date confirmTime) {
            this.confirmTime = confirmTime;
        }

        public Date getConfirmTime() {
            return this.confirmTime;
        }

        public void setRefundState(Long refundState) {
            this.refundState = refundState;
        }

        public Long getRefundState() {
            return this.refundState;
        }

        public void setIsRetailOrder(Boolean isRetailOrder) {
            this.isRetailOrder = isRetailOrder;
        }

        public Boolean getIsRetailOrder() {
            return this.isRetailOrder;
        }

        public void setSuccessTime(Date successTime) {
            this.successTime = successTime;
        }

        public Date getSuccessTime() {
            return this.successTime;
        }

        public void setOfflineId(Long offlineId) {
            this.offlineId = offlineId;
        }

        public Long getOfflineId() {
            return this.offlineId;
        }

    }


}