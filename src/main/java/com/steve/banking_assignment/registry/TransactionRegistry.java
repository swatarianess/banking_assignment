package com.steve.banking_assignment.registry;

import com.steve.banking_assignment.model.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionRegistry {

    private final Set<Transaction> transactions = new HashSet<>();
    private static TransactionRegistry transactionRegistry;

    private TransactionRegistry() {
        transactionRegistry = this;
    }

    public static TransactionRegistry getInstance() {
        if (transactionRegistry == null) return new TransactionRegistry();
        return transactionRegistry;
    }

    public boolean add(Transaction transaction) {
        return transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

}
