package com.upworkscraper.upworkscraper.repositories;

import generated.tables.pojos.Job;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobRepository {

    private final DSLContext context;

    public void insertJob(Job job) {

    }
}
