package com.seppe.backend.domain.match;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "external_api_id")
    private UUID externalApiId;

    @Column(name = "home_club_id", nullable = false)
    private UUID homeClubId;

    @Column(name = "away_club_id", nullable = false)
    private UUID awayClubId;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_state", nullable = false, length = 20)
    private GameState gameState;

    public Match() {
    }

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
