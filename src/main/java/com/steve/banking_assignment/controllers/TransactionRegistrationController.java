package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.domain.Transaction;
import com.steve.banking_assignment.domain.TransactionRegisterReply;
import com.steve.banking_assignment.domain.TransactionRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class TransactionRegistrationController {

    @PostMapping(value = "/transaction/", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionRegisterReply> registerTransaction(@RequestBody Transaction transaction) {
        TransactionRegisterReply transactionRegisterReply = new TransactionRegisterReply();

        if (TransactionRegistry.getInstance().add(transaction)){

            transactionRegisterReply.setTransactionID(transaction.getTransactionID());
            transactionRegisterReply.setRecipientCustomerID(transaction.getRecipientCustomerID());
            transactionRegisterReply.setSenderCustomerID(transaction.getSenderCustomerID());
            transactionRegisterReply.setTimestamp(Timestamp.from(Instant.now()));
            transactionRegisterReply.setRegistrationStatus("Success");
            transactionRegisterReply.setAmount(transaction.getAmount());

            return new ResponseEntity<>(transactionRegisterReply, HttpStatus.OK);

        } else {
            return new ResponseEntity<>( transactionRegisterReply, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}