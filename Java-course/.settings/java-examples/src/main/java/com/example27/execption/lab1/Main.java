package com.example27.execption.lab1;

import java.util.*;
public class Main {
    public static void solve() {
        Scanner cin = new Scanner(System.in);
        try{
            int n = cin.nextInt();
            System.out.println(10 - n);
        }
        catch (InputMismatchException e){
            System.out.println("not int");
        }
        finally {
            System.out.println("end");
        }
    }
    public static void main(String[] args) {
        solve();
    }
}
