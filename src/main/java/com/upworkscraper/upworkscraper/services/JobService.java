package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.models.Job;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    public boolean isQualified(Job job) {
        return true;
    }
}
