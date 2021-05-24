package com.example.android;

public class View {
    private String name;
    private Point point;
    public View(String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public Point getPoint() {
        return point;
    }
    public String getName() {
        return name;
    }
}
