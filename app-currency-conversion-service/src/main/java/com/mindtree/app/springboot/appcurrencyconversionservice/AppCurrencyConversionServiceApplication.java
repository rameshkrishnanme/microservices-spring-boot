package com.mindtree.app.springboot.appcurrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.mindtree.app.springboot.appcurrencyconversionservice")
@EnableDiscoveryClient
public class AppCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCurrencyConversionServiceApplication.class, args);
	}

	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
