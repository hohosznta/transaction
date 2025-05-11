package org.example.handlers;

import org.example.Account;

import java.lang.reflect.Method;


public class ValidateTransferHandler implements AnnotationHandler {

    @Override
    public void before(Method method, Object[] args, Object target) {
        Account from = (Account) args[0];
        double amount = (Double) args[2];

        if (amount <= 0) {
            throw new RuntimeException("이체 금액은 0보다 커야 합니다.");
        }

        if (from.getBalance() < amount) {
            throw new RuntimeException("잔액 부족: 이체 불가");
        }

        System.out.println("유효성 검사 통과");
    }
}

