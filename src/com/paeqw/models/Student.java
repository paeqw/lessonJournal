package com.paeqw.models;

import com.paeqw.enums.DayOfWeek;
import com.paeqw.interfaces.Sortable;

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
    public int compare(Sortable other) {
        if (other instanceof Person otherPerson) {
            int fNComparison = this.getFirstName().compareTo(otherPerson.getFirstName());
            if (fNComparison == 0) {
                int lNComparison = this.getLastName().compareTo(otherPerson.getLastName());
                if (lNComparison == 0) {
                    if (otherPerson instanceof Teacher) {
                        return -1; // Student comes after Teacher
                    } else if (otherPerson instanceof Student) {
                        return 0; // Student comes before Teacher
                    } else {
                        return 1; // Student comes before Person
                    }
                }
                return lNComparison;
            }
            return fNComparison;
        }
        throw new IllegalArgumentException("Cannot compare with non-Person objects");
    }
    @Override
    public void introduceYourself() {
        System.out.println("i am a student, my name is:" + this.getFirstName() + " and my lastname is: " + this.getLastName());
    }
}
