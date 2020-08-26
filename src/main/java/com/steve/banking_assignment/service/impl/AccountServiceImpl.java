package com.steve.banking_assignment.service.impl;

import com.steve.banking_assignment.model.Account;
import com.steve.banking_assignment.model.Transaction;
import com.steve.banking_assignment.registry.AccountRegistry;
import com.steve.banking_assignment.service.AccountService;
import com.steve.banking_assignment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRegistry registry = AccountRegistry.getInstance();

    @Autowired
    TransactionService transactionService;

    /**
     * Adds a new account to the {@link AccountRegistry}
     *
     * @param account The account to be added to the register
     * @return Returns true if the transaction was added to the register successfully, false otherwise.
     */
    @Override
    public boolean createAccount(Account account) {
        Transaction transaction = new Transaction(-1,account.getCustomerID(), account.getBalance());


        if (transactionService.createTransaction(transaction)) {
            account.getTransactionList().add(transaction);
            return registry.add(account);
        } else {
            return false;
        }

    }

    /**
     * Retrieves transactions sent/received by an account.
     *
     * @param customerID The customerID of the account
     * @return Returns the {@link Account} matching the customerID
     */
    @Override
    public Optional<Account> findAccountByID(long customerID) {
        return registry.getAccountRecords()
                .stream()
                .filter(account -> account.getCustomerID() == customerID)
                .findFirst();
    }

    /**
     * Retrieves a list of accounts currently in the registry
     * @return Returns a list of all accounts
     */
    @Override
    public List<Account> findAllAccounts() {
        return registry.getAccountRecords();
    }




}
