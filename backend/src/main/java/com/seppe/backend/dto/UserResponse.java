package com.seppe.backend.dto;

import com.seppe.backend.domain.user.UserRole;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        UserRole role) {
}
