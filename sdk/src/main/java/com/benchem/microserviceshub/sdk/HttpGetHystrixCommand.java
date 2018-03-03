package com.benchem.microserviceshub.sdk;

import com.alibaba.fastjson.JSONObject;
import com.benchem.microserviceshub.bean.DomainInfo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.HashMap;
import java.util.Map;

public class HttpGetHystrixCommand extends HystrixCommand<String> {

    private DomainInfo domainInfo;
    private final String path;
    private final HashMap<String, Object> pararms;

    public HttpGetHystrixCommand(DomainInfo domainInfo, String path, HashMap<String, Object> pararms){
        super(HystrixCommandGroupKey.Factory.asKey("MicroServicesRemoteInvoke"));
        this.domainInfo = domainInfo;
        this.path = path;
        this.pararms = pararms;
    }

    @Override
    protected String run() throws Exception {
        return HttpInvokeHelper.get(
                domainInfo.getProtocol(),
                domainInfo.getDomain(),
                domainInfo.getPort(),
                path,
                pararms
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
