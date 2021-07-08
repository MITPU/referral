package org.mitpu.referral.core.services.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.repositories.JobRepository;
import org.mitpu.referral.core.repositories.models.Job;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private static final Logger LOGGER = LogManager.getLogger(SkillService.class);

    private final static String OBJECT_NAME = "job";

    private JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job getJob(Integer id) {
        Job job = jobRepository.findById(id);
        if (job == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return job;
    }

    public List<Job> getJobs() {
        List<Job> jobList = jobRepository.findAll();
        if (jobList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return jobList;
    }

    public void deleteJob(Integer id) {
        Job job = jobRepository.findById(id);
        if (job == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (jobRepository.delete(id)) {
            LOGGER.debug("{} is deleted successfully.", OBJECT_NAME);
        }
    }

    public Integer createJob(Job job) {
        Integer newKey = jobRepository.save(job);

        return newKey;
    }
}
