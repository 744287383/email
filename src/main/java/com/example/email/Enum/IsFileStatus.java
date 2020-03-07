package com.example.email.Enum;

public enum  IsFileStatus {
    IS_FILE(1),
    NO_FILE(0);
    private int status;
    IsFileStatus(int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
