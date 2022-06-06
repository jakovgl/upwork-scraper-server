package com.upworkscraper.upworkscraper.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UWResponse {
    private List<Job> results;
}
