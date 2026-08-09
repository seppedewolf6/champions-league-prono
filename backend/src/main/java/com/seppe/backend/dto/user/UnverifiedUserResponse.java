package com.seppe.backend.dto.user;

import java.util.UUID;

public record UnverifiedUserResponse(
        UUID id,
        String username,
        String email
) {}