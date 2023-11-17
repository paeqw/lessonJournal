package com.paeqw.utils;

import com.paeqw.collections.ClassCollection;
import com.paeqw.collections.PersonCollection;
import com.paeqw.collections.SubjectCollection;
import com.paeqw.enums.DayOfWeek;
import com.paeqw.models.*;
import com.paeqw.models.Class;

import java.util.*;

import static com.paeqw.enums.DayOfWeek.*;

public class Adder {
    private ClassCollection classCollection;
    private PersonCollection personCollection;
    private SubjectCollection subjectCollection;

    public Adder(ClassCollection classCollection, PersonCollection personCollection, SubjectCollection subjectCollection) {
        this.classCollection = classCollection;
        this.personCollection = personCollection;
        this.subjectCollection = subjectCollection;
    }

    public void add() {
        Teacher mw = new Teacher("Marek", "Wrona", true);
        Teacher pm = new Teacher("Paweł", "Mazur", true);
        Teacher so = new Teacher("Małgorzata", "Sobieraj", true);
        Teacher gb = new Teacher("Barbara", "Gawrońska", true);
        Teacher mi = new Teacher("Aneta", "Miracka", true);
        Teacher am = new Teacher("Alina", "Mierzwa", true);
        Teacher km = new Teacher("Agnieszka", "Kossakowska-Michta", true);
        Teacher gj = new Teacher("Grzegorz", "Jańczy", true);
        Teacher mm = new Teacher("Magdalena", "Magiera", true);
        Teacher ba = new Teacher("Artur", "Burdzy",  true);

        this.personCollection.addPerson(mw,pm,so,gb,mi,am,km,gj,mm,ba);

        Subject s1 = new Subject("Fizyka", mi);
        Subject s2 = new Subject("Pracownia programowania obiektowego", mw);
        Subject s3 = new Subject("Pracownia programowania apl.mobilnch", pm);
        Subject s4 = new Subject("Matematyka", so);
        Subject s5 = new Subject("Język polski",gb);
        Subject s6 = new Subject("Programowanie aplikacji mobilnych", pm);
        Subject s7 = new Subject("Język angielski" ,am);
        Subject s8 = new Subject("Wiedza o społeczeństwie",km);
        Subject s9 = new Subject("Pracownia programowania obiektowego", mw);
        Subject s10 = new Subject("Zaawansowane aplikacje webowe", gj);
        Subject s11 = new Subject("Wychowanie fizyczne",mm);
        Subject s12 = new Subject("Religia", ba);
        Subject[] a = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12};

        this.subjectCollection.addSubject(a);

        List<Subject> subjectList = new ArrayList<>(Arrays.stream(a).toList());

        List<DayOfWeek> dayOfWeeksList = new ArrayList<>(Arrays.stream(new DayOfWeek[]{Monday, Tuesday, Wednesday, Thursday, Friday}).toList());

        List<Map<DayOfWeek,Map<Integer,Subject>>> cos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Map<DayOfWeek,Map<Integer,Subject>> mapMap = new HashMap<>();
            for (int j = 0; j < 5; j++) {
                Map<Integer,Subject> map = new HashMap<>();
                for (int k = 1; k < 9; k++) {
                    map.put(k,subjectList.get(new Random().nextInt(5 - 1 + 1) + 1));
                }
                mapMap.put(dayOfWeeksList.get(j),map);
            }
            cos.add(mapMap);
        }

        Class c1 = new Class("5bt", mw, cos.get(0));
        Class c2 = new Class("4bt", gj, cos.get(1));
        Class c3 = new Class("3bt", pm, cos.get(2));
        Class c4 = new Class("2bt", so, cos.get(3));
        Class c5 = new Class("1bt", gb, cos.get(4));
        Class c6 = new Class("5dt", mi, cos.get(5));
        Class c7 = new Class("4dt", am, cos.get(6));
        Class c8 = new Class("3dt", km, cos.get(7));
        Class c9 = new Class("2dt", mm, cos.get(8));
        Class c10 = new Class("1dt", ba, cos.get(9));

        this.classCollection.addClass(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);

        this.personCollection.addPerson(new Student("Jakub", "Berbes",c1));
        this.personCollection.addPerson(new Student("Wojtek", "Mianowski",c2));
        this.personCollection.addPerson(new Student("Maciej", "Kowalski", c3));
        this.personCollection.addPerson(new Student("Tomek","Nowak", c4));
        this.personCollection.addPerson(new Student("Wiktor", "Wisniewski", c5));
        this.personCollection.addPerson(new Student("Marek", "Wójcik", c6));
        this.personCollection.addPerson(new Student("Robert", "Kowalczyk", c7));
        this.personCollection.addPerson(new Student("Katarzyna", "Zielińska", c8));
        this.personCollection.addPerson(new Student("Magdalena", "Lewandowska",c9));
        this.personCollection.addPerson(new Student("Aleksandra", "Tworek",c10));
    }
}
