package com.paeqw.collections;

import com.paeqw.exceptions.CouldNotFind;
import com.paeqw.models.Class;
import java.util.List;

public class ClassCollection {
    private List<Class> allClasses;

    public ClassCollection(List<Class> classList) {
        this.allClasses = classList;
    }

    public List<Class> getAllClasses() {
        return allClasses;
    }
    public void addClass(Class ...schoolClass) {
        allClasses.addAll(List.of(schoolClass));
    }

    public Class searchClass(String className) throws CouldNotFind {
        for (Class c:allClasses) {
            if (c.getName().equals(className)) return c;
        }
        throw new CouldNotFind("could not find class with given name");
    }

    public boolean removeClass(String className) throws CouldNotFind {
        return allClasses.remove(searchClass(className));
    }
}
