package com.example18.anonymousclasses;

public class AnonymousTest {
    public static void main(String[] args) {
        getAnonymous();
    }
    private static void getAnonymous() {
        Student s1 = new Student("BO");
        /**
         * 匿名内部类
         * 其实相当于创造了抽象函数的子类
         * 从set接口处改写接口
         * */
        s1.setLearnable(new Learnable() {
            @Override
            public void read() {
                System.out.println("我要按自己的方式阅读");
            }
        });
        System.out.println(s1.getLearnable());
        s1.getLearnable().read();

        Student s2 = new Student("SUN");
        s2.setLearnable(new Learnable() {
            @Override
            public void read() {
                int number = 10;
                System.out.println("我要读" + number + "本书");
            }
        });
        System.out.println(s2.getLearnable());
        s2.getLearnable().read();
    }
}
