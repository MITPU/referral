package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.controllers.dto.SkillDto;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.springframework.web.bind.annotation.RequestMethod;

public class SkillValidation extends Validation {

    @Override
    public void validateRequest(Dto dto, RequestMethod requestMethod) throws ReferralException {
        SkillDto skillDto = (SkillDto) dto;
        if (requestMethod == RequestMethod.GET || requestMethod == RequestMethod.DELETE) {

        } else if (requestMethod == RequestMethod.POST) {

        }
    }

}
