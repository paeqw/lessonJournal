package com.paeqw.models;

public class Class {
    private String name;
    private Teacher supervisingTeacher;

    public Class(String name, Teacher supervisingTeacher) {
        this.name = name;
        this.supervisingTeacher = supervisingTeacher;
    }

    public Class() {
    }

    public String getName() {
        return name;
    }

    public Teacher getSupervisingTeacher() {
        return supervisingTeacher;
    }




}
