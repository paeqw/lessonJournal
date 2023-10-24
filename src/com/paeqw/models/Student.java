package com.paeqw.models;

import com.paeqw.enums.DayOfWeek;

import java.util.Map.*;

public class Student extends Person{
    private Class studentClass;

    public Student(String firstName, String lastName, Class studentClass) {
        super(firstName, lastName);
        this.studentClass = studentClass;
    }
    public void showLessonsOnSpecifiedDay(DayOfWeek day) {
        for (Entry<Integer,Subject> subject: studentClass.getLessonsOnSpecifiedDay(day).entrySet()) {
            System.out.println( subject.getKey() + " : " +subject.getValue().getName());
        }
    }
    @Override
    public void introduceYourself() {
        System.out.println("jestem uczniem " + this.getFirstName() + " " + this.getLastName());
    }
}
