package com.steve.banking_assignment.service.impl;

import com.steve.banking_assignment.beans.Account;
import com.steve.banking_assignment.service.AccountService;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Override
    public Optional<Account> findAccountByID(long customerID) {
        return Optional.empty();
    }

}
