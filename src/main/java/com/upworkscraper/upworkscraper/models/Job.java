package com.upworkscraper.upworkscraper.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Job {
    private String title;
    private String ciphertext;
    private String description;
    private String duration;
    private String engagement;
    private Amount amount;
    private String tier;
    private String proposalsTier;
    private List<Attributes> attrs;
}
