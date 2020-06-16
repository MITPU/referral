package org.mitpu.referral.core.services.main;

import org.mitpu.referral.core.controllers.mapper.CandidateMapper;
import org.mitpu.referral.core.repositories.CandidateRepository;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private CandidateRepository candidateRepository;

    private CandidateMapper candidateMapper;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
    }

    public Candidate getCandidate(int id) {
        return candidateRepository.findById(id);
    }
}
