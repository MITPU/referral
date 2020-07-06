package org.mitpu.referral.core.services.main;

import org.mitpu.referral.core.repositories.CandidateRepository;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final static String OBJECT_NAME = "candidate";

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate getCandidate(Integer id) {
        Candidate candidate = candidateRepository.findById(id);
        if (candidate == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidate;
    }

    public List<Candidate> getCandidates() {
        List<Candidate> candidateList = candidateRepository.findAll();
        if (candidateList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateList;
    }

    public void deleteCandidate(Integer id) {
        Candidate candidate = candidateRepository.findById(id);
        if (candidate == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (candidateRepository.delete(id)) {
            // TODO log
        }
    }

    public Integer createCandidate(Candidate candidate) {
        // override properties with default values
        candidate.setStage(Candidate.Stage.INITIAL);
        candidate.setStatus(Candidate.Status.NEW);

        Integer newKey = candidateRepository.save(candidate);
        if (newKey == null) {
            throw new ConflictException(OBJECT_NAME);
        }
        return newKey;
    }
}
