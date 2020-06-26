package org.mitpu.referral.core.controllers.dto.validation;

public class ValidationException extends Exception {

    public ValidationException() {
        super();
    }

    public ValidationException(String msg) {
        super(msg);
    }
}
