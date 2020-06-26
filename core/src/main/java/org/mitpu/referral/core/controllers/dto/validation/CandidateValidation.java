package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.CandidateDto;
import org.mitpu.referral.core.controllers.dto.Dto;
import org.springframework.web.bind.annotation.RequestMethod;

public class CandidateValidation implements Validation {

    @Override
    public void validate(Dto dto, RequestMethod requestMethod) throws ValidationException {
        CandidateDto candidateDto = (CandidateDto) dto;
        if (requestMethod == RequestMethod.GET) {
            if (candidateDto.getId() == null || candidateDto.getId() < 1) {
                throw new ValidationException("'id' is missing.");
            }
        } else if (requestMethod == RequestMethod.POST) {
            if (candidateDto.getFirstname() == null || candidateDto.getFirstname().isEmpty()) {
                throw new ValidationException("'firstname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getEmail() == null || candidateDto.getEmail().isEmpty()) {
                throw new ValidationException("'email' is missing.");
            }
            if (candidateDto.getPhone() == null || candidateDto.getPhone().isEmpty()) {
                throw new ValidationException("'phone' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }
            if (candidateDto.getLastname() == null || candidateDto.getLastname().isEmpty()) {
                throw new ValidationException("'lastname' is missing.");
            }

        }
    }

    private void validateNull(Object property) throws ValidationException {
        if (property == null) {
            throw new ValidationException("'firstname' is missing.");
        }
    }
}
