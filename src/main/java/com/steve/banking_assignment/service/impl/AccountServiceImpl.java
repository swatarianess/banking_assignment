package com.steve.banking_assignment.service.impl;

import com.steve.banking_assignment.domain.Account;
import com.steve.banking_assignment.domain.AccountRegistry;
import com.steve.banking_assignment.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRegistry registry = AccountRegistry.getInstance();

    @Override
    public Optional<Account> findAccountByID(long customerID) {
        return registry.getAccountRecords()
                .stream()
                .filter(account -> account.getCustomerID() == customerID)
                .findFirst();
    }

    @Override
    public List<Account> findAllAccounts() {
        return registry.getAccountRecords();
    }


}
