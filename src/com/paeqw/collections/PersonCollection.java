package com.paeqw.collections;

import com.paeqw.exceptions.CouldNotFind;
import com.paeqw.models.Person;
import com.paeqw.models.Student;
import com.paeqw.models.Teacher;
import java.util.ArrayList;
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
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        for (Person allPerson : allPersons) {
            if (allPerson.getClass() == Student.class) {
                list.add((Student) allPerson);
            }
        }
		return list;
	}
    public List<Teacher> getAllTeachers() {
        List<Teacher> list = new ArrayList<>();
        for (Person allPerson : allPersons) {
            if (allPerson.getClass() == Teacher.class) {
                list.add((Teacher) allPerson);
            }
        }
        return list;
    }
    public List<Teacher> getAllSupervisingTeachers() {
        List<Teacher> list = new ArrayList<>();
        for (Person allPerson : allPersons) {
            if (allPerson.getClass() == Teacher.class) {
                Teacher t = (Teacher) allPerson;
                if (t.isSupervisor()) list.add(t);
            }
        }
        return list;
    }
    public boolean removePerson(String firstname, String lastname) throws CouldNotFind {
        return allPersons.remove(searchPerson(firstname, lastname));
    }
}
