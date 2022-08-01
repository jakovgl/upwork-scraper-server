package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.repositories.JobRepository;
import generated.tables.pojos.Job;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {

    private final DSLContext context;
    private final JobRepository jobRepository;

    public Job findById(Long id) {
        return jobRepository.findById(id);
    }
}
