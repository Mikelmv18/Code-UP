package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CourseDto {
    private String title;
    private String description;
    private String type;
    private Boolean isPremium;
    private Integer prerequisiteCourseIds;
}
