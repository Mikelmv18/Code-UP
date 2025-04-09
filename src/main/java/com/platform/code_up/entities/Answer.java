package com.platform.code_up.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
