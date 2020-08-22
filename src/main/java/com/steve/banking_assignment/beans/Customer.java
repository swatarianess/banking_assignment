package com.steve.banking_assignment.beans;

import org.springframework.stereotype.Component;

@Component
public class Customer {

    String id;
    String name;
    int balance;

    public Customer() {
    }

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
