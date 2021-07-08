package org.mitpu.referral.core.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CandidateMapper;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.services.exception.ApplicationException;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.mitpu.referral.core.services.main.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CandidateController {

    private static final Logger LOGGER = LogManager.getLogger(CandidateController.class);

    private CandidateMapper candidateMapper;

    private CandidateService candidateService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public CandidateController(CandidateMapper candidateMapper, CandidateService candidateService) {
        this.candidateMapper = candidateMapper;
        this.candidateService = candidateService;
    }

    @RequestMapping(path = "/candidate/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidate(@PathVariable(name = "id") Integer id) {
        try {
            CandidateDto candidateDto = new CandidateDto();

            // validating request
            candidateDto.setId(id);
            Validation validation = ValidationFactory.getValidation(candidateDto);
            validation.validateRequest(candidateDto, RequestMethod.GET);

            Candidate candidate = candidateService.getCandidate(id);

            // mapping
            candidateDto = candidateMapper.getCandidateDtoFrom(candidate);
            return new ResponseEntity<>(candidateDto, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidates", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidates() {
        try {
            List<CandidateDto> candidateDtoList = new ArrayList<>();

            List<Candidate> candidateList = candidateService.getCandidates();

            // mapping
            for (Candidate candidate : candidateList) {
                candidateDtoList.add(candidateMapper.getCandidateDtoFrom(candidate));
            }
            return new ResponseEntity<>(candidateDtoList, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidate/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCandidate(@PathVariable(name = "id") Integer id) {
        try {
            CandidateDto candidateDto = new CandidateDto();

            // validating request
            candidateDto.setId(id);
            Validation validation = ValidationFactory.getValidation(candidateDto);
            validation.validateRequest(candidateDto, RequestMethod.DELETE);

            candidateService.deleteCandidate(id);

            return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidate", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidate(@RequestBody CandidateDto candidateDto) {
        try {
            // validating request
            Validation validation = ValidationFactory.getValidation(candidateDto);
            validation.validateRequest(candidateDto, RequestMethod.POST);

            Integer newKey = candidateService.createCandidate(candidateMapper.getCandidateFrom(candidateDto));
            candidateDto.setId(newKey);
            return new ResponseEntity<>(candidateDto, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

}
