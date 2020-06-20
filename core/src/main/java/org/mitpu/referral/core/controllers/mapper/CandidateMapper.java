package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.repositories.models.Candidate;
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
        candidate.setStage(candidateDto.getStage());
        candidate.setStatus(candidateDto.getStatus());
        candidate.setWorkAuthorization(candidateDto.getWorkAuthorization());
        candidate.setCity(candidateDto.getCity());
        candidate.setCountry(candidateDto.getCountry());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setFirstname(candidateDto.getFirstname());
        candidate.setLastname(candidateDto.getLastname());
        candidate.setMiddlename(candidateDto.getMiddlename());
        candidate.setPhone(candidateDto.getPhone());
        candidate.setState(candidateDto.getState());
        candidate.setStreet1(candidateDto.getStreet1());
        candidate.setStreet2(candidateDto.getStreet2());
        candidate.setZip(candidateDto.getZip());
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
        candidateDto.setStage(candidate.getStage());
        candidateDto.setStatus(candidate.getStatus());
        candidateDto.setWorkAuthorization(candidate.getWorkAuthorization());
        candidateDto.setCity(candidate.getCity());
        candidateDto.setCountry(candidate.getCountry());
        candidateDto.setEmail(candidate.getEmail());
        candidateDto.setFirstname(candidate.getFirstname());
        candidateDto.setLastname(candidate.getLastname());
        candidateDto.setMiddlename(candidate.getMiddlename());
        candidateDto.setPhone(candidate.getPhone());
        candidateDto.setState(candidate.getState());
        candidateDto.setStreet1(candidate.getStreet1());
        candidateDto.setStreet2(candidate.getStreet2());
        candidateDto.setZip(candidate.getZip());
        return candidateDto;
    }
}
