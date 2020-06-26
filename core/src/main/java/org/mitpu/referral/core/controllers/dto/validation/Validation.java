package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.Dto;
import org.springframework.web.bind.annotation.RequestMethod;

public interface Validation {

    void validate(Dto dto, RequestMethod requestMethod) throws ValidationException;
}
