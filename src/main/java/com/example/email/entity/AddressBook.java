package com.example.email.entity;

public class AddressBook {
    private Long aid;

    private Long friendgroupId;

    private String userName;

    public AddressBook(Long aid, Long friendgroupId, String userName) {
        this.aid = aid;
        this.friendgroupId = friendgroupId;
        this.userName = userName;
    }

    public AddressBook() {
        super();
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getFriendgroupId() {
        return friendgroupId;
    }

    public void setFriendgroupId(Long friendgroupId) {
        this.friendgroupId = friendgroupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", friendgroupId=").append(friendgroupId);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}