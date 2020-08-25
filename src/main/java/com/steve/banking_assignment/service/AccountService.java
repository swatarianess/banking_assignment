package com.steve.banking_assignment.service;

import com.steve.banking_assignment.beans.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findAccountByID(long customerID);

}
