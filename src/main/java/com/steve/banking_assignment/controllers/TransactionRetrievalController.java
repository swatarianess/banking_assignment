package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.model.Transaction;
import com.steve.banking_assignment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionRetrievalController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions/")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/transactions/user/{userID}")
    public ResponseEntity<List<Transaction>> getTransactionsFromUserID(@PathVariable long userID){
        return new ResponseEntity<>(transactionService.findTransactionsByAccountID(userID), HttpStatus.OK);
    }

    @GetMapping("/transactions/{transactionID}")
    public ResponseEntity<Transaction> getTransactionFromTransactionID(@PathVariable long transactionID){
        return new ResponseEntity<>(transactionService.findTransactionByTransactionID(transactionID), HttpStatus.OK);
    }

}
