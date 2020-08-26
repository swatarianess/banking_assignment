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
public class AccountRegistrationReply {
    String name;
    String surname;
    long customerID;
    String registrationStatus;
    Timestamp timestamp;
}
