package com.platform.code_up.controllers;

import com.platform.code_up.dtos.CourseDto;
import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = {"http://localhost:8081", "http://172.20.10.2:8081"})
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
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courseDtos = service.listAllCourses().stream()
                .map(course -> new CourseDto(
                        course.getTitle(),
                        course.getDescription(),
                        course.getType(),
                        course.getIsPremium(),
                        course.getPrerequisiteCourseIds()
                ))
                .toList();

        return ResponseEntity.ok(courseDtos);
    }



    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Integer id) throws CourseNotFoundException {

        CourseDto courseDto = service.getById(id);

        return ResponseEntity.ok(courseDto);

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id,
                                                  @RequestBody CourseDto dto)
            throws CourseNotFoundException {
         service.updateCourse(id, dto);
        return ResponseEntity.ok().body("Course updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) throws CourseNotFoundException {
        service.deleteCourse(id);
        return ResponseEntity.ok().body("Course deleted successfully");
    }
}
