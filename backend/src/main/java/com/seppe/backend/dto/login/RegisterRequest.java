package com.seppe.backend.dto.login;

public record RegisterRequest(
        String username,
        String email,
        String password
) {
}
