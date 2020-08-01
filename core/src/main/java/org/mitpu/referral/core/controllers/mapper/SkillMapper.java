package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.SkillDto;
import org.mitpu.referral.core.repositories.models.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public Skill getSkillFrom(SkillDto skillDto) {
        if (skillDto == null) {
            return null;
        }
        Skill skill = new Skill();
        skill.setId(skillDto.getId());
        skill.setSkill(skillDto.getSkill());
        return skill;
    }

    public SkillDto getSkillDtoFrom(Skill skill) {
        if (skill == null) {
            return null;
        }
        SkillDto skillDto = new SkillDto();
        skillDto.setSkill(skill.getSkill());
        skillDto.setId(skill.getId());
        return skillDto;
    }
}
