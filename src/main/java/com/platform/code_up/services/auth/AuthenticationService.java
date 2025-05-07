package com.platform.code_up.services.auth;

import com.platform.code_up.dtos.AuthenticationResponseDto;
import com.platform.code_up.dtos.LoginUserDto;
import com.platform.code_up.dtos.RegisterUserDto;
import com.platform.code_up.entities.RefreshToken;
import com.platform.code_up.entities.User;
import com.platform.code_up.repositories.RefreshTokenRepository;
import com.platform.code_up.repositories.auth.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final Duration refreshTokenTtl = Duration.ofDays(30); // Refresh token valid for 30 days

    public AuthenticationService(
            UserRepository userRepository,
            RefreshTokenRepository refreshTokenRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // User registration
    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setAvatar("default.png");
        return userRepository.save(user);
    }

    // Login: returns JWT + refresh token
    public AuthenticationResponseDto authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        // 1. Find user from database
        User user = userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("Unauthorized"));

        // 2. Generate access token using full user
        String accessToken = jwtService.generateToken(user);

        // 3. Create and save refresh token
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setId(UUID.randomUUID());
        refreshToken.setUser(user);
        refreshToken.setCreatedAt(Instant.now());
        refreshToken.setExpiresAt(Instant.now().plus(refreshTokenTtl));
        refreshTokenRepository.save(refreshToken);

        // 4. Return both tokens
        return new AuthenticationResponseDto(accessToken, refreshToken.getId());
    }

    // Refresh token: returns new access token
    public AuthenticationResponseDto refreshToken(UUID refreshTokenId) {
        RefreshToken token = refreshTokenRepository
                .findByIdAndExpiresAtAfter(refreshTokenId, Instant.now())
                .orElseThrow(() -> new RuntimeException("Invalid or expired refresh token"));

        String newAccessToken = jwtService.generateToken(token.getUser());

        return new AuthenticationResponseDto(newAccessToken, token.getId());
    }
    public void logout(UUID refreshTokenId) {
        if (refreshTokenRepository.existsById(refreshTokenId)) {
            refreshTokenRepository.deleteById(refreshTokenId);
        } else {
            throw new RuntimeException("Refresh token not found");
        }
    }

}
