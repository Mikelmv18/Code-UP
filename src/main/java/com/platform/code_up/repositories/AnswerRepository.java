package com.platform.code_up.repositories;

import com.platform.code_up.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    Optional<Answer> findByQuestionId(Integer question_id);
}
