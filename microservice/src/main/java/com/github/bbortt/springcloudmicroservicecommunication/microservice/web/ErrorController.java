package com.github.bbortt.springcloudmicroservicecommunication.microservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/throw-error")
public class ErrorController {
	@GetMapping
	public String throwError() {
		throw new IllegalArgumentException("I'm an evil microservice: I throw errors! *laughs*");
	}

	@GetMapping("/hystrix")
	@HystrixCommand(fallbackMethod = "someHystrixStringFallback")
	public String throwErrorWithHystrix() {
		return throwError();
	}

	public String someHystrixStringFallback() {
		return "Well, evil plan got destoyed.. But this is how Hystrix works!";
	}
}
