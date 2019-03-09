package com.mindtree.app.springboot.applimitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsConfiguration() {
		return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
}
