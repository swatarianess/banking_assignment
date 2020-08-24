package com.steve.banking_assignment.service;

import com.steve.banking_assignment.beans.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findCustomerByID(long customerID);

}
