package com.platform.code_up.controllers;

import com.platform.code_up.dtos.LessonDto;
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
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = service.listAllLessons();
        return ResponseEntity.ok(lessons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable Integer id)
            throws LessonNotFoundException {
        Lesson lesson = service.getById(id);
        return ResponseEntity.ok(new LessonDto(
                lesson.getTitle(),
                lesson.getDescription(),
                lesson.getContentType(),
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
}
