package com.platform.code_up.controllers;

import com.platform.code_up.dtos.UserQuizDto;
import com.platform.code_up.entities.UserQuiz;
import com.platform.code_up.services.UserQuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-quizzes")
@CrossOrigin(origins = "http://localhost:8081")
public class UserQuizController {

    private final UserQuizService service;

    public UserQuizController(UserQuizService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUserQuiz(@RequestBody UserQuizDto dto) {
        UserQuiz userQuiz = service.createUserQuiz(dto);
        return ResponseEntity.ok(userQuiz);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserQuiz>> getAllUserQuizzes() {
        List<UserQuiz> userQuizzes = service.listAllUserQuizzes();
        return ResponseEntity.ok(userQuizzes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQuiz> getUserQuizById(@PathVariable Integer id) {
        UserQuiz userQuiz = service.getById(id);
        return ResponseEntity.ok(userQuiz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserQuizDto> updateUserQuiz(@PathVariable Integer id, @RequestBody UserQuizDto dto) {
        UserQuizDto updated = service.updateUserQuiz(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserQuiz(@PathVariable Integer id) {
        service.deleteUserQuiz(id);
        return ResponseEntity.ok("UserQuiz deleted");
    }
}
