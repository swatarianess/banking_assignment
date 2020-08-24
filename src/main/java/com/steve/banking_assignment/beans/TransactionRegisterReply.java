package com.steve.banking_assignment.beans;

import java.sql.Timestamp;

public class TransactionRegisterReply {

    long transactionID;
    long recipientCustomerID;
    long senderCustomerID;
    long customerID;
    String registrationStatus;
    Timestamp timestamp;

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public long getRecipientCustomerID() {
        return recipientCustomerID;
    }

    public void setRecipientCustomerID(long recipientCustomerID) {
        this.recipientCustomerID = recipientCustomerID;
    }

    public long getSenderCustomerID() {
        return senderCustomerID;
    }

    public void setSenderCustomerID(long senderCustomerID) {
        this.senderCustomerID = senderCustomerID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
