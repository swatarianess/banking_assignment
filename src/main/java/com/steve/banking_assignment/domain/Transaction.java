package com.steve.banking_assignment.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class Transaction {

    protected static Long id = 0L;
    private long transactionID;
    private long senderCustomerID;
    private long amount;
    private long recipientCustomerID;
    private Timestamp timestamp;

    public Transaction(long senderCustomerID, long recipientCustomerID, long amount) {
        id++;
        this.transactionID = id;
        this.senderCustomerID = senderCustomerID;
        this.recipientCustomerID = recipientCustomerID;
        this.amount = amount;
        this.timestamp = new Timestamp(Instant.now().toEpochMilli());
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
