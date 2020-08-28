package com.steve.banking_assignment.service.impl;

import com.steve.banking_assignment.exception.AccountAlreadyAllocatedToCustomerException;
import com.steve.banking_assignment.exception.AccountAlreadyExistsException;
import com.steve.banking_assignment.exception.AccountCreationException;
import com.steve.banking_assignment.exception.AccountNotFoundException;
import com.steve.banking_assignment.model.Account;
import com.steve.banking_assignment.model.Transaction;
import com.steve.banking_assignment.registry.AccountRegistry;
import com.steve.banking_assignment.service.AccountService;
import com.steve.banking_assignment.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
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
        Transaction transaction = new Transaction(-1, account.getCustomerID(), account.getBalance());

        if (registry.getAccountRecords().stream().anyMatch(acc -> acc.getCustomerID() == account.getCustomerID()))
            throw new AccountAlreadyAllocatedToCustomerException();

        if (registry.getAccountRecords().contains(account))
            throw new AccountAlreadyExistsException();

        if (transactionService.createTransaction(transaction)) {
            if (account.getTransactionList().add(transaction)) {
                logger.debug("Successfully created transaction and added to account.");
                return registry.add(account);
            } else {
                logger.error("Could not create transaction and add it to an account");
                throw new AccountCreationException();
            }
        } else {
            logger.error("Could not add account to Registry");
            throw new AccountCreationException();
        }

    }

    /**
     * Retrieves transactions sent/received by an account.
     *
     * @param customerID The customerID of the account
     * @return Returns the {@link Account} matching the customerID
     */
    @Override
    @ExceptionHandler(AccountNotFoundException.class)
    public Account findAccountByID(long customerID) {
        return registry.getAccountRecords()
                .stream()
                .filter(account -> account.getCustomerID() == customerID)
                .findFirst().orElseThrow(AccountNotFoundException::new);
    }

    /**
     * Retrieves a list of accounts currently in the registry
     *
     * @return Returns a list of all accounts
     */
    @Override
    public List<Account> findAllAccounts() {
        return registry.getAccountRecords();
    }


}
