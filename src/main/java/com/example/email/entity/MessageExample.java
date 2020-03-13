package com.example.email.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMessageNameIsNull() {
            addCriterion("message_name is null");
            return (Criteria) this;
        }

        public Criteria andMessageNameIsNotNull() {
            addCriterion("message_name is not null");
            return (Criteria) this;
        }

        public Criteria andMessageNameEqualTo(String value) {
            addCriterion("message_name =", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotEqualTo(String value) {
            addCriterion("message_name <>", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameGreaterThan(String value) {
            addCriterion("message_name >", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameGreaterThanOrEqualTo(String value) {
            addCriterion("message_name >=", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLessThan(String value) {
            addCriterion("message_name <", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLessThanOrEqualTo(String value) {
            addCriterion("message_name <=", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameLike(String value) {
            addCriterion("message_name like", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotLike(String value) {
            addCriterion("message_name not like", value, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameIn(List<String> values) {
            addCriterion("message_name in", values, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotIn(List<String> values) {
            addCriterion("message_name not in", values, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameBetween(String value1, String value2) {
            addCriterion("message_name between", value1, value2, "messageName");
            return (Criteria) this;
        }

        public Criteria andMessageNameNotBetween(String value1, String value2) {
            addCriterion("message_name not between", value1, value2, "messageName");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andRecipientsIsNull() {
            addCriterion("recipients is null");
            return (Criteria) this;
        }

        public Criteria andRecipientsIsNotNull() {
            addCriterion("recipients is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientsEqualTo(String value) {
            addCriterion("recipients =", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotEqualTo(String value) {
            addCriterion("recipients <>", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsGreaterThan(String value) {
            addCriterion("recipients >", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsGreaterThanOrEqualTo(String value) {
            addCriterion("recipients >=", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsLessThan(String value) {
            addCriterion("recipients <", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsLessThanOrEqualTo(String value) {
            addCriterion("recipients <=", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsLike(String value) {
            addCriterion("recipients like", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotLike(String value) {
            addCriterion("recipients not like", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsIn(List<String> values) {
            addCriterion("recipients in", values, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotIn(List<String> values) {
            addCriterion("recipients not in", values, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsBetween(String value1, String value2) {
            addCriterion("recipients between", value1, value2, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotBetween(String value1, String value2) {
            addCriterion("recipients not between", value1, value2, "recipients");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNull() {
            addCriterion("last_updated is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNotNull() {
            addCriterion("last_updated is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualTo(Date value) {
            addCriterion("last_updated =", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("last_updated <>", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("last_updated >", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updated >=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("last_updated <", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("last_updated <=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIn(List<Date> values) {
            addCriterion("last_updated in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotIn(List<Date> values) {
            addCriterion("last_updated not in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedBetween(Date value1, Date value2) {
            addCriterion("last_updated between", value1, value2, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("last_updated not between", value1, value2, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andReadedIsNull() {
            addCriterion("readed is null");
            return (Criteria) this;
        }

        public Criteria andReadedIsNotNull() {
            addCriterion("readed is not null");
            return (Criteria) this;
        }

        public Criteria andReadedEqualTo(Integer value) {
            addCriterion("readed =", value, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedNotEqualTo(Integer value) {
            addCriterion("readed <>", value, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedGreaterThan(Integer value) {
            addCriterion("readed >", value, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedGreaterThanOrEqualTo(Integer value) {
            addCriterion("readed >=", value, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedLessThan(Integer value) {
            addCriterion("readed <", value, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedLessThanOrEqualTo(Integer value) {
            addCriterion("readed <=", value, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedIn(List<Integer> values) {
            addCriterion("readed in", values, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedNotIn(List<Integer> values) {
            addCriterion("readed not in", values, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedBetween(Integer value1, Integer value2) {
            addCriterion("readed between", value1, value2, "readed");
            return (Criteria) this;
        }

        public Criteria andReadedNotBetween(Integer value1, Integer value2) {
            addCriterion("readed not between", value1, value2, "readed");
            return (Criteria) this;
        }

        public Criteria andSenderStatusIsNull() {
            addCriterion("sender_status is null");
            return (Criteria) this;
        }

        public Criteria andSenderStatusIsNotNull() {
            addCriterion("sender_status is not null");
            return (Criteria) this;
        }

        public Criteria andSenderStatusEqualTo(Integer value) {
            addCriterion("sender_status =", value, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusNotEqualTo(Integer value) {
            addCriterion("sender_status <>", value, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusGreaterThan(Integer value) {
            addCriterion("sender_status >", value, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sender_status >=", value, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusLessThan(Integer value) {
            addCriterion("sender_status <", value, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sender_status <=", value, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusIn(List<Integer> values) {
            addCriterion("sender_status in", values, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusNotIn(List<Integer> values) {
            addCriterion("sender_status not in", values, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusBetween(Integer value1, Integer value2) {
            addCriterion("sender_status between", value1, value2, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andSenderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sender_status not between", value1, value2, "senderStatus");
            return (Criteria) this;
        }

        public Criteria andNewMsgIsNull() {
            addCriterion("new_msg is null");
            return (Criteria) this;
        }

        public Criteria andNewMsgIsNotNull() {
            addCriterion("new_msg is not null");
            return (Criteria) this;
        }

        public Criteria andNewMsgEqualTo(Integer value) {
            addCriterion("new_msg =", value, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotEqualTo(Integer value) {
            addCriterion("new_msg <>", value, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgGreaterThan(Integer value) {
            addCriterion("new_msg >", value, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_msg >=", value, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgLessThan(Integer value) {
            addCriterion("new_msg <", value, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgLessThanOrEqualTo(Integer value) {
            addCriterion("new_msg <=", value, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgIn(List<Integer> values) {
            addCriterion("new_msg in", values, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotIn(List<Integer> values) {
            addCriterion("new_msg not in", values, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgBetween(Integer value1, Integer value2) {
            addCriterion("new_msg between", value1, value2, "newMsg");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotBetween(Integer value1, Integer value2) {
            addCriterion("new_msg not between", value1, value2, "newMsg");
            return (Criteria) this;
        }

        public Criteria andIsFileIsNull() {
            addCriterion("is_file is null");
            return (Criteria) this;
        }

        public Criteria andIsFileIsNotNull() {
            addCriterion("is_file is not null");
            return (Criteria) this;
        }

        public Criteria andIsFileEqualTo(Integer value) {
            addCriterion("is_file =", value, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileNotEqualTo(Integer value) {
            addCriterion("is_file <>", value, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileGreaterThan(Integer value) {
            addCriterion("is_file >", value, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_file >=", value, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileLessThan(Integer value) {
            addCriterion("is_file <", value, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileLessThanOrEqualTo(Integer value) {
            addCriterion("is_file <=", value, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileIn(List<Integer> values) {
            addCriterion("is_file in", values, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileNotIn(List<Integer> values) {
            addCriterion("is_file not in", values, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileBetween(Integer value1, Integer value2) {
            addCriterion("is_file between", value1, value2, "isFile");
            return (Criteria) this;
        }

        public Criteria andIsFileNotBetween(Integer value1, Integer value2) {
            addCriterion("is_file not between", value1, value2, "isFile");
            return (Criteria) this;
        }

        public Criteria andRecStatusIsNull() {
            addCriterion("rec__status is null");
            return (Criteria) this;
        }

        public Criteria andRecStatusIsNotNull() {
            addCriterion("rec__status is not null");
            return (Criteria) this;
        }

        public Criteria andRecStatusEqualTo(Integer value) {
            addCriterion("rec__status =", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusNotEqualTo(Integer value) {
            addCriterion("rec__status <>", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusGreaterThan(Integer value) {
            addCriterion("rec__status >", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("rec__status >=", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusLessThan(Integer value) {
            addCriterion("rec__status <", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusLessThanOrEqualTo(Integer value) {
            addCriterion("rec__status <=", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusIn(List<Integer> values) {
            addCriterion("rec__status in", values, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusNotIn(List<Integer> values) {
            addCriterion("rec__status not in", values, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusBetween(Integer value1, Integer value2) {
            addCriterion("rec__status between", value1, value2, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("rec__status not between", value1, value2, "recStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
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