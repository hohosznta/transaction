package org.example;


public class BankingService implements IBankingService {

    @Override
    @ValidateTransfer
    public void transfer(Account a, Account b, double amount){
        a.withdrawal(amount);
        b.deposit(amount);
    }

}
