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
                            // 1. Modify person
                            case 1 -> {
                                String firstname = inputHandler.getString("Input firstname of the person you wanna modify");
                                String lastname = inputHandler.getString("Input lastname of the person you wanna modify");

                                Person foundPerson = personCollection.searchPerson(firstname,lastname);
                                System.out.println("Person you wanna modify is :" + firstname + " " + lastname);

                                System.out.println("What do you wanna modify? \n 1. Firstname, lastname \n 2. Firstname \n 3. Lastname");

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
                                    default -> System.err.println("Wrong choice");
                                }

                            }
                            // 2. Modify class
                            case 2 -> {
                                String className = inputHandler.getString("Input name of the class you want to modify");

                                Class classFound = classCollection.searchClass(className);

                                System.out.println("Class you wanna modify is: " + className);
                                System.out.println("What do you wanna modify? \n 1. Class name \n 2. Supervising teacher");
                                int c = inputHandler.getInt("Your choice");
                                switch (c) {
                                    case 1 -> {
                                        String newClassName = inputHandler.getString("Input new class name");
                                        classFound.setName(newClassName);
                                        System.out.println("Succesfully modified class name");
                                    }
                                    case 2 -> {
                                        System.out.println("1. Choose new teacher from list \n2. Create new teacher");
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
                                                    System.err.println("There is not a teacher with that number");
                                                } else {
                                                    classFound.setSupervisingTeacher(personCollection.getAllNotSupervisingTeachers().get(pc));
                                                }
                                            }
                                        }
                                    }
                                    default -> System.err.println("Wrong choice, choose number 1 or 2");
                                }

                            }
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