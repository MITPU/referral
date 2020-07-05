package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.springframework.web.bind.annotation.RequestMethod;

public class CandidateValidation extends Validation {

    @Override
    public void validateRequest(Dto dto, RequestMethod requestMethod) throws ReferralException {
        CandidateDto candidateDto = (CandidateDto) dto;
        if (requestMethod == RequestMethod.GET) {
            validateRequestProperty(RuleSet.DtoProperty.ID, candidateDto.getFirstname(), false);
        } else if (requestMethod == RequestMethod.POST) {
            validateRequestProperty(RuleSet.DtoProperty.ID, candidateDto.getFirstname(), true);
            validateRequestProperty(RuleSet.DtoProperty.FIRSTNAME, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.MIDDLENAME, candidateDto.getFirstname(), true);
            validateRequestProperty(RuleSet.DtoProperty.LASTNAME, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.EMAIL, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.PHONE, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.CITY, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.ZIP, candidateDto.getFirstname(), true);
            validateRequestProperty(RuleSet.DtoProperty.COUNTRY, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.WORKAUTHORIZATION, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.LINKEDIN, candidateDto.getFirstname(), true);
            validateRequestProperty(RuleSet.DtoProperty.STAGE, candidateDto.getFirstname(), false);
            validateRequestProperty(RuleSet.DtoProperty.STATUS, candidateDto.getFirstname(), false);
        }
    }

}
