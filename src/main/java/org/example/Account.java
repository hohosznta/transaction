package org.example;

public class Account {
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
            this.balance += amount;
    }

    public void withdrawal(double amount){
        this.balance -= amount;
    }
}
