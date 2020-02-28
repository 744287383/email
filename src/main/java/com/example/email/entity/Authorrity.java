package com.example.email.entity;

import java.util.Date;

public class Authorrity {
    private Long authId;

    private String authName;

    private Date createTime;

    private Date modifyTime;

    public Authorrity(Long authId, String authName, Date createTime, Date modifyTime) {
        this.authId = authId;
        this.authName = authName;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Authorrity() {
        super();
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authId=").append(authId);
        sb.append(", authName=").append(authName);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}