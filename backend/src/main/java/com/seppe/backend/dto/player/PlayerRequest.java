package com.seppe.backend.dto.player;

import com.seppe.backend.domain.player.PlayerPosition;

import java.util.UUID;

public record PlayerRequest(
        UUID clubId,
        UUID externalApiId,
        String name,
        PlayerPosition playerPosition
) {}
