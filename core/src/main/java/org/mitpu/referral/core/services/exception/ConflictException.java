package org.mitpu.referral.core.services.exception;

public class ConflictException extends ReferralException {

    private static final String MESSAGE_FORMAT = "'%s' is already exist.";

    public ConflictException(String object) {
        super(String.format(MESSAGE_FORMAT, object));
    }

}
