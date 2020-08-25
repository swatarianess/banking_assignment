package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.beans.Account;
import com.steve.banking_assignment.beans.AccountRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class AccountRetrievalController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @RequestMapping(method = RequestMethod.GET, value = "/account/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAllCustomers(){
        logger.info("Retrieving Customer data: " + AccountRegistry.getInstance().getAccountRecords().toString());
        return new ResponseEntity<>(AccountRegistry.getInstance().getAccountRecords(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/account/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getTransactionsFromUser(@PathVariable long userID){
        return new ResponseEntity<>(AccountRegistry.getInstance().getAccountRecords().stream().filter(customer -> customer.getCustomerID() == userID).findAny().get(), HttpStatus.OK);
    }



}
