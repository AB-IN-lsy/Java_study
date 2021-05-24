package com.example.collector;

public class Goods {
    private String name;
    private float price;
    public Goods() {
    }
    public Goods(String name, float price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public void setName(String name){this.name = name;}
    public void setPrice(float price){this.price = price;}
}
