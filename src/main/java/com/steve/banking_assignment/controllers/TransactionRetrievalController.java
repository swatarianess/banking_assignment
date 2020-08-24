package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.beans.Transaction;
import com.steve.banking_assignment.beans.TransactionRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class TransactionRetrievalController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        logger.info("Retrieving transaction data: " + TransactionRegistry.getInstance().getTransactions().toString());
        return new ResponseEntity<>(TransactionRegistry.getInstance().getTransactions(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/{userID}")
    public ResponseEntity<List<Transaction>> getTransactionsFromUserID(@PathVariable long userID){
        logger.info("Retrieved transaction data for userID: " + userID);
        return new ResponseEntity<>(TransactionRegistry.getInstance().getTransactions().stream().filter(transaction -> transaction.getSenderCustomerID() == userID).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/{transactionID}")
    public ResponseEntity<List<Transaction>> getTransactionsFromTransactionID(@PathVariable long transactionID){
        logger.info("Retrieved transaction data for transactionID: " + transactionID);
        return new ResponseEntity<>(TransactionRegistry.getInstance().getTransactions().stream().filter(transaction -> transaction.getId() == transactionID).collect(Collectors.toList()), HttpStatus.OK);
    }




}
