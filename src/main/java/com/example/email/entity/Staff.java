package com.example.email.entity;

import java.util.Date;

public class Staff {
    private Long id;

    private String userName;

    private String loginPassword;

    private String email;

    private String emailPassword;

    private Date startTime;

    private Date loginTime;

    private String nameall;

    private Long positionId;

    private String cardNo;

    private String imgUrl;

    private String qq;

    private String wechatNo;

    private String cellPhone;

    private Long deptNo;

    private String token;

    private Integer sex;

    private Integer status;

    public Staff(Long id, String userName, String loginPassword, String email, String emailPassword, Date startTime, Date loginTime, String nameall, Long positionId, String cardNo, String imgUrl, String qq, String wechatNo, String cellPhone, Long deptNo, String token, Integer sex, Integer status) {
        this.id = id;
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.email = email;
        this.emailPassword = emailPassword;
        this.startTime = startTime;
        this.loginTime = loginTime;
        this.nameall = nameall;
        this.positionId = positionId;
        this.cardNo = cardNo;
        this.imgUrl = imgUrl;
        this.qq = qq;
        this.wechatNo = wechatNo;
        this.cellPhone = cellPhone;
        this.deptNo = deptNo;
        this.token = token;
        this.sex = sex;
        this.status = status;
    }

    public Staff() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword == null ? null : emailPassword.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getNameall() {
        return nameall;
    }

    public void setNameall(String nameall) {
        this.nameall = nameall == null ? null : nameall.trim();
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo == null ? null : wechatNo.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", email=").append(email);
        sb.append(", emailPassword=").append(emailPassword);
        sb.append(", startTime=").append(startTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", nameall=").append(nameall);
        sb.append(", positionId=").append(positionId);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", qq=").append(qq);
        sb.append(", wechatNo=").append(wechatNo);
        sb.append(", cellPhone=").append(cellPhone);
        sb.append(", deptNo=").append(deptNo);
        sb.append(", token=").append(token);
        sb.append(", sex=").append(sex);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}