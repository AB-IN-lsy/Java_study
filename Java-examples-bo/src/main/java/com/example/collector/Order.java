package com.example.collector;

public class Order {
    private Consumer consumer;
    private Goods[] goods;

    public Order(Consumer consumer, Goods[] goods){
        this.consumer = consumer;
        this.goods = goods;
    }
    public Consumer getConsumer(){
        return consumer;
    }
    public Goods[] getGoods(){
        return goods;
    }
    public void setConsumer(Consumer consumer){
        this.consumer = consumer;
    }
    public void setGoods(Goods[] goods){
        this.goods = goods;
    }
}
