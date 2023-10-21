package com.paeqw.collections;

import com.paeqw.exceptions.CouldNotFind;
import com.paeqw.models.Subject;
import com.paeqw.models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SubjectCollection {
    private Set<Subject> allSubjects;

    public SubjectCollection(Set<Subject> allSubjects) {
        this.allSubjects = allSubjects;
    }

    public Set<Subject> getAllSubjects() {
        return allSubjects;
    }

    private void addSubject(Subject subject) {
        allSubjects.add(subject);
    }

    public Subject searchSubjectByName(String name) throws CouldNotFind {
        for (var l: allSubjects) {
            if(l.getName().equals(name)) return l;
        }
        throw new CouldNotFind("could not find subjects with given name");
    }
    public List<Subject> searchAllTeachersSubjects(String teacherName, String teacherSurname) throws CouldNotFind {
        List<Subject> list = new ArrayList<>();
        for (var l: allSubjects) {
            Teacher t = l.getTeacher();
            if(t.getFirstName().equals(teacherName) && t.getLastName().equals(teacherSurname)) list.add(l);
        }
        if (list.size() != 0) return list;
        throw new CouldNotFind("could not find subjects with that teacher");
    }
    public boolean removeSubject(String name) throws CouldNotFind {
        return allSubjects.remove(searchSubjectByName(name));
    }
}
