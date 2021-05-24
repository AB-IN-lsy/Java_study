package com.example17.polymorphism.OJ7174;
import java.util.*;
import java.math.*;


public class Main {
    public static class Vehicle{
        private int circles;
        private float weight;

        public Vehicle(int circles, float weight) {
            this.circles = circles;
            this.weight = weight;
        }

        public int getCircles() {
            return circles;
        }

        public void setCircles(int circles) {
            this.circles = circles;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }
        public void show(){
            System.out.println("汽车:\n" + "轮子数:" + circles + "个\n" + "自身重量:" + weight + "吨");
        }
    }
    public static class Car extends Vehicle{
        private int number;

        public Car(int circles, float weight, int number) {
            super(circles, weight);
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public void show(){
            System.out.println("小轿车:\n" + "轮子数:" + getCircles() + "个\n" + "自身重量:" + getWeight() + "吨\n" + "额定乘客数:" + getNumber() + "人");
        }
    }
    public static class Truck extends Vehicle{
        private int number;
        private float numWeight;

        public Truck(int circles, float weight, int number, float numWeight) {
            super(circles, weight);
            this.number = number;
            this.numWeight = numWeight;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public float getNumWeight() {
            return numWeight;
        }

        public void setNumWeight(float numWeight) {
            this.numWeight = numWeight;
        }
        @Override
        public void show(){
            System.out.println("卡车:\n" + "轮子数:" + getCircles() + "个\n" + "自身重量:" + getWeight() + "吨\n" + "额定乘客数" + getNumber() + "人\n" + "载重量" + getNumWeight() + "吨");
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int circle = cin.nextInt();
        float weight = cin.nextFloat();
        Vehicle vehicle = new Vehicle(circle, weight);
        vehicle.show();

        circle = cin.nextInt();
        weight = cin.nextFloat();
        int num = cin.nextInt();
        Car car = new Car(circle, weight, num);
        car.show();;

        circle = cin.nextInt();
        weight = cin.nextFloat();
        num = cin.nextInt();
        float numWeight = cin.nextFloat();
        Truck truck = new Truck(circle, weight, num, numWeight);
        truck.show();
    }
}


