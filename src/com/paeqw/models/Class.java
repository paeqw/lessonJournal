package com.paeqw.models;

import com.paeqw.enums.DayOfWeek;

import java.util.List;
import java.util.Map;

public class Class {
    private String name;
    private Teacher supervisingTeacher;

    private Map<DayOfWeek, Map<Integer,Subject>> lessonPlan;

    public Class(String name, Teacher supervisingTeacher, Map<DayOfWeek, Map<Integer, Subject>> lessonPlan) {
        this.name = name;
        this.supervisingTeacher = supervisingTeacher;
        this.lessonPlan = lessonPlan;
    }


    public String getName() {
        return name;
    }

    public Map<Integer,Subject> getLessonsOnSpecifiedDay(DayOfWeek day) {
        return lessonPlan.get(day);
    }
    public void modifyLessonPlan(DayOfWeek day, Map<Integer,Subject> slist) {
        lessonPlan.put(day,slist);
    }
    public Map<DayOfWeek, Map<Integer,Subject>> getEntireLessonPlan() {
        return lessonPlan;
    }
    public Teacher getSupervisingTeacher() {
        return supervisingTeacher;
    }
}
