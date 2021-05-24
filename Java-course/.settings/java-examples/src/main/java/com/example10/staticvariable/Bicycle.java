package com.example10.staticvariable;

public class Bicycle {
    private int gear;
    public static final int N = 110; //在类中声明了公有常量,外部通过类型名称直接调用
    private static int amount = 0; //私有静态变量，类的每个对象均可访问，与类有关，与对象无关,私有静态变量依然禁止对外直接暴露数据

    // private static Bicycle bicycle = getBicyle(); 静态变量只会创建一次
    public Bicycle() { //构造函数，每次创建个对象时，amount都++
        amount++;
        System.out.println("Bicycle()");
    }

    public static int getAmount() {
        return amount;
    }
    /*
    public static int getAmount() {
        getGear(); //无法调用实例级的
    }
    */


    public int getGear() {
        getAmount();
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}
