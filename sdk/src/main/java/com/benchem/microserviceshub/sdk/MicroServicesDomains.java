package com.benchem.microserviceshub.sdk;

import com.benchem.microserviceshub.bean.DomainInfo;
import java.util.HashMap;
import java.util.Map;

public class MicroServicesDomains {
    public static final String StudentSvr = "100000";
    public static final String LibrarySvr = "200000";

    static MicroServicesDomains instance = new MicroServicesDomains();
    private Map<String, DomainInfo> addressBook = new HashMap<>();

    private MicroServicesDomains() {
        addressBook.put(StudentSvr, new DomainInfo("http", "127.0.0.1", 9080));
        addressBook.put(LibrarySvr, new DomainInfo("http", "127.0.0.1", 9081));
    }

    public DomainInfo findDomainInfo(String domain){
        if(addressBook.containsKey(domain)) return addressBook.get(domain);
        boolean isHttps = domain.startsWith("https://");
        //todo:处理端口等
        return new DomainInfo(domain);
    }
}
