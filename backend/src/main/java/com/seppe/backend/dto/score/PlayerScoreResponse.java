package com.seppe.backend.dto.score;

import java.time.LocalDateTime;
import java.util.UUID;

public record PlayerScoreResponse(
        UUID id,
        UUID playerId,
        double points,
        LocalDateTime createdAt,
        int teamsCredited
) {}