package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.services.exception.ReferralException;

public class ValidationFactory {

    private ValidationFactory() {
    }

    public static Validation getValidation(Dto dto) throws ReferralException {
        if (dto instanceof CandidateDto) {
            return new CandidateValidation();
        } else {
            throw new ReferralException("Validation is not found.");
        }
    }
}
