package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.JobDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.JobMapper;
import org.mitpu.referral.core.repositories.models.Job;
import org.mitpu.referral.core.services.main.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobMapper jobMapper;

    private JobService jobService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public JobController(JobMapper jobMapper, JobService jobService) {
        this.jobMapper = jobMapper;
        this.jobService = jobService;
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getjob(@PathVariable(name = "id") Integer id) {
        JobDto jobDto = new JobDto();

        // validating request
        jobDto.setId(id);
        Validation validation = ValidationFactory.getValidation(jobDto);
        validation.validateRequest(jobDto, RequestMethod.GET);

        Job job = jobService.getJob(id);

        // mapping
        jobDto = jobMapper.getJobDtoFrom(job);
        return new ResponseEntity<>(jobDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/jobs", method = RequestMethod.GET)
    public ResponseEntity<?> getjobs() {
        List<JobDto> jobDtoList = new ArrayList<>();

        List<Job> jobList = jobService.getJobs();

        // mapping
        for (Job job : jobList) {
            jobDtoList.add(jobMapper.getJobDtoFrom(job));
        }
        return new ResponseEntity<>(jobDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletejob(@PathVariable(name = "id") Integer id) {
        JobDto jobDto = new JobDto();

        // validating request
        jobDto.setId(id);
        Validation validation = ValidationFactory.getValidation(jobDto);
        validation.validateRequest(jobDto, RequestMethod.DELETE);

        jobService.deleteJob(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/job", method = RequestMethod.POST)
    public ResponseEntity<?> createjob(@RequestBody JobDto jobDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(jobDto);
        validation.validateRequest(jobDto, RequestMethod.POST);

        Integer newKey = jobService.createJob(jobMapper.getJobFrom(jobDto));
        jobDto.setId(newKey);
        return new ResponseEntity<>(jobDto, HttpStatus.OK);
    }

}
