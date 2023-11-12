package com.paeqw.schoolmanagment;

import java.util.Map;
import java.util.*;
import com.paeqw.collections.ClassCollection;
import com.paeqw.collections.PersonCollection;
import com.paeqw.collections.SubjectCollection;
import com.paeqw.enums.DayOfWeek;
import com.paeqw.models.*;
import com.paeqw.models.Class;
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
            subjectCollection.addSubject(new Subject("example subject", new Teacher("exampleteacherfirstname", "exampleteacherlastname", false)));
            int choice;
            do {
                System.out.println("1. Show...");
                System.out.println("2. Delete...");
                System.out.println("3. Modify...");
                System.out.println("4. Add...");
                System.out.println("-1. Exit program.");

                choice = inputHandler.getInt("Input your choice");
                switch (choice) {
                    case 1 -> {
                        System.out.println("1. Show all subjects");
                        System.out.println("2. Show all teachers");
                        System.out.println("3. Show all supervising teachers");
                        System.out.println("4. Show all students");
                        System.out.println("5. Show all classes");
                        System.out.println("6. Show lesson plan for a given class for a given day");
                        System.out.println("7. Show all teacher's subjects");
                        int x = inputHandler.getInt("Your choice");
                        System.out.println();

                        switch (x) {
                            // 1. Show all subjects
                            case 1 -> {
                                int c = 0;
                                for (var el: subjectCollection.getAllSubjects()) {
                                    System.out.println(++c + ". " + el.getName() + " teacher - "+ el.getTeacher().getFirstName());
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
                                    System.out.println(++c + ". " + el.getName()+ " - " + el.getSupervisingTeacher().getFirstName() + el.getSupervisingTeacher().getLastName());
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
                            default -> System.out.println("wrong choice, enter number between 1 - 7");
                        }
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.println("1. Delete a person");
                        System.out.println("2. Delete class");
                        System.out.println("3. Delete subject");

                        int x = inputHandler.getInt("Your choice");
                        System.out.println();

                        switch (x) {
                            // 1. Delete a person
                            case 1 -> {
                                System.out.println("\n" + "Deleting a person...");

                                String firstname = inputHandler.getString("Enter first name");
                                String lastname = inputHandler.getString("Enter last name");

                                System.out.println("You are going to delete person: " + firstname+ " " + lastname);
                                String y = inputHandler.getString("Are you sure? (y/n)");
                                switch (y.toLowerCase()) {
                                    case "y" -> {
                                        personCollection.removePerson(firstname,lastname);
                                        System.out.println("Succesfully deleted person " + firstname + " " + lastname);
                                    }
                                    case "n" -> System.out.println("Canceled.");
                                    default -> System.err.println("Wrong choice.");
                                }
                            }
                            // 2. Delete class
                            case 2 -> {
                                System.out.println("\n" + "Deleting a class...");

                                String className = inputHandler.getString("Enter class name");
                                System.out.println("You are going to delete class with name '"+ className + "'");
                                String y = inputHandler.getString("Are you sure? (y/n)");
                                switch (y.toLowerCase()) {
                                    case "y" -> {
                                        classCollection.removeClass(className);
                                        System.out.println("Succesfully deleted class '" + className + "'");
                                    }
                                    case "n" -> System.out.println("Canceled.");
                                    default -> System.err.println("Wrong choice.");
                                }
                            }
                            // 3. Delete subject
                            case 3 -> {
                                System.out.println("\n" + "Deleting a subject...");

                                String subjectName = inputHandler.getString("Enter subject name");

                                System.out.println("You are going to delete subject with name '" + subjectName + "'");
                                String y = inputHandler.getString("Are you sure? (y/n)");
                                switch (y.toLowerCase()) {
                                    case "y" -> {
                                        subjectCollection.removeSubject(subjectName);
                                        System.out.println("Succesfully deleted subject '" + subjectName + "'");
                                    }
                                    case "n" -> System.out.println("Canceled.");
                                    default -> System.err.println("Wrong choice.");
                                }
                            }
                        }

                    }
                    case 3 -> {
                        System.out.println("1. Modify person");
                        System.out.println("2. Modify class");
                        System.out.println("3. Modify subject");
                        System.out.println("4. Modify lesson plan for given class");

                        int x = inputHandler.getInt("Your choice");
                        System.out.println();

                        switch (x) {

                        }

                    }
                    case 4 -> {
                        System.out.println("pain.");
                    }
                    case -1 -> System.out.println("exiting program...");
                    default -> System.out.println("wrong choice, enter number between 1 - x");
                }

            } while(choice != -1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}