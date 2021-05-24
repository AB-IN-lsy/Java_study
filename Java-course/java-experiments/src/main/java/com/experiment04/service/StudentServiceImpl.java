package com.experiment04.service;

import com.experiment04.entity.Student;
import com.experiment04.resource.DatabaseUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService{
    public static List<Student> LIST = DatabaseUtils.getStudents();
    @Override
    public List<Student> addStudent(Student student) {
        LIST.add(student);
        return LIST;
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        return LIST.stream()
                .filter(s -> year == s.getYear())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        return LIST.stream()
                .filter(s -> year == s.getYear() && sex == s.getSex())
                .map(Student :: getName)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Student.Sex, List<Student>> mapStudentsBySex() {
        return LIST.stream()
                .collect(Collectors.groupingBy(Student :: getSex));
    }

    @Override
    public boolean removeStudent(int id) {
       return LIST.removeIf(s -> s.getId() == id);
    }
}
