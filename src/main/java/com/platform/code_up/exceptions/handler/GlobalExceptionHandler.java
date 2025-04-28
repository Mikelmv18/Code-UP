package com.platform.code_up.exceptions.handler;

import com.platform.code_up.exceptions.PasswordException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleSecurityException(Exception exception) {

        Map<String,String> response = new HashMap<>();

        exception.printStackTrace(); // Log for debugging


        if (exception instanceof BadCredentialsException) {
            response.put("description", "Enter valid credentials");

        }

        else if (exception instanceof AccountStatusException) {
            response.put("description","Account is locked");
        }

        else if (exception instanceof AccessDeniedException) {
            response.put("description","You are not authorized to access this resource");
        }

        else if (exception instanceof SignatureException) {
           response.put("description","The JWT signature is invalid");
        }

        else if (exception instanceof ExpiredJwtException) {
            response.put("description","The JWT token has expired");
        }

        else if (exception instanceof PasswordException ||
                exception instanceof IllegalArgumentException ||
                exception instanceof UsernameNotFoundException ||
                exception instanceof TimeoutException) {

            response.put("description",exception.getMessage());

        }

        else {
            response.put("description","An unexpected error occurred");
        }

        return ResponseEntity.badRequest().body(response);
    }




}