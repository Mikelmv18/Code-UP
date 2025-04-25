package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AchievementDto {

    private String type;

    private String name;

    private String icon;
}
