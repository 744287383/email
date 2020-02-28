package com.example.email.entity;

import java.util.Date;

public class Dept {
    private Long deptNo;

    private String deptName;

    private Date createTime;

    public Dept(Long deptNo, String deptName, Date createTime) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.createTime = createTime;
    }

    public Dept() {
        super();
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptNo=").append(deptNo);
        sb.append(", deptName=").append(deptName);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}