package org.mitpu.referral.core.services.main;

import org.mitpu.referral.core.repositories.CandidateParticipationRepository;
import org.mitpu.referral.core.repositories.models.CandidateParticipation;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateParticipationService {

    private final static String OBJECT_NAME = "candidate's participation";

    private CandidateParticipationRepository candidateParticipationRepository;

    @Autowired
    public CandidateParticipationService(CandidateParticipationRepository candidateParticipationRepository) {
        this.candidateParticipationRepository = candidateParticipationRepository;
    }

    public CandidateParticipation getCandidateParticipation(Integer id) {
        CandidateParticipation candidateParticipation = candidateParticipationRepository.findById(id);
        if (candidateParticipation == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateParticipation;
    }

    public List<CandidateParticipation> getCandidateParticipations() {
        List<CandidateParticipation> candidateList = candidateParticipationRepository.findAll();
        if (candidateList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateList;
    }

    public List<CandidateParticipation> getCandidateParticipationsByCandidateId(Integer candidateId) {
        List<CandidateParticipation> candidateList = candidateParticipationRepository.findAllByCandidateId(candidateId);
        if (candidateList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return candidateList;
    }

    public void deleteCandidateParticipation(Integer id) {
        CandidateParticipation candidateParticipation = candidateParticipationRepository.findById(id);
        if (candidateParticipation == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (candidateParticipationRepository.delete(id)) {
            // TODO log
        }
    }

    public Integer createCandidateParticipation(CandidateParticipation candidateParticipation) {
        // set default values
        candidateParticipation.setReferrerId(null);
        candidateParticipation.setStatus(CandidateParticipation.Status.REQUESTED);

        Integer newKey = candidateParticipationRepository.save(candidateParticipation);
        if (newKey == null) {
            throw new ConflictException(OBJECT_NAME);
        }
        return newKey;
    }
}
