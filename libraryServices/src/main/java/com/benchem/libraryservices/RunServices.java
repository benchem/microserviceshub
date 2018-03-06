package com.benchem.libraryservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.benchem.microserviceshub",
        "com.benchem.libraryservices",
        "com.benchem.libraryservices.api",
})
public class RunServices {
    public static void main(String[] args) {
        SpringApplication.run(RunServices.class, args);
    }
}
