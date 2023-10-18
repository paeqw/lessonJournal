package com.paeqw.models;

import com.paeqw.exceptions.CouldNotFind;

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

    public Student findStudent(String name, String surname) throws CouldNotFind {
        for (var el:studentList) {
            if(el.getFirstName().equals(name) && el.getLastName().equals(surname)) return el;
        }
        throw new CouldNotFind("could not find specified student in this class");
    }

    public boolean removeStudent(String name, String surname) throws CouldNotFind {
        return studentList.remove(findStudent(name,surname));
    }


}
