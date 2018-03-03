package com.benchem.microserviceshub.sdk;

import com.alibaba.fastjson.JSONObject;
import com.benchem.microserviceshub.bean.DomainInfo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.HashMap;

public class HttpPostHystrixCommand extends HystrixCommand<String> {

    private DomainInfo domainInfo;
    private final String path;
    private String requestBody;

    public HttpPostHystrixCommand(DomainInfo domainInfo, String path, String requestBody){
        super(HystrixCommandGroupKey.Factory.asKey("MicroServicesRemoteInvoke"));
        this.domainInfo = domainInfo;
        this.path = path;
        this.requestBody = requestBody;
    }

    @Override
    protected String run() throws Exception {
        return HttpInvokeHelper.post(
                domainInfo.getProtocol(),
                domainInfo.getDomain(),
                domainInfo.getPort(),
                path,
                requestBody
        );
    }

    @Override
    protected String getFallback() {
        JSONObject json = new JSONObject();
        json.put("statecode", -3);
        json.put("errmsg", "远程服务应答异常");
        return  json.toJSONString();
    }
}
