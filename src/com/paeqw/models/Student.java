package com.paeqw.models;

public class Student extends Person{
    private Class studentClass;

    public Student(String firstName, String lastName, Class studentClass) {
        super(firstName, lastName);
        this.studentClass = studentClass;
    }

    @Override
    public void introduceYourself() {
        System.out.println("jestem uczeń " + this.getFirstName() + " " + this.getLastName());
    }
}
