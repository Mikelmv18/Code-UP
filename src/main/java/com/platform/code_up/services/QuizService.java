package com.platform.code_up.services;

import com.platform.code_up.dtos.QuizDto;
import com.platform.code_up.entities.Course;
import com.platform.code_up.entities.Quiz;
import com.platform.code_up.repositories.CourseRepository;
import com.platform.code_up.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final CourseRepository courseRepository;

    public QuizService(QuizRepository quizRepository, CourseRepository courseRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
    }

    public Quiz createQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz();

        Course course = courseRepository.findById(quizDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        quiz.setTitle(quizDto.getTitle());
        quiz.setTimer(quizDto.getTimer());
        quiz.setQuiz_order(quizDto.getQuizOrder());
        quiz.setUnit_number(quizDto.getUnitNumber());
        quiz.setCourse(course);

        return quizRepository.save(quiz);
    }

    public List<Quiz> listAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
    }

    public Quiz getById(Integer id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    public QuizDto updateQuiz(Integer id, QuizDto quizDto) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        Course course = courseRepository.findById(quizDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        quiz.setTitle(quizDto.getTitle());
        quiz.setTimer(quizDto.getTimer());
        quiz.setQuiz_order(quizDto.getQuizOrder());
        quiz.setUnit_number(quizDto.getUnitNumber());
        quiz.setCourse(course);

        quizRepository.save(quiz);

        return new QuizDto(
                quiz.getTitle(),
                quiz.getTimer(),
                quiz.getQuiz_order(),
                quiz.getUnit_number(),
                quiz.getCourse().getId()
        );
    }

    public void deleteQuiz(Integer id) {
        if (!quizRepository.existsById(id)) {
            throw new RuntimeException("Quiz not found");
        }
        quizRepository.deleteById(id);
    }
}
