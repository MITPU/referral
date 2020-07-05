package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.services.exception.InvalidException;
import org.mitpu.referral.core.services.exception.MissingException;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validation {

    public abstract void validateRequest(Dto dto, RequestMethod requestMethod) throws ReferralException;

    protected void validateRequestProperty(RuleSet.DtoProperty dtoProperty, Object propertyValue, Boolean isNullable) {
        if (!isNullable && propertyValue == null) {
            throw new MissingException(dtoProperty.name());
        }
        RuleSet.Rule rule = RuleSet.PROPERTY_RULE.get(dtoProperty);
        if (rule != null && propertyValue != null) {
            if (propertyValue instanceof String) {
                String value = (String) propertyValue;
                if (value.length() < rule.minValue || value.length() > rule.maxValue) {
                    throw new InvalidException(dtoProperty.name());
                }
                if (dtoProperty == RuleSet.DtoProperty.EMAIL) {
                    validateEmailProperty(value);
                }
            } else if (propertyValue instanceof Integer) {
                Integer value = (Integer) propertyValue;
                if (value < rule.minValue || value > rule.maxValue) {
                    throw new InvalidException(dtoProperty.name());
                }
            } else if (propertyValue instanceof Byte) {
                Byte value = (Byte) propertyValue;
                if (value < rule.minValue || value > rule.maxValue) {
                    throw new InvalidException(dtoProperty.name());
                }
            }
        }
    }

    private void validateEmailProperty(String email) {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidException("email");
        }
    }
}
