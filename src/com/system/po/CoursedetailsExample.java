package com.system.po;

import java.util.ArrayList;
import java.util.List;

public class CoursedetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoursedetailsExample() {
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

        public Criteria andCourseidIsNull() {
            addCriterion("courseID is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("courseID =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("courseID <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("courseID >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseID >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("courseID <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("courseID <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("courseID in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("courseID not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("courseID between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("courseID not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andStepidIsNull() {
            addCriterion("stepid is null");
            return (Criteria) this;
        }

        public Criteria andStepidIsNotNull() {
            addCriterion("stepid is not null");
            return (Criteria) this;
        }

        public Criteria andStepidEqualTo(String value) {
            addCriterion("stepid =", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotEqualTo(String value) {
            addCriterion("stepid <>", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidGreaterThan(String value) {
            addCriterion("stepid >", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidGreaterThanOrEqualTo(String value) {
            addCriterion("stepid >=", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLessThan(String value) {
            addCriterion("stepid <", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLessThanOrEqualTo(String value) {
            addCriterion("stepid <=", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLike(String value) {
            addCriterion("stepid like", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotLike(String value) {
            addCriterion("stepid not like", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidIn(List<String> values) {
            addCriterion("stepid in", values, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotIn(List<String> values) {
            addCriterion("stepid not in", values, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidBetween(String value1, String value2) {
            addCriterion("stepid between", value1, value2, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotBetween(String value1, String value2) {
            addCriterion("stepid not between", value1, value2, "stepid");
            return (Criteria) this;
        }

        public Criteria andFile1IsNull() {
            addCriterion("file1 is null");
            return (Criteria) this;
        }

        public Criteria andFile1IsNotNull() {
            addCriterion("file1 is not null");
            return (Criteria) this;
        }

        public Criteria andFile1EqualTo(String value) {
            addCriterion("file1 =", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1NotEqualTo(String value) {
            addCriterion("file1 <>", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1GreaterThan(String value) {
            addCriterion("file1 >", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1GreaterThanOrEqualTo(String value) {
            addCriterion("file1 >=", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1LessThan(String value) {
            addCriterion("file1 <", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1LessThanOrEqualTo(String value) {
            addCriterion("file1 <=", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1Like(String value) {
            addCriterion("file1 like", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1NotLike(String value) {
            addCriterion("file1 not like", value, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1In(List<String> values) {
            addCriterion("file1 in", values, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1NotIn(List<String> values) {
            addCriterion("file1 not in", values, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1Between(String value1, String value2) {
            addCriterion("file1 between", value1, value2, "file1");
            return (Criteria) this;
        }

        public Criteria andFile1NotBetween(String value1, String value2) {
            addCriterion("file1 not between", value1, value2, "file1");
            return (Criteria) this;
        }

        public Criteria andFile2IsNull() {
            addCriterion("file2 is null");
            return (Criteria) this;
        }

        public Criteria andFile2IsNotNull() {
            addCriterion("file2 is not null");
            return (Criteria) this;
        }

        public Criteria andFile2EqualTo(String value) {
            addCriterion("file2 =", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2NotEqualTo(String value) {
            addCriterion("file2 <>", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2GreaterThan(String value) {
            addCriterion("file2 >", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2GreaterThanOrEqualTo(String value) {
            addCriterion("file2 >=", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2LessThan(String value) {
            addCriterion("file2 <", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2LessThanOrEqualTo(String value) {
            addCriterion("file2 <=", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2Like(String value) {
            addCriterion("file2 like", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2NotLike(String value) {
            addCriterion("file2 not like", value, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2In(List<String> values) {
            addCriterion("file2 in", values, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2NotIn(List<String> values) {
            addCriterion("file2 not in", values, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2Between(String value1, String value2) {
            addCriterion("file2 between", value1, value2, "file2");
            return (Criteria) this;
        }

        public Criteria andFile2NotBetween(String value1, String value2) {
            addCriterion("file2 not between", value1, value2, "file2");
            return (Criteria) this;
        }

        public Criteria andFile3IsNull() {
            addCriterion("file3 is null");
            return (Criteria) this;
        }

        public Criteria andFile3IsNotNull() {
            addCriterion("file3 is not null");
            return (Criteria) this;
        }

        public Criteria andFile3EqualTo(String value) {
            addCriterion("file3 =", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3NotEqualTo(String value) {
            addCriterion("file3 <>", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3GreaterThan(String value) {
            addCriterion("file3 >", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3GreaterThanOrEqualTo(String value) {
            addCriterion("file3 >=", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3LessThan(String value) {
            addCriterion("file3 <", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3LessThanOrEqualTo(String value) {
            addCriterion("file3 <=", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3Like(String value) {
            addCriterion("file3 like", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3NotLike(String value) {
            addCriterion("file3 not like", value, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3In(List<String> values) {
            addCriterion("file3 in", values, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3NotIn(List<String> values) {
            addCriterion("file3 not in", values, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3Between(String value1, String value2) {
            addCriterion("file3 between", value1, value2, "file3");
            return (Criteria) this;
        }

        public Criteria andFile3NotBetween(String value1, String value2) {
            addCriterion("file3 not between", value1, value2, "file3");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
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