package com.platform.code_up.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;

    private String email;

    private String avatar;

    private String created_at;

    public UserDto(String email, String avatar, String s) {
    }
}
