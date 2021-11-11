package com.oi.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

  @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
  CurrencyConversion retrieveExchangeValue(
    @PathVariable(value = "from") String from,
    @PathVariable(value = "to") String to);

}