package com.paeqw.models;

public class Teacher extends Person{
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void introduceYourself() {
        System.out.println("jestem nauczyciel " + this.getFirstName() + " " + this.getLastName());
    }
}
