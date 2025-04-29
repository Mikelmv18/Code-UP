package com.platform.code_up.controllers;

import com.platform.code_up.dtos.UserAnswerDto;
import com.platform.code_up.entities.UserAnswer;
import com.platform.code_up.services.UserAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-answers")
@CrossOrigin(origins = "http://localhost:8081")
public class UserAnswerController {

    private final UserAnswerService service;

    public UserAnswerController(UserAnswerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUserAnswer(@RequestBody UserAnswerDto dto) {
        UserAnswer userAnswer = service.createUserAnswer(dto);
        return ResponseEntity.ok(userAnswer);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserAnswer>> getAllUserAnswers() {
        List<UserAnswer> list = service.listAllUserAnswers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAnswer> getUserAnswerById(@PathVariable Integer id) {
        UserAnswer userAnswer = service.getById(id);
        return ResponseEntity.ok(userAnswer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAnswerDto> updateUserAnswer(@PathVariable Integer id, @RequestBody UserAnswerDto dto) {
        UserAnswerDto updated = service.updateUserAnswer(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserAnswer(@PathVariable Integer id) {
        service.deleteUserAnswer(id);
        return ResponseEntity.ok("UserAnswer deleted");
    }
}
