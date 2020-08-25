package com.steve.banking_assignment.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionRegisterReply {
    long transactionID;
    long recipientCustomerID;
    long senderCustomerID;
    long amount;
    String registrationStatus;
    Timestamp timestamp;

}
