package com.platform.code_up.services;

import com.platform.code_up.entities.UserQuiz;
import com.platform.code_up.repositories.UserQuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuizService {
    private final UserQuizRepository repo;

    public UserQuizService(UserQuizRepository repo) {
        this.repo = repo;
    }

    public List<UserQuiz> findAll() {
        return repo.findAll();
    }

    public UserQuiz findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("UserQuiz not found"));
    }

    public UserQuiz create(UserQuiz uq) {
        return repo.save(uq);
    }

    public UserQuiz update(Integer id, UserQuiz uq) {
        uq.setId(id);
        return repo.save(uq);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
