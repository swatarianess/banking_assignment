package com.steve.banking_assignment.service.impl;

import com.steve.banking_assignment.beans.Customer;
import com.steve.banking_assignment.service.CustomerService;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Optional<Customer> findCustomerByID(long customerID) {
        return Optional.empty();
    }

}
