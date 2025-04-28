package com.platform.code_up.controllers;

import com.platform.code_up.dtos.AnswerDto;
import com.platform.code_up.entities.Answer;
import com.platform.code_up.exceptions.AnswerNotFoundException;
import com.platform.code_up.services.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "http://localhost:8081")
public class AnswerController {

    private final AnswerService service;

    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAnswer(@RequestBody AnswerDto answerDto) {
        Answer answer = service.createAnswer(answerDto);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = service.listAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<AnswerDto> getAnswerById(@PathVariable Integer id) throws AnswerNotFoundException {
        Answer answer = service.getById(id);
        return ResponseEntity.ok(new AnswerDto(answer.getAnswer(), answer.getQuestion().getId()));
    }

    @GetMapping("/by-question/{questionId}")
    public ResponseEntity<AnswerDto> getAnswerByQuestionId(@PathVariable Integer questionId) throws AnswerNotFoundException {
        Answer answer = service.getByQuestionId(questionId);
        return ResponseEntity.ok(new AnswerDto(answer.getAnswer(),
                answer.getQuestion().getId()));
    }

    @PutMapping("/by-question/{questionId}")
    public ResponseEntity<AnswerDto> updateAnswerByQuestionId(@PathVariable Integer questionId,
                                                              @RequestBody AnswerDto dto)
            throws AnswerNotFoundException {

        AnswerDto updatedAnswer = service.updateAnswer(questionId, dto);
        return ResponseEntity.ok(updatedAnswer);

    }

    @DeleteMapping("/by-question/{questionId}")
    public ResponseEntity<?> deleteAnswerByQuestionId(@PathVariable Integer questionId)
            throws AnswerNotFoundException {
        service.deleteAnswer(questionId);
        return ResponseEntity.ok().body("Answer deleted by question ID");
    }


    @PutMapping("/by-id/{answerId}")
    public ResponseEntity<AnswerDto> updateAnswerById(@PathVariable Integer answerId,
                                                      @RequestBody AnswerDto dto)
            throws AnswerNotFoundException {

        AnswerDto updatedAnswer = service.updateAnswerById(answerId, dto);
        return ResponseEntity.ok(updatedAnswer);

    }


    @DeleteMapping("/by-id/{answerId}")
    public ResponseEntity<?> deleteAnswerById(@PathVariable Integer answerId)
            throws AnswerNotFoundException {
        service.deleteAnswerById(answerId);
        return ResponseEntity.ok().body("Answer deleted by answer ID");
    }
}
