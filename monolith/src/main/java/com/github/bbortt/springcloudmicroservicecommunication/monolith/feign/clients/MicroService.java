package com.github.bbortt.springcloudmicroservicecommunication.monolith.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("microservice")
public interface MicroService {
	@RequestMapping({ "/process-something" })
	String processSomething();

	@RequestMapping({ "/throw-error" })
	String forceError();
}
