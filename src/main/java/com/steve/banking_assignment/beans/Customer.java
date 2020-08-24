package com.steve.banking_assignment.beans;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private static Long id = 0L;
    private Long customerID = 0L;
    private String name = "";
    private String surname = "";
    private int balance = 0;
    private List<Transaction> transactionList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String surname) {
        id += 1;
        this.customerID = id;
        this.name = name;
        this.surname = surname;
        this.balance = 0;
        this.transactionList.add(new Transaction( -1, customerID, 0, Timestamp.from(Instant.now())));
    }

    public Customer(String name, int balance) {
        id += 1;
        this.customerID = id;
        this.name = name;
        this.surname = "";
        this.balance = balance;
        this.transactionList.add(new Transaction( -1, customerID, balance, Timestamp.from(Instant.now())));
    }

    public Customer(String name, String surname, int balance) {
        id += 1;
        this.customerID = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.transactionList.add(new Transaction( -1, customerID, balance, Timestamp.from(Instant.now())));
    }

    public long getId() {
        return customerID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return this.customerID.equals(customer.customerID);
    }

    @Override
    public int hashCode() {
        return customerID.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", transactionList#Size='" + transactionList.size() + '\'' +
                ", balance=" + balance +
                '}';
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
