package com.example.email.entity;

public class FriendGroup {
    private Long id;

    private String groupName;

    private String userName;

    private Integer defaultGroup;

    public FriendGroup(Long id, String groupName, String userName, Integer defaultGroup) {
        this.id = id;
        this.groupName = groupName;
        this.userName = userName;
        this.defaultGroup = defaultGroup;
    }

    public FriendGroup() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(Integer defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupName=").append(groupName);
        sb.append(", userName=").append(userName);
        sb.append(", defaultGroup=").append(defaultGroup);
        sb.append("]");
        return sb.toString();
    }


}