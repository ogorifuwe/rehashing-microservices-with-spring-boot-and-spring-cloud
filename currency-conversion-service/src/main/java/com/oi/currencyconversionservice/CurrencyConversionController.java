package com.oi.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

  @Autowired
  private Environment environment;

  @GetMapping(value = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion calculateCurrencyConversion(
          @PathVariable String from,
          @PathVariable String to,
          @PathVariable BigDecimal quantity) {

    String port = environment.getProperty("local.server.port");
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);
    ResponseEntity<CurrencyConversion> responseEntity =
            new RestTemplate()
                    .getForEntity(
                            "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                            CurrencyConversion.class,
                            uriVariables
                    );

    CurrencyConversion currencyConversionDTO = responseEntity.getBody();
    currencyConversionDTO.toString();
    CurrencyConversion currencyConversion =
            new CurrencyConversion(
                    currencyConversionDTO.getId(),
                    from,
                    to,
                    quantity,
                    currencyConversionDTO.getConversionMultiple(),
                    quantity.multiply(currencyConversionDTO.getConversionMultiple()),
                    currencyConversionDTO.getEnvironment());
    return currencyConversion;
  }
}
