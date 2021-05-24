package com.example.duoTai;

public class Test {
    public static void main(String[] args) {
        I i = new F();

        F f = (F) i;

        S s = (S) f;
        // 下转型异常
        s.getI();
    }
}
