package com.steve.banking_assignment.registry;

import com.steve.banking_assignment.model.Account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountRegistry {

    private final Set<Account> accounts = new HashSet<>();
    private static AccountRegistry accountRegistry;

    private AccountRegistry() {
        accountRegistry = this;
    }

    public static AccountRegistry getInstance() {
        if (accountRegistry == null) return new AccountRegistry();
        return accountRegistry;
    }

    public boolean add(Account account){
        return accounts.add(account);
    }

    public boolean deleteAccount(long customerID){
        return accounts.removeIf(account -> account.getCustomerID() == customerID);
    }

    public List<Account> getAccountRecords(){
        return new ArrayList<>(accounts);
    }

}
