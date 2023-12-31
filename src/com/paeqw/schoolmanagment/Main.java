package com.paeqw.schoolmanagment;

import java.util.Map;
import java.util.*;
import com.paeqw.collections.ClassCollection;
import com.paeqw.collections.PersonCollection;
import com.paeqw.collections.SubjectCollection;
import com.paeqw.enums.DayOfWeek;
import com.paeqw.models.*;
import com.paeqw.models.Class;
import com.paeqw.utils.Adder;
import com.paeqw.utils.ConsoleColors;
import com.paeqw.utils.InputHandler;
import com.paeqw.utils.InputValidator;

import static com.paeqw.enums.DayOfWeek.*;

public class Main {
    public static void main(String[] args) {
        try {
            InputHandler inputHandler = new InputHandler();
            InputValidator inputValidator = new InputValidator();
            ClassCollection classCollection = new ClassCollection(new ArrayList<>());
            PersonCollection personCollection = new PersonCollection(new ArrayList<>());
            SubjectCollection subjectCollection = new SubjectCollection(new HashSet<>());
            Adder adder = new Adder(classCollection,personCollection,subjectCollection);
            adder.add();

            int choice;
            do {
                System.out.println(ConsoleColors.paint("1. Show...",2));
                System.out.println(ConsoleColors.paint("2. Delete...",2));
                System.out.println(ConsoleColors.paint("3. Modify...",2));
                System.out.println(ConsoleColors.paint("4. Add...",2));
                System.out.println(ConsoleColors.paint("-1. Exit program.",1));

                choice = inputHandler.getInt("Input your choice");
                switch (choice) {
                    // 1. Show...
                    case 1 -> {
                        System.out.println(ConsoleColors.paint("1. Show all subjects",2));
                        System.out.println(ConsoleColors.paint("2. Show all teachers",2));
                        System.out.println(ConsoleColors.paint("3. Show all supervising teachers",2));
                        System.out.println(ConsoleColors.paint("4. Show all students",2));
                        System.out.println(ConsoleColors.paint("5. Show all classes",2));
                        System.out.println(ConsoleColors.paint("6. Show lesson plan for a given class for a given day",2));
                        System.out.println(ConsoleColors.paint("7. Show all teacher's subjects",2));
                        int x = inputHandler.getInt("Your choice");
                        System.out.println();

                        switch (x) {
                            // 1. Show all subjects
                            case 1 -> {
                                int c = 0;
                                for (var el: subjectCollection.getAllSubjects()) {
                                    System.out.println(++c + ". '" + el.getName() + "' - "+ el.getTeacher().getFirstName());
                                }
                            }
                            // 2. Show all teachers
                            case 2 -> {
                                int c = 0;
                                for(var el: personCollection.getAllTeachers()) {
                                    System.out.println(++c+ ". " + el.getFirstName() + " " + el.getLastName());
                                }
                            }
                            // 3. Show all supervising teachers
                            case 3 -> {
                                int c = 0;
                                for(var el: personCollection.getAllSupervisingTeachers()) {
                                    System.out.println(++c+ ". " + el.getFirstName() + " " + el.getLastName());
                                }
                            }
                            // 4. Show all students
                            case 4 -> {
                                int c = 0;
                                for (var el:personCollection.getAllStudents()) {
                                    System.out.println(++c + ". " + el.getFirstName() + " " + el.getLastName());
                                }
                            }
                            // 5. Show all classes
                            case 5 -> {
                                int c = 0;
                                for (var el:classCollection.getAllClasses()) {
                                    System.out.println(++c + ". " + el.getName()+ " - supervisor - " + el.getSupervisingTeacher().getFirstName() + " " +  el.getSupervisingTeacher().getLastName());
                                }
                            }
                            // 6. Show lesson plan for a given class for a given day
                            case 6 -> {
                                DayOfWeek day = inputValidator.getDayOfWeek();
                                String className = inputHandler.getString("input class name");
                                Map<Integer,Subject> lessons = classCollection.searchClass(className).getLessonsOnSpecifiedDay(day);
                                for (Map.Entry<Integer, Subject> entry : lessons.entrySet()) {
                                    System.out.println(entry.getKey() + " - " + entry.getValue().getName());
                                }
                            }
                            // 7. Show all teacher's subjects
                            case 7 -> {
                                String firstname = inputHandler.getString("Enter first name");
                                String lastname = inputHandler.getString("Enter last name");

                                int c = 0;
                                for (var el : subjectCollection.searchAllTeachersSubjects(firstname, lastname)) {
                                    System.out.println(++c + " " + el.getName());
                                }
                            }
                            default -> System.err.println(ConsoleColors.paint("wrong choice",1));
                        }
                        System.out.println();
                    }
                    // 2. Delete...
                    case 2 -> {
                        System.out.println(ConsoleColors.paint("1. Delete a person",2));
                        System.out.println(ConsoleColors.paint("2. Delete class",2));
                        System.out.println(ConsoleColors.paint("3. Delete subject",2));
                        int x = inputHandler.getInt("Your choice");
                        System.out.println();
                        switch (x) {
                            // 1. Delete a person
                            case 1 -> {
                                System.out.println("\n" + "Deleting a person...");
                                String firstname = inputHandler.getString("Enter first name");
                                String lastname = inputHandler.getString("Enter last name");
                                System.out.println(ConsoleColors.paint("You are going to delete person: " + firstname+ " " + lastname,1));
                                String y = inputHandler.getString("Are you sure? (y/n)");
                                switch (y.toLowerCase()) {
                                    case "y" -> {
                                        personCollection.removePerson(firstname,lastname);
                                        System.out.println("Succesfully deleted person " + firstname + " " + lastname);
                                    }
                                    case "n" -> System.out.println("Canceled.");
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice.",1));
                                }
                            }
                            // 2. Delete class
                            case 2 -> {
                                System.out.println("\n" + "Deleting a class...");
                                String className = inputHandler.getString("Enter class name");
                                System.out.println(ConsoleColors.paint("You are going to delete class with name '"+ className + "'",2));
                                String y = inputHandler.getString("Are you sure? (y/n)");
                                switch (y.toLowerCase()) {
                                    case "y" -> {
                                        classCollection.removeClass(className);
                                        System.out.println("Succesfully deleted class '" + className + "'");
                                    }
                                    case "n" -> System.out.println("Canceled.");
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice.",1));
                                }
                            }
                            // 3. Delete subject
                            case 3 -> {
                                System.out.println("\n" + "Deleting a subject...");
                                String subjectName = inputHandler.getString("Enter subject name");
                                System.out.println(ConsoleColors.paint("You are going to delete subject with name '" + subjectName + "'",1));
                                String y = inputHandler.getString("Are you sure? (y/n)");
                                switch (y.toLowerCase()) {
                                    case "y" -> {
                                        subjectCollection.removeSubject(subjectName);
                                        System.out.println("Succesfully deleted subject '" + subjectName + "'");
                                    }
                                    case "n" -> System.out.println("Canceled.");
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice.",1));
                                }
                            }
                        }
                    }
                    // 3. Modify...
                    case 3 -> {
                        System.out.println(ConsoleColors.paint("1. Modify person",2));
                        System.out.println(ConsoleColors.paint("2. Modify class",2));
                        System.out.println(ConsoleColors.paint("3. Modify subject",2));
                        int x = inputHandler.getInt("Your choice");
                        System.out.println();
                        switch (x) {
                            // 1. Modify person
                            case 1 -> {
                                String firstname = inputHandler.getString("Input firstname of the person you wanna modify");
                                String lastname = inputHandler.getString("Input lastname of the person you wanna modify");
                                Person foundPerson = personCollection.searchPerson(firstname,lastname);
                                System.out.println("Person you wanna modify is :" + firstname + " " + lastname);
                                System.out.println(ConsoleColors.paint("What do you wanna modify? \n 1. Firstname, lastname \n 2. Firstname \n 3. Lastname",2));
                                int ch = inputHandler.getInt("Your choice");
                                switch (ch) {
                                    case 1 -> {
                                        String newFirstname = inputHandler.getString("New firstname is");
                                        String newLastname = inputHandler.getString("New lastname is");
                                        foundPerson.setFirstName(newFirstname);
                                        foundPerson.setLastName(newLastname);
                                        System.out.println("Succesfully modified that person");
                                    }
                                    case 2 -> {
                                        String newFirstname = inputHandler.getString("New firstname is");
                                        foundPerson.setFirstName(newFirstname);
                                        System.out.println("Succesfully modified that person");
                                    }
                                    case 3 -> {
                                        String newLastname = inputHandler.getString("New lastname is");
                                        foundPerson.setLastName(newLastname);
                                        System.out.println("Succesfully modified that person");
                                    }
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                }
                            }
                            // 2. Modify class
                            case 2 -> {
                                String className = inputHandler.getString("Input name of the class you want to modify");
                                Class classFound = classCollection.searchClass(className);
                                System.out.println("Class you wanna modify is: " + className);
                                System.out.println(ConsoleColors.paint("What do you wanna modify? \n1. Class name \n2. Supervising teacher",2));
                                int c = inputHandler.getInt("Your choice");
                                switch (c) {
                                    case 1 -> {
                                        String newClassName = inputHandler.getString("Input new class name");
                                        classFound.setName(newClassName);
                                        System.out.println("Succesfully modified class name");
                                    }
                                    case 2 -> {
                                        System.out.println(ConsoleColors.paint("1. Choose new teacher from list \n2. Create new teacher",2));
                                        int choiceT = inputHandler.getInt("Your choice");
                                        switch (choiceT) {
                                            case 1 -> {
                                                System.out.println();
                                                int l = 0;
                                                if(personCollection.getAllNotSupervisingTeachers().isEmpty()) {
                                                    System.err.println(ConsoleColors.paint("There is no teacher who is not a supervisor",1));
                                                } else {
                                                    for (var el : personCollection.getAllNotSupervisingTeachers()) {
                                                        System.out.println(++l + ". " + el.getFirstName() + " " + el.getLastName());
                                                    }

                                                    System.out.println();
                                                    int pc = inputHandler.getInt();
                                                    if (pc - 1 > personCollection.getAllNotSupervisingTeachers().size()) {
                                                        System.err.println(ConsoleColors.paint("There is not a teacher with that number",1));
                                                    } else {
                                                        classFound.setSupervisingTeacher(personCollection.getAllNotSupervisingTeachers().get(pc));
                                                    }
                                                }
                                            }
                                            case 2 -> {
                                                String firstname = inputHandler.getString("Input firstname of the teacher you wanna create");
                                                String lastname = inputHandler.getString("Input lastname of the teacher you wanna create");
                                                Teacher t = new Teacher(firstname, lastname, true);
                                                personCollection.addPerson(t);
                                                classFound.setSupervisingTeacher(t);
                                                System.out.println("Succesfully changed supervising teacher for class " + classFound.getName());
                                            }
                                            default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                        }
                                    }
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                }
                            }
                            // 3. Modify subject
                            case 3 -> {
                                String subjectName = inputHandler.getString("Enter name of the subject you wanna modify");
                                Subject foundSubject = subjectCollection.searchSubjectByName(subjectName);
                                System.out.println(ConsoleColors.paint("Succesfully found subject with given name\nWhat do you wanna modify?\n1. Subject name\n2. Teaching teacher",2));
                                int choiceS = inputHandler.getInt("Your choice");
                                switch (choiceS) {
                                    case 1 -> {
                                        String newSubjectName = inputHandler.getString("Enter new subject name");
                                        foundSubject.setName(newSubjectName);
                                        System.out.println("Succesfully changed subject name to: " + newSubjectName);
                                    }
                                    case 2 -> {
                                        System.out.println(ConsoleColors.paint("1. Choose new teacher from list \n2. Create new teacher",2));
                                        int choiceT = inputHandler.getInt("Your choice");
                                        switch (choiceT) {
                                            case 1 -> {
                                                System.out.println();
                                                int l = 0;
                                                for (var el : personCollection.getAllTeachers()) {
                                                    System.out.println(++l + ". " + el.getFirstName() + " " + el.getLastName());
                                                }
                                                System.out.println();
                                                int pc = inputHandler.getInt();
                                                if (pc - 1 > personCollection.getAllTeachers().size()) {
                                                    System.err.println(ConsoleColors.paint("There is not a teacher with that number",1));
                                                } else {
                                                    foundSubject.setTeacher(personCollection.getAllTeachers().get(pc));
                                                }
                                            }
                                            case 2 -> {
                                                String firstname = inputHandler.getString("Input firstname of the teacher you wanna create");
                                                String lastname = inputHandler.getString("Input lastname of the teacher you wanna create");
                                                Teacher t = new Teacher(firstname,lastname,true);
                                                personCollection.addPerson(t);
                                                foundSubject.setTeacher(t);
                                                System.out.println("Succesfully changed teaching teacher for subject " + foundSubject.getName());
                                            }
                                            default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                        }
                                    }
                                }
                            }
                            default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                        }
                    }
                    // 4. Add...
                    case 4 -> {
                        System.out.println(ConsoleColors.paint("1. Add student",2));
                        System.out.println(ConsoleColors.paint("2. Add teacher",2));
                        System.out.println(ConsoleColors.paint("3. Add subject",2));
                        System.out.println(ConsoleColors.paint("4. Add class",2));
                        int ch = inputHandler.getInt("Your choice");
                        switch (ch) {
                            case 1 -> {
                                String studentFistname = inputHandler.getString("Input firstname for student");
                                String studentLastname = inputHandler.getString("Input lastname for student");
                                Class c;
                                System.out.println(ConsoleColors.paint("1. Choose class for student \n2. Make new class for student",2));
                                switch (inputHandler.getInt("Your choice")) {
                                    // 1. Choose class for student
                                    case 1 -> {
                                        int z = 0;
                                        for (var el:classCollection.getAllClasses()) {
                                            System.out.println(++z + ". '" + el.getName() + "'");
                                        }
                                        int classChoice = inputHandler.getInt("Your choice");
                                        if(classChoice - 1 > classCollection.getAllClasses().size() && classChoice > 0) {
                                            System.err.println(ConsoleColors.paint("There is no class with given number",1));
                                        } else {
                                            personCollection.addPerson(new Student(studentFistname, studentLastname, classCollection.getAllClasses().get(classChoice)));
                                            System.out.println("Added new student");
                                        }
                                    }
                                    // 2. Make new class for student
                                    case 2 -> {
                                        System.out.println("Creating new class for student");
                                        String createClassName = inputHandler.getString("Input name for new class");
                                        System.out.println("You also need a supervising teacher");
                                        System.out.println(ConsoleColors.paint("1. Choose teacher from list\n2. Create new teacher",2));
                                        Teacher teacher;
                                        switch (inputHandler.getInt("Your choice")) {
                                            // 1. Choose teacher from list
                                            case 1 -> {
                                                int t = 0;
                                                if(!personCollection.getAllNotSupervisingTeachers().isEmpty()) {
                                                    for (var el : personCollection.getAllNotSupervisingTeachers()) {
                                                        System.out.println(++t + ". " + el.getFirstName() + " " + el.getLastName());
                                                    }
                                                    int chosenTeacher = inputHandler.getInt("Your choice");
                                                    if (chosenTeacher > 0 && chosenTeacher -1 > personCollection.getAllNotSupervisingTeachers().size()) {
                                                        System.err.println(ConsoleColors.paint("There is no teacher with given number",1));
                                                    } else {
                                                        teacher = personCollection.getAllNotSupervisingTeachers().get(chosenTeacher - 1);
                                                        Map<DayOfWeek, Map<Integer, Subject>> emptyMap = new HashMap<>();
                                                        c = new Class(createClassName, teacher, emptyMap);
                                                        classCollection.addClass(c);
                                                        System.out.println("Created new class with empty lesson plan.");
                                                        personCollection.addPerson(new Student(studentFistname, studentLastname, c));
                                                        System.out.println("Created student");
                                                    }
                                                }
                                                else {
                                                    System.err.println(ConsoleColors.paint("There is no teacher who is not a supervisor",1));
                                                }
                                            }
                                            // 2. Create new teacher
                                            case 2 -> {
                                                String newTeacherFirstname = inputHandler.getString("Input firstname for the new teacher");
                                                String newTeacherLastname = inputHandler.getString("Input lastname");
                                                Map<DayOfWeek,Map<Integer,Subject>> emptyMap = new HashMap<>();
                                                Teacher teacher1 = new Teacher(newTeacherFirstname,newTeacherLastname,true);
                                                c = new Class(createClassName, teacher1, emptyMap);
                                                System.out.println("Created new class with empty lesson plan.");
                                                classCollection.addClass(c);
                                                personCollection.addPerson(new Student(studentFistname,studentLastname,c));
                                                System.out.println("Created student");
                                            }
                                            default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                        }
                                    }
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                }
                            }
                            // 2. Add teacher
                            case 2 -> {
                                String teacherFirstname = inputHandler.getString("Input firstname for teacher");
                                String teacherLastname = inputHandler.getString("Input lastname for teacher");
                                switch (inputHandler.getString("Is he a supervisor (y/n)")) {
                                    case "y" -> {
                                        personCollection.addPerson(new Teacher(teacherFirstname,teacherLastname,true));
                                        System.out.println("Added new teacher");
                                    }
                                    case "n" -> {
                                        personCollection.addPerson(new Teacher(teacherFirstname,teacherLastname,false));
                                        System.out.println("Added new teacher");
                                    }
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                }
                            }
                            // 3. Add subject
                            case 3 -> {
                                String subjectName = inputHandler.getString("Enter subject name");
                                System.out.println(ConsoleColors.paint("1. Choose teacher from list\n2. Create new teacher",2));
                                switch (inputHandler.getInt("Your choice")) {
                                    case 1 -> {
                                        int c = 0;
                                        for (var el : personCollection.getAllTeachers()) {
                                            System.out.println(++c + ". " + el.getFirstName() + " " + el.getLastName());
                                        }
                                        int chosenTeacher = inputHandler.getInt("Your choice");
                                        if (chosenTeacher < 0 && chosenTeacher -1 > personCollection.getAllNotSupervisingTeachers().size()) {
                                            System.err.println(ConsoleColors.paint("There is no teacher with given number",1));
                                        } else {
                                            Teacher t = personCollection.getAllTeachers().get(chosenTeacher);
                                            subjectCollection.addSubject(new Subject(subjectName,t));
                                        }
                                    }
                                    case 2 -> {
                                        String teacherFirstname = inputHandler.getString("Input firstname for teacher");
                                        String teacherLastname = inputHandler.getString("Input lastname for teacher");
                                        switch (inputHandler.getString("Is he a supervisor (y/n)")) {
                                            case "y" -> {
                                                subjectCollection.addSubject(new Subject(subjectName, new Teacher(teacherFirstname,teacherLastname,true)));
                                                System.out.println("Added new subject");
                                            }
                                            case "n" -> {
                                                subjectCollection.addSubject(new Subject(subjectName, new Teacher(teacherFirstname,teacherLastname,false)));
                                                System.out.println("Added new subject");
                                            }
                                            default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                        }
                                    }
                                }
                            }
                            // 4. Add class
                            case 4 -> {
                                String createClassName = inputHandler.getString("Input name for new class");
                                System.out.println("You also need a supervising teacher");
                                System.out.println(ConsoleColors.paint("1. Choose teacher from list\n2. Create new teacher",2));
                                Teacher teacher;
                                Class c;
                                switch (inputHandler.getInt("Your choice")) {
                                    // 1. Choose teacher from list
                                    case 1 -> {
                                        int t = 0;
                                        if(!personCollection.getAllNotSupervisingTeachers().isEmpty()) {
                                        for (var el : personCollection.getAllNotSupervisingTeachers()) {
                                                System.out.println(++t + ". " + el.getFirstName() + " " + el.getLastName());
                                            }
                                            int chosenTeacher = inputHandler.getInt("Your choice");
                                            if (chosenTeacher < 0 && chosenTeacher -1 > personCollection.getAllNotSupervisingTeachers().size()) {
                                                System.err.println(ConsoleColors.paint("There is no teacher with given number",1));
                                            } else {
                                                teacher = personCollection.getAllNotSupervisingTeachers().get(chosenTeacher - 1);
                                                Map<DayOfWeek, Map<Integer, Subject>> emptyMap = new HashMap<>();
                                                c = new Class(createClassName, teacher, emptyMap);
                                                classCollection.addClass(c);
                                                System.out.println("Created new class with empty lesson plan.");
                                            }
                                        }
                                        else {
                                            System.err.println(ConsoleColors.paint("There is no teacher who is not a supervisor",1));
                                        }
                                    }
                                    // 2. Create new teacher
                                    case 2 -> {
                                        String newTeacherFirstname = inputHandler.getString("Input firstname for the new teacher");
                                        String newTeacherLastname = inputHandler.getString("Input lastname");
                                        Map<DayOfWeek,Map<Integer,Subject>> emptyMap = new HashMap<>();
                                        Teacher teacher1 = new Teacher(newTeacherFirstname,newTeacherLastname,true);
                                        c = new Class(createClassName, teacher1, emptyMap);
                                        System.out.println("Created new class with empty lesson plan.");
                                        classCollection.addClass(c);
                                    }
                                    default -> System.err.println(ConsoleColors.paint("Wrong choice",1));
                                }
                            }
                        }
                    }
                    case -1 -> System.out.println(ConsoleColors.paint("exiting program...",2));
                    default -> System.err.println(ConsoleColors.paint("wrong choice, enter number between 1 - 4",1));
                }
            } while(choice != -1);
        } catch (Exception e) {
            System.err.println(ConsoleColors.paint(e.getMessage(),1));
        }
    }
}