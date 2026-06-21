package com.seppe.backend.domain.player;

import java.util.UUID;

public class Player {
    private UUID id;
    private UUID clubId;
    private UUID externalApiId;
    private String name;
    private PlayerPosition playerPosition;

    public Player(UUID id, UUID clubId, UUID externalApiId, String name, PlayerPosition position) {
        this.id = id;
        this.clubId = clubId;
        this.externalApiId = externalApiId;
        this.name = name;
        this.playerPosition = position;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClubId() {
        return clubId;
    }

    public void setClubId(UUID clubId) {
        this.clubId = clubId;
    }

    public UUID getExternalApiId() {
        return externalApiId;
    }

    public void setExternalApiId(UUID external_api_id) {
        this.externalApiId = external_api_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }
}
