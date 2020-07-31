package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.JobDto;
import org.mitpu.referral.core.repositories.models.Job;
import org.mitpu.referral.core.services.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

    public Job getJobFrom(JobDto jobDto) {
        if (jobDto == null) {
            return null;
        }
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setCandidateId(jobDto.getCandidateId());
        job.setCity(jobDto.getCity());
        job.setCompanyId(jobDto.getCompanyId());
        job.setCountry(jobDto.getCountry());
        job.setDate(DateTimeUtils.stringToDateTime(jobDto.getDate()));
        job.setPosition(jobDto.getPosition());
        job.setPositionLink(jobDto.getPositionLink());
        job.setReferrerId(jobDto.getReferrerId());
        job.setStack(Job.Stack.getStack(jobDto.getStack()));
        job.setState(jobDto.getState());
        job.setType(Job.Type.getType(jobDto.getType()));
        return job;
    }

    public JobDto getJobFrom(Job job) {
        if (job == null) {
            return null;
        }
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setCandidateId(job.getCandidateId());
        jobDto.setCity(job.getCity());
        jobDto.setCompanyId(job.getCompanyId());
        jobDto.setCountry(job.getCountry());
        jobDto.setDate(DateTimeUtils.dateTimeToString(job.getDate()));
        jobDto.setPosition(job.getPosition());
        jobDto.setPositionLink(job.getPositionLink());
        jobDto.setReferrerId(job.getReferrerId());
        jobDto.setStack(job.getStack().value);
        jobDto.setState(job.getState());
        jobDto.setType(job.getType().value);
        return jobDto;
    }
}
