package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModifyOrderHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModifyOrderHistoryExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNull() {
            addCriterion("modify_user is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("modify_user is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("modify_user =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("modify_user <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("modify_user >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("modify_user <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("modify_user <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("modify_user like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("modify_user not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("modify_user in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("modify_user not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("modify_user between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("modify_user not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyFromIsNull() {
            addCriterion("modify_from is null");
            return (Criteria) this;
        }

        public Criteria andModifyFromIsNotNull() {
            addCriterion("modify_from is not null");
            return (Criteria) this;
        }

        public Criteria andModifyFromEqualTo(Integer value) {
            addCriterion("modify_from =", value, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromNotEqualTo(Integer value) {
            addCriterion("modify_from <>", value, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromGreaterThan(Integer value) {
            addCriterion("modify_from >", value, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("modify_from >=", value, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromLessThan(Integer value) {
            addCriterion("modify_from <", value, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromLessThanOrEqualTo(Integer value) {
            addCriterion("modify_from <=", value, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromIn(List<Integer> values) {
            addCriterion("modify_from in", values, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromNotIn(List<Integer> values) {
            addCriterion("modify_from not in", values, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromBetween(Integer value1, Integer value2) {
            addCriterion("modify_from between", value1, value2, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyFromNotBetween(Integer value1, Integer value2) {
            addCriterion("modify_from not between", value1, value2, "modifyFrom");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoIsNull() {
            addCriterion("before_order_info is null");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoIsNotNull() {
            addCriterion("before_order_info is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoEqualTo(String value) {
            addCriterion("before_order_info =", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoNotEqualTo(String value) {
            addCriterion("before_order_info <>", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoGreaterThan(String value) {
            addCriterion("before_order_info >", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoGreaterThanOrEqualTo(String value) {
            addCriterion("before_order_info >=", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoLessThan(String value) {
            addCriterion("before_order_info <", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoLessThanOrEqualTo(String value) {
            addCriterion("before_order_info <=", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoLike(String value) {
            addCriterion("before_order_info like", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoNotLike(String value) {
            addCriterion("before_order_info not like", value, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoIn(List<String> values) {
            addCriterion("before_order_info in", values, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoNotIn(List<String> values) {
            addCriterion("before_order_info not in", values, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoBetween(String value1, String value2) {
            addCriterion("before_order_info between", value1, value2, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeOrderInfoNotBetween(String value1, String value2) {
            addCriterion("before_order_info not between", value1, value2, "beforeOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoIsNull() {
            addCriterion("after_order_info is null");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoIsNotNull() {
            addCriterion("after_order_info is not null");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoEqualTo(String value) {
            addCriterion("after_order_info =", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoNotEqualTo(String value) {
            addCriterion("after_order_info <>", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoGreaterThan(String value) {
            addCriterion("after_order_info >", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoGreaterThanOrEqualTo(String value) {
            addCriterion("after_order_info >=", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoLessThan(String value) {
            addCriterion("after_order_info <", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoLessThanOrEqualTo(String value) {
            addCriterion("after_order_info <=", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoLike(String value) {
            addCriterion("after_order_info like", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoNotLike(String value) {
            addCriterion("after_order_info not like", value, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoIn(List<String> values) {
            addCriterion("after_order_info in", values, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoNotIn(List<String> values) {
            addCriterion("after_order_info not in", values, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoBetween(String value1, String value2) {
            addCriterion("after_order_info between", value1, value2, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andAfterOrderInfoNotBetween(String value1, String value2) {
            addCriterion("after_order_info not between", value1, value2, "afterOrderInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoIsNull() {
            addCriterion("before_delay_info is null");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoIsNotNull() {
            addCriterion("before_delay_info is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoEqualTo(String value) {
            addCriterion("before_delay_info =", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoNotEqualTo(String value) {
            addCriterion("before_delay_info <>", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoGreaterThan(String value) {
            addCriterion("before_delay_info >", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoGreaterThanOrEqualTo(String value) {
            addCriterion("before_delay_info >=", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoLessThan(String value) {
            addCriterion("before_delay_info <", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoLessThanOrEqualTo(String value) {
            addCriterion("before_delay_info <=", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoLike(String value) {
            addCriterion("before_delay_info like", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoNotLike(String value) {
            addCriterion("before_delay_info not like", value, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoIn(List<String> values) {
            addCriterion("before_delay_info in", values, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoNotIn(List<String> values) {
            addCriterion("before_delay_info not in", values, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoBetween(String value1, String value2) {
            addCriterion("before_delay_info between", value1, value2, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andBeforeDelayInfoNotBetween(String value1, String value2) {
            addCriterion("before_delay_info not between", value1, value2, "beforeDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoIsNull() {
            addCriterion("after_delay_info is null");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoIsNotNull() {
            addCriterion("after_delay_info is not null");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoEqualTo(String value) {
            addCriterion("after_delay_info =", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoNotEqualTo(String value) {
            addCriterion("after_delay_info <>", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoGreaterThan(String value) {
            addCriterion("after_delay_info >", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoGreaterThanOrEqualTo(String value) {
            addCriterion("after_delay_info >=", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoLessThan(String value) {
            addCriterion("after_delay_info <", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoLessThanOrEqualTo(String value) {
            addCriterion("after_delay_info <=", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoLike(String value) {
            addCriterion("after_delay_info like", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoNotLike(String value) {
            addCriterion("after_delay_info not like", value, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoIn(List<String> values) {
            addCriterion("after_delay_info in", values, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoNotIn(List<String> values) {
            addCriterion("after_delay_info not in", values, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoBetween(String value1, String value2) {
            addCriterion("after_delay_info between", value1, value2, "afterDelayInfo");
            return (Criteria) this;
        }

        public Criteria andAfterDelayInfoNotBetween(String value1, String value2) {
            addCriterion("after_delay_info not between", value1, value2, "afterDelayInfo");
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