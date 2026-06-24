package com.seppe.backend.dto.login;

public record AuthResponse(
        String token,
        String username,
        String role
) {
}
