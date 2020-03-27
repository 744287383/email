package com.example.email.ModelDTO;

import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


public class MessageInfoDTO {
    private String messageName;
    private String subject;
    private String senderNameAll;
    private String senderEmail;
    private String acceptNameAll;
    private String acceptEmail;
    private String fileName;
    private String fileurl;
    private String text;
    private String sendDate;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSenderNameAll(String senderNameAll) {
        this.senderNameAll = senderNameAll;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void setAcceptNameAll(String acceptNameAll) {
        this.acceptNameAll = acceptNameAll;
    }

    public void setAcceptEmail(String acceptEmail) {
        this.acceptEmail = acceptEmail;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessageName() {
        return messageName;
    }

    public String getSubject() {
        return subject;
    }

    public String getSenderNameAll() {
        return senderNameAll;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getAcceptNameAll() {
        return acceptNameAll;
    }

    public String getAcceptEmail() {
        return acceptEmail;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileurl() {
        return fileurl;
    }

    public String getText() {
        return text;
    }
}
