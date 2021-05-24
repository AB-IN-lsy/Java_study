package com.example18.anonymousclasses;


public class Student {
    private String name;
    /**
     * 直接在类中定义接口，而不是implement接口，然后在类中改写
     */
    private Learnable learnable;
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Learnable getLearnable() {
        return learnable;
    }
    public void setLearnable(Learnable learnable) {
        this.learnable = learnable;
    }

}
