package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.beans.Customer;
import com.steve.banking_assignment.beans.CustomerRegistrationReply;
import com.steve.banking_assignment.beans.CustomerRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Logger;

@Controller
public class CustomerRegistrationController {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    @RequestMapping(method = RequestMethod.POST, value = "/customer/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CustomerRegistrationReply> registerCustomer(@RequestBody Customer customer) {
        CustomerRegistrationReply customerRegistrationReply = new CustomerRegistrationReply();

        if(CustomerRegistry.getInstance().add(customer)) {

            logger.info("Customer details: " + customer.toString());
            customerRegistrationReply.setName(customer.getName());
            customerRegistrationReply.setCustomerID(customer.getId());
            customerRegistrationReply.setSurname(customer.getSurname());
            customerRegistrationReply.setTimestamp(new Timestamp(Instant.now().toEpochMilli()));
            customerRegistrationReply.setRegistrationStatus("Success");

            return new ResponseEntity<>(customerRegistrationReply, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
