package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.dtos.UWJob;
import org.springframework.stereotype.Service;

@Service
public class UWJobService {

    public boolean isQualified(UWJob job) {
        return true;
    }
}
