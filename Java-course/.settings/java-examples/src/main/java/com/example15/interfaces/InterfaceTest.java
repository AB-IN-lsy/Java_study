package com.example15.interfaces;

public class InterfaceTest {

    public static void main(String[] args) {
        getAble();
        System.out.println("-------interface imp --------");
        getUniversityClub();
    }

    private static void getAble() {
        //可以创建出接口的对象，但类型应为可以实现接口的类
        //面向接口编程
        //我们不能直接去实例化一个接口，因为接口中的方法都是抽象的，是没有方法体的，这样怎么可能产生具体的实例呢？
        //但是，我们可以使用接口类型的引用指向一个实现了该接口的对象，并且可以调用这个接口中的方法。
        Learnable under = new Undergraduate("BO");
        under.test("Java");
        Learnable post = new Postgraduate("ZHANG");
        post.test("Java");

    }

    private static void getUniversityClub() {
        // Undergraduate实现了Learnable接口，表示其具有相应能力
        // 创建一个具有Learnable"能力"的本科生
        Learnable under = new Undergraduate("BO");
        UniversityClub club = new UniversityClub("读书会");
        club.setLearnable(under); //赋予club对象Learnable能力的本科生
        club.getLearnable().read("C++"); //让这个人使用读书的能力，读C++
        club.getLearnable().study(); //不用重写，可直接调用

        Learnable post = new Postgraduate("SUN");
        club.setLearnable(post); //替换了，新的对象为具有Learnable能力的毕业生
        club.getLearnable().read("C++");
    }

}
