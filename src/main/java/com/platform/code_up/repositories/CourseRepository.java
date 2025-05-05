package com.platform.code_up.repositories;

import com.platform.code_up.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Optional<Course> findByPrerequisiteCourseIds(Integer course_id);
        Optional<Course> findByTitle(String title);


}
