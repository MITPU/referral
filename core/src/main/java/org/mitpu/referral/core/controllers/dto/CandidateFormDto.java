package org.mitpu.referral.core.controllers.dto;

import java.util.List;

public class CandidateFormDto extends Dto {

    private CandidateDto candidate;

    private List<CandidateSkillDto> skillList;

    private List<CandidateParticipationDto> participationList;

    private List<JobDto> desiredJobList;

    public CandidateFormDto() {
        super("Candidate form");
    }

    public CandidateDto getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDto candidate) {
        this.candidate = candidate;
    }

    public List<CandidateSkillDto> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<CandidateSkillDto> skillList) {
        this.skillList = skillList;
    }

    public List<CandidateParticipationDto> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<CandidateParticipationDto> participationList) {
        this.participationList = participationList;
    }

    public List<JobDto> getDesiredJobList() {
        return desiredJobList;
    }

    public void setDesiredJobList(List<JobDto> desiredJobList) {
        this.desiredJobList = desiredJobList;
    }
}
