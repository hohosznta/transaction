package org.example;


public class Client {
    public static void main(String[] args) {
        Account a  = new Account(1, "Jason", 10000);
        Account b  = new Account(2, "Mike", 3000);

        IBankingService banking = new BankingService();  // Banking은 IBanking 구현체여야 함
        IBankingService proxy = BankingInvocationHandler.createProxy(banking);

        proxy.transfer(a,b, 900);
        proxy.transfer(a,b, 90000);
    }
}
