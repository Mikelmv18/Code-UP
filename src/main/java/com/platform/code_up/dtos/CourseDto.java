package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

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
