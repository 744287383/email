package com.example.email.entity;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPwdhashIsNull() {
            addCriterion("pwdHash is null");
            return (Criteria) this;
        }

        public Criteria andPwdhashIsNotNull() {
            addCriterion("pwdHash is not null");
            return (Criteria) this;
        }

        public Criteria andPwdhashEqualTo(String value) {
            addCriterion("pwdHash =", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashNotEqualTo(String value) {
            addCriterion("pwdHash <>", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashGreaterThan(String value) {
            addCriterion("pwdHash >", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashGreaterThanOrEqualTo(String value) {
            addCriterion("pwdHash >=", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashLessThan(String value) {
            addCriterion("pwdHash <", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashLessThanOrEqualTo(String value) {
            addCriterion("pwdHash <=", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashLike(String value) {
            addCriterion("pwdHash like", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashNotLike(String value) {
            addCriterion("pwdHash not like", value, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashIn(List<String> values) {
            addCriterion("pwdHash in", values, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashNotIn(List<String> values) {
            addCriterion("pwdHash not in", values, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashBetween(String value1, String value2) {
            addCriterion("pwdHash between", value1, value2, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdhashNotBetween(String value1, String value2) {
            addCriterion("pwdHash not between", value1, value2, "pwdhash");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmIsNull() {
            addCriterion("pwdAlgorithm is null");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmIsNotNull() {
            addCriterion("pwdAlgorithm is not null");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmEqualTo(String value) {
            addCriterion("pwdAlgorithm =", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmNotEqualTo(String value) {
            addCriterion("pwdAlgorithm <>", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmGreaterThan(String value) {
            addCriterion("pwdAlgorithm >", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmGreaterThanOrEqualTo(String value) {
            addCriterion("pwdAlgorithm >=", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmLessThan(String value) {
            addCriterion("pwdAlgorithm <", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmLessThanOrEqualTo(String value) {
            addCriterion("pwdAlgorithm <=", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmLike(String value) {
            addCriterion("pwdAlgorithm like", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmNotLike(String value) {
            addCriterion("pwdAlgorithm not like", value, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmIn(List<String> values) {
            addCriterion("pwdAlgorithm in", values, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmNotIn(List<String> values) {
            addCriterion("pwdAlgorithm not in", values, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmBetween(String value1, String value2) {
            addCriterion("pwdAlgorithm between", value1, value2, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andPwdalgorithmNotBetween(String value1, String value2) {
            addCriterion("pwdAlgorithm not between", value1, value2, "pwdalgorithm");
            return (Criteria) this;
        }

        public Criteria andUseforwardingIsNull() {
            addCriterion("useForwarding is null");
            return (Criteria) this;
        }

        public Criteria andUseforwardingIsNotNull() {
            addCriterion("useForwarding is not null");
            return (Criteria) this;
        }

        public Criteria andUseforwardingEqualTo(Short value) {
            addCriterion("useForwarding =", value, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingNotEqualTo(Short value) {
            addCriterion("useForwarding <>", value, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingGreaterThan(Short value) {
            addCriterion("useForwarding >", value, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingGreaterThanOrEqualTo(Short value) {
            addCriterion("useForwarding >=", value, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingLessThan(Short value) {
            addCriterion("useForwarding <", value, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingLessThanOrEqualTo(Short value) {
            addCriterion("useForwarding <=", value, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingIn(List<Short> values) {
            addCriterion("useForwarding in", values, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingNotIn(List<Short> values) {
            addCriterion("useForwarding not in", values, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingBetween(Short value1, Short value2) {
            addCriterion("useForwarding between", value1, value2, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andUseforwardingNotBetween(Short value1, Short value2) {
            addCriterion("useForwarding not between", value1, value2, "useforwarding");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationIsNull() {
            addCriterion("forwardDestination is null");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationIsNotNull() {
            addCriterion("forwardDestination is not null");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationEqualTo(String value) {
            addCriterion("forwardDestination =", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationNotEqualTo(String value) {
            addCriterion("forwardDestination <>", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationGreaterThan(String value) {
            addCriterion("forwardDestination >", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationGreaterThanOrEqualTo(String value) {
            addCriterion("forwardDestination >=", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationLessThan(String value) {
            addCriterion("forwardDestination <", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationLessThanOrEqualTo(String value) {
            addCriterion("forwardDestination <=", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationLike(String value) {
            addCriterion("forwardDestination like", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationNotLike(String value) {
            addCriterion("forwardDestination not like", value, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationIn(List<String> values) {
            addCriterion("forwardDestination in", values, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationNotIn(List<String> values) {
            addCriterion("forwardDestination not in", values, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationBetween(String value1, String value2) {
            addCriterion("forwardDestination between", value1, value2, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andForwarddestinationNotBetween(String value1, String value2) {
            addCriterion("forwardDestination not between", value1, value2, "forwarddestination");
            return (Criteria) this;
        }

        public Criteria andUsealiasIsNull() {
            addCriterion("useAlias is null");
            return (Criteria) this;
        }

        public Criteria andUsealiasIsNotNull() {
            addCriterion("useAlias is not null");
            return (Criteria) this;
        }

        public Criteria andUsealiasEqualTo(Short value) {
            addCriterion("useAlias =", value, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasNotEqualTo(Short value) {
            addCriterion("useAlias <>", value, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasGreaterThan(Short value) {
            addCriterion("useAlias >", value, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasGreaterThanOrEqualTo(Short value) {
            addCriterion("useAlias >=", value, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasLessThan(Short value) {
            addCriterion("useAlias <", value, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasLessThanOrEqualTo(Short value) {
            addCriterion("useAlias <=", value, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasIn(List<Short> values) {
            addCriterion("useAlias in", values, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasNotIn(List<Short> values) {
            addCriterion("useAlias not in", values, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasBetween(Short value1, Short value2) {
            addCriterion("useAlias between", value1, value2, "usealias");
            return (Criteria) this;
        }

        public Criteria andUsealiasNotBetween(Short value1, Short value2) {
            addCriterion("useAlias not between", value1, value2, "usealias");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
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