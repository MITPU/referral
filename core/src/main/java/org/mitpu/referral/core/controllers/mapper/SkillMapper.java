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
        skill.setName(skillDto.getName());
        return skill;
    }

    public SkillDto getSkillDtoFrom(Skill skill) {
        if (skill == null) {
            return null;
        }
        SkillDto skillDto = new SkillDto();
        skill.setName(skill.getName());
        skill.setId(skill.getId());
        return skillDto;
    }
}
