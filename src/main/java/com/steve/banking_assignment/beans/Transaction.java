package com.steve.banking_assignment.beans;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Transaction {

    String id;
    String fromCustomer;
    int amount;
    String toCustomer;
    Timestamp timestamp;

    public Transaction(String id, String fromCustomer, String toCustomer, Timestamp timestamp) {
        this.id = id;
        this.fromCustomer = fromCustomer;
        this.toCustomer = toCustomer;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFromCustomer() {
        return fromCustomer;
    }

    public void setFromCustomer(String fromCustomer) {
        this.fromCustomer = fromCustomer;
    }

    public String getToCustomer() {
        return toCustomer;
    }

    public void setToCustomer(String toCustomer) {
        this.toCustomer = toCustomer;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
