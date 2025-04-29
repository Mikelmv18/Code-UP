package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuizDto {

    private Integer xp;
    private Date timeCompleted;
    private Integer userId;
    private Integer quizId;
}
