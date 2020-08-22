package com.steve.banking_assignment.controllers;

import com.steve.banking_assignment.beans.Customer;
import com.steve.banking_assignment.beans.CustomerRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerRetrieveController {

    @RequestMapping(method = RequestMethod.GET, value = "/customer/allCustomers")

    @RequestBody
    public List<Customer> getAllCustomers(){
        return CustomerRegistration.getInstance().getCustomerRecords();
    }

}
