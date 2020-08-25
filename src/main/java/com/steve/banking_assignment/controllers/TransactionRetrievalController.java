package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.domain.Transaction;
import com.steve.banking_assignment.domain.TransactionRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class TransactionRetrievalController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @GetMapping("/transaction/all")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        logger.info("Retrieving transaction data: " + TransactionRegistry.getInstance().getTransactions().toString());
        return new ResponseEntity<>(TransactionRegistry.getInstance().getTransactions(), HttpStatus.OK);
    }

    @GetMapping("/transaction/{userID}")
    public ResponseEntity<List<Transaction>> getTransactionsFromUserID(@PathVariable long userID){
        logger.info("Retrieved transaction data for userID: " + userID);
        return new ResponseEntity<>(TransactionRegistry.getInstance().getTransactions().stream().filter(transaction -> transaction.getSenderCustomerID() == userID).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/transaction/{transactionID}")
    public ResponseEntity<List<Transaction>> getTransactionsFromTransactionID(@PathVariable long transactionID){
        logger.info("Retrieved transaction data for transactionID: " + transactionID);
        return new ResponseEntity<>(TransactionRegistry.getInstance().getTransactions().stream().filter(transaction -> transaction.getTransactionID() == transactionID).collect(Collectors.toList()), HttpStatus.OK);
    }




}
