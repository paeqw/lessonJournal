package com.paeqw.models;

import com.paeqw.interfaces.Sortable;

public class Teacher extends Person{
    private boolean isSupervisor;

    public Teacher(String firstName, String lastName, boolean isSupervisor) {
        super(firstName, lastName);
        this.isSupervisor = isSupervisor;
    }
    public int compare(Sortable other) {
        if (other instanceof Person otherPerson) {
            int fNComparison = this.getFirstName().compareTo(otherPerson.getFirstName());
            if (fNComparison == 0) {
                int lNComparison = this.getLastName().compareTo(otherPerson.getLastName());
                if (lNComparison == 0) {
                    if (otherPerson instanceof Teacher) {
                        return 0; // Teacher comes before Student
                    } else if (otherPerson instanceof Student) {
                        return 1; // Teacher comes before Student
                    } else {
                        return 1; // Teacher comes before Person
                    }
                }
                return lNComparison;
            }
            return fNComparison;
        }
        throw new IllegalArgumentException("Cannot compare with non-Person objects");
    }
    public boolean isSupervisor() {
        return isSupervisor;
    }

    @Override
    public void introduceYourself() {
        System.out.println("i am a teacher, my name is: " + this.getFirstName() + " and my lastname is: " + this.getLastName());
    }
}
