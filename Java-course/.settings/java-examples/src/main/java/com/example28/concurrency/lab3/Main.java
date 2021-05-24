package com.example28.concurrency.lab3;

class SaleTicket implements Runnable{
    volatile private static int sum = 200;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                sum -= 1;
                System.out.println(Thread.currentThread().getName() + "卖出一张, " + "还剩" + sum + "票");
                if(sum <= 2){
                    /**
                     * 为了避免负数，则小于2就跳出是最佳的
                     * 小于0会有负数情况产生
                     */
                    System.out.println("票卖完了");
                    break;
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        new Thread(saleTicket, "哈站").start();
        new Thread(saleTicket, "哈东站").start();
        new Thread(saleTicket, "哈西站").start();
    }

}
