package com.platform.code_up.services;

import com.platform.code_up.dtos.AnswerDto;
import com.platform.code_up.entities.Answer;
import com.platform.code_up.entities.Question;
import com.platform.code_up.exceptions.AnswerNotFoundException;
import com.platform.code_up.exceptions.QuestionNotFoundException;
import com.platform.code_up.repositories.AnswerRepository;
import com.platform.code_up.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository repo;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository repo, QuestionRepository questionRepository) {
        this.repo = repo;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(AnswerDto answerDto) {
        Answer answer = new Answer();

        Question question = questionRepository.findById(answerDto.getQuestionId())
                .orElseThrow(() -> new QuestionNotFoundException("Question does not exist"));

        answer.setAnswer(answerDto.getAnswer());
        answer.setQuestion(question);

        return repo.save(answer);
    }

    public List<Answer> listAllAnswers() {
        List<Answer> answers = new ArrayList<>();
        repo.findAll().forEach(answers::add);
        return answers;
    }

    public Answer getById(Integer id) throws AnswerNotFoundException {
        return repo.findById(id)
                .orElseThrow(AnswerNotFoundException::new);
    }

    public Answer getByQuestionId(Integer questionId) throws AnswerNotFoundException {
        return repo.findByQuestionId(questionId)
                .orElseThrow(AnswerNotFoundException::new);
    }

    public AnswerDto updateAnswer(Integer questionId, AnswerDto answerDto) throws AnswerNotFoundException {
        Answer a = repo.findByQuestionId(questionId)
                .orElseThrow(AnswerNotFoundException::new);

        a.setAnswer(answerDto.getAnswer());
        repo.save(a);

        return new AnswerDto(a.getAnswer(), a.getQuestion().getId());
    }

    public void deleteAnswer(Integer questionId) throws AnswerNotFoundException {
        Answer a = repo.findByQuestionId(questionId)
                .orElseThrow(AnswerNotFoundException::new);

        repo.delete(a);
    }


    public AnswerDto updateAnswerById(Integer answerId, AnswerDto answerDto) throws AnswerNotFoundException {
        Answer a = repo.findById(answerId)
                .orElseThrow(AnswerNotFoundException::new);

        a.setAnswer(answerDto.getAnswer());
        repo.save(a);

        return new AnswerDto(a.getAnswer(), a.getQuestion().getId());
    }


    public void deleteAnswerById(Integer answerId) throws AnswerNotFoundException {
        Answer a = repo.findById(answerId)
                .orElseThrow(AnswerNotFoundException::new);

        repo.delete(a);
    }
}
