package com.platform.code_up.repositories;

import com.platform.code_up.entities.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository
        extends JpaRepository<UserAnswer, Integer> {
}
