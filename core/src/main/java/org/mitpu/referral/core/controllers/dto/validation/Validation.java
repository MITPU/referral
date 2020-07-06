package org.mitpu.referral.core.controllers.dto.validation;

import org.mitpu.referral.core.controllers.dto.Dto;
import org.mitpu.referral.core.repositories.DBConstants;
import org.mitpu.referral.core.repositories.ValueRange;
import org.mitpu.referral.core.services.exception.InvalidException;
import org.mitpu.referral.core.services.exception.MissingException;
import org.mitpu.referral.core.services.exception.ReferralException;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validation {

    public abstract void validateRequest(Dto dto, RequestMethod requestMethod) throws ReferralException;

    protected void validateRequestProperty(DBConstants.Column column, Object propertyValue, Boolean isNullable) {
        if (!isNullable && propertyValue == null) {
            throw new MissingException(column.name());
        }
        ValueRange valueRange = DBConstants.VALUE_CONSTRAINTS.get(column);
        if (valueRange != null && propertyValue != null) {
            if (propertyValue instanceof String) {
                String value = (String) propertyValue;
                if (value.length() < valueRange.minValue || value.length() > valueRange.maxValue) {
                    throw new InvalidException(column.name());
                }
                if (column == DBConstants.Column.EMAIL) {
                    validateEmailProperty(value);
                }
            } else if (propertyValue instanceof Integer) {
                Integer value = (Integer) propertyValue;
                if (value < valueRange.minValue || value > valueRange.maxValue) {
                    throw new InvalidException(column.name());
                }
            } else if (propertyValue instanceof Byte) {
                Byte value = (Byte) propertyValue;
                if (value < valueRange.minValue || value > valueRange.maxValue) {
                    throw new InvalidException(column.name());
                }
            }
        }
    }

    private void validateEmailProperty(String email) {
        email = email.toUpperCase();
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidException("email");
        }
    }
}
