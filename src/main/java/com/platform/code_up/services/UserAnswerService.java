package com.platform.code_up.services;

import com.platform.code_up.dtos.UserAnswerDto;
import com.platform.code_up.entities.Question;
import com.platform.code_up.entities.User;
import com.platform.code_up.entities.UserAnswer;
import com.platform.code_up.repositories.UserAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;

    public UserAnswerService(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    public UserAnswer createUserAnswer(UserAnswerDto dto) {
        UserAnswer userAnswer = new UserAnswer();

        User user = new User();
        user.setId(dto.getUserId());

        Question question = new Question();
        question.setId(dto.getQuestionId());

        userAnswer.setXp(dto.getXp());
        userAnswer.setTimeStarted(dto.getTimeStarted());
        userAnswer.setTimeCompleted(dto.getTimeCompleted());
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);

        return userAnswerRepository.save(userAnswer);
    }

    public List<UserAnswer> listAllUserAnswers() {
        List<UserAnswer> answers = new ArrayList<>();
        userAnswerRepository.findAll().forEach(answers::add);
        return answers;
    }

    public UserAnswer getById(Integer id) {
        return userAnswerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAnswer not found"));
    }

    public UserAnswerDto updateUserAnswer(Integer id, UserAnswerDto dto) {
        UserAnswer ua = userAnswerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAnswer not found"));

        User user = new User();
        user.setId(dto.getUserId());

        Question question = new Question();
        question.setId(dto.getQuestionId());

        ua.setXp(dto.getXp());
        ua.setTimeStarted(dto.getTimeStarted());
        ua.setTimeCompleted(dto.getTimeCompleted());
        ua.setUser(user);
        ua.setQuestion(question);

        userAnswerRepository.save(ua);

        return new UserAnswerDto(
                ua.getXp(),
                ua.getTimeStarted(),
                ua.getTimeCompleted(),
                ua.getUser().getId(),
                ua.getQuestion().getId()
        );
    }

    public void deleteUserAnswer(Integer id) {
        if (!userAnswerRepository.existsById(id)) {
            throw new RuntimeException("UserAnswer not found");
        }
        userAnswerRepository.deleteById(id);
    }
}
