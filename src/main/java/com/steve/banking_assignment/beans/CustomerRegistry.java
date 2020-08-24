package com.steve.banking_assignment.beans;

import java.util.ArrayList;
import java.util.List;

public class CustomerRegistry {

    private final ArrayList<Customer> customers = new ArrayList<>();
    private static CustomerRegistry customerRegistry = null;

    private CustomerRegistry() {
        customerRegistry = this;
    }

    public static CustomerRegistry getInstance() {
        if (customerRegistry == null) return new CustomerRegistry();
        return customerRegistry;
    }

    public boolean add(Customer customer){
        if (!customers.contains(customer)) {
            return this.customers.add(customer);
        }
        return false;
    }

    public boolean deleteCustomer(long customerID){
        return customers.removeIf(customer -> customer.getId() == customerID);
    }

    public List<Customer> getCustomerRecords(){
        return customers;
    }

}
