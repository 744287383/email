package com.example.email.Enum;

public enum NewMsgStatus {
    NEW_MSG(1),
    OLD_MSG(0);
    private int status;
    private NewMsgStatus(int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
