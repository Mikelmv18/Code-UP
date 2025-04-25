package com.platform.code_up.controllers;

import com.platform.code_up.entities.Question;
import com.platform.code_up.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Question> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Question getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Question create(@RequestBody Question q) {
        return service.create(q);
    }

    @PutMapping("/{id}")
    public Question update(
            @PathVariable Integer id,
            @RequestBody Question q
    ) {
        return service.update(id, q);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
