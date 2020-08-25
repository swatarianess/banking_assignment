package com.steve.banking_assignment.service;

import com.steve.banking_assignment.domain.Transaction;

import java.util.Optional;

public interface TransactionService {

   Optional<Transaction> createTransaction();
   Optional<Transaction> findTransactionByAccountID(long accountID);
   Optional<Transaction> findTransactionByTransactionID(long transactionID);

}
