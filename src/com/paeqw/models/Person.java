package com.paeqw.models;

import com.paeqw.interfaces.Sortable;

public abstract class Person implements Sortable {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public abstract int compare(Sortable other);

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public abstract void introduceYourself();
}
