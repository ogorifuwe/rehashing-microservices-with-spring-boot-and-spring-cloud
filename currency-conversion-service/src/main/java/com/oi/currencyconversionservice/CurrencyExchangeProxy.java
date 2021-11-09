package com.oi.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeProxy {

  @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
  CurrencyConversion retrieveExchangeValue(
    @PathVariable String from,
    @PathVariable String to);

}
