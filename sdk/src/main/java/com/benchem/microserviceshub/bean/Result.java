package com.benchem.microserviceshub.bean;

import com.benchem.microserviceshub.lang.SystemStateCode;

public class Result {
    Integer statecode;
    String errmsg;
    Object result;

    public Result(Integer statecode, String errmsg) {
        this.statecode = statecode;
        this.errmsg = errmsg;
    }

    public Result(Object result) {
        this.statecode = SystemStateCode.OK.getCode();
        this.errmsg = SystemStateCode.OK.getMessage();
        this.result = result;
    }

    public Integer getStatecode() {
        return statecode;
    }

    public void setStatecode(Integer statecode) {
        this.statecode = statecode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
