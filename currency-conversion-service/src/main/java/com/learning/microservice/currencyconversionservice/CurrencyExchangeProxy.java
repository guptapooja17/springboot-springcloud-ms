package com.learning.microservice.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url="localhost:8000")
// Load balancing
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    /* here we will define a method which will call another microservice url like currency-exchange-service */
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
