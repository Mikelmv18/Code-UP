package com.platform.code_up.controllers;

import com.platform.code_up.dtos.QuizDto;
import com.platform.code_up.entities.Quiz;
import com.platform.code_up.services.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin(origins = "http://localhost:8081")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestBody QuizDto quizDto) {
        Quiz quiz = service.createQuiz(quizDto);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = service.listAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Integer id) {
        Quiz quiz = service.getById(id);
        return ResponseEntity.ok(quiz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizDto> updateQuiz(@PathVariable Integer id, @RequestBody QuizDto quizDto) {
        QuizDto updated = service.updateQuiz(id, quizDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Integer id) {
        service.deleteQuiz(id);
        return ResponseEntity.ok("Quiz deleted");
    }
}
