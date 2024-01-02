package com.university.lab_5;


public class BankAccount {
    private final int accountNumber;
    private final String accountName;

    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeAmountException{
        if (amount < 0){
                throw new NegativeAmountException("Unable to deposit amount that < 0 to a balance!");
        }
        else {
            this.balance += amount;
            System.out.println("Amount was deposited to account!");

        }
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException{
        if (amount > balance){
                throw new InsufficientFundsException("You don't have enough balance to make a transaction");
        }
        if (amount < 0){
            throw new NegativeAmountException("Unable to withdraw amount that < 0 from a balance!");
        }
        else {
            this.balance -= amount;
            System.out.println("Amount was withdrawn from account!");
        }

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }







    public String getAccountSummary(){
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
