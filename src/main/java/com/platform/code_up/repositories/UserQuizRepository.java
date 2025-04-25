package com.platform.code_up.repositories;

import com.platform.code_up.entities.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuizRepository
        extends JpaRepository<UserQuiz, Integer> {
}
