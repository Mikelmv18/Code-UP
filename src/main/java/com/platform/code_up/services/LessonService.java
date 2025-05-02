package com.platform.code_up.services;

import com.platform.code_up.dtos.LessonDto;
import com.platform.code_up.entities.Course;
import com.platform.code_up.entities.Lesson;
import com.platform.code_up.exceptions.CourseNotFoundException;
import com.platform.code_up.exceptions.LessonNotFoundException;
import com.platform.code_up.repositories.CourseRepository;
import com.platform.code_up.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonService(LessonRepository lessonRepo, CourseRepository courseRepo) {
        this.lessonRepo = lessonRepo;
        this.courseRepo = courseRepo;
    }

    public Lesson createLesson(LessonDto lessonDto) throws CourseNotFoundException {
        Lesson lesson = new Lesson();

        Course course = courseRepo.findById(lessonDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException());

        lesson.setTitle(lessonDto.getTitle());
        lesson.setContent(lessonDto.getContent());
        lesson.setLesson_order(lessonDto.getLessonOrder());
        lesson.setUnit_number(lessonDto.getUnitNumber());
        lesson.setCourse(course);

        return lessonRepo.save(lesson);
    }

    public List<Lesson> listAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepo.findAll().forEach(lessons::add);
        return lessons;
    }

    public Lesson getById(Integer id) throws LessonNotFoundException {
        return lessonRepo.findById(id)
                .orElseThrow(() -> new LessonNotFoundException());
    }

    public LessonDto updateLesson(Integer id, LessonDto lessonDto)
            throws LessonNotFoundException {
        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new LessonNotFoundException());

        lesson.setTitle(lessonDto.getTitle());
        lesson.setContent(lessonDto.getContent());
        lesson.setLesson_order(lessonDto.getLessonOrder());
        lesson.setUnit_number(lessonDto.getUnitNumber());

        lessonRepo.save(lesson);

        return new LessonDto(
                lesson.getTitle(),
                lesson.getContent(),
                lesson.getLesson_order(),
                lesson.getUnit_number(),
                lesson.getCourse().getId()
        );
    }

    public void deleteLesson(Integer id) throws LessonNotFoundException {
        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new LessonNotFoundException());

        lessonRepo.delete(lesson);
    }
}
