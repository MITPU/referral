package org.mitpu.referral.core.controllers.dto;

public class CandidateSkillDto extends Dto {

    private Integer id;

    private Integer skillId;

    private Integer candidateId;

    private Byte year;

    public CandidateSkillDto() {
        super("Candidate's skill");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Byte getYear() {
        return year;
    }

    public void setYear(Byte year) {
        this.year = year;
    }
}
