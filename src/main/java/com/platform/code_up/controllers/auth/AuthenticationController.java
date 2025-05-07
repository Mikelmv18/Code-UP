package com.platform.code_up.controllers.auth;

import com.platform.code_up.dtos.LoginResponse;
import com.platform.code_up.dtos.LoginUserDto;
import com.platform.code_up.dtos.RegisterUserDto;
import com.platform.code_up.entities.User;
import com.platform.code_up.services.auth.AuthenticationService;
import com.platform.code_up.services.auth.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/auth")
@RestController
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8005"})
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDto registerUserDto,
                                      Errors errors) {

        if (errors.hasErrors()) {

            String firstError = String.valueOf(errors.getAllErrors().
                   get(0).getDefaultMessage());

            return ResponseEntity.badRequest().body(Map.of("error", firstError));
        }

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
