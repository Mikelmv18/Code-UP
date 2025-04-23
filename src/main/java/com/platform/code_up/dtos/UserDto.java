package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String email;

    private String avatar;

    private String created_at;
}
