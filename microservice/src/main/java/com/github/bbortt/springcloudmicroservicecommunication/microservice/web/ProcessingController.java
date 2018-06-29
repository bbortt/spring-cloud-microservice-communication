package com.github.bbortt.springcloudmicroservicecommunication.microservice.web;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process-something")
public class ProcessingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessingController.class);

	@GetMapping
	public String processSomething() {
		return "Microservice did successfully process some data.";
	}

	@GetMapping("/a-bit-longer")
	public String processSomethingABitLonger() throws InterruptedException {
		IntStream.range(0, 100000).forEach(integer -> LOGGER.info("{}^2 is: {}", integer, integer * integer));

		return "Microservice did successfully process some real big data.";
	}
}
