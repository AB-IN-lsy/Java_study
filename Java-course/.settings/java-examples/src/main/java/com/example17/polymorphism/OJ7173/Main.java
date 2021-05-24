package com.example17.polymorphism.OJ7173;
import java.util.*;
import java.math.*;


public class Main {
    public static class Dog{
        private String name;
        private int weight;
        private String color;

        public Dog(String name, int weight, String color) {
            this.name = name;
            this.weight = weight;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
        public void show(){
            System.out.println("这是一只" + name + "体重为" + weight + ",颜色为" + color);
        }
    }

    public static class UnspottedDog extends Dog{
        public UnspottedDog(String name, int weight, String color) {
            super(name, weight, color);
        }
        @Override
        public void show(){
            System.out.println("这是一只" + getName() + "犬");
        }
    }
    public static class SpottedDog extends Dog{
        private String spotColor;
        public SpottedDog(String name, int weight, String color, String spotColor) {
            super(name, weight, color);
            this.spotColor = spotColor;
        }

        public String getSpotColor() {
            return spotColor;
        }

        public void setSpotColor(String spotColor) {
            this.spotColor = spotColor;
        }
        @Override
        public void show(){
            System.out.println("这是一只" + getName() + "体重为" + getWeight() + ",颜色为" + getColor());
            System.out.println("这是一只" + getName() + ",颜色为" + getColor() + ",斑点颜色为" + getSpotColor());
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String name = cin.next();
        int weight = cin.nextInt();
        String color = cin.next();
        String spotColor = cin.next();

        SpottedDog spottedDog = new SpottedDog(name, weight, color, spotColor);
        spottedDog.show();

        name = cin.next();
        weight = cin.nextInt();
        color = cin.next();
        UnspottedDog unspottedDog = new UnspottedDog(name, weight, color);
        unspottedDog.show();
    }
}

