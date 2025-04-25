package com.platform.code_up.controllers;

import com.platform.code_up.entities.Quiz;
import com.platform.code_up.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping
    public List<Quiz> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz q) {
        return service.create(q);
    }

    @PutMapping("/{id}")
    public Quiz update(
            @PathVariable Integer id,
            @RequestBody Quiz q
    ) {
        return service.update(id, q);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
