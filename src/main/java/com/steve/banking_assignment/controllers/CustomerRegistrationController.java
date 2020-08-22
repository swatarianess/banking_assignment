package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.beans.Customer;
import com.steve.banking_assignment.beans.CustomerRegistration;
import com.steve.banking_assignment.beans.CustomerRegistrationReply;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class CustomerRegistrationController {

    @RequestMapping(method = RequestMethod.POST, value = "/register/customer")


    @ResponseBody
    public CustomerRegistrationReply registerCustomer(@RequestBody Customer customer){

        CustomerRegistrationReply customerRegistrationReply = new CustomerRegistrationReply();
        CustomerRegistration.getInstance().add(customer);

        customerRegistrationReply.

    }

}
