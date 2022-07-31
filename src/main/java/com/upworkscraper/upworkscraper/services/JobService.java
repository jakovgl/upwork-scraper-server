package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.dtos.UWJob;
import com.upworkscraper.upworkscraper.repositories.AbstractRepository;
import generated.tables.Job;
import generated.tables.records.JobRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
public class JobService extends AbstractRepository<JobRecord, generated.tables.pojos.Job> {

    public JobService(DSLContext db) {
        super(db, Job.JOB.asTable(), Job.JOB.ID, generated.tables.pojos.Job.class);
    }

    public generated.tables.pojos.Job getJob() {
        return findById(1L);
    }

    public boolean isQualified(UWJob job) {
        return true;
    }
}
