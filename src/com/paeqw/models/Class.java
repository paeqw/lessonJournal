package com.paeqw.models;

import java.util.*;

public class Class {
    private String name;
    private Teacher supervisingTeacher;
    private TreeSet<Student> studentList;

    public Class(String name, Teacher supervisingTeacher, TreeSet<Student> studentList) {
        this.name = name;
        this.supervisingTeacher = supervisingTeacher;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public Teacher getSupervisingTeacher() {
        return supervisingTeacher;
    }

    public TreeSet<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
}
