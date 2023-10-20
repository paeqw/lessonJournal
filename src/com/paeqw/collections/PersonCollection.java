package com.paeqw.collections;

import com.paeqw.exceptions.CouldNotFind;
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

    public Person searchPerson(String firstname,String lastname) throws CouldNotFind {
        for (Person person: allPersons) {
            if(person.getFirstName().equals(firstname) && person.getLastName().equals(lastname)) return person;
        }
        throw new CouldNotFind("could not find person with given name and lastname");
    }
    public boolean removePerson(String firstname, String lastname) throws CouldNotFind {
        return allPersons.remove(searchPerson(firstname, lastname));
    }
}
