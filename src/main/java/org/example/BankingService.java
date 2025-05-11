package org.example;


import org.example.annotations.Transactional;
import org.example.annotations.ValidateTransfer;

public class BankingService implements IBankingService {

    @Override
    @Transactional
    @ValidateTransfer
    public void transfer(Account a, Account b, double amount){
        a.withdrawal(amount);
        b.deposit(amount);
    }

}
