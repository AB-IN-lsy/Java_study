package com.example15.interfaces;

public interface Learnable {
    /**Java接口支持
     公有/私有常量
     抽象方法
     默认方法
     公有/私有静态方法
     公有/私有方法
     */
    int STUDY_TIME = 8; // 常量，前面本来就有public static final
    void read(String bookName); // 前面为public abstract，抽象方法
    int test(String courseName);
    default void study(){
        System.out.println("study");
    }
    //声明方法的具体实现
}
