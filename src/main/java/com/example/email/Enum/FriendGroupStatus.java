package com.example.email.Enum;

public enum FriendGroupStatus {
    DEFAULT(1),
    UNDEFAULT(0);
    private int status;
     FriendGroupStatus(int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
