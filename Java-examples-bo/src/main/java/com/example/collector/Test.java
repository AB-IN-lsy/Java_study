package com.example.collector;

/**
 * @author Liusy
 */
public class Test {
    public static void main(String[] args) {
        Consumer me = new Consumer("Myles", 99);
        Goods noodles = new Goods("noodles", 5.5f);
        Goods ham = new Goods("ham", 2.2f);
        Order order = new Order(me, new Goods[]{noodles, noodles, ham, ham, ham, ham});
        float balanceOver = calculateBalance(order);
        System.out.println(balanceOver);
    }

    public static float calculateBalance(Order order){
        float balance1 = order.getConsumer().getBalance();
        for(Goods i : order.getGoods()){
            balance1 -= i.getPrice();
        }
        order.getConsumer().setBalance(balance1);
        return balance1;
    }
}
