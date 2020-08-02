package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.CandidateSkillDto;
import org.mitpu.referral.core.repositories.models.CandidateSkill;
import org.springframework.stereotype.Component;

@Component
public class CandidateSkillMapper {

    public CandidateSkill getCandidateSkillFrom(CandidateSkillDto candidateSkillDto) {
        if (candidateSkillDto == null) {
            return null;
        }
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setId(candidateSkillDto.getId());
        candidateSkill.setCandidateId(candidateSkillDto.getCandidateId());
        candidateSkill.setSkillId(candidateSkillDto.getSkillId());
        candidateSkill.setYear(candidateSkillDto.getYear());
        return candidateSkill;
    }

    public CandidateSkillDto getCandidateSkillDtoFrom(CandidateSkill candidateSkill) {
        if (candidateSkill == null) {
            return null;
        }
        CandidateSkillDto candidateSkillDto = new CandidateSkillDto();
        candidateSkillDto.setId(candidateSkill.getId());
        candidateSkillDto.setCandidateId(candidateSkill.getCandidateId());
        candidateSkillDto.setSkillId(candidateSkill.getSkillId());
        candidateSkillDto.setYear(candidateSkill.getYear());
        return candidateSkillDto;
    }

}
