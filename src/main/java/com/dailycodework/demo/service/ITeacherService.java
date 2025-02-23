package com.dailycodework.demo.service;

import com.dailycodework.demo.model.Teacher;
import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    List<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherById(Long id);
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
}
