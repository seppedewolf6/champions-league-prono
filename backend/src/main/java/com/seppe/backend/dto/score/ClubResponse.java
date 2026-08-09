package com.seppe.backend.dto.score;

import java.util.UUID;

public record ClubResponse(
        UUID id,
        String name
) {}