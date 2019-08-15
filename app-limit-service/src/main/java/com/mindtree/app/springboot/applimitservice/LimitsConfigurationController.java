package com.blacksystems.app.springboot.applimitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	@HystrixCommand(fallbackMethod = "defaultMethod")
	public LimitsConfiguration retrieveLimitsConfiguration() {
		return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
	public LimitsConfiguration defaultMethod() {
		return new LimitsConfiguration(2, 33);
	}
}
