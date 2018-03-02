package com.benchem.microserviceshub.lang;

public class RemoteStateCode implements StateCode {

    Integer code;
    String message;

    public RemoteStateCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
