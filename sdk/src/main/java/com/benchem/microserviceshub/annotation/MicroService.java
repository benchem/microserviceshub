package com.benchem.microserviceshub.annotation;

import com.benchem.microserviceshub.bean.DomainType;
import com.benchem.microserviceshub.bean.RequestType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MicroService {
    DomainType domainType() default DomainType.Internal;
    String domain();
    String path();
    RequestType type() default RequestType.GET;
}
