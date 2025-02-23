package com.dailycodework.demo.service;

import com.dailycodework.demo.model.Lesson;
import com.dailycodework.demo.model.Student;
import com.dailycodework.demo.model.Teacher;
import com.dailycodework.demo.repository.LessonRepository;
import com.dailycodework.demo.repository.StudentRepository;
import com.dailycodework.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class LessonService implements ILessonService {

   @Autowired
   private LessonRepository lessonRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Lesson> getLessons() {
       return lessonRepository.findAll();
    }

    @Override
    public Lesson addLesson(Lesson lesson) {
        if (lesson.getTeacherId() == null || lesson.getStudentId() == null) {
            throw new RuntimeException("Teacher ID and Student ID must be provided");
        }

        // Öğretmeni ve öğrenciyi veritabanından bul
        Teacher teacher = teacherRepository.findById(lesson.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Student student = studentRepository.findById(lesson.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Lesson nesnesine atamalar
        lesson.setTeacher(teacher);
        lesson.setStudent(student);

        return lessonRepository.save(lesson);
    }




    @Override
    public Lesson updateLesson(Lesson lesson, Long id) {
        return lessonRepository.findById(id).map(ls -> {
            ls.setLessonName(lesson.getLessonName());
            ls.setLessonNumber(lesson.getLessonNumber());

            // Teacher ve Student nesnelerini veritabanından bul
            Teacher teacher = teacherRepository.findById(lesson.getTeacherId())  // Düzeltildi
                    .orElseThrow(() -> new RuntimeException("Teacher not found"));

            Student student = studentRepository.findById(lesson.getStudentId())  // Düzeltildi
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            ls.setTeacher(teacher);
            ls.setStudent(student);

            return lessonRepository.save(ls); // Güncellenmiş nesneyi kaydet ve döndür
        }).orElseThrow(() -> new RuntimeException("Lesson not found"));
    }


    @Override
    public Lesson getLessonById(Long id) {
   return lessonRepository.findById(id).orElseThrow(()->new RuntimeException("Lesson not found"));
    }

    @Override
    public void deleteLesson(Long id) {
       if (!lessonRepository.existsById(id)){
           throw new RuntimeException("lesson not found"+id);
       }

       lessonRepository.deleteById(id);

    }
}
