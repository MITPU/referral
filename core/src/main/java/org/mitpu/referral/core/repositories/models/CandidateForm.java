package org.mitpu.referral.core.repositories.models;

import java.util.List;

public class CandidateForm {

    private Candidate candidate;

    private List<CandidateSkill> skillList;

    private List<CandidateParticipation> participationList;

    private List<Job> desiredJobList;

    public CandidateForm() {
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public List<CandidateSkill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<CandidateSkill> skillList) {
        this.skillList = skillList;
    }

    public List<CandidateParticipation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<CandidateParticipation> participationList) {
        this.participationList = participationList;
    }

    public List<Job> getDesiredJobList() {
        return desiredJobList;
    }

    public void setDesiredJobList(List<Job> desiredJobList) {
        this.desiredJobList = desiredJobList;
    }
}
