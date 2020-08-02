package org.mitpu.referral.core.services.main;

import org.mitpu.referral.core.repositories.SkillRepository;
import org.mitpu.referral.core.repositories.models.Skill;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final static String OBJECT_NAME = "skill";

    private SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getSkill(Integer id) {
        Skill skill = skillRepository.findById(id);
        if (skill == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return skill;
    }

    public List<Skill> getSkills() {
        List<Skill> skillList = skillRepository.findAll();
        if (skillList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return skillList;
    }

    public void deleteSkill(Integer id) {
        Skill skill = skillRepository.findById(id);
        if (skill == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (skillRepository.delete(id)) {
            // TODO log
        }
    }

    public Integer createSkill(Skill skill) {
        Integer newKey = skillRepository.save(skill);
        if (newKey == null) {
            throw new ConflictException(OBJECT_NAME);
        }
        return newKey;
    }
}
