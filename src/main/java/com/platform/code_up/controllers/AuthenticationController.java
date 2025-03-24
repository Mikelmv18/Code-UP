package com.platform.code_up.controllers;

import com.platform.code_up.LoginResponse;
import com.platform.code_up.dtos.LoginUserDto;
import com.platform.code_up.dtos.RegisterUserDto;
import com.platform.code_up.entities.User;
import com.platform.code_up.services.AuthenticationService;
import com.platform.code_up.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/auth")
@RestController
@CrossOrigin(origins = "*")
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
            // Get the first error message (if any)
            String firstError = result.getFieldErrors().stream()
                    .findFirst() // Get the first error (Optional)
                    .map(error -> error.getDefaultMessage()) // Get the message
                    .orElse("Validation error occurred"); // Default message if no error found

            // Log the first validation error
            System.out.println("First validation error: " + firstError);

            return ResponseEntity.badRequest().body(Map.of("error", firstError));  // Return first validation error
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
