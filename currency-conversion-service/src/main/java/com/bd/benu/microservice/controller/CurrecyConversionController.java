package com.bd.benu.microservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bd.benu.microservice.CurrencyExchangeServiceFignproxy;
import com.bd.benu.microservice.model.CurrencyConversionBean;

@RestController
public class CurrecyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceFignproxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(
			@PathVariable("from")String from,
			@PathVariable("to")String to,
			@PathVariable("quantity")BigDecimal quantity) {
		
		Map<String, String> UriVariable = new HashMap<>();
		UriVariable.put("from", from);
		UriVariable.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/exchangeValue/from/{from}/to/{to}", CurrencyConversionBean.class, UriVariable);
		CurrencyConversionBean response = responseEntity.getBody();
		return  new CurrencyConversionBean(response.getId(), from, to, response.getConvestionMultiple(), quantity,quantity.multiply(response.getConvestionMultiple()), response.getPort());
	}

	@GetMapping("/currency-converter-fign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFign(
			@PathVariable("from")String from,
			@PathVariable("to")String to,
			@PathVariable("quantity")BigDecimal quantity) {
		
		Map<String, String> UriVariable = new HashMap<>();
		UriVariable.put("from", from);
		UriVariable.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/exchangeValue/from/{from}/to/{to}", CurrencyConversionBean.class, UriVariable);
		CurrencyConversionBean response = proxy.fetchAllcurrencyExchangeValues(from, to);
				//responseEntity.getBody();
		
		return  new CurrencyConversionBean(response.getId(), from, to, response.getConvestionMultiple(), quantity,quantity.multiply(response.getConvestionMultiple()), response.getPort());
	}
}
