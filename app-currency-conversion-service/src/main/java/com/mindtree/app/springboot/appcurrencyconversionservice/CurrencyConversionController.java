package com.mindtree.app.springboot.appcurrencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	Logger logger =	LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

//		Map<String, String> map = new HashMap<String, String>();
//		ResponseEntity<ConversionValue> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/INR/to/GBP", ConversionValue.class, map);
		ConversionValue cv = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

		ConversionValue conversionValue = new ConversionValue(1L, from, to, cv.getConversionMultiple(), quantity,
				cv.getConversionMultiple().multiply(quantity));
		//conversionValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		conversionValue.setPort(cv.getPort());
		
		logger.info("{}" , conversionValue);
		
		return conversionValue;
	}

}
