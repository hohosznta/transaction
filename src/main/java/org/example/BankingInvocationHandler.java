package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BankingInvocationHandler implements InvocationHandler {

    private IBankingService banking; //Proxy.newProxyInstance()는 인터페이스를 기반으로 동작

    public BankingInvocationHandler(IBankingService banking) {
        this.banking = banking;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try{
            Method targetMethod = banking.getClass().getMethod(method.getName(), method.getParameterTypes());

            if (targetMethod.isAnnotationPresent(ValidateTransfer.class)) {
                Account a = (Account) args[0];
                Double amount = (Double) args[2];

                double aBalance = a.getBalance();

                if (amount <= 0 || aBalance - amount < 0) {
                    throw new RuntimeException("출금 금액이 유효하지 않습니다.");
                }
            }
            Object result = method.invoke(banking, args);
            System.out.println("커밋되었습니다.");
            return result;

        }catch (Exception e) {
            System.out.println("에러가 발생하여 롤백합니다.");
            throw e;
        }
    }

    public static IBankingService createProxy(IBankingService target) {
        return (IBankingService) Proxy.newProxyInstance(
                IBankingService.class.getClassLoader(),
                new Class[]{IBankingService.class},
                new BankingInvocationHandler(target)
        );
    }

}
