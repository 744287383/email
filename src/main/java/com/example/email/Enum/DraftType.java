package com.example.email.Enum;

public enum DraftType {
    ONE(0),
    more(1);
    private int type;

    DraftType(int type) {
        this.type=type;
    }

    public int getType() {
        return type;
    }
}
