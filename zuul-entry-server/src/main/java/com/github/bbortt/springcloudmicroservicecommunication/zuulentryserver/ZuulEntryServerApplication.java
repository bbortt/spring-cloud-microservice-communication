package com.github.bbortt.springcloudmicroservicecommunication.zuulentryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulEntryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulEntryServerApplication.class, args);
	}
}
