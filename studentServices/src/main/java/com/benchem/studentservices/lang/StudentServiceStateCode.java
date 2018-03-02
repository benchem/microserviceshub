package com.benchem.studentservices.lang;

import com.benchem.microserviceshub.lang.MicroServiceStateCode;
import com.benchem.microserviceshub.lang.StateCode;

public enum StudentServiceStateCode implements StateCode {
    OK(0, ""),
    NOT_FOUND(100001, "找不到这个学生"),
    STUDENT_EXITES(100002, "这个学生已注册")
    ;

    private final Integer stateCode;
    private final String message;

    StudentServiceStateCode(Integer stateCode, String message){
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
