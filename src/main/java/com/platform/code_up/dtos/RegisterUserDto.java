package com.platform.code_up.dtos;

import com.platform.code_up.annotations.PasswordMatcher;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@PasswordMatcher(field = "password", fieldMatch = "confirmPassword")
public class RegisterUserDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*\\d.*\\d).{8,}$",
            message = "Use a strong password which contains at least:\n" +
                    "- 8 characters\n" +
                    "- one uppercase letter\n" +
                    "- two numbers\n" +
                    "- one special character (! @ # $ & *)")
    private String password;


    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;


}
