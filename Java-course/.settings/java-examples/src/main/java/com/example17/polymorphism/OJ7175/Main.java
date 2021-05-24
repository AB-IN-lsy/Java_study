package com.example17.polymorphism.OJ7175;
import java.util.*;
import java.math.*;


public class Main {
    public static abstract class Employer{
        private String name;
        private String department;
        private float salary;
        public Employer(String name, String department, float salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }

        void showSalary(){}
        void showBonus(){}
    }
    public static class BasicEmployee extends Employer{
        public BasicEmployee(String name, String department, float salary) {
            super(name, department, salary);
        }
        @Override
        public void showSalary(){
            System.out.println(String.format("我叫%s,在%s部门，我的工资是%.1f", getName(), getDepartment(), getSalary()));
        }
        @Override
        public void showBonus(){
            System.out.println("我是普通员工，没有奖金，加油升级！");
        }
    }
    public static class GoodEmployee extends Employer{
        private float bonus;

        public GoodEmployee(String name, String department, float salary, float bonus) {
            super(name, department, salary);
            this.bonus = bonus;
        }

        public float getBonus() {
            return bonus;
        }

        public void setBonus(float bonus) {
            this.bonus = bonus;
        }
        @Override
        public void showSalary(){
            System.out.println(String.format("我叫%s,在%s部门，我的工资是%.1f", getName(), getDepartment(), getSalary()));
        }
        @Override
        public void showBonus(){
            System.out.println(String.format("我是优秀员工，我的奖金是%.1f", getBonus()));
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String name = cin.next();
        String department = cin.next();
        float salary = cin.nextFloat();

        BasicEmployee basicEmployee = new BasicEmployee(name, department, salary);
        basicEmployee.showSalary();
        basicEmployee.showBonus();

        name = cin.next();
        department = cin.next();
        salary = cin.nextFloat();
        float bonus = cin.nextFloat();

        GoodEmployee goodEmployee = new GoodEmployee(name, department, salary, bonus);
        goodEmployee.showSalary();
        goodEmployee.showBonus();
    }
}

