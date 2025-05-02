package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {

    private String title;
    private String content;
    private Integer lessonOrder;
    private Integer unitNumber;
    private Integer courseId;
}
