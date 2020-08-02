package org.mitpu.referral.core.services.main;

import org.mitpu.referral.core.repositories.CandidateSkillRepository;
import org.mitpu.referral.core.repositories.models.CandidateSkill;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSkillService {

    private final static String OBJECT_NAME = "candidate's skill";

    private CandidateSkillRepository candidateSkillRepository;

    @Autowired
    public CandidateSkillService(CandidateSkillRepository candidateSkillRepository) {
        this.candidateSkillRepository = candidateSkillRepository;
    }

    public CandidateSkill getCandidateSkill(Integer id) {
        CandidateSkill candidateSkill = candidateSkillRepository.findById(id);
        if (candidateSkill == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateSkill;
    }

    public List<CandidateSkill> getCandidateSkills() {
        List<CandidateSkill> candidateList = candidateSkillRepository.findAll();
        if (candidateList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateList;
    }

    public List<CandidateSkill> getCandidateSkillsByCandidateId(Integer candidateId) {
        List<CandidateSkill> candidateList = candidateSkillRepository.findAllByCandidateId(candidateId);
        if (candidateList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateList;
    }

    public void deleteCandidateSkill(Integer id) {
        CandidateSkill candidateSkill = candidateSkillRepository.findById(id);
        if (candidateSkill == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (candidateSkillRepository.delete(id)) {
            // TODO log
        }
    }

    public Integer createCandidateSkill(CandidateSkill candidateSkill) {
        Integer newKey = candidateSkillRepository.save(candidateSkill);
        if (newKey == null) {
            throw new ConflictException(OBJECT_NAME);
        }
        return newKey;
    }
}
