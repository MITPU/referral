package org.mitpu.referral.core.services.exception;

public class ConflictException extends ReferralException {

    private static final String MESSAGE_FORMAT = "'%s' is already exist.";

    private static final String MESSAGE = "one of the properties is already exist.";

    public ConflictException(String object) {
        super(String.format(MESSAGE_FORMAT, object));
    }

    public ConflictException() {
        super(MESSAGE);
    }

}
