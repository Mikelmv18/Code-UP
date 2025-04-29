package com.platform.code_up.controllers;

import com.platform.code_up.dtos.QuestionDto;
import com.platform.code_up.entities.Question;
import com.platform.code_up.services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:8081")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createQuestion(@RequestBody QuestionDto questionDto) {
        Question question = service.createQuestion(questionDto);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = service.listAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
        Question question = service.getById(id);
        return ResponseEntity.ok(question);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> updateQuestion(@PathVariable Integer id, @RequestBody QuestionDto questionDto) {
        QuestionDto updated = service.updateQuestion(id, questionDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
        service.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted");
    }
}
