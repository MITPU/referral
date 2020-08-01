package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.CandidateSkillDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CandidateSkillMapper;
import org.mitpu.referral.core.repositories.models.CandidateSkill;
import org.mitpu.referral.core.services.main.CandidateSkillService;
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
public class CandidateSkillController {

    private CandidateSkillMapper candidateSkillMapper;

    private CandidateSkillService candidateSkillService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public CandidateSkillController(CandidateSkillMapper candidateSkillMapper,
                                    CandidateSkillService candidateSkillService) {
        this.candidateSkillMapper = candidateSkillMapper;
        this.candidateSkillService = candidateSkillService;
    }

    @RequestMapping(path = "/candidate/skill/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateSkill(@PathVariable(name = "id") Integer id) {
        CandidateSkillDto candidateSkillDto = new CandidateSkillDto();

        // validating request
        candidateSkillDto.setId(id);
        Validation validation = ValidationFactory.getValidation(candidateSkillDto);
        validation.validateRequest(candidateSkillDto, RequestMethod.GET);

        CandidateSkill candidateSkill = candidateSkillService.getCandidateSkill(id);

        // mapping
        candidateSkillDto = candidateSkillMapper.getCandidateSkillDtoFrom(candidateSkill);
        return new ResponseEntity<>(candidateSkillDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/{candidate_id}/skills", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateSkillsByCandidateId(@PathVariable(name = "candidate_id") Integer candidateId) {
        List<CandidateSkillDto> candidateSkillDtoList = new ArrayList<>();

        List<CandidateSkill> candidateSkillList = candidateSkillService.getCandidateSkillsByCandidateId(candidateId);

        // mapping
        for (CandidateSkill candidateSkill : candidateSkillList) {
            candidateSkillDtoList.add(candidateSkillMapper.getCandidateSkillDtoFrom(candidateSkill));
        }
        return new ResponseEntity<>(candidateSkillDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/skills", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateSkills() {
        List<CandidateSkillDto> candidateSkillDtoList = new ArrayList<>();

        List<CandidateSkill> candidateSkillList = candidateSkillService.getCandidateSkills();

        // mapping
        for (CandidateSkill candidateSkill : candidateSkillList) {
            candidateSkillDtoList.add(candidateSkillMapper.getCandidateSkillDtoFrom(candidateSkill));
        }
        return new ResponseEntity<>(candidateSkillDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/skill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCandidateSkill(@PathVariable(name = "id") Integer id) {
        CandidateSkillDto candidateSkillDto = new CandidateSkillDto();

        // validating request
        candidateSkillDto.setId(id);
        Validation validation = ValidationFactory.getValidation(candidateSkillDto);
        validation.validateRequest(candidateSkillDto, RequestMethod.DELETE);

        candidateSkillService.deleteCandidateSkill(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/candidate/skill", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidateSkill(@RequestBody CandidateSkillDto candidateSkillDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(candidateSkillDto);
        validation.validateRequest(candidateSkillDto, RequestMethod.POST);

        Integer newKey = candidateSkillService
                .createCandidateSkill(candidateSkillMapper.getCandidateSkillFrom(candidateSkillDto));
        candidateSkillDto.setId(newKey);
        return new ResponseEntity<>(candidateSkillDto, HttpStatus.OK);
    }

}
