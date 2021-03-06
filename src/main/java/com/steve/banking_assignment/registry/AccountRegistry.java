package com.steve.banking_assignment.registry;

import com.steve.banking_assignment.model.Account;
import org.apache.juli.logging.LogFactory;

import java.text.MessageFormat;
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

    public List<Account> getAccountRecords(){
        LogFactory.getFactory().getInstance(this.getClass().getSimpleName()).info(MessageFormat.format("Getting accounts ({0}): {1} ", accounts.size(), accounts));
        return new ArrayList<>(accounts);
    }

}
