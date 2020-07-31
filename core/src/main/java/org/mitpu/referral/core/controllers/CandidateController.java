package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CandidateMapper;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.services.main.CandidateService;
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
public class CandidateController {

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
        CandidateDto candidateDto = new CandidateDto();

        // validating request
        candidateDto.setId(id);
        Validation validation = ValidationFactory.getValidation(candidateDto);
        validation.validateRequest(candidateDto, RequestMethod.GET);

        Candidate candidate = candidateService.getCandidate(id);

        // mapping
        candidateDto = candidateMapper.getCandidateDtoFrom(candidate);
        return new ResponseEntity<>(candidateDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidates", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidates() {
        List<CandidateDto> candidateDtoList = new ArrayList<>();

        List<Candidate> candidateList = candidateService.getCandidates();

        // mapping
        for (Candidate candidate : candidateList) {
            candidateDtoList.add(candidateMapper.getCandidateDtoFrom(candidate));
        }
        return new ResponseEntity<>(candidateDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCandidate(@PathVariable(name = "id") Integer id) {
        CandidateDto candidateDto = new CandidateDto();

        // validating request
        candidateDto.setId(id);
        Validation validation = ValidationFactory.getValidation(candidateDto);
        validation.validateRequest(candidateDto, RequestMethod.DELETE);

        candidateService.deleteCandidate(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidate(@RequestBody CandidateDto candidateDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(candidateDto);
        validation.validateRequest(candidateDto, RequestMethod.POST);

        Integer newKey = candidateService.createCandidate(candidateMapper.getCandidateFrom(candidateDto));
        candidateDto.setId(newKey);
        return new ResponseEntity<>(candidateDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidateform", method = RequestMethod.POST)
    public ResponseEntity<?> submitCandidateForm(@RequestBody CandidateDto candidateDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(candidateDto);
        validation.validateRequest(candidateDto, RequestMethod.POST);

        Integer newKey = candidateService.createCandidate(candidateMapper.getCandidateFrom(candidateDto));
        candidateDto.setId(newKey);
        return new ResponseEntity<>(candidateDto, HttpStatus.OK);
    }
}
