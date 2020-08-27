package com.steve.banking_assignment.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AccountAlreadyAllocatedToCustomerException extends RuntimeException {
    private final static long serialVersionUID = 6L;
}
