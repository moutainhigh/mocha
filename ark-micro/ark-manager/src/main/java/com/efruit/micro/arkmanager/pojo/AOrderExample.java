package com.efruit.micro.arkmanager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AOrderExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
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

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductSkuIsNull() {
            addCriterion("product_sku is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuIsNotNull() {
            addCriterion("product_sku is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuEqualTo(String value) {
            addCriterion("product_sku =", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuNotEqualTo(String value) {
            addCriterion("product_sku <>", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuGreaterThan(String value) {
            addCriterion("product_sku >", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuGreaterThanOrEqualTo(String value) {
            addCriterion("product_sku >=", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuLessThan(String value) {
            addCriterion("product_sku <", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuLessThanOrEqualTo(String value) {
            addCriterion("product_sku <=", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuLike(String value) {
            addCriterion("product_sku like", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuNotLike(String value) {
            addCriterion("product_sku not like", value, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuIn(List<String> values) {
            addCriterion("product_sku in", values, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuNotIn(List<String> values) {
            addCriterion("product_sku not in", values, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuBetween(String value1, String value2) {
            addCriterion("product_sku between", value1, value2, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductSkuNotBetween(String value1, String value2) {
            addCriterion("product_sku not between", value1, value2, "productSku");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(Long value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(Long value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(Long value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(Long value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(Long value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<Long> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<Long> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(Long value1, Long value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(Long value1, Long value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
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

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIsNull() {
            addCriterion("shipping_type is null");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIsNotNull() {
            addCriterion("shipping_type is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTypeEqualTo(String value) {
            addCriterion("shipping_type =", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotEqualTo(String value) {
            addCriterion("shipping_type <>", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeGreaterThan(String value) {
            addCriterion("shipping_type >", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_type >=", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLessThan(String value) {
            addCriterion("shipping_type <", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLessThanOrEqualTo(String value) {
            addCriterion("shipping_type <=", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLike(String value) {
            addCriterion("shipping_type like", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotLike(String value) {
            addCriterion("shipping_type not like", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIn(List<String> values) {
            addCriterion("shipping_type in", values, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotIn(List<String> values) {
            addCriterion("shipping_type not in", values, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeBetween(String value1, String value2) {
            addCriterion("shipping_type between", value1, value2, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotBetween(String value1, String value2) {
            addCriterion("shipping_type not between", value1, value2, "shippingType");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgIsNull() {
            addCriterion("buyer_msg is null");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgIsNotNull() {
            addCriterion("buyer_msg is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgEqualTo(String value) {
            addCriterion("buyer_msg =", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgNotEqualTo(String value) {
            addCriterion("buyer_msg <>", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgGreaterThan(String value) {
            addCriterion("buyer_msg >", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_msg >=", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgLessThan(String value) {
            addCriterion("buyer_msg <", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgLessThanOrEqualTo(String value) {
            addCriterion("buyer_msg <=", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgLike(String value) {
            addCriterion("buyer_msg like", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgNotLike(String value) {
            addCriterion("buyer_msg not like", value, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgIn(List<String> values) {
            addCriterion("buyer_msg in", values, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgNotIn(List<String> values) {
            addCriterion("buyer_msg not in", values, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgBetween(String value1, String value2) {
            addCriterion("buyer_msg between", value1, value2, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andBuyerMsgNotBetween(String value1, String value2) {
            addCriterion("buyer_msg not between", value1, value2, "buyerMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgIsNull() {
            addCriterion("trade_msg is null");
            return (Criteria) this;
        }

        public Criteria andTradeMsgIsNotNull() {
            addCriterion("trade_msg is not null");
            return (Criteria) this;
        }

        public Criteria andTradeMsgEqualTo(String value) {
            addCriterion("trade_msg =", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgNotEqualTo(String value) {
            addCriterion("trade_msg <>", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgGreaterThan(String value) {
            addCriterion("trade_msg >", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgGreaterThanOrEqualTo(String value) {
            addCriterion("trade_msg >=", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgLessThan(String value) {
            addCriterion("trade_msg <", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgLessThanOrEqualTo(String value) {
            addCriterion("trade_msg <=", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgLike(String value) {
            addCriterion("trade_msg like", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgNotLike(String value) {
            addCriterion("trade_msg not like", value, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgIn(List<String> values) {
            addCriterion("trade_msg in", values, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgNotIn(List<String> values) {
            addCriterion("trade_msg not in", values, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgBetween(String value1, String value2) {
            addCriterion("trade_msg between", value1, value2, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andTradeMsgNotBetween(String value1, String value2) {
            addCriterion("trade_msg not between", value1, value2, "tradeMsg");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusIsNull() {
            addCriterion("youzan_status is null");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusIsNotNull() {
            addCriterion("youzan_status is not null");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusEqualTo(String value) {
            addCriterion("youzan_status =", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusNotEqualTo(String value) {
            addCriterion("youzan_status <>", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusGreaterThan(String value) {
            addCriterion("youzan_status >", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusGreaterThanOrEqualTo(String value) {
            addCriterion("youzan_status >=", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusLessThan(String value) {
            addCriterion("youzan_status <", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusLessThanOrEqualTo(String value) {
            addCriterion("youzan_status <=", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusLike(String value) {
            addCriterion("youzan_status like", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusNotLike(String value) {
            addCriterion("youzan_status not like", value, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusIn(List<String> values) {
            addCriterion("youzan_status in", values, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusNotIn(List<String> values) {
            addCriterion("youzan_status not in", values, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusBetween(String value1, String value2) {
            addCriterion("youzan_status between", value1, value2, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andYouzanStatusNotBetween(String value1, String value2) {
            addCriterion("youzan_status not between", value1, value2, "youzanStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusIsNull() {
            addCriterion("order_valid_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusIsNotNull() {
            addCriterion("order_valid_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusEqualTo(Integer value) {
            addCriterion("order_valid_status =", value, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusNotEqualTo(Integer value) {
            addCriterion("order_valid_status <>", value, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusGreaterThan(Integer value) {
            addCriterion("order_valid_status >", value, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_valid_status >=", value, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusLessThan(Integer value) {
            addCriterion("order_valid_status <", value, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_valid_status <=", value, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusIn(List<Integer> values) {
            addCriterion("order_valid_status in", values, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusNotIn(List<Integer> values) {
            addCriterion("order_valid_status not in", values, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_valid_status between", value1, value2, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andOrderValidStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_valid_status not between", value1, value2, "orderValidStatus");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdIsNull() {
            addCriterion("renew_order_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdIsNotNull() {
            addCriterion("renew_order_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdEqualTo(Long value) {
            addCriterion("renew_order_parent_id =", value, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdNotEqualTo(Long value) {
            addCriterion("renew_order_parent_id <>", value, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdGreaterThan(Long value) {
            addCriterion("renew_order_parent_id >", value, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("renew_order_parent_id >=", value, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdLessThan(Long value) {
            addCriterion("renew_order_parent_id <", value, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdLessThanOrEqualTo(Long value) {
            addCriterion("renew_order_parent_id <=", value, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdIn(List<Long> values) {
            addCriterion("renew_order_parent_id in", values, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdNotIn(List<Long> values) {
            addCriterion("renew_order_parent_id not in", values, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdBetween(Long value1, Long value2) {
            addCriterion("renew_order_parent_id between", value1, value2, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andRenewOrderParentIdNotBetween(Long value1, Long value2) {
            addCriterion("renew_order_parent_id not between", value1, value2, "renewOrderParentId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeIsNull() {
            addCriterion("order_period_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeIsNotNull() {
            addCriterion("order_period_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeEqualTo(Integer value) {
            addCriterion("order_period_type =", value, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeNotEqualTo(Integer value) {
            addCriterion("order_period_type <>", value, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeGreaterThan(Integer value) {
            addCriterion("order_period_type >", value, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_period_type >=", value, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeLessThan(Integer value) {
            addCriterion("order_period_type <", value, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_period_type <=", value, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeIn(List<Integer> values) {
            addCriterion("order_period_type in", values, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeNotIn(List<Integer> values) {
            addCriterion("order_period_type not in", values, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_period_type between", value1, value2, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andOrderPeriodTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_period_type not between", value1, value2, "orderPeriodType");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateIsNull() {
            addCriterion("order_start_send_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateIsNotNull() {
            addCriterion("order_start_send_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateEqualTo(Date value) {
            addCriterion("order_start_send_date =", value, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateNotEqualTo(Date value) {
            addCriterion("order_start_send_date <>", value, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateGreaterThan(Date value) {
            addCriterion("order_start_send_date >", value, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_start_send_date >=", value, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateLessThan(Date value) {
            addCriterion("order_start_send_date <", value, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateLessThanOrEqualTo(Date value) {
            addCriterion("order_start_send_date <=", value, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateIn(List<Date> values) {
            addCriterion("order_start_send_date in", values, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateNotIn(List<Date> values) {
            addCriterion("order_start_send_date not in", values, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateBetween(Date value1, Date value2) {
            addCriterion("order_start_send_date between", value1, value2, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andOrderStartSendDateNotBetween(Date value1, Date value2) {
            addCriterion("order_start_send_date not between", value1, value2, "orderStartSendDate");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayIsNull() {
            addCriterion("initial_order_day is null");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayIsNotNull() {
            addCriterion("initial_order_day is not null");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayEqualTo(Integer value) {
            addCriterion("initial_order_day =", value, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayNotEqualTo(Integer value) {
            addCriterion("initial_order_day <>", value, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayGreaterThan(Integer value) {
            addCriterion("initial_order_day >", value, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("initial_order_day >=", value, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayLessThan(Integer value) {
            addCriterion("initial_order_day <", value, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayLessThanOrEqualTo(Integer value) {
            addCriterion("initial_order_day <=", value, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayIn(List<Integer> values) {
            addCriterion("initial_order_day in", values, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayNotIn(List<Integer> values) {
            addCriterion("initial_order_day not in", values, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayBetween(Integer value1, Integer value2) {
            addCriterion("initial_order_day between", value1, value2, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andInitialOrderDayNotBetween(Integer value1, Integer value2) {
            addCriterion("initial_order_day not between", value1, value2, "initialOrderDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayIsNull() {
            addCriterion("renew_later_day is null");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayIsNotNull() {
            addCriterion("renew_later_day is not null");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayEqualTo(Integer value) {
            addCriterion("renew_later_day =", value, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayNotEqualTo(Integer value) {
            addCriterion("renew_later_day <>", value, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayGreaterThan(Integer value) {
            addCriterion("renew_later_day >", value, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("renew_later_day >=", value, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayLessThan(Integer value) {
            addCriterion("renew_later_day <", value, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayLessThanOrEqualTo(Integer value) {
            addCriterion("renew_later_day <=", value, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayIn(List<Integer> values) {
            addCriterion("renew_later_day in", values, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayNotIn(List<Integer> values) {
            addCriterion("renew_later_day not in", values, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayBetween(Integer value1, Integer value2) {
            addCriterion("renew_later_day between", value1, value2, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andRenewLaterDayNotBetween(Integer value1, Integer value2) {
            addCriterion("renew_later_day not between", value1, value2, "renewLaterDay");
            return (Criteria) this;
        }

        public Criteria andItemCountIsNull() {
            addCriterion("item_count is null");
            return (Criteria) this;
        }

        public Criteria andItemCountIsNotNull() {
            addCriterion("item_count is not null");
            return (Criteria) this;
        }

        public Criteria andItemCountEqualTo(Integer value) {
            addCriterion("item_count =", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotEqualTo(Integer value) {
            addCriterion("item_count <>", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountGreaterThan(Integer value) {
            addCriterion("item_count >", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_count >=", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLessThan(Integer value) {
            addCriterion("item_count <", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLessThanOrEqualTo(Integer value) {
            addCriterion("item_count <=", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountIn(List<Integer> values) {
            addCriterion("item_count in", values, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotIn(List<Integer> values) {
            addCriterion("item_count not in", values, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountBetween(Integer value1, Integer value2) {
            addCriterion("item_count between", value1, value2, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotBetween(Integer value1, Integer value2) {
            addCriterion("item_count not between", value1, value2, "itemCount");
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

        public Criteria andLastDateIsNull() {
            addCriterion("last_date is null");
            return (Criteria) this;
        }

        public Criteria andLastDateIsNotNull() {
            addCriterion("last_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastDateEqualTo(Date value) {
            addCriterion("last_date =", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotEqualTo(Date value) {
            addCriterion("last_date <>", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThan(Date value) {
            addCriterion("last_date >", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_date >=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThan(Date value) {
            addCriterion("last_date <", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThanOrEqualTo(Date value) {
            addCriterion("last_date <=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateIn(List<Date> values) {
            addCriterion("last_date in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotIn(List<Date> values) {
            addCriterion("last_date not in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateBetween(Date value1, Date value2) {
            addCriterion("last_date between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotBetween(Date value1, Date value2) {
            addCriterion("last_date not between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNull() {
            addCriterion("sku_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNotNull() {
            addCriterion("sku_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuNameEqualTo(String value) {
            addCriterion("sku_name =", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotEqualTo(String value) {
            addCriterion("sku_name <>", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThan(String value) {
            addCriterion("sku_name >", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_name >=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThan(String value) {
            addCriterion("sku_name <", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanOrEqualTo(String value) {
            addCriterion("sku_name <=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLike(String value) {
            addCriterion("sku_name like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotLike(String value) {
            addCriterion("sku_name not like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameIn(List<String> values) {
            addCriterion("sku_name in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotIn(List<String> values) {
            addCriterion("sku_name not in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameBetween(String value1, String value2) {
            addCriterion("sku_name between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotBetween(String value1, String value2) {
            addCriterion("sku_name not between", value1, value2, "skuName");
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