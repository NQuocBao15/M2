package com.codegym.model;

public enum EGender {
    MALE("NAM"), FEMALE("NỮ");

    private final String value;
    EGender(String value){
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
