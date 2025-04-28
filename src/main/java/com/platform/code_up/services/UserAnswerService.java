package com.platform.code_up.services;

import com.platform.code_up.entities.UserAnswer;
import com.platform.code_up.repositories.UserAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
    private final UserAnswerRepository repo;

    public UserAnswerService(UserAnswerRepository repo) {
        this.repo = repo;
    }

    public List<UserAnswer> findAll() {
        return repo.findAll();
    }

    public UserAnswer findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAnswer not found"));
    }

    public UserAnswer create(UserAnswer ua) {
        return repo.save(ua);
    }

    public UserAnswer update(Integer id, UserAnswer ua) {
        ua.setId(id);
        return repo.save(ua);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
