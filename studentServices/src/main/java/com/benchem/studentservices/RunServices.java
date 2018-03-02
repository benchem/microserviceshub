package com.benchem.studentservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "com.benchem.microserviceshub",
        "com.benchem.studentservices",
})
public class RunServices {
    public static void main(String[] args) {
        SpringApplication.run(RunServices.class, args);

    }
}
