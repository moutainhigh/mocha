package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderItemInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(String value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(String value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(String value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(String value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(String value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(String value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLike(String value) {
            addCriterion("oid like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotLike(String value) {
            addCriterion("oid not like", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<String> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<String> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(String value1, String value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(String value1, String value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Long value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Long value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Long value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Long value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Long value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Long> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Long> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Long value1, Long value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Long value1, Long value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Long value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Long value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Long value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Long value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Long value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Long value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Long> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Long> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Long value1, Long value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Long value1, Long value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIsNull() {
            addCriterion("outer_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIsNotNull() {
            addCriterion("outer_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdEqualTo(String value) {
            addCriterion("outer_sku_id =", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotEqualTo(String value) {
            addCriterion("outer_sku_id <>", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdGreaterThan(String value) {
            addCriterion("outer_sku_id >", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("outer_sku_id >=", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLessThan(String value) {
            addCriterion("outer_sku_id <", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLessThanOrEqualTo(String value) {
            addCriterion("outer_sku_id <=", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLike(String value) {
            addCriterion("outer_sku_id like", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotLike(String value) {
            addCriterion("outer_sku_id not like", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIn(List<String> values) {
            addCriterion("outer_sku_id in", values, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotIn(List<String> values) {
            addCriterion("outer_sku_id not in", values, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdBetween(String value1, String value2) {
            addCriterion("outer_sku_id between", value1, value2, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotBetween(String value1, String value2) {
            addCriterion("outer_sku_id not between", value1, value2, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Long value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Long> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameIsNull() {
            addCriterion("sku_properties_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameIsNotNull() {
            addCriterion("sku_properties_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameEqualTo(String value) {
            addCriterion("sku_properties_name =", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotEqualTo(String value) {
            addCriterion("sku_properties_name <>", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameGreaterThan(String value) {
            addCriterion("sku_properties_name >", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_properties_name >=", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameLessThan(String value) {
            addCriterion("sku_properties_name <", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameLessThanOrEqualTo(String value) {
            addCriterion("sku_properties_name <=", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameLike(String value) {
            addCriterion("sku_properties_name like", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotLike(String value) {
            addCriterion("sku_properties_name not like", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameIn(List<String> values) {
            addCriterion("sku_properties_name in", values, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotIn(List<String> values) {
            addCriterion("sku_properties_name not in", values, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameBetween(String value1, String value2) {
            addCriterion("sku_properties_name between", value1, value2, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotBetween(String value1, String value2) {
            addCriterion("sku_properties_name not between", value1, value2, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateIsNull() {
            addCriterion("start_deliver_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateIsNotNull() {
            addCriterion("start_deliver_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateEqualTo(Date value) {
            addCriterion("start_deliver_date =", value, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateNotEqualTo(Date value) {
            addCriterion("start_deliver_date <>", value, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateGreaterThan(Date value) {
            addCriterion("start_deliver_date >", value, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_deliver_date >=", value, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateLessThan(Date value) {
            addCriterion("start_deliver_date <", value, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateLessThanOrEqualTo(Date value) {
            addCriterion("start_deliver_date <=", value, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateIn(List<Date> values) {
            addCriterion("start_deliver_date in", values, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateNotIn(List<Date> values) {
            addCriterion("start_deliver_date not in", values, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateBetween(Date value1, Date value2) {
            addCriterion("start_deliver_date between", value1, value2, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andStartDeliverDateNotBetween(Date value1, Date value2) {
            addCriterion("start_deliver_date not between", value1, value2, "startDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateIsNull() {
            addCriterion("end_deliver_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateIsNotNull() {
            addCriterion("end_deliver_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateEqualTo(Date value) {
            addCriterion("end_deliver_date =", value, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateNotEqualTo(Date value) {
            addCriterion("end_deliver_date <>", value, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateGreaterThan(Date value) {
            addCriterion("end_deliver_date >", value, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_deliver_date >=", value, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateLessThan(Date value) {
            addCriterion("end_deliver_date <", value, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateLessThanOrEqualTo(Date value) {
            addCriterion("end_deliver_date <=", value, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateIn(List<Date> values) {
            addCriterion("end_deliver_date in", values, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateNotIn(List<Date> values) {
            addCriterion("end_deliver_date not in", values, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateBetween(Date value1, Date value2) {
            addCriterion("end_deliver_date between", value1, value2, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andEndDeliverDateNotBetween(Date value1, Date value2) {
            addCriterion("end_deliver_date not between", value1, value2, "endDeliverDate");
            return (Criteria) this;
        }

        public Criteria andDeliverCountIsNull() {
            addCriterion("deliver_count is null");
            return (Criteria) this;
        }

        public Criteria andDeliverCountIsNotNull() {
            addCriterion("deliver_count is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverCountEqualTo(Long value) {
            addCriterion("deliver_count =", value, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountNotEqualTo(Long value) {
            addCriterion("deliver_count <>", value, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountGreaterThan(Long value) {
            addCriterion("deliver_count >", value, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountGreaterThanOrEqualTo(Long value) {
            addCriterion("deliver_count >=", value, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountLessThan(Long value) {
            addCriterion("deliver_count <", value, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountLessThanOrEqualTo(Long value) {
            addCriterion("deliver_count <=", value, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountIn(List<Long> values) {
            addCriterion("deliver_count in", values, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountNotIn(List<Long> values) {
            addCriterion("deliver_count not in", values, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountBetween(Long value1, Long value2) {
            addCriterion("deliver_count between", value1, value2, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andDeliverCountNotBetween(Long value1, Long value2) {
            addCriterion("deliver_count not between", value1, value2, "deliverCount");
            return (Criteria) this;
        }

        public Criteria andAdminMsgIsNull() {
            addCriterion("admin_msg is null");
            return (Criteria) this;
        }

        public Criteria andAdminMsgIsNotNull() {
            addCriterion("admin_msg is not null");
            return (Criteria) this;
        }

        public Criteria andAdminMsgEqualTo(String value) {
            addCriterion("admin_msg =", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgNotEqualTo(String value) {
            addCriterion("admin_msg <>", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgGreaterThan(String value) {
            addCriterion("admin_msg >", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgGreaterThanOrEqualTo(String value) {
            addCriterion("admin_msg >=", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgLessThan(String value) {
            addCriterion("admin_msg <", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgLessThanOrEqualTo(String value) {
            addCriterion("admin_msg <=", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgLike(String value) {
            addCriterion("admin_msg like", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgNotLike(String value) {
            addCriterion("admin_msg not like", value, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgIn(List<String> values) {
            addCriterion("admin_msg in", values, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgNotIn(List<String> values) {
            addCriterion("admin_msg not in", values, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgBetween(String value1, String value2) {
            addCriterion("admin_msg between", value1, value2, "adminMsg");
            return (Criteria) this;
        }

        public Criteria andAdminMsgNotBetween(String value1, String value2) {
            addCriterion("admin_msg not between", value1, value2, "adminMsg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}