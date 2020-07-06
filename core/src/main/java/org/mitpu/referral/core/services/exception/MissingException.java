package org.mitpu.referral.core.services.exception;

public class MissingException extends ReferralException {

    private static final String MESSAGE_FORMAT = "'%s' is missing.";

    public MissingException(String object) {
        super(String.format(MESSAGE_FORMAT, object));
    }

}
