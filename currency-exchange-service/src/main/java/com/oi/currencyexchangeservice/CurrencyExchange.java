package com.oi.currencyexchangeservice;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class CurrencyExchange {

  @NonNull
  @Id
  private Long id;

  @NonNull
  @Column(name = "currency_from")
  private String from;

  @NonNull
  @Column(name = "currency_to")
  private String to;

  @NonNull
  private BigDecimal conversionMultiple;

  private  String environment;
}
