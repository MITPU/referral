package org.mitpu.referral.core.services.exception;

public final class NotFoundException extends ReferralException {

    private static final String MESSAGE_FORMAT = "'%s' not found.";

    public NotFoundException(String object) {
        super(String.format(MESSAGE_FORMAT, object));
    }
}
