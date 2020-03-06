package com.example.email.Enum;

public enum  RecStatus {
    UNDELETE(0),
    DELETED(1),
    DELETE_COMPLETELY(2);
    private int status;
    private RecStatus (int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
