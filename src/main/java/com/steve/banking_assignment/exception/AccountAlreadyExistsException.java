package com.steve.banking_assignment.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AccountAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
