package com.upworkscraper.upworkscraper.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class UWAmount {
    private String currencyCode;
    private BigDecimal amount;
}
