package com.benchem.libraryservices.lang;

import com.benchem.microserviceshub.lang.StateCode;

public enum LibraryServiceStateCode implements StateCode {
    CAN_NOT_READ(200001, "这个学生不能借书"),
    ;

    private final Integer stateCode;
    private final String message;

    LibraryServiceStateCode(Integer stateCode, String message){
        this.stateCode = stateCode;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return stateCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}