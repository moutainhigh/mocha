package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusStrIsNull() {
            addCriterion("status_str is null");
            return (Criteria) this;
        }

        public Criteria andStatusStrIsNotNull() {
            addCriterion("status_str is not null");
            return (Criteria) this;
        }

        public Criteria andStatusStrEqualTo(String value) {
            addCriterion("status_str =", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotEqualTo(String value) {
            addCriterion("status_str <>", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrGreaterThan(String value) {
            addCriterion("status_str >", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrGreaterThanOrEqualTo(String value) {
            addCriterion("status_str >=", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrLessThan(String value) {
            addCriterion("status_str <", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrLessThanOrEqualTo(String value) {
            addCriterion("status_str <=", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrLike(String value) {
            addCriterion("status_str like", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotLike(String value) {
            addCriterion("status_str not like", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrIn(List<String> values) {
            addCriterion("status_str in", values, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotIn(List<String> values) {
            addCriterion("status_str not in", values, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrBetween(String value1, String value2) {
            addCriterion("status_str between", value1, value2, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotBetween(String value1, String value2) {
            addCriterion("status_str not between", value1, value2, "statusStr");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNull() {
            addCriterion("express_type is null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIsNotNull() {
            addCriterion("express_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpressTypeEqualTo(Integer value) {
            addCriterion("express_type =", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotEqualTo(Integer value) {
            addCriterion("express_type <>", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThan(Integer value) {
            addCriterion("express_type >", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("express_type >=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThan(Integer value) {
            addCriterion("express_type <", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeLessThanOrEqualTo(Integer value) {
            addCriterion("express_type <=", value, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeIn(List<Integer> values) {
            addCriterion("express_type in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotIn(List<Integer> values) {
            addCriterion("express_type not in", values, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeBetween(Integer value1, Integer value2) {
            addCriterion("express_type between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andExpressTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("express_type not between", value1, value2, "expressType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
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

        public Criteria andFansTypeIsNull() {
            addCriterion("fans_type is null");
            return (Criteria) this;
        }

        public Criteria andFansTypeIsNotNull() {
            addCriterion("fans_type is not null");
            return (Criteria) this;
        }

        public Criteria andFansTypeEqualTo(Long value) {
            addCriterion("fans_type =", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotEqualTo(Long value) {
            addCriterion("fans_type <>", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeGreaterThan(Long value) {
            addCriterion("fans_type >", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("fans_type >=", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeLessThan(Long value) {
            addCriterion("fans_type <", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeLessThanOrEqualTo(Long value) {
            addCriterion("fans_type <=", value, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeIn(List<Long> values) {
            addCriterion("fans_type in", values, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotIn(List<Long> values) {
            addCriterion("fans_type not in", values, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeBetween(Long value1, Long value2) {
            addCriterion("fans_type between", value1, value2, "fansType");
            return (Criteria) this;
        }

        public Criteria andFansTypeNotBetween(Long value1, Long value2) {
            addCriterion("fans_type not between", value1, value2, "fansType");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(Long value) {
            addCriterion("buyer_id =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(Long value) {
            addCriterion("buyer_id <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(Long value) {
            addCriterion("buyer_id >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buyer_id >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(Long value) {
            addCriterion("buyer_id <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            addCriterion("buyer_id <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<Long> values) {
            addCriterion("buyer_id in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<Long> values) {
            addCriterion("buyer_id not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(Long value1, Long value2) {
            addCriterion("buyer_id between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            addCriterion("buyer_id not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andFansIdIsNull() {
            addCriterion("fans_id is null");
            return (Criteria) this;
        }

        public Criteria andFansIdIsNotNull() {
            addCriterion("fans_id is not null");
            return (Criteria) this;
        }

        public Criteria andFansIdEqualTo(Long value) {
            addCriterion("fans_id =", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotEqualTo(Long value) {
            addCriterion("fans_id <>", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdGreaterThan(Long value) {
            addCriterion("fans_id >", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fans_id >=", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLessThan(Long value) {
            addCriterion("fans_id <", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdLessThanOrEqualTo(Long value) {
            addCriterion("fans_id <=", value, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdIn(List<Long> values) {
            addCriterion("fans_id in", values, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotIn(List<Long> values) {
            addCriterion("fans_id not in", values, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdBetween(Long value1, Long value2) {
            addCriterion("fans_id between", value1, value2, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansIdNotBetween(Long value1, Long value2) {
            addCriterion("fans_id not between", value1, value2, "fansId");
            return (Criteria) this;
        }

        public Criteria andFansNicknameIsNull() {
            addCriterion("fans_nickname is null");
            return (Criteria) this;
        }

        public Criteria andFansNicknameIsNotNull() {
            addCriterion("fans_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andFansNicknameEqualTo(String value) {
            addCriterion("fans_nickname =", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameNotEqualTo(String value) {
            addCriterion("fans_nickname <>", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameGreaterThan(String value) {
            addCriterion("fans_nickname >", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("fans_nickname >=", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameLessThan(String value) {
            addCriterion("fans_nickname <", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameLessThanOrEqualTo(String value) {
            addCriterion("fans_nickname <=", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameLike(String value) {
            addCriterion("fans_nickname like", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameNotLike(String value) {
            addCriterion("fans_nickname not like", value, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameIn(List<String> values) {
            addCriterion("fans_nickname in", values, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameNotIn(List<String> values) {
            addCriterion("fans_nickname not in", values, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameBetween(String value1, String value2) {
            addCriterion("fans_nickname between", value1, value2, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andFansNicknameNotBetween(String value1, String value2) {
            addCriterion("fans_nickname not between", value1, value2, "fansNickname");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageIsNull() {
            addCriterion("buyer_message is null");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageIsNotNull() {
            addCriterion("buyer_message is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageEqualTo(String value) {
            addCriterion("buyer_message =", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotEqualTo(String value) {
            addCriterion("buyer_message <>", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageGreaterThan(String value) {
            addCriterion("buyer_message >", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_message >=", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageLessThan(String value) {
            addCriterion("buyer_message <", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageLessThanOrEqualTo(String value) {
            addCriterion("buyer_message <=", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageLike(String value) {
            addCriterion("buyer_message like", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotLike(String value) {
            addCriterion("buyer_message not like", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageIn(List<String> values) {
            addCriterion("buyer_message in", values, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotIn(List<String> values) {
            addCriterion("buyer_message not in", values, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageBetween(String value1, String value2) {
            addCriterion("buyer_message between", value1, value2, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotBetween(String value1, String value2) {
            addCriterion("buyer_message not between", value1, value2, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andTradeMemoIsNull() {
            addCriterion("trade_memo is null");
            return (Criteria) this;
        }

        public Criteria andTradeMemoIsNotNull() {
            addCriterion("trade_memo is not null");
            return (Criteria) this;
        }

        public Criteria andTradeMemoEqualTo(String value) {
            addCriterion("trade_memo =", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotEqualTo(String value) {
            addCriterion("trade_memo <>", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoGreaterThan(String value) {
            addCriterion("trade_memo >", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_memo >=", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoLessThan(String value) {
            addCriterion("trade_memo <", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoLessThanOrEqualTo(String value) {
            addCriterion("trade_memo <=", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoLike(String value) {
            addCriterion("trade_memo like", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotLike(String value) {
            addCriterion("trade_memo not like", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoIn(List<String> values) {
            addCriterion("trade_memo in", values, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotIn(List<String> values) {
            addCriterion("trade_memo not in", values, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoBetween(String value1, String value2) {
            addCriterion("trade_memo between", value1, value2, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotBetween(String value1, String value2) {
            addCriterion("trade_memo not between", value1, value2, "tradeMemo");
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

        public Criteria andPostFeeIsNull() {
            addCriterion("post_fee is null");
            return (Criteria) this;
        }

        public Criteria andPostFeeIsNotNull() {
            addCriterion("post_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPostFeeEqualTo(Long value) {
            addCriterion("post_fee =", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeNotEqualTo(Long value) {
            addCriterion("post_fee <>", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeGreaterThan(Long value) {
            addCriterion("post_fee >", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("post_fee >=", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeLessThan(Long value) {
            addCriterion("post_fee <", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeLessThanOrEqualTo(Long value) {
            addCriterion("post_fee <=", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeIn(List<Long> values) {
            addCriterion("post_fee in", values, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeNotIn(List<Long> values) {
            addCriterion("post_fee not in", values, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeBetween(Long value1, Long value2) {
            addCriterion("post_fee between", value1, value2, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeNotBetween(Long value1, Long value2) {
            addCriterion("post_fee not between", value1, value2, "postFee");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(Long value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(Long value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(Long value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(Long value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(Long value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(Long value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<Long> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<Long> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(Long value1, Long value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(Long value1, Long value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNull() {
            addCriterion("delivery_address is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNotNull() {
            addCriterion("delivery_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressEqualTo(String value) {
            addCriterion("delivery_address =", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotEqualTo(String value) {
            addCriterion("delivery_address <>", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThan(String value) {
            addCriterion("delivery_address >", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_address >=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThan(String value) {
            addCriterion("delivery_address <", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("delivery_address <=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLike(String value) {
            addCriterion("delivery_address like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotLike(String value) {
            addCriterion("delivery_address not like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIn(List<String> values) {
            addCriterion("delivery_address in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotIn(List<String> values) {
            addCriterion("delivery_address not in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressBetween(String value1, String value2) {
            addCriterion("delivery_address between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("delivery_address not between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeIsNull() {
            addCriterion("delivery_postal_code is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeIsNotNull() {
            addCriterion("delivery_postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeEqualTo(String value) {
            addCriterion("delivery_postal_code =", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotEqualTo(String value) {
            addCriterion("delivery_postal_code <>", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeGreaterThan(String value) {
            addCriterion("delivery_postal_code >", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_postal_code >=", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeLessThan(String value) {
            addCriterion("delivery_postal_code <", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_postal_code <=", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeLike(String value) {
            addCriterion("delivery_postal_code like", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotLike(String value) {
            addCriterion("delivery_postal_code not like", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeIn(List<String> values) {
            addCriterion("delivery_postal_code in", values, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotIn(List<String> values) {
            addCriterion("delivery_postal_code not in", values, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeBetween(String value1, String value2) {
            addCriterion("delivery_postal_code between", value1, value2, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_postal_code not between", value1, value2, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNull() {
            addCriterion("receiver_tel is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNotNull() {
            addCriterion("receiver_tel is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelEqualTo(String value) {
            addCriterion("receiver_tel =", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotEqualTo(String value) {
            addCriterion("receiver_tel <>", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThan(String value) {
            addCriterion("receiver_tel >", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_tel >=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThan(String value) {
            addCriterion("receiver_tel <", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThanOrEqualTo(String value) {
            addCriterion("receiver_tel <=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLike(String value) {
            addCriterion("receiver_tel like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotLike(String value) {
            addCriterion("receiver_tel not like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIn(List<String> values) {
            addCriterion("receiver_tel in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotIn(List<String> values) {
            addCriterion("receiver_tel not in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelBetween(String value1, String value2) {
            addCriterion("receiver_tel between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotBetween(String value1, String value2) {
            addCriterion("receiver_tel not between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceIsNull() {
            addCriterion("delivery_province is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceIsNotNull() {
            addCriterion("delivery_province is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceEqualTo(String value) {
            addCriterion("delivery_province =", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotEqualTo(String value) {
            addCriterion("delivery_province <>", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceGreaterThan(String value) {
            addCriterion("delivery_province >", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_province >=", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceLessThan(String value) {
            addCriterion("delivery_province <", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceLessThanOrEqualTo(String value) {
            addCriterion("delivery_province <=", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceLike(String value) {
            addCriterion("delivery_province like", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotLike(String value) {
            addCriterion("delivery_province not like", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceIn(List<String> values) {
            addCriterion("delivery_province in", values, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotIn(List<String> values) {
            addCriterion("delivery_province not in", values, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceBetween(String value1, String value2) {
            addCriterion("delivery_province between", value1, value2, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotBetween(String value1, String value2) {
            addCriterion("delivery_province not between", value1, value2, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityIsNull() {
            addCriterion("delivery_city is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityIsNotNull() {
            addCriterion("delivery_city is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityEqualTo(String value) {
            addCriterion("delivery_city =", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotEqualTo(String value) {
            addCriterion("delivery_city <>", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityGreaterThan(String value) {
            addCriterion("delivery_city >", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_city >=", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityLessThan(String value) {
            addCriterion("delivery_city <", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityLessThanOrEqualTo(String value) {
            addCriterion("delivery_city <=", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityLike(String value) {
            addCriterion("delivery_city like", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotLike(String value) {
            addCriterion("delivery_city not like", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityIn(List<String> values) {
            addCriterion("delivery_city in", values, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotIn(List<String> values) {
            addCriterion("delivery_city not in", values, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityBetween(String value1, String value2) {
            addCriterion("delivery_city between", value1, value2, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotBetween(String value1, String value2) {
            addCriterion("delivery_city not between", value1, value2, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictIsNull() {
            addCriterion("delivery_district is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictIsNotNull() {
            addCriterion("delivery_district is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictEqualTo(String value) {
            addCriterion("delivery_district =", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotEqualTo(String value) {
            addCriterion("delivery_district <>", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictGreaterThan(String value) {
            addCriterion("delivery_district >", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_district >=", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictLessThan(String value) {
            addCriterion("delivery_district <", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictLessThanOrEqualTo(String value) {
            addCriterion("delivery_district <=", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictLike(String value) {
            addCriterion("delivery_district like", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotLike(String value) {
            addCriterion("delivery_district not like", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictIn(List<String> values) {
            addCriterion("delivery_district in", values, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotIn(List<String> values) {
            addCriterion("delivery_district not in", values, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictBetween(String value1, String value2) {
            addCriterion("delivery_district between", value1, value2, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotBetween(String value1, String value2) {
            addCriterion("delivery_district not between", value1, value2, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdIsNull() {
            addCriterion("self_fetch_id is null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdIsNotNull() {
            addCriterion("self_fetch_id is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdEqualTo(Long value) {
            addCriterion("self_fetch_id =", value, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdNotEqualTo(Long value) {
            addCriterion("self_fetch_id <>", value, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdGreaterThan(Long value) {
            addCriterion("self_fetch_id >", value, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("self_fetch_id >=", value, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdLessThan(Long value) {
            addCriterion("self_fetch_id <", value, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdLessThanOrEqualTo(Long value) {
            addCriterion("self_fetch_id <=", value, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdIn(List<Long> values) {
            addCriterion("self_fetch_id in", values, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdNotIn(List<Long> values) {
            addCriterion("self_fetch_id not in", values, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdBetween(Long value1, Long value2) {
            addCriterion("self_fetch_id between", value1, value2, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchIdNotBetween(Long value1, Long value2) {
            addCriterion("self_fetch_id not between", value1, value2, "selfFetchId");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameIsNull() {
            addCriterion("self_fetch_name is null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameIsNotNull() {
            addCriterion("self_fetch_name is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameEqualTo(String value) {
            addCriterion("self_fetch_name =", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameNotEqualTo(String value) {
            addCriterion("self_fetch_name <>", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameGreaterThan(String value) {
            addCriterion("self_fetch_name >", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameGreaterThanOrEqualTo(String value) {
            addCriterion("self_fetch_name >=", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameLessThan(String value) {
            addCriterion("self_fetch_name <", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameLessThanOrEqualTo(String value) {
            addCriterion("self_fetch_name <=", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameLike(String value) {
            addCriterion("self_fetch_name like", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameNotLike(String value) {
            addCriterion("self_fetch_name not like", value, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameIn(List<String> values) {
            addCriterion("self_fetch_name in", values, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameNotIn(List<String> values) {
            addCriterion("self_fetch_name not in", values, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameBetween(String value1, String value2) {
            addCriterion("self_fetch_name between", value1, value2, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchNameNotBetween(String value1, String value2) {
            addCriterion("self_fetch_name not between", value1, value2, "selfFetchName");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelIsNull() {
            addCriterion("self_fetch_tel is null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelIsNotNull() {
            addCriterion("self_fetch_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelEqualTo(String value) {
            addCriterion("self_fetch_tel =", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelNotEqualTo(String value) {
            addCriterion("self_fetch_tel <>", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelGreaterThan(String value) {
            addCriterion("self_fetch_tel >", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelGreaterThanOrEqualTo(String value) {
            addCriterion("self_fetch_tel >=", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelLessThan(String value) {
            addCriterion("self_fetch_tel <", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelLessThanOrEqualTo(String value) {
            addCriterion("self_fetch_tel <=", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelLike(String value) {
            addCriterion("self_fetch_tel like", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelNotLike(String value) {
            addCriterion("self_fetch_tel not like", value, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelIn(List<String> values) {
            addCriterion("self_fetch_tel in", values, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelNotIn(List<String> values) {
            addCriterion("self_fetch_tel not in", values, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelBetween(String value1, String value2) {
            addCriterion("self_fetch_tel between", value1, value2, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchTelNotBetween(String value1, String value2) {
            addCriterion("self_fetch_tel not between", value1, value2, "selfFetchTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserIsNull() {
            addCriterion("self_fetch_user is null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserIsNotNull() {
            addCriterion("self_fetch_user is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserEqualTo(String value) {
            addCriterion("self_fetch_user =", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserNotEqualTo(String value) {
            addCriterion("self_fetch_user <>", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserGreaterThan(String value) {
            addCriterion("self_fetch_user >", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserGreaterThanOrEqualTo(String value) {
            addCriterion("self_fetch_user >=", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserLessThan(String value) {
            addCriterion("self_fetch_user <", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserLessThanOrEqualTo(String value) {
            addCriterion("self_fetch_user <=", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserLike(String value) {
            addCriterion("self_fetch_user like", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserNotLike(String value) {
            addCriterion("self_fetch_user not like", value, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserIn(List<String> values) {
            addCriterion("self_fetch_user in", values, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserNotIn(List<String> values) {
            addCriterion("self_fetch_user not in", values, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserBetween(String value1, String value2) {
            addCriterion("self_fetch_user between", value1, value2, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserNotBetween(String value1, String value2) {
            addCriterion("self_fetch_user not between", value1, value2, "selfFetchUser");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelIsNull() {
            addCriterion("self_fetch_user_tel is null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelIsNotNull() {
            addCriterion("self_fetch_user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelEqualTo(String value) {
            addCriterion("self_fetch_user_tel =", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelNotEqualTo(String value) {
            addCriterion("self_fetch_user_tel <>", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelGreaterThan(String value) {
            addCriterion("self_fetch_user_tel >", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("self_fetch_user_tel >=", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelLessThan(String value) {
            addCriterion("self_fetch_user_tel <", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelLessThanOrEqualTo(String value) {
            addCriterion("self_fetch_user_tel <=", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelLike(String value) {
            addCriterion("self_fetch_user_tel like", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelNotLike(String value) {
            addCriterion("self_fetch_user_tel not like", value, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelIn(List<String> values) {
            addCriterion("self_fetch_user_tel in", values, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelNotIn(List<String> values) {
            addCriterion("self_fetch_user_tel not in", values, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelBetween(String value1, String value2) {
            addCriterion("self_fetch_user_tel between", value1, value2, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andSelfFetchUserTelNotBetween(String value1, String value2) {
            addCriterion("self_fetch_user_tel not between", value1, value2, "selfFetchUserTel");
            return (Criteria) this;
        }

        public Criteria andLonIsNull() {
            addCriterion("lon is null");
            return (Criteria) this;
        }

        public Criteria andLonIsNotNull() {
            addCriterion("lon is not null");
            return (Criteria) this;
        }

        public Criteria andLonEqualTo(String value) {
            addCriterion("lon =", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotEqualTo(String value) {
            addCriterion("lon <>", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThan(String value) {
            addCriterion("lon >", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThanOrEqualTo(String value) {
            addCriterion("lon >=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThan(String value) {
            addCriterion("lon <", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThanOrEqualTo(String value) {
            addCriterion("lon <=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLike(String value) {
            addCriterion("lon like", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotLike(String value) {
            addCriterion("lon not like", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonIn(List<String> values) {
            addCriterion("lon in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotIn(List<String> values) {
            addCriterion("lon not in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonBetween(String value1, String value2) {
            addCriterion("lon between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotBetween(String value1, String value2) {
            addCriterion("lon not between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
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