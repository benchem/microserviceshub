package com.benchem.microserviceshub.sdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.benchem.microserviceshub.annotation.MicroService;
import com.benchem.microserviceshub.bean.DomainInfo;
import com.benchem.microserviceshub.bean.DomainType;
import com.benchem.microserviceshub.bean.RequestType;
import com.benchem.microserviceshub.lang.MicroServiceException;
import com.benchem.microserviceshub.lang.RemoteStateCode;
import com.benchem.microserviceshub.lang.StateCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.HashMap;

@Aspect
@Component
public class MicroServiceInvoke {
    @Around(value = "@annotation(microService)")
    public Object aroundMethod(ProceedingJoinPoint point, MicroService microService) throws Throwable {
        MethodSignature methodSignature =(MethodSignature) point.getSignature();
        String[] argsNames = methodSignature.getParameterNames();
        Object[] argsValues = point.getArgs();
        DomainInfo domainInfo = MicroServicesDomains.instance.findDomainInfo(microService.domain());
        String result = "";
        if(microService.type() == RequestType.GET){
            HashMap<String, Object> queryParam = new HashMap<>();
            for (int index=0; index<argsNames.length; index++){
                queryParam.put(argsNames[index], argsValues[index]);
            }
            result = HttpInvokeHelper.get(
                    domainInfo.getProtocol(),
                    domainInfo.getDomain(),
                    domainInfo.getPort(),
                    microService.path(),
                    queryParam
            );
        }else if(microService.type() == RequestType.POST){
            String queryParam = argsValues.length == 0 ? "" : JSON.toJSONString(argsValues[0]);
            result = HttpInvokeHelper.post(
                    domainInfo.getProtocol(),
                    domainInfo.getDomain(),
                    domainInfo.getPort(),
                    microService.path(),
                    queryParam
            );
        }else{
            return point.proceed();
        }

        if(microService.domainType() == DomainType.Internal) {
            JSONObject invokeReuslt = JSONObject.parseObject(result);
            int code = invokeReuslt.getIntValue("statecode");
            if(code == 0) {
                Type targetClass = methodSignature.getMethod().getAnnotatedReturnType().getType();
                String jsonStr = invokeReuslt.getJSONObject("result").toJSONString();
                Object reValue = JSON.parseObject(jsonStr, targetClass);
                return reValue;
            } else {
                StateCode stateCode = new RemoteStateCode(code, invokeReuslt.getString("errmsg"));
                throw new MicroServiceException(stateCode);
            }
        } else if(microService.domainType() == DomainType.External){
            Type targetClass = methodSignature.getMethod().getAnnotatedReturnType().getType();
            Object reValue = JSON.parseObject(result, targetClass);
            return reValue;
        } else{
            return point.proceed();
        }
    }
}
