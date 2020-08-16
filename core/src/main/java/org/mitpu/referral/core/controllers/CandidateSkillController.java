package org.mitpu.referral.core.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.controllers.dto.CandidateSkillDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CandidateSkillMapper;
import org.mitpu.referral.core.repositories.models.CandidateSkill;
import org.mitpu.referral.core.services.exception.ApplicationException;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.mitpu.referral.core.services.main.CandidateSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CandidateSkillController {

    private static final Logger LOGGER = LogManager.getLogger(CandidateSkillController.class);

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
        try {
            CandidateSkillDto candidateSkillDto = new CandidateSkillDto();

            // validating request
            candidateSkillDto.setId(id);
            Validation validation = ValidationFactory.getValidation(candidateSkillDto);
            validation.validateRequest(candidateSkillDto, RequestMethod.GET);

            CandidateSkill candidateSkill = candidateSkillService.getCandidateSkill(id);

            // mapping
            candidateSkillDto = candidateSkillMapper.getCandidateSkillDtoFrom(candidateSkill);
            return new ResponseEntity<>(candidateSkillDto, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidate/{candidate_id}/skills", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateSkillsByCandidateId(@PathVariable(name = "candidate_id") Integer candidateId) {
        try {
            List<CandidateSkillDto> candidateSkillDtoList = new ArrayList<>();

            List<CandidateSkill> candidateSkillList = candidateSkillService.getCandidateSkillsByCandidateId(candidateId);

            // mapping
            for (CandidateSkill candidateSkill : candidateSkillList) {
                candidateSkillDtoList.add(candidateSkillMapper.getCandidateSkillDtoFrom(candidateSkill));
            }
            return new ResponseEntity<>(candidateSkillDtoList, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidate/skills", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidateSkills() {
        try {
            List<CandidateSkillDto> candidateSkillDtoList = new ArrayList<>();

            List<CandidateSkill> candidateSkillList = candidateSkillService.getCandidateSkills();

            // mapping
            for (CandidateSkill candidateSkill : candidateSkillList) {
                candidateSkillDtoList.add(candidateSkillMapper.getCandidateSkillDtoFrom(candidateSkill));
            }
            return new ResponseEntity<>(candidateSkillDtoList, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidate/skill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCandidateSkill(@PathVariable(name = "id") Integer id) {
        try {
            CandidateSkillDto candidateSkillDto = new CandidateSkillDto();

            // validating request
            candidateSkillDto.setId(id);
            Validation validation = ValidationFactory.getValidation(candidateSkillDto);
            validation.validateRequest(candidateSkillDto, RequestMethod.DELETE);

            candidateSkillService.deleteCandidateSkill(id);

            return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/candidate/skill", method = RequestMethod.POST)
    public ResponseEntity<?> createCandidateSkill(@RequestBody CandidateSkillDto candidateSkillDto) {
        try {
            // validating request
            Validation validation = ValidationFactory.getValidation(candidateSkillDto);
            validation.validateRequest(candidateSkillDto, RequestMethod.POST);

            Integer newKey = candidateSkillService
                    .createCandidateSkill(candidateSkillMapper.getCandidateSkillFrom(candidateSkillDto));
            candidateSkillDto.setId(newKey);
            return new ResponseEntity<>(candidateSkillDto, HttpStatus.OK);
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

}
