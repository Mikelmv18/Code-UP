package com.platform.code_up;

import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.services.CourseService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {

    private final CourseService service;

    public DataSeeder(CourseService service) {
        this.service = service;
    }

    @PostConstruct
    public void seed() throws CourseNotFoundException {
        service.createCourses();
    }
}
