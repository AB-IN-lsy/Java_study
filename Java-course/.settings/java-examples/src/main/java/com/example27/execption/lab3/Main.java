package com.example27.execption.lab3;

import java.util.*;

class IllegalArgumentException extends Exception{
    public void showMessage(int a, int b, int c){
        System.out.println(String.format("%d,%d,%d不能构成三角形", a, b, c));
    }
}

public class Main {
    public static void triangle(int a, int b, int c) throws IllegalArgumentException{
        int[] s = new int[3];
        s[0] = a;
        s[1] = b;
        s[2] = c;
        Arrays.sort(s);
        if(s[0] + s[1] > s[2] && s[2] - s[1] < s[0]){
            System.out.println(String.format("三角形的三边长为%d %d %d", a, b, c));
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    public static void solve() {
        Scanner cin = new Scanner(System.in);
        int a = 0, b = 0, c = 0;
        try{
            a = cin.nextInt();
            b = cin.nextInt();
            c = cin.nextInt();
            triangle(a, b, c);
        }
        catch(IllegalArgumentException e){
            e.showMessage(a, b, c);
        }
        catch (InputMismatchException e){
            System.out.println("请输入整数作为三角形边长！");
        }
    }
    public static void main(String[] args) {
        solve();
    }
}