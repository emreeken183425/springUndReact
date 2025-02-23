package com.dailycodework.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lessonName;
    private int lessonNumber;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)  // Foreign Key
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)  // Foreign Key
    private Student student;

    // ✅ Getter Metotları
    public Long getId() {
        return id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public Long getTeacherId() {
        return teacher != null ? teacher.getId() : null;  // Eğer teacher null ise hata vermez
    }

    public Long getStudentId() {
        return student != null ? student.getId() : null;  // Eğer student null ise hata vermez
    }

    // ✅ Setter Metotları
    public void setId(Long id) {
        this.id = id;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
