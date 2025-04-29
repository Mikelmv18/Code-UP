package com.platform.code_up.services;

import com.platform.code_up.dtos.UserQuizDto;
import com.platform.code_up.entities.Quiz;
import com.platform.code_up.entities.User;
import com.platform.code_up.entities.UserQuiz;
import com.platform.code_up.repositories.UserQuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserQuizService {

    private final UserQuizRepository userQuizRepository;

    public UserQuizService(UserQuizRepository userQuizRepository) {
        this.userQuizRepository = userQuizRepository;
    }

    public UserQuiz createUserQuiz(UserQuizDto dto) {
        UserQuiz userQuiz = new UserQuiz();

        User user = new User();
        user.setId(dto.getUserId());

        Quiz quiz = new Quiz();
        quiz.setId(dto.getQuizId());

        userQuiz.setXp(dto.getXp());
        userQuiz.setTimeCompleted(dto.getTimeCompleted());
        userQuiz.setUser(user);
        userQuiz.setQuiz(quiz);

        return userQuizRepository.save(userQuiz);
    }

    public List<UserQuiz> listAllUserQuizzes() {
        List<UserQuiz> userQuizzes = new ArrayList<>();
        userQuizRepository.findAll().forEach(userQuizzes::add);
        return userQuizzes;
    }

    public UserQuiz getById(Integer id) {
        return userQuizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserQuiz not found"));
    }

    public UserQuizDto updateUserQuiz(Integer id, UserQuizDto dto) {
        UserQuiz userQuiz = userQuizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserQuiz not found"));

        User user = new User();
        user.setId(dto.getUserId());

        Quiz quiz = new Quiz();
        quiz.setId(dto.getQuizId());

        userQuiz.setXp(dto.getXp());
        userQuiz.setTimeCompleted(dto.getTimeCompleted());
        userQuiz.setUser(user);
        userQuiz.setQuiz(quiz);

        userQuizRepository.save(userQuiz);

        return new UserQuizDto(
                userQuiz.getXp(),
                userQuiz.getTimeCompleted(),
                userQuiz.getUser().getId(),
                userQuiz.getQuiz().getId()
        );
    }

    public void deleteUserQuiz(Integer id) {
        if (!userQuizRepository.existsById(id)) {
            throw new RuntimeException("UserQuiz not found");
        }
        userQuizRepository.deleteById(id);
    }
}
