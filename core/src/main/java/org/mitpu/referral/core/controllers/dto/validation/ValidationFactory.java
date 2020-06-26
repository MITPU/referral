package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.Dto;

public class ValidationFactory {

    private ValidationFactory() {
    }

    public static Validation getValidation(Dto dto) throws ValidationException {
        if (dto instanceof CandidateDto) {
            return new CandidateValidation();
        } else {
            throw new ValidationException("Validation is not found.");
        }
    }
}
