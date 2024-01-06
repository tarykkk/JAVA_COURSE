package com.university.lab_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInsufficientFundsException {
    Bank bank;
    BankAccount bankAccount1;
    BankAccount bankAccount2;



    @Test
    void InsufficientFundsTransfer() throws NegativeAmountException {
        this.bank = new Bank();
        this.bankAccount1 = this.bank.createAccount (  "Test1",  1000);
        this.bankAccount2 = this.bank.createAccount(  "Test2", 1000);
        Assertions.assertThrows (InsufficientFundsException.class, 
        ()-> this.bank.transferMoney(this.bankAccount1.getAccountNumber(), this.bankAccount2.getAccountNumber(),1000000000));
    }
    @Test
    void InsufficientFundsWithdraw() throws NegativeAmountException {
        this.bank = new Bank();
        this.bankAccount1 = this.bank.createAccount (  "Test1",  1000);
        Assertions.assertThrows(InsufficientFundsException.class, () ->bankAccount1.withdraw(1100));
    }



}
