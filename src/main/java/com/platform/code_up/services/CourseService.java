package com.platform.code_up.services;

import com.platform.code_up.dtos.CourseDto;
import com.platform.code_up.entities.Course;
import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Course createCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setType(courseDto.getType());
        course.setIsPremium(courseDto.getIsPremium());
        course.setPrerequisiteCourseIds(courseDto.getPrerequisiteCourseIds());

        return repo.save(course);
    }

    public List<Course> listAllCourses() {
        List<Course> courses = new ArrayList<>();
        repo.findAll().forEach(courses::add);
        return courses;
    }

    public Course getById(Integer id) throws CourseNotFoundException {
        return repo.findById(id).orElseThrow(() -> new CourseNotFoundException());
    }

    public CourseDto updateCourse(Integer id, CourseDto courseDto) throws CourseNotFoundException {
        Course course = repo.findById(id).orElseThrow(() -> new CourseNotFoundException());

        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setType(courseDto.getType());
        course.setIsPremium(courseDto.getIsPremium());
        course.setPrerequisiteCourseIds(courseDto.getPrerequisiteCourseIds());

        repo.save(course);

        return new CourseDto(course.getTitle(), course.getDescription(), course.getType(),
                course.getIsPremium(), course.getPrerequisiteCourseIds());
    }

    public void deleteCourse(Integer id) throws CourseNotFoundException {
        Course course = repo.findById(id).orElseThrow(() -> new CourseNotFoundException());
        repo.delete(course);
    }
}
