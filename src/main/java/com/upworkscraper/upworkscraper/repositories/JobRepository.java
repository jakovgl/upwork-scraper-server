package com.upworkscraper.upworkscraper.repositories;

import generated.tables.Job;
import generated.tables.records.JobRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
public class JobRepository extends AbstractRepository<JobRecord, generated.tables.pojos.Job> {

    public JobRepository(DSLContext db) {
        super(db, Job.JOB.asTable(), Job.JOB.ID, generated.tables.pojos.Job.class);
    }

}
