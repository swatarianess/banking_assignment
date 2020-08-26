package com.steve.banking_assignment.service;

import com.steve.banking_assignment.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

   boolean createTransaction(Transaction transaction);
   List<Transaction> findAllTransactions();
   List<Transaction> findTransactionsByAccountID(long accountID);
   Optional<Transaction> findTransactionByTransactionID(long transactionID);

}
