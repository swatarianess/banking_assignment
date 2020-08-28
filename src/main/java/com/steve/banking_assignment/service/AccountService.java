package com.steve.banking_assignment.service;

import com.steve.banking_assignment.model.Account;

import java.util.List;

public interface AccountService {

    Account findAccountByID(long customerID);
    List<Account> findAllAccounts();
    boolean createAccount(Account account);
}
