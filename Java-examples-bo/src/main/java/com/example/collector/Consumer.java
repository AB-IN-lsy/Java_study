package com.example.collector;

public class Consumer {
    private String name;
    private float balance;
    public Consumer() {
    }
    public Consumer(String name, float balance){
        this.name = name;
        this.balance = balance;
    }
    public String getName(){
        return name;
    }
    public float getBalance(){
        return balance;
    }
    public void setName(String name){this.name = name;}
    public void setBalance(float balance){this.balance = balance;}
}
