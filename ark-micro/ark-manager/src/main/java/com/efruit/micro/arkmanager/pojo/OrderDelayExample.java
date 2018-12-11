package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDelayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDelayExample() {
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

        public Criteria andDelayIdIsNull() {
            addCriterion("delay_id is null");
            return (Criteria) this;
        }

        public Criteria andDelayIdIsNotNull() {
            addCriterion("delay_id is not null");
            return (Criteria) this;
        }

        public Criteria andDelayIdEqualTo(Integer value) {
            addCriterion("delay_id =", value, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdNotEqualTo(Integer value) {
            addCriterion("delay_id <>", value, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdGreaterThan(Integer value) {
            addCriterion("delay_id >", value, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("delay_id >=", value, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdLessThan(Integer value) {
            addCriterion("delay_id <", value, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdLessThanOrEqualTo(Integer value) {
            addCriterion("delay_id <=", value, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdIn(List<Integer> values) {
            addCriterion("delay_id in", values, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdNotIn(List<Integer> values) {
            addCriterion("delay_id not in", values, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdBetween(Integer value1, Integer value2) {
            addCriterion("delay_id between", value1, value2, "delayId");
            return (Criteria) this;
        }

        public Criteria andDelayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("delay_id not between", value1, value2, "delayId");
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

        public Criteria andOrderDelayDateIsNull() {
            addCriterion("order_delay_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateIsNotNull() {
            addCriterion("order_delay_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateEqualTo(Date value) {
            addCriterion("order_delay_date =", value, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateNotEqualTo(Date value) {
            addCriterion("order_delay_date <>", value, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateGreaterThan(Date value) {
            addCriterion("order_delay_date >", value, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_delay_date >=", value, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateLessThan(Date value) {
            addCriterion("order_delay_date <", value, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateLessThanOrEqualTo(Date value) {
            addCriterion("order_delay_date <=", value, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateIn(List<Date> values) {
            addCriterion("order_delay_date in", values, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateNotIn(List<Date> values) {
            addCriterion("order_delay_date not in", values, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateBetween(Date value1, Date value2) {
            addCriterion("order_delay_date between", value1, value2, "orderDelayDate");
            return (Criteria) this;
        }

        public Criteria andOrderDelayDateNotBetween(Date value1, Date value2) {
            addCriterion("order_delay_date not between", value1, value2, "orderDelayDate");
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