package com.platform.code_up.services;

import com.platform.code_up.entities.Quiz;
import com.platform.code_up.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository repo;

    public QuizService(QuizRepository repo) {
        this.repo = repo;
    }

    public List<Quiz> findAll() {
        return repo.findAll();
    }

    public Quiz findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    public Quiz create(Quiz quiz) {
        return repo.save(quiz);
    }

    public Quiz update(Integer id, Quiz quiz) {
        quiz.setId(id);
        return repo.save(quiz);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
