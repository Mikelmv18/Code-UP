package com.platform.code_up.dtos;

import jakarta.validation.constraints.Pattern;



public record ChangePassword(String password, String confirmPassword) {

    public boolean isStrong(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*\\d.*\\d).{8,}$");
    }
}
