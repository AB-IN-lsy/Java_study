package com.example17.polymorphism.OJ7176;
import java.util.*;
import java.math.*;

interface Teacher{
    void teachering();
}

class Englishclass implements Teacher{
    private String knowledge;

    public Englishclass(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public void teachering() {
        System.out.println(String.format("我是英语老师，I say %s", knowledge));
    }
}
class Mathclass implements Teacher{
    private String knowledge;

    public Mathclass(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public void teachering() {
        System.out.println(String.format("我是数学老师，I say %s", knowledge));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String knowledge = cin.next();
        Teacher teacher = new Englishclass(knowledge);
        TeachingRace(teacher);

        knowledge = cin.next();
        teacher = new Mathclass(knowledge);
        TeachingRace(teacher);
    }
    public static void TeachingRace(Teacher t){
        t.teachering();
    }
}

