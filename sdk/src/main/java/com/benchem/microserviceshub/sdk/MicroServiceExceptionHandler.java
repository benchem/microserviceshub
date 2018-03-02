package com.benchem.microserviceshub.sdk;


import com.alibaba.fastjson.JSONObject;
import com.benchem.microserviceshub.lang.MicroServiceException;
import com.benchem.microserviceshub.lang.StateCode;
import com.benchem.microserviceshub.lang.SystemStateCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MicroServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleUnhandleException(Exception ex, WebRequest request) {
        JSONObject result = new JSONObject();
        result.put("statecode", SystemStateCode.SYSTEM_ERROR.getCode());
        result.put("errmsg", SystemStateCode.SYSTEM_ERROR.getMessage());
        String errMsg = ex.getMessage();
        if(errMsg != null && !errMsg.isEmpty()){
            result.put("innermsg", errMsg);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @ExceptionHandler(value = MicroServiceException.class)
    public ResponseEntity<Object> handleException(MicroServiceException ex, WebRequest request) {
        StateCode code = ex.getStateCode();
        JSONObject result = new JSONObject();
        result.put("statecode", code.getCode());
        result.put("errmsg", code.getMessage());
        String errMsg = ex.getMessage();
        if(errMsg != null && !errMsg.isEmpty()){
            result.put("innermsg", errMsg);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
