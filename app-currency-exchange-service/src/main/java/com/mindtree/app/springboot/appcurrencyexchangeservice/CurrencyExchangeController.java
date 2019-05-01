package com.mindtree.app.springboot.appcurrencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	Logger logger =	LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment; 

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = new ExchangeValue(1L, from, to, BigDecimal.valueOf(88));
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		
		logger.info("{}" , exchangeValue);
		
		return exchangeValue;
	}

}
