package com.seppe.backend.dto.score;

import java.util.UUID;

public record PlayerForScoringResponse(
        UUID id,
        String name,
        String position
) {}