package com.example17.polymorphism;

//public final class 无法重写
public class Animal implements Movable {

    private String name;
    public Animal(String name) {
        this.name = name;
    }
    @Override
    public void move() {
        System.out.println(name + " is moving");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void barking() {
        System.out.println("Animal barking");
    }

}
