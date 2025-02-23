package com.dailycodework.demo.controller;


import com.dailycodework.demo.model.Lesson;
import com.dailycodework.demo.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private ILessonService lessonService;

    @GetMapping
    public ResponseEntity<List<Lesson>>getLessons(){
        return new ResponseEntity<>(lessonService.getLessons(), HttpStatus.FOUND);
            }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id){
        return lessonService.getLessonById(id);
    }

    @PostMapping
    public Lesson addLesson(@RequestBody Lesson lesson){
        return lessonService.addLesson(lesson);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@RequestBody Lesson lesson ,@PathVariable Long id){
        return lessonService.updateLesson(lesson,id);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id){
        lessonService.deleteLesson(id);
    }



}
