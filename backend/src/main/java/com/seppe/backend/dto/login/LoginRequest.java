package com.seppe.backend.dto.login;

public record LoginRequest(
        String email,
        String password) {
}
