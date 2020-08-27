package com.steve.banking_assignment.service.impl;

import com.steve.banking_assignment.exception.TransactionNotFoundException;
import com.steve.banking_assignment.model.Account;
import com.steve.banking_assignment.model.Transaction;
import com.steve.banking_assignment.registry.TransactionRegistry;
import com.steve.banking_assignment.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRegistry registry = TransactionRegistry.getInstance();

    /**
     * Adds a new transaction to the {@link TransactionRegistry}
     *
     * @param transaction The transaction to be added to the registry
     * @return Returns true if the transaction was added to the registry successfully, false otherwise.
     */
    @Override
    public boolean createTransaction(Transaction transaction) {
        return registry.add(transaction);
    }

    /**
     * Retrieves all the transactions in the reegistry
     *
     * @return Returns all transactions in the registry
     */
    @Override
    public List<Transaction> findAllTransactions() {
        return registry.getTransactions();
    }

    /**
     * Retrieves transactions sent/received by an {@link Account}.
     *
     * @param accountID The accountID of the sender/receiver of the transaction
     * @return Returns a list of transactions sent to/from an {@link Account}
     */
    @Override
    public List<Transaction> findTransactionsByAccountID(long accountID) {
        return registry.getTransactions().stream().filter(transaction -> transaction.getSenderCustomerID() == accountID || transaction.getRecipientCustomerID() == accountID).collect(Collectors.toList());
    }

    /**
     * Retrieves a transaction matching the supplied Transaction ID
     *
     * @param transactionID The transactionID of the {@link Transaction}
     * @return Returns the {@link Transaction} matching the supplied transactionID
     */
    @Override
    @ExceptionHandler(TransactionNotFoundException.class)
    public Transaction findTransactionByTransactionID(long transactionID) {
        return registry.getTransactions().stream().filter(transaction -> transaction.getTransactionID() == transactionID).findFirst().orElseThrow(TransactionNotFoundException::new);
    }
}
