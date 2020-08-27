package com.steve.banking_assignment.exception.controller;


import com.steve.banking_assignment.exception.TransactionAlreadyExistsException;
import com.steve.banking_assignment.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionController {

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<Object> notFoundException(TransactionNotFoundException exception){
        return new ResponseEntity<>("Transaction not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionAlreadyExistsException.class)
    public ResponseEntity<Object> alreadyExistsException(TransactionNotFoundException exception){
        return new ResponseEntity<>("Transaction already exists!", HttpStatus.FORBIDDEN);
    }

}