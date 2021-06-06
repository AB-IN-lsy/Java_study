package com;

public class A {
    String a = "a";
    private String privateA = "privateA";
    protected String protectedA = "protectedA";
    public String publicA = "publicA";

    public static void main(String[] args){
        A a = new A();
        a.test();
    }

    public void test(){
        B b = new B();
        b.accessA();
    }

    public class B{
        public void accessA(){
            System.out.println(a);
            System.out.println(privateA);
            System.out.println(protectedA);
            System.out.println(publicA);
        }
    }
}
