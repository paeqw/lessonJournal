package com.paeqw.models;

public class Teacher extends Person{
    private boolean isSupervisor;

    public Teacher(String firstName, String lastName, boolean isSupervisor) {
        super(firstName, lastName);
        this.isSupervisor = isSupervisor;
    }

    @Override
    public void introduceYourself() {
        System.out.println("jestem nauczyciel " + this.getFirstName() + " " + this.getLastName());
    }
}
