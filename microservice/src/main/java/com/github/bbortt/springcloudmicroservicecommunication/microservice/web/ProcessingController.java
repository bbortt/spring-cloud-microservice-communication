package com.github.bbortt.springcloudmicroservicecommunication.microservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process-something")
public class ProcessingController {
	@GetMapping
	public String processSomething() {
		return "Microservice did successfully process some data.";
	}
}
