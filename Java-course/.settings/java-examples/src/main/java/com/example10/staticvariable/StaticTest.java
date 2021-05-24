package com.example10.staticvariable;

import com.example07.method.Calculation;
import static java.lang.Math.*;

public class StaticTest {
    public static int num = 10; //全局静态变量num
    public static void main(String[] args) {
        // testStaticVariable();

        Student s = new Student("11", "22"); //不用引用，因为在一个包里
        Calculation a = new Calculation(); //需要引用，因为在不同包里，子包也算不同包

        //类的私有静态变量/常量，类的每一个对象均可访问
        //类的公有静态变量/常量，全局可访问

        double cos = cos(1);
        //如果不加static的话，就要Math.cos(1)

        testStaticBlock();

    }
    //静态变量仅与类相关而与类的具体对象无关
    private static void testStaticBlock() {
        StaticBlock staticBlock = new StaticBlock();
        System.out.println(Bicycle.N); //外部通过类型名称直接调用
    }
    //主函数的静态代码块在加载时就执行了
    static{
        System.out.println("StaticTest static");
    }

    private static void testStaticVariable() {
        Bicycle bicycle = new Bicycle();
        System.out.println(Bicycle.getAmount());
    }
    private static void testStaticStudent() {
        Student student = new Student("BO", Student.MALE);
        Student student1 = new Student("SUN", Student.FEMALE);
        Student student2 = new Student("ZHANG", Student.FEMALE);
    }


}
