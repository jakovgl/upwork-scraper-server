package com.upworkscraper.upworkscraper.services;

import com.upworkscraper.upworkscraper.repositories.JobRepository;
import generated.tables.pojos.Job;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService implements IService<Job> {

    private final JobRepository jobRepository;

    public Logger logger = LoggerFactory.getLogger(JobService.class);

    @Override
    public Job findById(Long id) {

        logger.debug("Getting the job ID {}", id);
        return jobRepository.findById(id);
    }

    @Override
    public Job insert(Job job) {

        logger.debug("Inserting the job {}", job.toString());
        return jobRepository.insert(job);
    }

    @Override
    public Job update(Long id, Job job) {

        return jobRepository.update(id, job);
    }
}
