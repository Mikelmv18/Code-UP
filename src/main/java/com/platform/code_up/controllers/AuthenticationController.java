package com.platform.code_up.controllers;

import com.platform.code_up.dtos.LoginResponse;
import com.platform.code_up.dtos.LoginUserDto;
import com.platform.code_up.dtos.RegisterUserDto;
import com.platform.code_up.entities.User;
import com.platform.code_up.services.AuthenticationService;
import com.platform.code_up.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/auth")
@RestController
@CrossOrigin
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDto registerUserDto,
                                      BindingResult result) {
        if (result.hasErrors()) {

            String firstError = result.getFieldErrors().stream()
                    .findFirst()
                    .map(error -> error.getDefaultMessage())
                    .orElse("Validation error occurred");

            // Log the first validation error
            System.out.println("First validation error: " + firstError);

            return ResponseEntity.badRequest().body(Map.of("error", firstError));
        }

        // Proceed with registration if no validation errors
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {

        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
