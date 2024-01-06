package com.university.lab_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNegativeAmountException {

    Bank bank;
    BankAccount bankAccount1;
    BankAccount bankAccount2;


    @Test
    void NegativeDepositAmountTest() throws NegativeAmountException {
        bank = new Bank();
        bankAccount1 = bank.createAccount("Acc1",1000);
        Assertions.assertThrows(NegativeAmountException.class, () ->bankAccount1.deposit(-100));
    }

    @Test
    void NegativeAmountWithdrawTest() throws NegativeAmountException {
        bank = new Bank();
        bankAccount1 = bank.createAccount("Acc1",1000);
        Assertions.assertThrows(NegativeAmountException.class, () -> bankAccount1.withdraw(-100));
    }

    @Test
    void NegativeAmountDepositTest() throws NegativeAmountException {
        bank = new Bank();
        bankAccount1 = bank.createAccount("Acc1",1000);
        Assertions.assertThrows(NegativeAmountException.class, () -> bankAccount1.deposit(-100));
    }

    @Test
    void NegativeAmountTransferTest() throws NegativeAmountException {
        bank = new Bank();
        bankAccount1 = bank.createAccount("Acc1",1000);
        bankAccount2 = bank.createAccount("Acc2",1000);
        Assertions.assertThrows(NegativeAmountException.class, () ->  bank.transferMoney(bankAccount1.getAccountNumber(), bankAccount2.getAccountNumber(), -100));
    }

}
