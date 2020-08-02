package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.CandidateParticipationDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CandidateParticipationMapper;
import org.mitpu.referral.core.repositories.models.CandidateParticipation;
import org.mitpu.referral.core.services.main.CandidateParticipationService;
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
public class CandidateParticipationController {

    private CandidateParticipationMapper candidateParticipationMapper;

    private CandidateParticipationService candidateParticipationService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public CandidateParticipationController(CandidateParticipationMapper candidateParticipationMapper,
                                            CandidateParticipationService candidateParticipationService) {
        this.candidateParticipationMapper = candidateParticipationMapper;
        this.candidateParticipationService = candidateParticipationService;
    }

    @RequestMapping(path = "/candidate/participation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateParticipation(@PathVariable(name = "id") Integer id) {
        CandidateParticipationDto candidateParticipationDto = new CandidateParticipationDto();

        // validating request
        candidateParticipationDto.setId(id);
        Validation validation = ValidationFactory.getValidation(candidateParticipationDto);
        validation.validateRequest(candidateParticipationDto, RequestMethod.GET);

        CandidateParticipation candidateParticipation = candidateParticipationService.getCandidateParticipation(id);

        // mapping
        candidateParticipationDto = candidateParticipationMapper
                .getCandidateParticipationDtoFrom(candidateParticipation);
        return new ResponseEntity<>(candidateParticipationDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/{candidate_id}/participations", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateParticipationsByCandidateId(
            @PathVariable(name = "candidate_id") Integer candidateId) {
        List<CandidateParticipationDto> candidateParticipationDtoList = new ArrayList<>();

        List<CandidateParticipation> candidateParticipationList = candidateParticipationService
                .getCandidateParticipationsByCandidateId(candidateId);

        // mapping
        for (CandidateParticipation candidateParticipation : candidateParticipationList) {
            candidateParticipationDtoList
                    .add(candidateParticipationMapper.getCandidateParticipationDtoFrom(candidateParticipation));
        }
        return new ResponseEntity<>(candidateParticipationDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/participations", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateParticipations() {
        List<CandidateParticipationDto> candidateParticipationDtoList = new ArrayList<>();

        List<CandidateParticipation> candidateParticipationList = candidateParticipationService
                .getCandidateParticipations();

        // mapping
        for (CandidateParticipation candidateParticipation : candidateParticipationList) {
            candidateParticipationDtoList
                    .add(candidateParticipationMapper.getCandidateParticipationDtoFrom(candidateParticipation));
        }
        return new ResponseEntity<>(candidateParticipationDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/participation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCandidateParticipation(@PathVariable(name = "id") Integer id) {
        CandidateParticipationDto candidateParticipationDto = new CandidateParticipationDto();

        // validating request
        candidateParticipationDto.setId(id);
        Validation validation = ValidationFactory.getValidation(candidateParticipationDto);
        validation.validateRequest(candidateParticipationDto, RequestMethod.DELETE);

        candidateParticipationService.deleteCandidateParticipation(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/participation", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidateParticipation(
            @RequestBody CandidateParticipationDto candidateParticipationDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(candidateParticipationDto);
        validation.validateRequest(candidateParticipationDto, RequestMethod.POST);

        Integer newKey = candidateParticipationService.createCandidateParticipation(
                candidateParticipationMapper.getCandidateParticipationFrom(candidateParticipationDto));
        candidateParticipationDto.setId(newKey);
        return new ResponseEntity<>(candidateParticipationDto, HttpStatus.OK);
    }

}
