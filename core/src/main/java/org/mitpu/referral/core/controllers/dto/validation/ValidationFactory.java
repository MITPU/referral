package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.CandidateFormDto;
import org.mitpu.referral.core.controllers.dto.CandidateParticipationDto;
import org.mitpu.referral.core.controllers.dto.CandidateSkillDto;
import org.mitpu.referral.core.controllers.dto.CompanyDto;
import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.controllers.dto.JobDto;
import org.mitpu.referral.core.controllers.dto.ParticipationDto;
import org.mitpu.referral.core.controllers.dto.SkillDto;
import org.mitpu.referral.core.services.exception.ReferralException;

public class ValidationFactory {

    private ValidationFactory() {
    }

    public static Validation getValidation(Dto dto) throws ReferralException {
        if (dto instanceof CandidateDto) {
            return new CandidateValidation();
        } else if (dto instanceof CompanyDto) {
            return new CompanyValidation();
        } else if (dto instanceof SkillDto) {
            return new SkillValidation();
        } else if (dto instanceof JobDto) {
            return new JobValidation();
        } else if (dto instanceof CandidateSkillDto) {
            return new CandidateSkillValidation();
        } else if (dto instanceof ParticipationDto) {
            return new ParticipationValidation();
        } else if (dto instanceof CandidateParticipationDto) {
            return new CandidateParticipationValidation();
        } else if (dto instanceof CandidateFormDto) {
            return new CandidateFormValidation();
        } else {
            throw new ReferralException("Validation is not found.");
        }
    }
}
