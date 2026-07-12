package com.seppe.backend.dto.team;

import com.seppe.backend.domain.player.PlayerPosition;

import java.util.UUID;

public record TeamPlayerResponse(
        UUID id,
        UUID playerId,
        String playerName,
        String clubName,
        PlayerPosition position,
        boolean isStarter
) {}