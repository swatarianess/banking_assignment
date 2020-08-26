package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.dto.TransactionRegisterReply;
import com.steve.banking_assignment.model.Transaction;
import com.steve.banking_assignment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TransactionService transactionService;

    /**
     * Creates new transaction
     * @param transaction The transaction information
    * */
    @PostMapping(value = "/transaction/", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionRegisterReply> registerTransaction(@RequestBody Transaction transaction) {
        TransactionRegisterReply transactionRegisterReply = null;

        if (transactionService.createTransaction(transaction)){
            transactionRegisterReply = TransactionRegisterReply.builder()
                    .transactionID(transaction.getTransactionID())
                    .recipientCustomerID(transaction.getRecipientCustomerID())
                    .senderCustomerID(transaction.getSenderCustomerID())
                    .timestamp(Timestamp.from(Instant.now()))
                    .registrationStatus("Success")
                    .amount(transaction.getAmount())
                    .build();

            return new ResponseEntity<>(transactionRegisterReply, HttpStatus.OK);

        } else {
            return new ResponseEntity<>( transactionRegisterReply, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}