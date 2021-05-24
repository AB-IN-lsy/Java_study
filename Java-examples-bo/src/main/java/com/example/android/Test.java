package com.example.android;

/**
 * @author Liusy
 */
public class Test {
    public static void main(String[] args) {
        Button b1 = new Button("ButtonA");
        b1.setPoint(new Point() {
            @Override
            public void read() {
                System.out.println("ButtonA");
            }
        });
        Button b2 = new Button("ButtonB");
        b2.setPoint(new Point() {
            @Override
            public void read() {
                System.out.println("ButtonB");
            }
        });
        b1.getPoint().read();
        b2.getPoint().read();
    }
}
