package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.mapper.CandidateMapper;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.services.main.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {

    private CandidateMapper candidateMapper;

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateMapper candidateMapper, CandidateService candidateService) {
        this.candidateMapper = candidateMapper;
        this.candidateService = candidateService;
    }

    @RequestMapping(path = "/candidate/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidate(@PathVariable(name = "id") int id) throws Exception {
        Candidate candidate = candidateService.getCandidate(id);
        CandidateDto candidateDto = candidateMapper.getCandidateDtoFrom(candidate);

        return new ResponseEntity<>(candidateDto, HttpStatus.OK);
    }
}