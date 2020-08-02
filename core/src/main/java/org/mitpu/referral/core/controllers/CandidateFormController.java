package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.CandidateFormDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CandidateFormMapper;
import org.mitpu.referral.core.services.main.CandidateFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateFormController {

    private CandidateFormMapper candidateFormMapper;

    private CandidateFormService candidateFormService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public CandidateFormController(CandidateFormMapper candidateFormMapper, CandidateFormService candidateFormService) {
        this.candidateFormMapper = candidateFormMapper;
        this.candidateFormService = candidateFormService;
    }

    @RequestMapping(path = "/candidate/form", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidate(@RequestBody CandidateFormDto candidateFormDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(candidateFormDto);
        validation.validateRequest(candidateFormDto, RequestMethod.POST);

        Integer newKey = candidateFormService
                .createCandidateFrom(candidateFormMapper.getCandidateFormFrom(candidateFormDto));
        candidateFormDto.getCandidate().setId(newKey);
        return new ResponseEntity<>(candidateFormDto.getCandidate(), HttpStatus.OK);
    }

}
