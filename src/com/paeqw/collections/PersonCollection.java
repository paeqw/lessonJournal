package com.paeqw.collections;

import com.paeqw.models.Person;

import java.util.List;

public class PersonCollection {
    private List<Person> allPersons;

    public PersonCollection(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public List<Person> getAllPersons() {
        return allPersons;
    }
    private void addPerson(Person person) {
        allPersons.add(person);
    }
}
