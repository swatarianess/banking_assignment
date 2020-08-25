package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.domain.Account;
import com.steve.banking_assignment.domain.AccountRegistrationReply;
import com.steve.banking_assignment.domain.AccountRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Logger;

@RestController
public class AccountRegistrationController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    /**
     * Opens a new account.
    * @param account The details for the new account
     */
    @PostMapping(value = "/account/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountRegistrationReply> registerAccount(@RequestBody Account account) {
        AccountRegistrationReply accountRegistrationReply = new AccountRegistrationReply();

        if(AccountRegistry.getInstance().add(account)) {
            logger.info("Account details: " + account.toString());
            accountRegistrationReply.setCustomerID(account.getCustomerID());
            accountRegistrationReply.setName(account.getName());
            accountRegistrationReply.setSurname(account.getSurname());
            accountRegistrationReply.setTimestamp(new Timestamp(Instant.now().toEpochMilli()));
            accountRegistrationReply.setRegistrationStatus("Success");

            return new ResponseEntity<>(accountRegistrationReply, HttpStatus.OK);
        } else {
            logger.info("Could not create an account.");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
