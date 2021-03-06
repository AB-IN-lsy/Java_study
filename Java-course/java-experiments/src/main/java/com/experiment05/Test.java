package com.experiment05;

import com.experiment05.entity.College;
import com.experiment05.entity.Student;
import com.experiment05.entity.Teacher;
import com.experiment05.resource.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
         System.out.println(getCourseName(DatabaseUtils.getStudents(),201105));
         //printCollegeName(DatabaseUtils.getStudents(), 201001, 1001);
    }

    /**
     * 基于给定学生集合，学生编号，实现获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     * @param student
     * @param sNumber
     * @return
     */
    private static String getCourseName(List<Student> student, int sNumber) {
        /*String[] v = new String[1];
        v[0] = "未知学院";
        // 初始化便为未知学院，是因可能学生的ID在流中找不到
        student.stream()
                .filter(s -> s.getNumber() == sNumber)
                .collect(Collectors.toList())
                .forEach(
                        s -> {
                                v[0] = Optional.ofNullable(s)
                                .map(Student::getTeacher)
                                .map(Teacher::getCollege)
                                .map(College::getName)
                                .orElse("未知学院");
                                // 这里未知学院是为了可能会出现的异常情况，比如没导师
                        }
                );
        return v[0];*/
        return student.stream()
                .filter(s -> s.getNumber() == sNumber)
                .findFirst()
                .map(Student::getTeacher)
                .map(Teacher::getCollege)
                .map(College::getName)
                .orElse("未知学院");
    }

    /**
     * 实现在给定学生集合中查询指定编号学生，如果学生导师编号为指定编号，打印显式导师所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     * @param students
     * @param sNumber
     * @param tNumber
     */
    private static void printCollegeName(List<Student> students, int sNumber, int tNumber) {
//        String[] v = new String[1];
//        v[0] = "未知学院";
//        students.stream()
//                .filter(s -> s.getNumber() == sNumber)
//                .collect(Collectors.toList())
//                .forEach(
//                        s -> {
//                            v[0] = Optional.ofNullable(s)
//                                    .map(Student::getTeacher)
//                                    .filter(t -> tNumber == t.getNumber())
//                                    .map(Teacher::getCollege)
//                                    .map(College::getName)
//                                    .orElse("未知学院");
//                        }
//                );
//        System.out.println(v[0]);
        students.stream()
                .filter(s -> s.getNumber() == sNumber)
                .findFirst()
                .map(Student::getTeacher)
                .filter(t -> tNumber == t.getNumber())
                .map(Teacher::getCollege)
                .map(College::getName)
                .ifPresentOrElse(System.out::println, () -> System.out.println("未知学院"));
    }
}
