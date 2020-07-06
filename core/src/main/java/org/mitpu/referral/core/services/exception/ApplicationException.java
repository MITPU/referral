package org.mitpu.referral.core.services.exception;

public class ApplicationException extends ReferralException {

    private static final String MESSAGE = "Request is failed.";

    public ApplicationException() {
        super(MESSAGE);
    }

}
