package com.university.lab_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestAccountNotFoundException
{
    Bank bank;
    BankAccount bankAccount;

    @Test
    void searchNotExisingAccount(){
        bank = new Bank();
       bankAccount = bank.createAccount("Acc1",1000);
        Assertions.assertThrows(AccountNotFoundException.class, () ->bank.findAccount(96438841));

    }

    @Test
    void sendMoneyToNotExistingAccount(){
        bank = new Bank();
        bankAccount = bank.createAccount("Acc1",1000);
        Assertions.assertThrows(AccountNotFoundException.class, () ->bank.transferMoney(bankAccount.getAccountNumber(), 83832252, 100));
    }

    @Test
    void sendMoneyFromNotExistingAccount(){
        bank = new Bank();
        bankAccount = bank.createAccount("Acc1",1000);
        Assertions.assertThrows(AccountNotFoundException.class, () ->bank.transferMoney(83832252, bankAccount.getAccountNumber(), 100));
    }


}
