package com.steve.banking_assignment.model;


import java.util.ArrayList;
import java.util.List;

public class Account {

    private Long customerID = 0L;
    private String name = "";
    private String surname = "";
    private int balance = 0;
    private List<Transaction> transactionList = new ArrayList<>();

    public Account() {
    }

    public Account(long customerID, int balance) {
        this.customerID = customerID;
        this.name = "";
        this.surname = "";
        this.balance = balance;
    }

    public Account(long customerID, String name, String surname) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.balance = 0;
    }

    public Account(long customerID, String name, int balance) {
        this.customerID = customerID;
        this.name = name;
        this.surname = "";
        this.balance = balance;
    }

    public Account(long customerID, String name, String surname, int balance) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
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
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return this.customerID.equals(account.customerID);
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
