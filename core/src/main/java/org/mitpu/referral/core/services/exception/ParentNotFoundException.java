package org.mitpu.referral.core.services.exception;

public class ParentNotFoundException extends NotFoundException {

    private static final String MESSAGE_FORMAT = "Parent %s's ID";

    private static final String MESSAGE_DEFAULT = "A parent ID";

    public ParentNotFoundException(String object) {
        super(String.format(MESSAGE_FORMAT, object));
    }

    public ParentNotFoundException() {
        super(MESSAGE_DEFAULT);
    }
}
