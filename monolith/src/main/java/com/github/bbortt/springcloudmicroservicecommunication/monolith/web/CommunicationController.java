package com.github.bbortt.springcloudmicroservicecommunication.monolith.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.bbortt.springcloudmicroservicecommunication.monolith.feign.clients.MicroService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixTimeoutException;

@RestController
@RequestMapping("/communicate")
public class CommunicationController {
	private MicroService microService;

	public CommunicationController(MicroService microService) {
		this.microService = microService;
	}

	@GetMapping("/process-something")
	public String getSomethingProcessed() {
		return microService.processSomething();
	}

	@GetMapping("/process-something-real-big")
	@HystrixCommand(fallbackMethod = "catchRealBigStuffTimeout")
	public String getSomethingRealBigProcessed() {
		return microService.processSomethingRealBig();
	}

	public String catchRealBigStuffTimeout(Throwable e) {
		if (e instanceof HystrixTimeoutException) {
			return "I want wait for this s***!! AUTOBOTS - ROLLBACK!";
		}

		throw new IllegalArgumentException(e);
	}

	@GetMapping("/error-without-hystrix")
	public String forceErrorWithoutHystrix() {
		return microService.forceError();
	}

	@GetMapping("/error-with-hystrix")
	@HystrixCommand(fallbackMethod = "catchErrorToString")
	public String forceErrorWithHystrix() {
		return microService.forceError();
	}

	public String catchErrorToString(Throwable e) {
		return "Captain here; caught an exception: " + e.getLocalizedMessage();
	}
}
