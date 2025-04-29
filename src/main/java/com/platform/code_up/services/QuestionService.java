package com.platform.code_up.services;

import com.platform.code_up.dtos.QuestionDto;
import com.platform.code_up.entities.Question;
import com.platform.code_up.entities.Quiz;
import com.platform.code_up.exceptions.QuestionNotFoundException;
import com.platform.code_up.repositories.QuestionRepository;
import com.platform.code_up.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    public Question createQuestion(QuestionDto questionDto) {
        Question question = new Question();

        Quiz quiz = quizRepository.findById(questionDto.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        question.setQuestion(questionDto.getQuestion());
        question.setChoices(questionDto.getChoices());
        question.setQuiz(quiz);

        return questionRepository.save(question);
    }

    public List<Question> listAllQuestions() {
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    public Question getById(Integer id) throws QuestionNotFoundException {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));
    }

    public QuestionDto updateQuestion(Integer id, QuestionDto questionDto) throws QuestionNotFoundException {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));

        Quiz quiz = quizRepository.findById(questionDto.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        question.setQuestion(questionDto.getQuestion());
        question.setChoices(questionDto.getChoices());
        question.setQuiz(quiz);

        questionRepository.save(question);

        return new QuestionDto(
                question.getQuestion(),
                question.getChoices(),
                question.getQuiz().getId()
        );
    }

    public void deleteQuestion(Integer id) throws QuestionNotFoundException {
        if (!questionRepository.existsById(id)) {
            throw new QuestionNotFoundException("Question not found");
        }
        questionRepository.deleteById(id);
    }
}
