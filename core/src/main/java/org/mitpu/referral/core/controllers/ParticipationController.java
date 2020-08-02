package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.ParticipationDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.ParticipationMapper;
import org.mitpu.referral.core.repositories.models.Participation;
import org.mitpu.referral.core.services.main.ParticipationService;
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
public class ParticipationController {

    private ParticipationMapper participationMapper;

    private ParticipationService participationService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public ParticipationController(ParticipationMapper participationMapper, ParticipationService participationService) {
        this.participationMapper = participationMapper;
        this.participationService = participationService;
    }

    @RequestMapping(path = "/participation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getParticipation(@PathVariable(name = "id") Integer id) {
        ParticipationDto participationDto = new ParticipationDto();

        // validating request
        participationDto.setId(id);
        Validation validation = ValidationFactory.getValidation(participationDto);
        validation.validateRequest(participationDto, RequestMethod.GET);

        Participation participation = participationService.getParticipation(id);

        // mapping
        participationDto = participationMapper.getParticipationDtoFrom(participation);
        return new ResponseEntity<>(participationDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/participations", method = RequestMethod.GET)
    public ResponseEntity<?> getParticipations() {
        List<ParticipationDto> participationDtoList = new ArrayList<>();

        List<Participation> participationList = participationService.getParticipations();

        // mapping
        for (Participation participation : participationList) {
            participationDtoList.add(participationMapper.getParticipationDtoFrom(participation));
        }
        return new ResponseEntity<>(participationDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/participation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteParticipation(@PathVariable(name = "id") Integer id) {
        ParticipationDto participationDto = new ParticipationDto();

        // validating request
        participationDto.setId(id);
        Validation validation = ValidationFactory.getValidation(participationDto);
        validation.validateRequest(participationDto, RequestMethod.DELETE);

        participationService.deleteParticipation(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/participation", method = RequestMethod.POST)
    public ResponseEntity<?> createParticipation(@RequestBody ParticipationDto participationDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(participationDto);
        validation.validateRequest(participationDto, RequestMethod.POST);

        Integer newKey = participationService
                .createParticipation(participationMapper.getParticipationFrom(participationDto));
        participationDto.setId(newKey);
        return new ResponseEntity<>(participationDto, HttpStatus.OK);
    }

}
