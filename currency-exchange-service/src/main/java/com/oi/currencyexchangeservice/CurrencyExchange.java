package com.oi.currencyexchangeservice;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class CurrencyExchange {

  @NonNull
  private Long id;
  @NonNull
  private String from;
  @NonNull
  private String to;
  @NonNull
  private BigDecimal conversionMultiple;
  private  String environment;
}
