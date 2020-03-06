package com.example.email.Enum;

import lombok.Data;


public enum ReadStatus {
    UNREAD(0),
    READED(1);

    private int status;
    private ReadStatus (int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
