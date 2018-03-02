package com.benchem.microserviceshub.lang;

public enum MicroServiceStateCode implements StateCode {
    OK(0, "")
    ;

    private final Integer stateCode;
    private final String message;

    MicroServiceStateCode(Integer stateCode, String message){
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
