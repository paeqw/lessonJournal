package com.paeqw.schoolmanagment;

import com.paeqw.collections.PersonCollection;
import com.paeqw.enums.DayOfWeek;
import com.paeqw.models.*;
import com.paeqw.models.Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.paeqw.enums.DayOfWeek.*;

public class Main {
    public static void main(String[] args) {
        Teacher gj = new Teacher("Grzegorz", "Janczy", true);
        Teacher mw = new Teacher("Marek", "Wrona", false);
        Map<DayOfWeek, Map<Integer,Subject>> plan = new HashMap<>();
        Map<Integer,Subject> mondayLessons = new HashMap<>();
        mondayLessons.put(0,new Subject("programowanie aplikacji internetowych", gj));
        mondayLessons.put(1,new Subject("programowanie obiekowe", mw));
        plan.put(Monday,mondayLessons);
        Class fourbt = new Class("4bt",gj,plan);

        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Student("Dominik", "Marek",fourbt));
        listPerson.add(new Student("Szymon", "Ordon",fourbt));
        listPerson.add(new Student("Paweł", "Mroczek",fourbt));
        listPerson.add(mw);
        listPerson.add(gj);
        PersonCollection pc = new PersonCollection(listPerson);
//        for (var per: pc.getAllSupervisingTeachers()) {
//            System.out.println(per.getFirstName());
//        }
    }
}
