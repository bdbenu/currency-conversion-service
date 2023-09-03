package com.bd.benu.microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bd.benu.microservice.model.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service",url="localhost:8000")
public interface CurrencyExchangeServiceFignproxy {
	
	@GetMapping("/exchangeValue/from/{from}/to/{to}")
	public CurrencyConversionBean fetchAllcurrencyExchangeValues
	(@PathVariable("from")String  from, @PathVariable("to")String  to);

}
