package com.steve.banking_assignment.beans;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AccountRegistrationReply {
    String name;
    String surname;
    long customerID;
    String registrationStatus;
    Timestamp timestamp;
}
