package com.github.bbortt.springcloudmicroservicecommunication.zuulentryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulEntryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulEntryServerApplication.class, args);
    }
}
