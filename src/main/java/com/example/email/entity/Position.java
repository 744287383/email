package com.example.email.entity;

import java.util.Date;

public class Position {
    private Long positionId;

    private String positionName;

    private Date createTime;

    private Date modifyTime;

    private Long authId;

    public Position(Long positionId, String positionName, Date createTime, Date modifyTime, Long authId) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.authId = authId;
    }

    public Position() {
        super();
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
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

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", positionId=").append(positionId);
        sb.append(", positionName=").append(positionName);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", authId=").append(authId);
        sb.append("]");
        return sb.toString();
    }
}