package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.ParticipationDto;
import org.mitpu.referral.core.repositories.models.Participation;
import org.springframework.stereotype.Component;

@Component
public class ParticipationMapper {

    public Participation getParticipationFrom(ParticipationDto participationDto) {
        if (participationDto == null) {
            return null;
        }
        Participation participation = new Participation();
        participation.setId(participationDto.getId());
        participation.setName(participationDto.getName());
        return participation;
    }

    public ParticipationDto getParticipationDtoFrom(Participation participation) {
        if (participation == null) {
            return null;
        }
        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setId(participation.getId());
        participationDto.setName(participation.getName());
        return participationDto;
    }
}
