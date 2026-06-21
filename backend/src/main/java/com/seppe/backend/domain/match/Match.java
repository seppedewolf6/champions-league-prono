package com.seppe.backend.domain.match;

import java.time.LocalDateTime;
import java.util.UUID;

public class Match {
    private UUID id;

    private UUID externalApiId;
    private UUID homeClubId;
    private UUID awayClubId;
    private LocalDateTime dateTime;
    private GameState gameState;


    public Match(UUID id, UUID externalApiId, UUID homeClubId, UUID awayClubId, LocalDateTime startTime, GameState gameState) {
        this.id = id;
        this.externalApiId = externalApiId;
        this.homeClubId = homeClubId;
        this.awayClubId = awayClubId;
        this.dateTime = startTime;
        this.gameState = gameState;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getExternalApiId() {
        return externalApiId;
    }

    public void setExternalApiId(UUID externalApiId) {
        this.externalApiId = externalApiId;
    }

    public UUID getHomeClubId() {
        return homeClubId;
    }

    public void setHomeClubId(UUID homeClubId) {
        this.homeClubId = homeClubId;
    }

    public UUID getAwayClubId() {
        return awayClubId;
    }

    public void setAwayClubId(UUID awayClubId) {
        this.awayClubId = awayClubId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
