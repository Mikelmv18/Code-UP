package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "quizzes")
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private Integer timer;

    private int quiz_order;

    private int unit_number;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    private List<UserQuiz> userQuizzes;

    public Quiz(String title, int quiz_order, int unit_number, Course course, List<Question>
            questions){

        this.title = title;
        this.quiz_order = quiz_order;
        this.unit_number = unit_number;
        this.course = course;
        this.questions = questions;

    }
}
