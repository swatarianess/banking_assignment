package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.dto.AccountRegistrationReply;
import com.steve.banking_assignment.model.Account;
import com.steve.banking_assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Logger;

@RestController
public class AccountRegistrationController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Autowired
    AccountService accountService;

    /**
     * Opens a new account.
     *
     * @param account The details for the new account
     */
    @PostMapping(value = "/account/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountRegistrationReply> registerAccount(@RequestBody Account account) {
        AccountRegistrationReply accountRegistrationReply = null;

        if (accountService.createAccount(account)) {

            accountRegistrationReply = AccountRegistrationReply.builder()
                    .customerID(account.getCustomerID())
                    .name(account.getName())
                    .surname(account.getSurname())
                    .timestamp(new Timestamp(Instant.now().toEpochMilli()))
                    .registrationStatus("Success")
                    .build();

            return new ResponseEntity<>(accountRegistrationReply, HttpStatus.OK);
        } else {
            logger.info("Could not create an account.");
            return new ResponseEntity<>(accountRegistrationReply, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
