package com.github.bbortt.springcloudmicroservicecommunication.microservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	@GetMapping
	public String getHelloWorldMessage() {
		return "Hello, I'm a microservice.";
	}
}
