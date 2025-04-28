package com.platform.code_up.controllers;

import com.platform.code_up.entities.UserAnswer;
import com.platform.code_up.services.UserAnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-answers")
public class UserAnswerController {
    private final UserAnswerService service;

    public UserAnswerController(UserAnswerService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserAnswer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserAnswer getOne(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public UserAnswer create(@RequestBody UserAnswer ua) {
        return service.create(ua);
    }

    @PutMapping("/{id}")
    public UserAnswer update(
            @PathVariable Integer id,
            @RequestBody UserAnswer ua
    ) {
        return service.update(id, ua);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
