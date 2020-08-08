package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.CandidateFormDto;
import org.mitpu.referral.core.controllers.dto.CandidateParticipationDto;
import org.mitpu.referral.core.controllers.dto.CandidateSkillDto;
import org.mitpu.referral.core.controllers.dto.JobDto;
import org.mitpu.referral.core.repositories.models.CandidateForm;
import org.mitpu.referral.core.repositories.models.CandidateParticipation;
import org.mitpu.referral.core.repositories.models.CandidateSkill;
import org.mitpu.referral.core.repositories.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidateFormMapper {

    private CandidateMapper candidateMapper;

    private CandidateSkillMapper candidateSkillMapper;

    private CandidateParticipationMapper candidateParticipationMapper;

    private JobMapper jobMapper;

    @Autowired
    public CandidateFormMapper(CandidateMapper candidateMapper, CandidateSkillMapper candidateSkillMapper,
                               CandidateParticipationMapper candidateParticipationMapper, JobMapper jobMapper) {
        this.candidateMapper = candidateMapper;
        this.candidateSkillMapper = candidateSkillMapper;
        this.candidateParticipationMapper = candidateParticipationMapper;
        this.jobMapper = jobMapper;
    }

    public CandidateForm getCandidateFormFrom(CandidateFormDto candidateFormDto) {
        if (candidateFormDto == null) {
            return null;
        }
        List<CandidateSkill> candidateSkillList = candidateFormDto.getSkillList().stream()
                .map(s -> candidateSkillMapper.getCandidateSkillFrom(s)).collect(Collectors.toList());
        List<CandidateParticipation> candidateParticipationList = candidateFormDto.getParticipationList().stream()
                .map(p -> candidateParticipationMapper.getCandidateParticipationFrom(p)).collect(Collectors.toList());
        List<Job> jobList = candidateFormDto.getDesiredJobList().stream().map(j -> jobMapper.getJobFrom(j))
                .collect(Collectors.toList());

        CandidateForm candidateForm = new CandidateForm();
        candidateForm.setCandidate(candidateMapper.getCandidateFrom(candidateFormDto.getCandidate()));
        candidateForm.setParticipationList(candidateParticipationList);
        candidateForm.setDesiredJobList(jobList);
        candidateForm.setSkillList(candidateSkillList);
        return candidateForm;
    }

    public CandidateFormDto getCandidateFormDtoFrom(CandidateForm candidateForm) {
        if (candidateForm == null) {
            return null;
        }
        List<CandidateSkillDto> candidateSkillList = candidateForm.getSkillList().stream()
                .map(s -> candidateSkillMapper.getCandidateSkillDtoFrom(s)).collect(Collectors.toList());
        List<CandidateParticipationDto> candidateParticipationList = candidateForm.getParticipationList().stream()
                .map(p -> candidateParticipationMapper.getCandidateParticipationDtoFrom(p))
                .collect(Collectors.toList());
        List<JobDto> jobList = candidateForm.getDesiredJobList().stream().map(j -> jobMapper.getJobDtoFrom(j))
                .collect(Collectors.toList());
        CandidateFormDto candidateFormDto = new CandidateFormDto();
        candidateFormDto.setCandidate(candidateMapper.getCandidateDtoFrom(candidateForm.getCandidate()));
        candidateFormDto.setDesiredJobList(jobList);
        candidateFormDto.setParticipationList(candidateParticipationList);
        candidateFormDto.setSkillList(candidateSkillList);
        return candidateFormDto;
    }
}
