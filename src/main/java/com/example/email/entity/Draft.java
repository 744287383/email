package com.example.email.entity;

import java.util.Date;

public class Draft {
    private Long id;

    private String recipients;

    private String subjects;

    private String content;

    private String sender;

    private Integer type;

    private Date createTime;

    public Draft(Long id, String recipients, String subjects, String content, String sender, Integer type, Date createTime) {
        this.id = id;
        this.recipients = recipients;
        this.subjects = subjects;
        this.content = content;
        this.sender = sender;
        this.type = type;
        this.createTime = createTime;
    }

    public Draft() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients == null ? null : recipients.trim();
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects == null ? null : subjects.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", id=").append(id);
        sb.append(", recipients=").append(recipients);
        sb.append(", subjects=").append(subjects);
        sb.append(", content=").append(content);
        sb.append(", sender=").append(sender);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}