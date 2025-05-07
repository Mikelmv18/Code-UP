package com.platform.code_up.repositories;

import com.platform.code_up.dtos.LessonDto;
import com.platform.code_up.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    List<Lesson> findLessonsByCourseId(Integer courseId);
}