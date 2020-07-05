package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.services.exception.ApplicationException;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.InvalidException;
import org.mitpu.referral.core.services.exception.MissingException;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handle(NotFoundException nfe) {
        return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<Object> handle(ConflictException ce) {
        return new ResponseEntity<>(ce.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MissingException.class)
    public ResponseEntity<Object> handle(MissingException ce) {
        return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity<Object> handle(InvalidException ie) {
        return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<Object> handle(ApplicationException ae) {
        return new ResponseEntity<>(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
