package com.example27.execption.lab2;

import java.util.*;

class DangerException extends Exception{
    public void showMessage(){
        System.out.println("超重");
    }
}

class CargoBoat{
    int realContent;
    int maxContent;
    public void setMaxContent(int maxContent){
        this.maxContent = maxContent;
    }
    public void loading(int m) throws DangerException {
        if(realContent + m > maxContent){
            throw new DangerException();
        }
        else{
            realContent += m;
            System.out.println("目前载重量" + realContent);
        }
    }
}

public class Main {
    public static void solve() {
        Scanner cin = new Scanner(System.in);
        CargoBoat ship = new CargoBoat();
        ship.setMaxContent(1000);
        int m = 0;
        try{
            while(true){
                m = cin.nextInt();
                ship.loading(m);
            }
        }
        catch (DangerException e){
            e.showMessage();
            System.out.println("无法再装载重量是" + m + "吨货物");
        }
        finally {
            System.out.println("货轮启航");
        }
    }
    public static void main(String[] args) {
        solve();
    }
}
