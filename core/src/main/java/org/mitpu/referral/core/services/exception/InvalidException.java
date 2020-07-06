package org.mitpu.referral.core.services.exception;

public class InvalidException extends ReferralException {

    private static final String MESSAGE_FORMAT = "'%s' is invalid.";

    public InvalidException(String object) {
        super(String.format(MESSAGE_FORMAT, object));
    }

}
