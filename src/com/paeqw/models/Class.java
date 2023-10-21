package com.paeqw.models;

import com.paeqw.enums.DayOfWeek;

import java.util.List;
import java.util.Map;

public class Class {
    private String name;
    private Teacher supervisingTeacher;

    private Map<DayOfWeek, List<Subject>> lessonPlan;
    public Class(String name, Teacher supervisingTeacher) {
        this.name = name;
        this.supervisingTeacher = supervisingTeacher;
    }


    public String getName() {
        return name;
    }

    public Teacher getSupervisingTeacher() {
        return supervisingTeacher;
    }




}
