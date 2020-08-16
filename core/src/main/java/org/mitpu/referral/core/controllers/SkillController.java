package org.mitpu.referral.core.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.controllers.dto.SkillDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.SkillMapper;
import org.mitpu.referral.core.repositories.models.Skill;
import org.mitpu.referral.core.services.LogUtils;
import org.mitpu.referral.core.services.exception.ApplicationException;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.mitpu.referral.core.services.main.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SkillController {

    private static final Logger LOGGER = LogManager.getLogger(SkillController.class);

    private SkillMapper skillMapper;

    private SkillService skillService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public SkillController(SkillMapper skillMapper, SkillService skillService) {
        this.skillMapper = skillMapper;
        this.skillService = skillService;
    }

    @RequestMapping(path = "/skill/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSkill(HttpServletRequest httpServletRequest, @PathVariable(name = "id") Integer id) {
        SkillDto skillDto = new SkillDto();
        try {

            LogUtils.logWebRequest(skillDto, httpServletRequest, null);

            // validating request
            skillDto.setId(id);
            Validation validation = ValidationFactory.getValidation(skillDto);
            validation.validateRequest(skillDto, RequestMethod.GET);

            Skill skill = skillService.getSkill(id);

            // mapping
            skillDto = skillMapper.getSkillDtoFrom(skill);

            ResponseEntity<SkillDto> responseEntity = new ResponseEntity<>(skillDto, HttpStatus.OK);
            LogUtils.logWebResponse(skillDto, responseEntity.getStatusCode());
            return responseEntity;
        } catch (ReferralException re) {
            //TODO log here
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/skills", method = RequestMethod.GET)
    public ResponseEntity<?> getSkills() {
        try {
            LOGGER.info("Getting skill list request received.");

            List<SkillDto> skillDtoList = new ArrayList<>();

            List<Skill> skillList = skillService.getSkills();

            // mapping
            for (Skill skill : skillList) {
                skillDtoList.add(skillMapper.getSkillDtoFrom(skill));
            }

            ResponseEntity<List> responseEntity = new ResponseEntity<>(skillDtoList, HttpStatus.OK);
            LogUtils.logWebResponse(skillDtoList.get(0), responseEntity.getStatusCode());
            return responseEntity;
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/skill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSkill(@PathVariable(name = "id") Integer id) {
        try {
            LOGGER.info("Deleting skill by ID request received. ID={}", id);

            SkillDto skillDto = new SkillDto();

            // validating request
            skillDto.setId(id);
            Validation validation = ValidationFactory.getValidation(skillDto);
            validation.validateRequest(skillDto, RequestMethod.DELETE);

            skillService.deleteSkill(id);

            ResponseEntity<SkillDto> responseEntity = new ResponseEntity<>(skillDto, HttpStatus.OK);
            LogUtils.logWebResponse(skillDto, responseEntity.getStatusCode());
            return responseEntity;
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }
    }

    @RequestMapping(path = "/skill", method = RequestMethod.POST)
    public ResponseEntity<?> createSkill(@RequestBody SkillDto skillDto) {
        try {
            LOGGER.info("Creating skill request received. Request={}", skillDto.toString());

            // validating request
            Validation validation = ValidationFactory.getValidation(skillDto);
            validation.validateRequest(skillDto, RequestMethod.POST);

            Integer newKey = skillService.createSkill(skillMapper.getSkillFrom(skillDto));
            skillDto.setId(newKey);

            ResponseEntity<SkillDto> responseEntity = new ResponseEntity<>(skillDto, HttpStatus.OK);
            LogUtils.logWebResponse(skillDto, responseEntity.getStatusCode());
            return responseEntity;
        } catch (ReferralException re) {
            throw re;
        } catch (Exception e) {
            LOGGER.error(ApplicationException.MESSAGE, e);
            throw new ApplicationException();
        }

    }

}
