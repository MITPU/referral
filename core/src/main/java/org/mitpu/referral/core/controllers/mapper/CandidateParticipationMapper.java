package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.CandidateParticipationDto;
import org.mitpu.referral.core.repositories.models.CandidateParticipation;
import org.springframework.stereotype.Component;

@Component
public class CandidateParticipationMapper {

    public CandidateParticipation getCandidateParticipationFrom(CandidateParticipationDto candidateParticipationDto) {
        if (candidateParticipationDto == null) {
            return null;
        }
        CandidateParticipation candidateParticipation = new CandidateParticipation();
        candidateParticipation.setId(candidateParticipationDto.getId());
        candidateParticipation.setParticipationId(candidateParticipationDto.getParticipationId());
        candidateParticipation.setCandidateId(candidateParticipationDto.getCandidateId());
        candidateParticipation.setReferrerId(candidateParticipationDto.getReferrerId());
        candidateParticipation
                .setStatus(CandidateParticipation.Status.getStatus(candidateParticipationDto.getStatus()));
        return candidateParticipation;
    }

    public CandidateParticipationDto getCandidateParticipationDtoFrom(CandidateParticipation candidateParticipation) {
        if (candidateParticipation == null) {
            return null;
        }
        CandidateParticipationDto candidateParticipationDto = new CandidateParticipationDto();
        candidateParticipationDto.setId(candidateParticipation.getId());
        candidateParticipationDto.setParticipationId(candidateParticipation.getParticipationId());
        candidateParticipationDto.setCandidateId(candidateParticipation.getCandidateId());
        candidateParticipationDto.setReferrerId(candidateParticipation.getReferrerId());
        candidateParticipationDto.setStatus(candidateParticipation.getStatus().value);
        return candidateParticipationDto;
    }
}
