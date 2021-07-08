package org.mitpu.referral.core.services.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.repositories.CandidateParticipationRepository;
import org.mitpu.referral.core.repositories.CandidateRepository;
import org.mitpu.referral.core.repositories.CandidateSkillRepository;
import org.mitpu.referral.core.repositories.JobRepository;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.repositories.models.CandidateForm;
import org.mitpu.referral.core.repositories.models.CandidateParticipation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateFormService {

    private static final Logger LOGGER = LogManager.getLogger(SkillService.class);

    private final static String OBJECT_NAME = "candidate form";

    private CandidateRepository candidateRepository;

    private CandidateParticipationRepository candidateParticipationRepository;

    private CandidateSkillRepository candidateSkillRepository;

    private JobRepository jobRepository;

    @Autowired
    public CandidateFormService(CandidateRepository candidateRepository,
                                CandidateParticipationRepository candidateParticipationRepository,
                                CandidateSkillRepository candidateSkillRepository, JobRepository jobRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateParticipationRepository = candidateParticipationRepository;
        this.candidateSkillRepository = candidateSkillRepository;
        this.jobRepository = jobRepository;
    }

    public Integer createCandidateFrom(CandidateForm candidateForm) {
        // override properties with default values
        candidateForm.getCandidate().setStage(Candidate.Stage.INITIAL);
        candidateForm.getCandidate().setStatus(Candidate.Status.NEW);

        // saving candidate
        Integer newKey = candidateRepository.save(candidateForm.getCandidate());

        // set candidate's ID
        candidateForm.getSkillList().forEach(s -> s.setCandidateId(newKey));
        candidateForm.getParticipationList().forEach(p -> p.setCandidateId(newKey));
        candidateForm.getParticipationList().forEach(p -> p.setStatus(CandidateParticipation.Status.REQUESTED));
        candidateForm.getDesiredJobList().forEach(j -> j.setCandidateId(newKey));

        // saving job list
        candidateForm.getDesiredJobList().forEach(j -> jobRepository.save(j));

        // saving participation list
        candidateForm.getParticipationList().forEach(p -> candidateParticipationRepository.save(p));

        // saving skill list
        candidateForm.getSkillList().forEach(s -> candidateSkillRepository.save(s));

        return newKey;
    }
}
