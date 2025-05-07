package com.platform.code_up.dtos;

import java.util.UUID;

public record AuthenticationResponseDto(String accessToken, UUID refreshToken) {}
