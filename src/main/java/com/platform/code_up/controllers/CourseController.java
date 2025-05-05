package com.platform.code_up.controllers;

import com.platform.code_up.dtos.CourseDto;
import com.platform.code_up.entities.Course;
import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = {"http://localhost:8005", "http://localhost:8081"})
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCourse() throws CourseNotFoundException {
        service.createCourses();
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = service.listAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Integer id) throws CourseNotFoundException {
        Course course = service.getById(id);
        return ResponseEntity.ok(new CourseDto(course.getTitle(), course.getDescription(), course.getType(),
                course.getIsPremium(), course.getPrerequisiteCourseIds()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer id,
                                                  @RequestBody CourseDto dto)
            throws CourseNotFoundException {
        CourseDto courseDto = service.updateCourse(id, dto);
        return ResponseEntity.ok(courseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) throws CourseNotFoundException {
        service.deleteCourse(id);
        return ResponseEntity.ok().body("Course deleted successfully");
    }
}
