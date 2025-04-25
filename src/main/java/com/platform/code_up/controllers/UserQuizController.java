package com.platform.code_up.controllers;

import com.platform.code_up.entities.UserQuiz;
import com.platform.code_up.services.UserQuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-quizzes")
public class UserQuizController {
    private final UserQuizService service;

    public UserQuizController(UserQuizService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserQuiz> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserQuiz getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public UserQuiz create(@RequestBody UserQuiz uq) {
        return service.create(uq);
    }

    @PutMapping("/{id}")
    public UserQuiz update(
            @PathVariable Integer id,
            @RequestBody UserQuiz uq
    ) {
        return service.update(id, uq);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
