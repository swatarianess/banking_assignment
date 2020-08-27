package com.steve.banking_assignment.service;

import com.steve.banking_assignment.model.Transaction;

import java.util.List;

public interface TransactionService {

   boolean createTransaction(Transaction transaction);
   List<Transaction> findAllTransactions();
   List<Transaction> findTransactionsByAccountID(long accountID);
   Transaction findTransactionByTransactionID(long transactionID);

}
