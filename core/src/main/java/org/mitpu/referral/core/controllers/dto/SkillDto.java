package org.mitpu.referral.core.controllers.dto;

public class SkillDto extends Dto {

    private Integer id;

    private String skill;

    public SkillDto() {
        super("Skill");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
