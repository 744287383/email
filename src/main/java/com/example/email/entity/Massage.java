package com.example.email.entity;

import java.util.Date;

public class Massage {
    private Long id;

    private String messageName;

    private String sender;

    private Date lastUpdated;

    private Integer readed;

    private Integer senderStatus;

    private Integer newMsg;

    private Integer isFile;

    private Integer recStatus;

    private String recipients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName == null ? null : messageName.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getReaded() {
        return readed;
    }

    public void setReaded(Integer readed) {
        this.readed = readed;
    }

    public Integer getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(Integer senderStatus) {
        this.senderStatus = senderStatus;
    }

    public Integer getNewMsg() {
        return newMsg;
    }

    public void setNewMsg(Integer newMsg) {
        this.newMsg = newMsg;
    }

    public Integer getIsFile() {
        return isFile;
    }

    public void setIsFile(Integer isFile) {
        this.isFile = isFile;
    }

    public Integer getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(Integer recStatus) {
        this.recStatus = recStatus;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients == null ? null : recipients.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", messageName=").append(messageName);
        sb.append(", sender=").append(sender);
        sb.append(", lastUpdated=").append(lastUpdated);
        sb.append(", readed=").append(readed);
        sb.append(", senderStatus=").append(senderStatus);
        sb.append(", newMsg=").append(newMsg);
        sb.append(", isFile=").append(isFile);
        sb.append(", recStatus=").append(recStatus);
        sb.append(", recipients=").append(recipients);
        sb.append("]");
        return sb.toString();
    }
}