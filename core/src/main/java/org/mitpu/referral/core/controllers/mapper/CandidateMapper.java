package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.repositories.models.WorkAuthorization;
import org.mitpu.referral.core.services.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper {

    public Candidate getCandidateFrom(CandidateDto candidateDto) {
        if (candidateDto == null) {
            return null;
        }
        Candidate candidate = new Candidate();
        candidate.setId(candidateDto.getId());
        candidate.setLinkedin(candidateDto.getLinkedin());
        candidate.setCoordinatorId(candidateDto.getCoordinatorId());
        if (candidateDto.getStage() != null) {
            candidate.setStage(Candidate.Stage.getStage(candidateDto.getStage()));
        }
        if (candidateDto.getStatus() != null) {
            candidate.setStatus(Candidate.Status.getStatus(candidateDto.getStatus()));
        }
        candidate.setWorkAuthorization(WorkAuthorization.getWorkAuthorization(candidateDto.getWorkAuthorization()));
        candidate.setCity(candidateDto.getCity());
        candidate.setCountry(candidateDto.getCountry());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setFirstname(candidateDto.getFirstname());
        candidate.setLastname(candidateDto.getLastname());
        candidate.setMiddlename(candidateDto.getMiddlename());
        candidate.setPhone(candidateDto.getPhone());
        candidate.setState(candidateDto.getState());
        candidate.setZip(candidateDto.getZip());
        candidate.setAbout(candidateDto.getAbout());
        candidate.setDate(DateTimeUtils.stringToDateTime(candidateDto.getDate()));
        return candidate;
    }

    public CandidateDto getCandidateDtoFrom(Candidate candidate) {
        if (candidate == null) {
            return null;
        }
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setLinkedin(candidate.getLinkedin());
        candidateDto.setCoordinatorId(candidate.getCoordinatorId());
        candidateDto.setStage(candidate.getStage().value);
        candidateDto.setStatus(candidate.getStatus().value);
        candidateDto.setWorkAuthorization(candidate.getWorkAuthorization().value);
        candidateDto.setCity(candidate.getCity());
        candidateDto.setCountry(candidate.getCountry());
        candidateDto.setEmail(candidate.getEmail());
        candidateDto.setFirstname(candidate.getFirstname());
        candidateDto.setLastname(candidate.getLastname());
        candidateDto.setMiddlename(candidate.getMiddlename());
        candidateDto.setPhone(candidate.getPhone());
        candidateDto.setState(candidate.getState());
        candidateDto.setZip(candidate.getZip());
        candidateDto.setAbout(candidate.getAbout());
        candidateDto.setDate(DateTimeUtils.dateTimeToString(candidate.getDate()));
        return candidateDto;
    }
}
