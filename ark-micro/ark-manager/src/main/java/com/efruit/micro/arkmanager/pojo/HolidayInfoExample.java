package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HolidayInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HolidayInfoExample() {
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

        public Criteria andDayDateIsNull() {
            addCriterion("day_date is null");
            return (Criteria) this;
        }

        public Criteria andDayDateIsNotNull() {
            addCriterion("day_date is not null");
            return (Criteria) this;
        }

        public Criteria andDayDateEqualTo(Date value) {
            addCriterion("day_date =", value, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateNotEqualTo(Date value) {
            addCriterion("day_date <>", value, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateGreaterThan(Date value) {
            addCriterion("day_date >", value, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("day_date >=", value, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateLessThan(Date value) {
            addCriterion("day_date <", value, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateLessThanOrEqualTo(Date value) {
            addCriterion("day_date <=", value, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateIn(List<Date> values) {
            addCriterion("day_date in", values, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateNotIn(List<Date> values) {
            addCriterion("day_date not in", values, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateBetween(Date value1, Date value2) {
            addCriterion("day_date between", value1, value2, "dayDate");
            return (Criteria) this;
        }

        public Criteria andDayDateNotBetween(Date value1, Date value2) {
            addCriterion("day_date not between", value1, value2, "dayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayIsNull() {
            addCriterion("holiday is null");
            return (Criteria) this;
        }

        public Criteria andHolidayIsNotNull() {
            addCriterion("holiday is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayEqualTo(Integer value) {
            addCriterion("holiday =", value, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayNotEqualTo(Integer value) {
            addCriterion("holiday <>", value, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayGreaterThan(Integer value) {
            addCriterion("holiday >", value, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayGreaterThanOrEqualTo(Integer value) {
            addCriterion("holiday >=", value, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayLessThan(Integer value) {
            addCriterion("holiday <", value, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayLessThanOrEqualTo(Integer value) {
            addCriterion("holiday <=", value, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayIn(List<Integer> values) {
            addCriterion("holiday in", values, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayNotIn(List<Integer> values) {
            addCriterion("holiday not in", values, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayBetween(Integer value1, Integer value2) {
            addCriterion("holiday between", value1, value2, "holiday");
            return (Criteria) this;
        }

        public Criteria andHolidayNotBetween(Integer value1, Integer value2) {
            addCriterion("holiday not between", value1, value2, "holiday");
            return (Criteria) this;
        }

        public Criteria andNameDescIsNull() {
            addCriterion("name_desc is null");
            return (Criteria) this;
        }

        public Criteria andNameDescIsNotNull() {
            addCriterion("name_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNameDescEqualTo(String value) {
            addCriterion("name_desc =", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescNotEqualTo(String value) {
            addCriterion("name_desc <>", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescGreaterThan(String value) {
            addCriterion("name_desc >", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescGreaterThanOrEqualTo(String value) {
            addCriterion("name_desc >=", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescLessThan(String value) {
            addCriterion("name_desc <", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescLessThanOrEqualTo(String value) {
            addCriterion("name_desc <=", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescLike(String value) {
            addCriterion("name_desc like", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescNotLike(String value) {
            addCriterion("name_desc not like", value, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescIn(List<String> values) {
            addCriterion("name_desc in", values, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescNotIn(List<String> values) {
            addCriterion("name_desc not in", values, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescBetween(String value1, String value2) {
            addCriterion("name_desc between", value1, value2, "nameDesc");
            return (Criteria) this;
        }

        public Criteria andNameDescNotBetween(String value1, String value2) {
            addCriterion("name_desc not between", value1, value2, "nameDesc");
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