package com.example28.concurrency.lab1;

class Saipao implements Runnable{
    private int distance = 100;
    private int wgPosition = 0;
    private int tzPosition = 0;
    @Override
    public void run() {
        while(true) {
            if(Thread.currentThread().getName().equals("tortoise")){
                /**
                 * 获取的是当前正在执行的线程的名字
                 */
                wgPosition += 1;
                if(wgPosition >= distance){
                    System.out.println("乌龟到终点了");
                    break;
                }
                else{
                    System.out.println("乌龟距离终点还差" + (distance - wgPosition) + "米");
                }
            }
            else{
                tzPosition += 10;
                if(tzPosition >= distance){
                    System.out.println("兔子到终点了");
                    break;
                }
                else{
                    System.out.println("兔子距离终点还差" + (distance - tzPosition) + "米");
                }
                if(tzPosition > wgPosition){
                    try {
                        System.out.println("我跑得快，睡一觉");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Saipao saipao = new Saipao();
        Thread tz = new Thread(saipao, "rabbit");
        Thread wg = new Thread(saipao, "tortoise");
        /**
         * 两个线程封装的是同一个对象(即任务)，所以使用的是统一的值
         */
        tz.start();
        wg.start();
        /**
         * 线程并发过程中，由于调度算法不同，则结果的可能性顺序不同，可能兔子先跑完，可能乌龟先跑完
         */
    }
}
