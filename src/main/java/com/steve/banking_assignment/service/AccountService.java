package com.steve.banking_assignment.service;

import com.steve.banking_assignment.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<Account> findAccountByID(long customerID);
    List<Account> findAllAccounts();
}
