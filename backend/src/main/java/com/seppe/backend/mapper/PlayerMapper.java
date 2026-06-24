package com.seppe.backend.mapper;

import com.seppe.backend.domain.player.Player;
import com.seppe.backend.dto.player.PlayerResponse;

public class PlayerMapper {

    private PlayerMapper() {}

    public static PlayerResponse toResponse(
            Player player
    ) {
        return new PlayerResponse(
                player.getId(),
                player.getClub().getId(),
                player.getClub().getName(),
                player.getExternalApiId(),
                player.getName(),
                player.getPlayerPosition()
        );
    }
}