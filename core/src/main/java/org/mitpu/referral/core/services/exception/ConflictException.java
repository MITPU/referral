package org.mitpu.referral.core.services.exception;

public class ConflictException extends ReferralException {

    private static final String MESSAGE_FORMAT = "'%s' is already exist.";

    private static final String MESSAGE_DEFAULT = "A property is already exist.";

    public ConflictException(String message) {
        super(String.format(MESSAGE_FORMAT, message));
    }

    public ConflictException() {
        super(MESSAGE_DEFAULT);
    }
}
