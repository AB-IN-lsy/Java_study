package com.example.abTest;

public class B extends A{

    private A a;

    public B() {

        System.out.println("3");

    }

    public B(String name) {

        System.out.println("4");

        a = new A("5");

    }

}
