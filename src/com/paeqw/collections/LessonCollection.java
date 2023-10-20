package com.paeqw.collections;

import com.paeqw.models.Lesson;

import java.util.Set;

public class LessonCollection {
    private Set<Lesson> allLessons;

    public LessonCollection(Set<Lesson> allLessons) {
        this.allLessons = allLessons;
    }

    public Set<Lesson> getAllLessons() {
        return allLessons;
    }
    private void addLesson(Lesson lesson) {
        allLessons.add(lesson);
    }

}
