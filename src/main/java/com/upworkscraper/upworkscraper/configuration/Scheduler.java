package com.upworkscraper.upworkscraper.configuration;

import com.upworkscraper.upworkscraper.services.UpworkService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Scheduler {

    private UpworkService upworkService;

    @Scheduled(fixedRate = 10000)
    void pingUpwork() {
        upworkService.handleUpworkRequest();
    }
}
