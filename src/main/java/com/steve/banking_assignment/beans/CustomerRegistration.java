package com.steve.banking_assignment.beans;

import java.util.ArrayList;
import java.util.List;

public class CustomerRegistration {

    private List<Customer> customers;
    private static CustomerRegistration customerRegistration = null;

    private CustomerRegistration() {
        customers = new ArrayList<>();
    }

    public static CustomerRegistration getInstance() {
        if (customerRegistration == null) return customerRegistration;
        return new CustomerRegistration();
    }

    public void add(Customer customer){
        customers.add(customer);
    }

    public boolean deleteCustomer(String customerID){
        return customers.removeIf(customer -> customer.id.equals(customerID));
    }

    public List<Customer> getCustomerRecords(){
        return customers;
    }

}
