package com.github.bbortt.springcloudmicroservicecommunication.monolith.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients({ "com.github.bbortt.springcloudmicroservicecommunication.monolith.feign.clients" })
public class FeignClientConfiguration {

}
