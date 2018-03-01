package com.benchem.microserviceshub.bean;

public class DomainInfo {
    private String protocol;
    private String domain;
    int port;

    public DomainInfo(String domain) {
        this.protocol = "http";
        this.domain = domain;
        this.port = 80;
    }

    public DomainInfo(String protocol, String domain, int port) {
        this.protocol = protocol;
        this.domain = domain;
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
