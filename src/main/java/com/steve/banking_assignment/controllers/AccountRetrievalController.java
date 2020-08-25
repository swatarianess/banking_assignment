package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.domain.Account;
import com.steve.banking_assignment.domain.AccountRegistry;
import com.steve.banking_assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class AccountRetrievalController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/account/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAllAccounts() {
        logger.info("Retrieving Customer data: " + AccountRegistry.getInstance().getAccountRecords().toString());
        return new ResponseEntity<>(AccountRegistry.getInstance().getAccountRecords(), HttpStatus.OK);
    }

    @GetMapping(value = "/account/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccountFromUserId(@PathVariable long userID) {
        return new ResponseEntity<>(AccountRegistry.getInstance().getAccountRecords().stream().filter(customer -> customer.getCustomerID() == userID).findAny().get(), HttpStatus.OK);
    }

}
