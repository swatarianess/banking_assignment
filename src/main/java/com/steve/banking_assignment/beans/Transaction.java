package com.steve.banking_assignment.beans;

import java.sql.Timestamp;

public class Transaction {

    static long id = 0;
    long transactionID;
    long senderCustomerID;
    long amount;
    long recipientCustomerID;
    Timestamp timestamp;

    public Transaction(long senderCustomerID, long recipientCustomerID, long amount, Timestamp timestamp) {
        id++;
        this.transactionID = id;
        this.senderCustomerID = senderCustomerID;
        this.recipientCustomerID = recipientCustomerID;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public long getId() {
        return transactionID;
    }

    public void setId(long id) {
        this.transactionID = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getSenderCustomerID() {
        return senderCustomerID;
    }

    public void setSenderCustomerID(long senderCustomerID) {
        this.senderCustomerID = senderCustomerID;
    }

    public long getRecipientCustomerID() {
        return recipientCustomerID;
    }

    public void setRecipientCustomerID(long recipientCustomerID) {
        this.recipientCustomerID = recipientCustomerID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        return transactionID == that.transactionID;
    }

    @Override
    public int hashCode() {
        return (int) (transactionID ^ (transactionID >>> 32));
    }
}
