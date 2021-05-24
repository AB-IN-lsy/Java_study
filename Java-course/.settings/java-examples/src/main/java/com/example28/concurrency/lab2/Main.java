package com.example28.concurrency.lab2;

import java.util.HashSet;
import java.util.Set;

class GuoQiao implements Runnable{

    @Override
    synchronized public void run() {
        System.out.println(Thread.currentThread().getName() + "正在过桥");
        /**
         * 停顿5s，停顿时可能出现异常，故用try catch捕获
         */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "过完桥了");
    }
}



public class Main {
    public static void main(String[] args) {
        String[] name = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        Set<Integer> set = new HashSet<>();
        /**
         * 生成 0~9 随机序列，采用set容器
         * Math.random() 生成 0~1的double类型的随机数
         */
        while(set.size() < 10){
            set.add((int) (Math.random() * 10) );
        }
        GuoQiao guoQiao = new GuoQiao();
        for(int i : set){
            new Thread(guoQiao, name[i]).start();
        }
    }
}
