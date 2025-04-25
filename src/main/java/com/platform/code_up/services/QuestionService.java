package com.platform.code_up.services;

import com.platform.code_up.entities.Question;
import com.platform.code_up.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public List<Question> findAll() {
        return repo.findAll();
    }

    public Question findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public Question create(Question question) {
        return repo.save(question);
    }

    public Question update(Integer id, Question question) {
        question.setId(id);
        return repo.save(question);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
