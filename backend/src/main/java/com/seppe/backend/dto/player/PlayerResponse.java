package com.seppe.backend.dto.player;

import com.seppe.backend.domain.player.PlayerPosition;

import java.util.UUID;

public record PlayerResponse(
        UUID id,
        UUID clubId,
        String clubName,
        UUID externalApiId,
        String name,
        PlayerPosition playerPosition
) {}
