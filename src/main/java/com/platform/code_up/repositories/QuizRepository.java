package com.platform.code_up.repositories;

import com.platform.code_up.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository
        extends JpaRepository<Quiz, Integer> {
}
