package com.university.lab_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private final Random random = new Random();
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException{
        if (initialDeposit < 0) {
                throw new NegativeAmountException("Can't create an account with a initial deposit < 0");
        }
        else {
            BankAccount account = new BankAccount(random.nextInt(10000000, 100000000), accountName, initialDeposit);
            accounts.add(account);
            return account;
        }


    }
    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException{
            BankAccount accountToFind = accounts.stream()
                    .filter(account -> account.getAccountNumber() == accountNumber)
                    .findFirst()
                    .orElseThrow(() -> new AccountNotFoundException("There is no account with this number ->" + accountNumber));

            System.out.println(accountToFind.getAccountSummary());
            return accountToFind;
        }
    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        BankAccount sender = findAccount(fromAccountNumber);
        BankAccount receiver = findAccount(toAccountNumber);
        sender.withdraw(amount);
        receiver.deposit(amount);

    }

}
