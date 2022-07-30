package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.dtos.UWJob;
import generated.tables.pojos.Job;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import static generated.Tables.*;

@Service
@RequiredArgsConstructor
public class JobService {

    private final DSLContext context;

    public boolean isQualified(UWJob job) {
        return true;
    }

    public void insertJob(Job job) {
        var jobRecord = context.newRecord(JOB, job);
        jobRecord.insert();
    }

}
