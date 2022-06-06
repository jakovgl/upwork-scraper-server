package com.upworkscraper.upworkscraper.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class Amount {
    private String currencyCode;
    private BigDecimal amount;
}
