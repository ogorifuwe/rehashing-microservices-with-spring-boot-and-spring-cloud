package com.oi.limitsservice.controller;

import com.oi.limitsservice.bean.Limits;
import com.oi.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

  @Autowired
  private Configuration configuration;

  @GetMapping(value = "/limits")
  public Limits retrieveLimits() {
    int minimum = configuration.getMinimum();
    int maximum = configuration.getMaximum();
    Limits limits = new Limits(minimum, maximum);
    return limits;
  }
}