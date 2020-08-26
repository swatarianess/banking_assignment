package com.steve.banking_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRegisterReply {
    long transactionID;
    long recipientCustomerID;
    long senderCustomerID;
    long amount;
    String registrationStatus;
    Timestamp timestamp;
}
