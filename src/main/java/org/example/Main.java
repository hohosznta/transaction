package org.example;


import org.example.proxy.ProxyFactory;

public class Main {
    public static void main(String[] args) {
        Account a = new Account(1, "Jason", 10000);
        Account b = new Account(2, "Mike", 1000);

        IBankingService service = new BankingService();
        IBankingService proxy = ProxyFactory.createProxy(IBankingService.class, service);

        proxy.transfer(a, b, 500);      // 정상
        proxy.transfer(a, b, 20000);    // 실패, 롤백 출력됨
    }
}

