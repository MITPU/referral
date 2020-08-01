package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.SkillDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.SkillMapper;
import org.mitpu.referral.core.repositories.models.Skill;
import org.mitpu.referral.core.services.main.SkillService;
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
public class SkillController {

    private SkillMapper skillMapper;

    private SkillService skillService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public SkillController(SkillMapper skillMapper, SkillService skillService) {
        this.skillMapper = skillMapper;
        this.skillService = skillService;
    }

    @RequestMapping(path = "/skill/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSkill(@PathVariable(name = "id") Integer id) {
        SkillDto skillDto = new SkillDto();

        // validating request
        skillDto.setId(id);
        Validation validation = ValidationFactory.getValidation(skillDto);
        validation.validateRequest(skillDto, RequestMethod.GET);

        Skill skill = skillService.getSkill(id);

        // mapping
        skillDto = skillMapper.getSkillDtoFrom(skill);
        return new ResponseEntity<>(skillDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/skills", method = RequestMethod.GET)
    public ResponseEntity<?> getSkills() {
        List<SkillDto> skillDtoList = new ArrayList<>();

        List<Skill> skillList = skillService.getSkills();

        // mapping
        for (Skill skill : skillList) {
            skillDtoList.add(skillMapper.getSkillDtoFrom(skill));
        }
        return new ResponseEntity<>(skillDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/skill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSkill(@PathVariable(name = "id") Integer id) {
        SkillDto skillDto = new SkillDto();

        // validating request
        skillDto.setId(id);
        Validation validation = ValidationFactory.getValidation(skillDto);
        validation.validateRequest(skillDto, RequestMethod.DELETE);

        skillService.deleteSkill(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/skill", method = RequestMethod.POST)
    public ResponseEntity<?> createSkill(@RequestBody SkillDto skillDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(skillDto);
        validation.validateRequest(skillDto, RequestMethod.POST);

        Integer newKey = skillService.createSkill(skillMapper.getSkillFrom(skillDto));
        skillDto.setId(newKey);
        return new ResponseEntity<>(skillDto, HttpStatus.OK);
    }

}
