package com.oi.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

  private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

  @GetMapping(value = "/sample-api")
//  @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
//  @RateLimiter(name = "default")
  @Bulkhead(name = "default")
//  @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
  public String sampleAPI() {
    logger.info("Sample API called");
//    ResponseEntity<String> entity =
//            new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//    String response = entity.getBody();
    return "Sample API";
  }

  public String hardCodedResponse(Exception exception) {
    return "Fallback Response";
  }
}
