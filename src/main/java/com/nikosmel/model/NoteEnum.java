package com.nikosmel.model;

public enum NoteEnum {

    note50(1,50),
    note20(0,20);

    private final int value;
    private final int key;

    NoteEnum(int key,int value ){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

}
