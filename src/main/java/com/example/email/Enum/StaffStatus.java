package com.example.email.Enum;

public enum StaffStatus {
    QUIT(1),
    UNQUIT(0);
    private int status;
     StaffStatus(int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
