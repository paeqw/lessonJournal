package com.paeqw.models;

public class Student extends Person{

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void introduceYourself() {
        System.out.println("jestem uczeń " + this.getFirstName() + " " + this.getLastName());
    }
}
