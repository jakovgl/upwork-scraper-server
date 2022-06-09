package com.upworkscraper.upworkscraper.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Amount {
    private String currencyCode;
    private BigDecimal amount;
}
