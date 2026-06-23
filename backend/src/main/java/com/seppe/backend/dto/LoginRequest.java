package com.seppe.backend.dto;

public record LoginRequest(
        String email,
        String password) {
}
