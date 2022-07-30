package com.upworkscraper.upworkscraper.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class UWResponse {
    private List<UWJob> results;
}
