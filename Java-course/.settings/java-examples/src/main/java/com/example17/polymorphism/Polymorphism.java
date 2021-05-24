package com.example17.polymorphism;

// 多态、封装、继承
public class Polymorphism {

    public static void main(String[] args) {
        System.out.println("-------Inheritance --------");
        //getBrid();
        System.out.println("-------Overrde Inheritance --------");
        //getOverrde();
        System.out.println("-------instanceof --------");
        //getinstanceof();
        System.out.println("-------Casting Objects--------");
        getCastingObjects();
        System.out.println("-------Polymorphism--------");
        //getPolymorphism();
        System.out.println("-------Polymorphism by interface--------");
        //getPolymorphismByInterface();
        System.out.println("-------Polymorphism final--------");
        //getPolymorphism2();
        System.out.println("-------Hiding Static Methods--------");
        //getHidingStaticMethod();

    }

    private static void getBrid() {
        Bird bird = new Bird("Raven", "black");
        bird.move();
        bird.fly();
        System.out.println(bird.getName() + "/" +bird.getColor());

    }

    private static void getOverrde() {
        Bird bird = new Bird("Raven", "black");
        bird.move();
        Animal animal = new Animal("Lion");
        animal.move();
    }

    private static void getinstanceof() {
        Bird bird = new Bird("Raven", "black");
        System.out.println(bird instanceof Bird);
        System.out.println(bird instanceof Animal);
        System.out.println(bird instanceof Object);
        //均true,实际类型都是bird

    }

    private static void getCastingObjects() {
        Bird bird = new Bird("Raven", "black");
        System.out.println(bird.getClass().getName());
        //上转型
        Animal animal = bird;
        ((Bird) animal).fly();
        System.out.println(animal.getClass().getName()); //com.example17.polymorphism.Bird
        Object obj = bird; //实际类型还是bird
        System.out.println(obj.getClass().getName());

        Animal animal2 = new Animal("Lion");
        System.out.println(animal2.getClass().getName());
        //下转型，超类未必一定是子类，因此需显式声明强制转换，且只有运行时才能知道错误
        Bird bird2 = (Bird) animal2; //强制转换，但animal2不是bird类型，会异常
        //Bird bird2 = (Bird) obj; 强制转换，不会异常
    }

    private static void getPolymorphism() {
        Animal animal = new Animal("Lion");
        animal.move();
        Bird bird = new Bird("Raven", "black");
        bird.move();
        Animal animal2 = bird;
        animal2.move(); //bird的move实现，等号左侧只能决定对象能干什么，右侧才是真正实现
        //animal2.fly(); 实际属性为鸟，但左侧类型是动物，只能表现出动物的特性，所以无fly()
    }

    private static void getPolymorphismByInterface() {
        Movable animal = new Animal("Lion");
        System.out.println(animal.getClass().getName()); //接口类型变量实际类型为引用对象类型,打出来是animal
        Flyable bird = new Bird("Raven", "black");
        bird.fly();
    }
    private static void getPolymorphism2() {
        Bird bird = new Bird("Raven", "black");
        System.out.println(bird.getClass().getName());
        bird.fly();bird.move();
        System.out.println(bird.getColor());
        // 仅能表现Animal行为
        Animal animal = bird;
        animal.move();
        System.out.println(animal.getName());
        // 仅能表现Movable能力
        Movable mBird = bird;
        mBird.move();
        // 仅能表现Flyable能力
        Flyable fBird = bird;
        fBird.fly();
        // 但只生成了一个对象
    }

    private static void getHidingStaticMethod() {
        Animal.barking();
        Bird.barking();
    }

}
