package com.example.email.Enum;

public enum  SenderStatus {
    UNCLEAN(0),
    CLEAN(1);
    private int status;
    SenderStatus(int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
