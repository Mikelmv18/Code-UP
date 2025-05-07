package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {

    private String title;
    private int quizOrder;
    private int unitNumber;
    private Integer courseId;
}
