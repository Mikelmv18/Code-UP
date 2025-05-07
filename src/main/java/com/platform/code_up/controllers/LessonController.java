package com.platform.code_up.controllers;

import com.platform.code_up.dtos.CourseDto;
import com.platform.code_up.dtos.LessonDto;
import com.platform.code_up.entities.Course;
import com.platform.code_up.entities.Lesson;
import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.exceptions.LessonNotFoundException;
import com.platform.code_up.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@CrossOrigin(origins = "http://localhost:8081")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLesson(@RequestBody LessonDto lessonDto)
            throws CourseNotFoundException {

        Lesson lesson = service.createLesson(lessonDto);
        return ResponseEntity.ok(lesson);
    }

    @GetMapping("/")
    public ResponseEntity<List<LessonDto>> getAllLessons() {
        List<LessonDto> lessonDtos = service.listAllLessons().stream()
                .map(lessons -> new LessonDto(
                        lessons.getTitle(),
                        lessons.getContent(),
                        lessons.getLesson_order(),
                        lessons.getUnit_number(),
                        lessons.getCourse().getId()
                ))
                .toList();

        return ResponseEntity.ok(lessonDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable Integer id)
            throws LessonNotFoundException {
        Lesson lesson = service.getById(id);
        return ResponseEntity.ok(new LessonDto(
                lesson.getTitle(),
                lesson.getContent(),
                lesson.getLesson_order(),
                lesson.getUnit_number(),
                lesson.getCourse().getId()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonDto> updateLesson(@PathVariable Integer id,
                                                  @RequestBody LessonDto lessonDto)
            throws LessonNotFoundException {
        LessonDto updated = service.updateLesson(id, lessonDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable Integer id)
            throws LessonNotFoundException {
        service.deleteLesson(id);
        return ResponseEntity.ok().body("Lesson deleted successfully");
    }

    @GetMapping("/by-course/{course_id}")
    public ResponseEntity<List<LessonDto>> getLessonsByCourseId(
            @PathVariable("course_id") Integer course_id) {

        List<LessonDto> lessons = service.getLessonsByCourseId(course_id);
        return ResponseEntity.ok(lessons);
    }
 }
