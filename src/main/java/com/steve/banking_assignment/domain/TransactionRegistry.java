package com.steve.banking_assignment.domain;

import java.util.ArrayList;
import java.util.List;

public class TransactionRegistry {

    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private static TransactionRegistry transactionRegistry;

    private TransactionRegistry() {
        transactionRegistry = this;
    }

    public static TransactionRegistry getInstance() {
        if (transactionRegistry == null) return new TransactionRegistry();
        return transactionRegistry;
    }

    public boolean add(Transaction transaction){
        if (!transactions.contains(transaction)) {
            return this.transactions.add(transaction);
        }
        return false;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

}
