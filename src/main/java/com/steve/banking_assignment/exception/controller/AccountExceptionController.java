package com.steve.banking_assignment.exception.controller;

import com.steve.banking_assignment.exception.AccountAlreadyAllocatedToCustomerException;
import com.steve.banking_assignment.exception.AccountAlreadyExistsException;
import com.steve.banking_assignment.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionController {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> notFoundException(AccountNotFoundException exception){
        return new ResponseEntity<>("Account not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<Object> alreadyExistsException(){
        return new ResponseEntity<>("Account already exists!", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountAlreadyAllocatedToCustomerException.class)
    public ResponseEntity<Object> alreadyAllocatedToCustomerException(){
        return new ResponseEntity<>("Customer already has an Account!", HttpStatus.FORBIDDEN);

    }

}
