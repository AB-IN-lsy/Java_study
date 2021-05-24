package com.experiment04;


import com.experiment04.entity.Student;
import com.experiment04.service.StudentService;
import com.experiment04.service.StudentServiceImpl;

public class Test {
    public static StudentService service = new StudentServiceImpl();
    public static void main(String[] args) {
        // addStudent();
        // listStudentsByYear();
        // listStudentsNames();
        // mapStudentsBySex();
        // removeStudent();
    }
    public static void addStudent(){
        Student student = new Student(201910, Student.Sex.FEMALE, "刘思远", 2019);
        service.addStudent(student)
                .forEach(System.out::println);
    }
    public static void listStudentsByYear(){
        service.listStudentsByYear(2011)
                .forEach(System.out::println);
    }
    public static void listStudentsNames() {
        service.listStudentsNames(2011, Student.Sex.MALE)
                .forEach(System.out::println);
    }
    public static void mapStudentsBySex(){
        service.mapStudentsBySex()
                .forEach((sex, list) -> {
                    System.out.println(sex + ": " + list);
                });
    }
    public static void removeStudent(){
        System.out.println(service.removeStudent(201001));
        StudentServiceImpl.LIST.forEach(System.out::println);
        System.out.println(service.removeStudent(201000));
    }
}
