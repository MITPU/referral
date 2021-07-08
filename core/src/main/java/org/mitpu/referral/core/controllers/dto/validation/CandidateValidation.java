package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.repositories.database.DBConstants;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.springframework.web.bind.annotation.RequestMethod;

public class CandidateValidation extends Validation {

    @Override
    public void validateRequest(Dto dto, RequestMethod requestMethod) throws ReferralException {
        CandidateDto candidateDto = (CandidateDto) dto;
        if (requestMethod == RequestMethod.GET || requestMethod == RequestMethod.DELETE) {
            validateRequestProperty(DBConstants.Column.ID, candidateDto.getId(), false);
        } else if (requestMethod == RequestMethod.POST) {
            validateRequestProperty(DBConstants.Column.ID, candidateDto.getFirstname(), true);
            validateRequestProperty(DBConstants.Column.FIRSTNAME, candidateDto.getFirstname(), false);
            validateRequestProperty(DBConstants.Column.MIDDLENAME, candidateDto.getMiddlename(), true);
            validateRequestProperty(DBConstants.Column.LASTNAME, candidateDto.getLastname(), false);
            validateRequestProperty(DBConstants.Column.EMAIL, candidateDto.getEmail(), false);
            validateRequestProperty(DBConstants.Column.PHONE, candidateDto.getPhone(), false);
            validateRequestProperty(DBConstants.Column.CITY, candidateDto.getCity(), false);
            validateRequestProperty(DBConstants.Column.ZIP, candidateDto.getZip(), true);
            validateRequestProperty(DBConstants.Column.COUNTRY, candidateDto.getCountry(), false);
            validateRequestProperty(DBConstants.Column.WORKAUTHORIZATION, candidateDto.getWorkAuthorization(), false);
            validateRequestProperty(DBConstants.Column.LINKEDIN, candidateDto.getLinkedin(), true);
            validateRequestProperty(DBConstants.Column.STAGE, candidateDto.getStage(), true);
            validateRequestProperty(DBConstants.Column.STATUS, candidateDto.getStatus(), true);
            validateRequestProperty(DBConstants.Column.ABOUT, candidateDto.getAbout(), false);
            validateRequestProperty(DBConstants.Column.COORDINATOR_ID, candidateDto.getCoordinatorId(), true);
        } else if (requestMethod == RequestMethod.PUT || requestMethod == RequestMethod.PATCH) {
            validateRequestProperty(DBConstants.Column.DATE, candidateDto.getAbout(), true);
        }
    }

}
