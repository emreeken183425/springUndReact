package com.dailycodework.demo.service;

import com.dailycodework.demo.model.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> getLessons();
    Lesson addLesson(Lesson lesson);
    Lesson updateLesson(Lesson lesson, Long id);
    Lesson getLessonById(Long id);
    void deleteLesson(Long id);
}
