package com.example17.polymorphism;
/**
 * 超类必然包括Object类
 * super可以访问所有超类的public成员
 * @author Liusy*/
interface A{ }
public class Bird extends Animal implements Flyable {

    A[] a=new A[10];
    private String color;
    public Bird(String name, String color) {
        super(name);
        /**调用父类有参构造函数，不是创造了父类的对象
         * super必须置顶
         * 不存在超类对象*/
        this.color = color;
    }
    //可重写父类的方法
    @Override
    public void fly() {
        System.out.println(getName() + " is flying");
        // 不能直接用name，因为自己这儿没有变量，需要调用父类的方法
        // 运用超类的方法，但方法里的属性还是运用的自己的，如name
        // 若子类/超类无名称冲突，则等效 System.out.println(super.getName() + " is flying");
    }
    @Override
    public void move() {
        System.out.println(getName() + " move so slow");
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public static void barking() {
        System.out.println("Brid barking");
    }

}
