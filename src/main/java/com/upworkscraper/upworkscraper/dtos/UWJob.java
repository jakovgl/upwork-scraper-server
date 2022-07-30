package com.upworkscraper.upworkscraper.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class UWJob {
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
