package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.beans.Customer;
import com.steve.banking_assignment.beans.CustomerRegistry;
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
public class CustomerRetrieveController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @RequestMapping(method = RequestMethod.GET, value = "/customer/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers(){
        logger.info("Retrieving Customer data: " + CustomerRegistry.getInstance().getCustomerRecords().toString());
        return new ResponseEntity<>(CustomerRegistry.getInstance().getCustomerRecords(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getTransactionsFromUser(@PathVariable long userID){
        return new ResponseEntity<>(CustomerRegistry.getInstance().getCustomerRecords().stream().filter(customer -> customer.getId() == userID).findFirst().get(), HttpStatus.OK);
    }



}
