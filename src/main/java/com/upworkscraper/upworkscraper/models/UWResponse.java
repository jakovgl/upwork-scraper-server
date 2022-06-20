package com.upworkscraper.upworkscraper.models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class UWResponse {
    private List<Job> results;
}
