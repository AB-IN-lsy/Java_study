package com.example17.polymorphism.OJ7177;

import java.util.*;
import java.math.*;

abstract class Animai{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animai(String name) {
        this.name = name;
    }

    public abstract void speak();
}

class Mouse extends Animai{
    public Mouse(String name) {
        super(name);
    }
    @Override
    public void speak() {
        System.out.println(String.format("%s的叫声为喵喵",getName()));
    }
}
class Dog extends Animai{
    public Dog(String name) {
        super(name);
    }
    @Override
    public void speak() {
        System.out.println(String.format("%s的叫声为吱吱",getName()));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Animai mouse = new Mouse(cin.next());
        mouse.speak();
        Animai dog = new Dog(cin.next());
        dog.speak();
    }
}

