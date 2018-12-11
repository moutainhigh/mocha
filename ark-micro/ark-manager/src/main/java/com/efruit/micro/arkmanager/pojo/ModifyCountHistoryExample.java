package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModifyCountHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModifyCountHistoryExample() {
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

        public Criteria andModifyMsgIsNull() {
            addCriterion("modify_msg is null");
            return (Criteria) this;
        }

        public Criteria andModifyMsgIsNotNull() {
            addCriterion("modify_msg is not null");
            return (Criteria) this;
        }

        public Criteria andModifyMsgEqualTo(String value) {
            addCriterion("modify_msg =", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgNotEqualTo(String value) {
            addCriterion("modify_msg <>", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgGreaterThan(String value) {
            addCriterion("modify_msg >", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgGreaterThanOrEqualTo(String value) {
            addCriterion("modify_msg >=", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgLessThan(String value) {
            addCriterion("modify_msg <", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgLessThanOrEqualTo(String value) {
            addCriterion("modify_msg <=", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgLike(String value) {
            addCriterion("modify_msg like", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgNotLike(String value) {
            addCriterion("modify_msg not like", value, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgIn(List<String> values) {
            addCriterion("modify_msg in", values, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgNotIn(List<String> values) {
            addCriterion("modify_msg not in", values, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgBetween(String value1, String value2) {
            addCriterion("modify_msg between", value1, value2, "modifyMsg");
            return (Criteria) this;
        }

        public Criteria andModifyMsgNotBetween(String value1, String value2) {
            addCriterion("modify_msg not between", value1, value2, "modifyMsg");
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

        public Criteria andModifyCountIsNull() {
            addCriterion("modify_count is null");
            return (Criteria) this;
        }

        public Criteria andModifyCountIsNotNull() {
            addCriterion("modify_count is not null");
            return (Criteria) this;
        }

        public Criteria andModifyCountEqualTo(Integer value) {
            addCriterion("modify_count =", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountNotEqualTo(Integer value) {
            addCriterion("modify_count <>", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountGreaterThan(Integer value) {
            addCriterion("modify_count >", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("modify_count >=", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountLessThan(Integer value) {
            addCriterion("modify_count <", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountLessThanOrEqualTo(Integer value) {
            addCriterion("modify_count <=", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountIn(List<Integer> values) {
            addCriterion("modify_count in", values, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountNotIn(List<Integer> values) {
            addCriterion("modify_count not in", values, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountBetween(Integer value1, Integer value2) {
            addCriterion("modify_count between", value1, value2, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("modify_count not between", value1, value2, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountIsNull() {
            addCriterion("before_count is null");
            return (Criteria) this;
        }

        public Criteria andBeforeCountIsNotNull() {
            addCriterion("before_count is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeCountEqualTo(Integer value) {
            addCriterion("before_count =", value, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountNotEqualTo(Integer value) {
            addCriterion("before_count <>", value, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountGreaterThan(Integer value) {
            addCriterion("before_count >", value, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("before_count >=", value, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountLessThan(Integer value) {
            addCriterion("before_count <", value, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountLessThanOrEqualTo(Integer value) {
            addCriterion("before_count <=", value, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountIn(List<Integer> values) {
            addCriterion("before_count in", values, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountNotIn(List<Integer> values) {
            addCriterion("before_count not in", values, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountBetween(Integer value1, Integer value2) {
            addCriterion("before_count between", value1, value2, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andBeforeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("before_count not between", value1, value2, "beforeCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountIsNull() {
            addCriterion("after_count is null");
            return (Criteria) this;
        }

        public Criteria andAfterCountIsNotNull() {
            addCriterion("after_count is not null");
            return (Criteria) this;
        }

        public Criteria andAfterCountEqualTo(Integer value) {
            addCriterion("after_count =", value, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountNotEqualTo(Integer value) {
            addCriterion("after_count <>", value, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountGreaterThan(Integer value) {
            addCriterion("after_count >", value, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("after_count >=", value, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountLessThan(Integer value) {
            addCriterion("after_count <", value, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountLessThanOrEqualTo(Integer value) {
            addCriterion("after_count <=", value, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountIn(List<Integer> values) {
            addCriterion("after_count in", values, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountNotIn(List<Integer> values) {
            addCriterion("after_count not in", values, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountBetween(Integer value1, Integer value2) {
            addCriterion("after_count between", value1, value2, "afterCount");
            return (Criteria) this;
        }

        public Criteria andAfterCountNotBetween(Integer value1, Integer value2) {
            addCriterion("after_count not between", value1, value2, "afterCount");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNull() {
            addCriterion("from_type is null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNotNull() {
            addCriterion("from_type is not null");
            return (Criteria) this;
        }

        public Criteria andFromTypeEqualTo(Integer value) {
            addCriterion("from_type =", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotEqualTo(Integer value) {
            addCriterion("from_type <>", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThan(Integer value) {
            addCriterion("from_type >", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_type >=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThan(Integer value) {
            addCriterion("from_type <", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThanOrEqualTo(Integer value) {
            addCriterion("from_type <=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeIn(List<Integer> values) {
            addCriterion("from_type in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotIn(List<Integer> values) {
            addCriterion("from_type not in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeBetween(Integer value1, Integer value2) {
            addCriterion("from_type between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("from_type not between", value1, value2, "fromType");
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