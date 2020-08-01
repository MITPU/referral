package org.mitpu.referral.core.controllers.dto;

public class SkillDto extends Dto{

    private Integer id;

    private String name;

    public SkillDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
